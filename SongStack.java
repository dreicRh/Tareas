/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.songstack;

import java.util.Stack;
import java.util.Scanner;

public class SongStack {

    private Stack<String> stack;

    public SongStack() {
        stack = new Stack<>();
    }

    public void addSong(String song) {
        stack.push(song);
        System.out.println(song + " ha sido agregada al historial.");
    }

    public String previousSong() {
        if (!stack.isEmpty()) {
            String lastSong = stack.pop();
            System.out.println(lastSong + " ha sido eliminada del historial.");
            return lastSong;
        } else {
            System.out.println("No hay canciones en el historial.");
            return null;
        }
    }

    public String currentSong() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            System.out.println("No hay canciones en el historial.");
            return null;
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SongStack history = new SongStack();
        boolean exit = false;

        System.out.println("¡Bienvenido al historial de canciones de Spotify!");

        while (!exit) {
            System.out.println("\nSelecciona una acción:");
            System.out.println("1. Agregar una canción");
            System.out.println("2. Ver la canción actual");
            System.out.println("3. Retroceder a la canción anterior");
            System.out.println("4. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Escribe el nombre de la canción:");
                    String song = scanner.nextLine();
                    history.addSong(song);
                    break;
                case 2:
                    System.out.println("Canción actual: " + history.currentSong());
                    break;
                case 3:
                    history.previousSong();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo del historial de canciones...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }

        scanner.close();
    }
}
