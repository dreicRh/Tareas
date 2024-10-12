/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.invertircadena;

import java.util.Scanner;

public class InvertirCadena {

    
    public static String invertir(String cadena) {
        
        if (cadena.length() <= 1) {
            return cadena;
        }
       
        return invertir(cadena.substring(1)) + cadena.charAt(0);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
       
        System.out.print("Introduce una cadena para invertir: ");
        String entrada = sc.nextLine();  
        
       
        String salida = invertir(entrada);
        
       
        System.out.println("Cadena invertida: " + salida);
        
        sc.close(); 
    }
}
