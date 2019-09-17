/*
 * INTERFASE INODO
 */
package ut04arboles0;

/**
 * @author EQUIPO
 */
public interface INodo<T> {

   // Dato.
    T getDato();
    void setDato(T dato);
    
    // Etiqueta.
    Comparable getEtiqueta();
    void setEtiqueta(Comparable etiqueta);
    
    // Hoja Derecha.
    INodo<T> getHojaDerecha();
    void setHojaDerecha(Nodo hojaDerecha);
    
    // Hoja Izquierda.
    INodo<T> getHojaIzquierda();
    void setHojaIzquierda(Nodo hojaIzquierda);
    
    // Padre.
    INodo<T> getPadre();
    void setPadre(Nodo padre);
    
    // Clonar.
    Nodo<T> clonarSinReferencias();

    int compareTo(Comparable etiqueta);

    int compareTo(INodo<T> unNodo);

    boolean equals(INodo unNodo);
    
    void imprimir();

    void imprimirEtiqueta();
    
}
