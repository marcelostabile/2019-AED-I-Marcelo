/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import tdaarbolbb.*;

/**
 *
 * @author Diego
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        TArbolBB arbolPrueba = new TArbolBB();
        arbolPrueba.insertar(new TElementoAB(7, new Producto(4, 4)));

        System.out.println(arbolPrueba.obtenerAltura());

        arbolPrueba.insertar(new TElementoAB(2, new Producto(5, 5)));
        arbolPrueba.insertar(new TElementoAB(15, new Producto(0, 0)));
        arbolPrueba.insertar(new TElementoAB(1, new Producto(4, 4)));
        arbolPrueba.insertar(new TElementoAB(4, new Producto(3, 3)));
        arbolPrueba.insertar(new TElementoAB(3, new Producto(1, 1)));
        arbolPrueba.insertar(new TElementoAB(10, new Producto(3, 3)));
        arbolPrueba.insertar(new TElementoAB(8, new Producto(24, 24)));
        arbolPrueba.insertar(new TElementoAB(19, new Producto(19, 0)));
        arbolPrueba.insertar(new TElementoAB(12, new Producto(9, 9)));

        Comparable resultado1 = arbolPrueba.mayorValor(3, 8);
        Comparable resultado2 = arbolPrueba.mayorValor(1, 3);
        Comparable resultado3 = arbolPrueba.mayorValor(19, 55);

        System.out.println(arbolPrueba.inOrden());
        System.out.println("Mayor valor entre 3 y 8: " + resultado1);
        System.out.println("Mayor valor entre 1 y 3: " + resultado2);
        System.out.println("Mayor valor entre 19 y 55: " + resultado3);

        String hojas = arbolPrueba.obtenerHojasConNivel();
        System.out.println(hojas);

        System.out.println(Fibonaccis.fibonacciFactorialIterativo(4));

        TArbolBB arbolsete = new TArbolBB();
        arbolsete.inOrden();

        System.out.println("*** CANTIDAD HOJAS DEL ARBOL ***");

    }

}
