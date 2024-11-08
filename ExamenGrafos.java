/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examengrafos;

import java.util.Scanner;

class Nodo {

    int valor;
    Nodo izquierdo, derecho;

    public Nodo(int valor) {
        this.valor = valor;
        izquierdo = derecho = null;
    }
}

class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }
        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        return nodo;
    }

    public int calcularAltura() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(Nodo nodo) {
        if (nodo == null) {
            return -1;
        }
        int alturaIzquierda = calcularAlturaRecursivo(nodo.izquierdo);
        int alturaDerecha = calcularAlturaRecursivo(nodo.derecho);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public int calcularPeso() {
        return calcularPesoRecursivo(raiz);
    }

    private int calcularPesoRecursivo(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + calcularPesoRecursivo(nodo.izquierdo) + calcularPesoRecursivo(nodo.derecho);
    }

    public int calcularNivel() {
        return calcularAltura();
    }
}

public class ExamenGrafos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        System.out.print("Ingrese la cantidad de números que desea ingresar en el árbol: ");
        int cantidadNumeros = scanner.nextInt();

        System.out.println("Ingrese los elementos del árbol binario:");
        for (int i = 0; i < cantidadNumeros; i++) {
            int valor = scanner.nextInt();
            arbol.insertar(valor);
        }

        int altura = arbol.calcularAltura();
        int nivel = arbol.calcularNivel();
        int peso = arbol.calcularPeso();

        System.out.println("Altura del árbol: " + altura);
        System.out.println("Nivel del árbol: " + nivel);
        System.out.println("Peso del árbol (número de nodos): " + peso);

        scanner.close();
    }
}