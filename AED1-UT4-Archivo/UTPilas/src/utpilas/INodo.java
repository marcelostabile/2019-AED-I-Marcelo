/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utpilas;

/**
 * @author mstabile
 */
public interface INodo<T> {

    /**
    * Etiqueta.
    * 
    * @return etiqueta.
    */        
    Comparable getEtiqueta();
    
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
    void setDato(T dato);
    
    /**
     * Retorna el siguiente nodo al nodo actual.
     *
     * @return Siguiente nodo del actual
     */
    INodo<T> getSiguiente();
    
    /**
     * Asigna el siguiente nodo al nodo actual.
     *
     * @param nodo Nodo a asignar como siguiente.
     */
    void setSiguiente(INodo<T> nodo);
    
    /**
     * Imprimir.
     *
     * Imprime la etiqueta y el dato en formato String.
     */
    void imprimir();

    /**
     * Imprimir Etiqueta.
     *
     * Imprime solo la etiqueta.
     */
    void imprimirEtiqueta();
    
    /**
     * Equals.
     * Compara que el dato del nodo sea igual al dato del nodo proporcionado.
     *
     * @param unNodo
     * @return verdadero o falso.
     */
    boolean equals(INodo<T> unNodo);

    /**
     * CompareTo
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    int compareTo(Comparable etiqueta);

    /**
     * Clonar un nodo
     * @return un nodo.
     */
    Nodo<T> clonar();
    
}
