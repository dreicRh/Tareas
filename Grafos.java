/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafos {

    private List<List<Integer>> listaAdyacencia;

    public Grafos(int[][] matrizAdyacencia) {
        int n = matrizAdyacencia.length;
        listaAdyacencia = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrizAdyacencia[i][j] == 1) {
                    listaAdyacencia.get(i).add(j);
                }
            }
        }
    }

    public void imprimirGrafo() {
        for (int i = 0; i < listaAdyacencia.size(); i++) {
            System.out.print("Nodo " + i + " conectado con: ");
            for (int vecino : listaAdyacencia.get(i)) {
                System.out.print(vecino + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrizAdyacencia = {
            {0, 1, 1, 0},
            {1, 0, 1, 1},
            {1, 1, 0, 1},
            {0, 1, 1, 0}
        };

        Grafos grafo = new Grafos(matrizAdyacencia);
        grafo.imprimirGrafo();
    }
}
