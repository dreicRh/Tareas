/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.listas;
import java.util.ArrayList;
import java.util.Scanner;

public class Listas {
    
class Video {
    String titulo;
    String autor;
    String url;
    boolean activo;

    // Constructor que acepta todos los parámetros
    public Video(String titulo, String autor, String url, boolean activo) {
        this.titulo = titulo;
        this.autor = autor;
        this.url = url;
        this.activo = activo;
    }

    // Método para mostrar el video
    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", URL: " + url + ", Activo: " + activo;
    }
}

public class Main {
    public static void main(String[] args) {
        // Lista de videos
        ArrayList<Video> listaVideos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String titulo, autor, url, continuar;
        boolean activo;

        do {
            // Entrada de datos para el video
            System.out.print("Ingrese el título del video: ");
            titulo = sc.nextLine();

            System.out.print("Ingrese el autor del video: ");
            autor = sc.nextLine();

            System.out.print("Ingrese la URL del video: ");
            url = sc.nextLine();

            // Aquí verificamos si el video está activo
            System.out.print("¿El video está activo? (true/false): ");
            while (!sc.hasNextBoolean()) {
                System.out.println("Entrada inválida. Por favor, ingrese true o false.");
                sc.next(); // Consumir entrada inválida
            }
            activo = sc.nextBoolean();
            sc.nextLine();  // Limpiar el buffer del scanner

            // Crear y agregar el nuevo objeto Video a la lista
            Video video = new Video(titulo, autor, url, activo);
            listaVideos.add(video);

            // Preguntar si el usuario desea agregar otro video
            System.out.print("¿Desea agregar otro video? (s/n): ");
            continuar = sc.nextLine();

        } while (continuar.equalsIgnoreCase("s"));

        // Imprimir la lista de videos
        System.out.println("\nLista de Videos:");
        for (Video v : listaVideos) {
            System.out.println(v);
        }

        sc.close();
    }
}
}