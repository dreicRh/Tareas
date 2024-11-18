/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.recorrido;

class Nodo {

    int dato;
    Nodo izquierda, derecha;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}

class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierda);
            System.out.print(nodo.dato + " ");
            inOrden(nodo.derecha);
        }
    }

    void posOrden(Nodo nodo) {
        if (nodo != null) {
            posOrden(nodo.izquierda);
            posOrden(nodo.derecha);
            System.out.print(nodo.dato + " ");
        }
    }

    void inOrden() {
        System.out.print("Recorrido InOrden: ");
        inOrden(raiz);
        System.out.println();
    }

    void posOrden() {
        System.out.print("Recorrido PosOrden: ");
        posOrden(raiz);
        System.out.println();
    }
}

public class Recorrido {

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.raiz = new Nodo(1);
        arbol.raiz.izquierda = new Nodo(2);
        arbol.raiz.derecha = new Nodo(3);
        arbol.raiz.izquierda.izquierda = new Nodo(4);
        arbol.raiz.izquierda.derecha = new Nodo(5);
        arbol.raiz.derecha.izquierda = new Nodo(6);
        arbol.raiz.derecha.derecha = new Nodo(7);
        arbol.inOrden();
        arbol.posOrden();
    }
}