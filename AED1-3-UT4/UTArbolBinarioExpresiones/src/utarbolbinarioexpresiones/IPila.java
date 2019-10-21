/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utarbolbinarioexpresiones;

/**
 * @author mstabile
 */
public interface IPila<T> {

    // Apilar.
    void apilar(INodo<T> nodoNuevo);

    // Desapilar.
    INodo<T> desapilar();

    // Pila está vacía.
    boolean esVacia();
    
}
