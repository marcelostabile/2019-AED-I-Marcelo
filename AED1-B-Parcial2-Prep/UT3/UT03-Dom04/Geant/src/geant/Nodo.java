/*
 *  NODO
 */
package geant;

/**
 *
 * @author mstabile
 */
public class Nodo<T> implements INodo<T> {
    
    private Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente = null;
    
    public Nodo (Comparable etiqueta, T dato) {
        
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    // Etiqueta.
    public Comparable getEtiqueta() {
        
        return this.etiqueta;
    }
    
    // Dato.
    public T getDato() {
        
        return this.dato;
    }
            
    // Siguiente.
    public void setSiguiente(Nodo<T> siguiente) {
        
        this.siguiente = siguiente;
    }
    
    public Nodo<T> getSiguiente() {
        
        return this.siguiente;
    }    

    public Nodo<T> clonar() {
        
        return new Nodo<>(this.etiqueta, this.dato);
    }

    public void imprimir() {
               
        System.out.println(this.etiqueta);
    }
}
