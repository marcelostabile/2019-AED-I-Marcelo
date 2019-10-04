/*
 * Clase Nodo
 */
package pkg02.listaencadenada1;

/**
 *
 * @author Marcelo Stabile
 */
public class Nodo {
    
    // Variables de instanacia.
    int carga;
    Nodo prox;
    
    // Constructor.
    public Nodo() {
        
        carga = 0;
        prox  = null;
    }
    
    // Constructor.
    public Nodo (int carga, Nodo prox) {
        
        this.carga = carga;
        this.prox = prox;
    }
    
    // Retorna el valor de la carga.
    public String toString() {
        
        return carga + "";
    }
}
