/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Queue<T> {

    private LinkedList<T> elements;

    public Queue() {
        elements = new LinkedList<>();
    }

    public void enqueue(T value) {
        elements.addLast(value);
    }

    public T dequeue() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return elements.removeFirst();
    }

    public T peek() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return elements.getFirst();
    }

    public int count() {
        return elements.size();
    }

    public void clear() {
        elements.clear();
    }

    public T getFirst() {
        return peek();
    }

    public T getLast() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("La cola está vacía.");
        }
        return elements.getLast();
    }

    public LinkedList<T> getAll() {
        return new LinkedList<>(elements);
    }

    public void printQueue() {
        System.out.println(elements);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Object> queue = new Queue<>();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menú de Cola ---");
            System.out.println("1. Enqueue (Agregar a la cola)");
            System.out.println("2. Dequeue (Eliminar de la cola)");
            System.out.println("3. Peek (Ver el primer elemento)");
            System.out.println("4. GetFirst (Obtener el primer elemento)");
            System.out.println("5. GetLast (Obtener el último elemento)");
            System.out.println("6. GetAll (Obtener todos los elementos)");
            System.out.println("7. Count (Contar los elementos)");
            System.out.println("8. Clear (Limpiar la cola)");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingresa un valor (String, Integer, Double): ");
                    String input = scanner.nextLine();
                    try {
                        if (input.matches("-?\\d+")) {
                            queue.enqueue(Integer.parseInt(input));
                        } else if (input.matches("-?\\d+\\.\\d+")) {
                            queue.enqueue(Double.parseDouble(input));
                        } else {
                            queue.enqueue(input);
                        }
                        System.out.println("Elemento agregado a la cola.");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                    Object removed = queue.dequeue();
                    System.out.println("Elemento removido: " + removed);
                } catch (NoSuchElementException e) {
                    System.out.println("Error: La cola está vacía.");
                }
                break;

                case 3:
                    try {
                    System.out.println("Primer elemento: " + queue.peek());
                } catch (NoSuchElementException e) {
                    System.out.println("Error: La cola está vacía.");
                }
                break;

                case 4:
                    try {
                    System.out.println("Primer elemento: " + queue.getFirst());
                } catch (NoSuchElementException e) {
                    System.out.println("Error: La cola está vacía.");
                }
                break;

                case 5:
                    try {
                    System.out.println("Último elemento: " + queue.getLast());
                } catch (NoSuchElementException e) {
                    System.out.println("Error: La cola está vacía.");
                }
                break;

                case 6:
                    System.out.println("Todos los elementos: " + queue.getAll());
                    break;

                case 7:
                    System.out.println("Cantidad de elementos en la cola: " + queue.count());
                    break;

                case 8:
                    queue.clear();
                    System.out.println("Cola limpiada.");
                    break;

                case 9:

                    running = false;
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
