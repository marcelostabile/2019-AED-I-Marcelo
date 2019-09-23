/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut04arbolbexpresiones;

/**
 *
 * @author mstabile
 */
public interface IArbolBinario<T> {

    // Buscar.
    TElementoAB<T> buscar(Comparable unaEtiqueta);

    // Eliminar un nodo dada una etiqueta.
    void eliminar(Comparable unaEtiqueta);

    // EsVacio.
    boolean esVacio();

    // Insertar.
    boolean insertar(TElementoAB<T> unElemento);

    // Recorrido inOrden.
    String recorrerInOrden();

    // Recorrido postOrden.
    String recorrerPostOrden();

    // Recorrido preOrden.
    String recorrerPreOrden();
    
}
