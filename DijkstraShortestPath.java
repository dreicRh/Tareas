/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dijkstrashortestpath;

import java.util.*;

public class DijkstraShortestPath {

    public static void main(String[] args) {

        Map<String, Map<String, Integer>> graph = new HashMap<>();

        graph.put("A", Map.of("B", 4, "C", 2));
        graph.put("B", Map.of("A", 4, "C", 5, "D", 10));
        graph.put("C", Map.of("A", 2, "B", 5, "D", 3));
        graph.put("D", Map.of("B", 10, "C", 3));

        System.out.println("Ciudades disponibles y conexiones:");
        for (String city : graph.keySet()) {
            System.out.print(city + " -> ");
            graph.get(city).forEach((neighbor, distance)
                    -> System.out.print(neighbor + " (" + distance + " km), "));
            System.out.println();
        }
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ciudad de inicio: ");
        String start = scanner.nextLine().toUpperCase();
        System.out.print("Ciudad de destino: ");
        String end = scanner.nextLine().toUpperCase();

        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            System.out.println("Una o ambas ciudades no existen en el grafo.");
            return;
        }

        DijkstraResult result = dijkstra(graph, start, end);

        if (result.distance == Integer.MAX_VALUE) {
            System.out.println("No hay conexión posible entre " + start + " y " + end + ".");
        } else {
            System.out.println("Distancia más corta: " + result.distance + " km");
            System.out.println("Ruta: " + String.join(" -> ", result.path));
        }

        scanner.close();
    }

    static class DijkstraResult {

        int distance;
        List<String> path;

        DijkstraResult(int distance, List<String> path) {
            this.distance = distance;
            this.path = path;
        }
    }

    public static DijkstraResult dijkstra(Map<String, Map<String, Integer>> graph, String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Set<String> visited = new HashSet<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.offer(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            String current = pq.poll().getKey();

            if (!visited.add(current)) {
                continue;
            }

            for (Map.Entry<String, Integer> neighbor : graph.get(current).entrySet()) {
                String neighborNode = neighbor.getKey();
                int newDist = distances.get(current) + neighbor.getValue();

                if (newDist < distances.get(neighborNode)) {
                    distances.put(neighborNode, newDist);
                    previous.put(neighborNode, current);
                    pq.offer(new AbstractMap.SimpleEntry<>(neighborNode, newDist));
                }
            }
        }

        List<String> path = new ArrayList<>();
        for (String at = end; at != null; at = previous.get(at)) {
            path.add(0, at);
        }
        if (!path.contains(start)) {
            path.clear();
        }
        return new DijkstraResult(distances.get(end), path);
    }
}
