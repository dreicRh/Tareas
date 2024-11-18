/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ordenamiento;

class Nodo {

    int dato;
    Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void recorridoInOrden(Nodo nodo) {
        if (nodo != null) {
            recorridoInOrden(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            recorridoInOrden(nodo.derecho);
        }
    }

    public void recorridoPosOrden(Nodo nodo) {
        if (nodo != null) {
            recorridoPosOrden(nodo.izquierdo);
            recorridoPosOrden(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    public class Ordenamiento {

        public static void main(String[] args) {

            ArbolBinario arbol = new ArbolBinario();

            arbol.raiz = new Nodo(1);
            arbol.raiz.izquierdo = new Nodo(2);
            arbol.raiz.derecho = new Nodo(3);
            arbol.raiz.izquierdo.izquierdo = new Nodo(4);
            arbol.raiz.izquierdo.derecho = new Nodo(5);
            arbol.raiz.derecho.izquierdo = new Nodo(6);
            arbol.raiz.derecho.derecho = new Nodo(7);

            System.out.println("Recorrido InOrden:");
            arbol.recorridoInOrden(arbol.raiz);

            System.out.println("\nRecorrido PosOrden:");
            arbol.recorridoPosOrden(arbol.raiz);
        }
    }
}
