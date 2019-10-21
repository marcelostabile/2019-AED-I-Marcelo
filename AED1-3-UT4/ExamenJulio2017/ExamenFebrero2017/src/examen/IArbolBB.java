package examen;

import java.util.ArrayList;

public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operación
     */
    public boolean insertar(TElementoAB<T> unElemento);

    /**
     * devuelve un arrayList que contiene todos los elementos del arbol
     * ordenados en forma ascendente por su etiqueta.
     *
     * @return
     */
    public ArrayList<T> listar();

}
