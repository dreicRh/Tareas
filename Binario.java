/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.binario;
import java.util.Scanner;

class Nodo {
    int valor;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.valor = valor;
        izquierda = derecha = null;
    }
}

class ArbolBinario {
    Nodo raiz;

    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierda = insertarRecursivo(actual.izquierda, valor);
        } else if (valor > actual.valor) {
            actual.derecha = insertarRecursivo(actual.derecha, valor);
        }

        return actual;
    }

    public int obtenerAltura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Nodo actual) {
        if (actual == null) {
            return 0;
        }

        int alturaIzquierda = calcularAltura(actual.izquierda);
        int alturaDerecha = calcularAltura(actual.derecha);

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    public void mostrarInorden() {
        imprimirInorden(raiz);
        System.out.println();
    }

    private void imprimirInorden(Nodo actual) {
        if (actual != null) {
            imprimirInorden(actual.izquierda);
            System.out.print(actual.valor + " ");
            imprimirInorden(actual.derecha);
        }
    }
}
public class Binario {
    
public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario();

        System.out.println("Ingresa la cantidad de números que quieres añadir al árbol:");
        int cantidad = sc.nextInt();

        System.out.println("Ingresa los números:");
        for (int i = 0; i < cantidad; i++) {
            int valor = sc.nextInt();
            arbol.insertar(valor);
        }

        System.out.println("Árbol en inorden:");
        arbol.mostrarInorden();

        int altura = arbol.obtenerAltura();
        System.out.println("El nivel (altura) del árbol es: " + altura);
    }
}