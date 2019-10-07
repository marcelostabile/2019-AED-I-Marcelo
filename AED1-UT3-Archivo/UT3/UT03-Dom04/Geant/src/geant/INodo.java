/*
 * INODO
 */
package geant;

/**
 *
 * @author mstabile
 */
public interface INodo<T> {

    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();
    
    /**
     * devuelve el dato del nodo
     *
     * @return
     */
    public T getDato();

    /**
     * "engancha" otro nodo a continuacion
     *
     */
    public void setSiguiente(Nodo<T> nodo);
    
    /**
     * devuelve el siguiente del nodo
     *
     * @return
     */
    public Nodo<T> getSiguiente();

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
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);


}
