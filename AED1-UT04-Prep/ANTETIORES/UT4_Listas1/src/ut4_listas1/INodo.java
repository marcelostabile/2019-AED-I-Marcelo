/*
 * INTERFASE INODO
 */
package ut4_listas1;

/**
 * @author EQUIPO
 */
public interface INodo<T> {

    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();

    /**
     * Asignar la etiqueta al nodo
     *
     * @param unaEtiqueta a asignar.
     */
    public void setEtiqueta(Comparable unaEtiqueta);

    /**
     * Retorna el dato contenido en el nodo.
     *
     * @return Dato contenido en el nodo.
     */
    public T getDato();

    /**
     * Asigna un dato al nodo.
     *
     * @param dato a asignar.
     */
    public void setDato(T dato);

    /**
     * Retorna el siguiente nodo al nodo actual.
     *
     * @return Siguiente nodo del actual
     */
    public INodo<T> getSiguiente();

    /**
     * Asigna el siguiente nodo al nodo actual.
     *
     * @param nodo Nodo a asignar como siguiente.
     */
    public void setSiguiente(INodo<T> nodo);

    /**
     * Clonar el nodo.
     * 
     * @return Retorna un clon del nodo.
     */
    public Nodo<T> clonar();
    
    /**
     * Imprime los datos del nodo
     */
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     * Compara la etiqueta de este nodo con un nodo pasado por parámetro.
     *
     * @param unNodo
     * @return devuelve "verdadero" si son iguales, "falso" si no lo son.
     */
    public boolean equals(INodo<T> unNodo);

        /**
     * Comparación de etiquetas.
     * 
     * @param unaClave
     * @return devueve "-1" si tiene etiqueta menor, "0" si son iguales, "1" si es mayor.
     */
    public int compareTo(Comparable unaClave);
    
    /**
     * Compara la etiqueta de este nodo con un nodo pasado por parámetro.
     * 
     * @param unNodo
     * @return devueve "-1" si tiene etiqueta menor, "0" si son iguales, "1" si es mayor.
     */
    public int compareTo(INodo<T> unNodo);

    
}
