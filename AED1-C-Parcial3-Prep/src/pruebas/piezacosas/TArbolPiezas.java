package pruebas.piezacosas;

import tdaarbolbb.*;
import TDALista.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class TArbolPiezas extends TArbolBB<Pieza> implements IArbolPiezas {

    @Override
    public TArbolPiezas piezasPorRubro(String unRubro) {
        TArbolPiezas arbolPiezas = new TArbolPiezas();
        Lista<Pieza> listaPiezas = new Lista();
        this.inOrden(listaPiezas);
        Nodo<Pieza> nodoActual;
        Pieza piezaActual;

        if (this.getRaiz() == null) {
            return arbolPiezas;
        }

        // Genero lista inorden del arbol y recorro
        nodoActual = listaPiezas.getPrimero();
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            // Inserto pieza si coincide con rubro
            if (piezaActual.obtenerRubro().equals(unRubro)) {
                arbolPiezas.insertar(new TElementoAB<>(piezaActual.getCodigoCatalogo(), piezaActual));
            }
            nodoActual = nodoActual.getSiguiente();
        }

        // Retorno nuevo arbol
        return arbolPiezas;
    }

    @Override
    public int[] cantYvalorStock() {
        int cantValor[] = new int[2];
        Nodo<Pieza> nodoActual;
        Lista<Pieza> listaPiezas = new Lista();
        Pieza piezaActual;
        if (this.getRaiz() == null) {
            return cantValor;
        }

        // Genero lista inorden del arbol y recorro
        this.inOrden(listaPiezas);
        nodoActual = listaPiezas.getPrimero();
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            // Actualizo arreglo
            cantValor[0] += piezaActual.getCantidad();
            cantValor[1] += piezaActual.getValorEnStock();
            nodoActual = nodoActual.getSiguiente();
        }

        // Retorno arreglo
        return cantValor;
    }

}
