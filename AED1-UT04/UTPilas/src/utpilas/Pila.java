/*
 * CLASE PILA.
 */
package utpilas;

/**
 * @author mstabile.
 */
public class Pila<T> implements IPila<T> {
    
    /**
     * CARACTERISTICA: LIFO (Last In, First Out)
     */
    
    // Crear pila.
    Lista<T> pilaBase = new Lista<>();
    
    // Constructor.
    public Pila () { 
    }
    
    // Apilar.
    @Override
    public void apilar(INodo<T> nodoNuevo) { 
        this.pilaBase.insertar(nodoNuevo.clonar());
    }
    
    // Desapilar.
    @Override
    public INodo<T> desapilar() { 
        // Si la lista està vacia, retorna nulo.
        if (this.pilaBase.esVacia()) { 
            return null;
        }
        else { 
            // Si solo existe primero, retornamos primero, queda la pila vacía.
            if (this.pilaBase.getPrimero().getSiguiente() == null) { 
                INodo<T> nodoAux = this.pilaBase.getPrimero().clonar();
                this.pilaBase.eliminar(this.pilaBase.getPrimero().getEtiqueta());
                return nodoAux;
            }
            else {
                // Si hay otros elementos, retorna el más de arriba.
                INodo<T> nodoAnterior = null;
                INodo<T> nodoAux = this.pilaBase.getPrimero();
                while (nodoAux.getSiguiente() != null) { 
                    nodoAnterior = nodoAux;
                    nodoAux = nodoAux.getSiguiente();
                }
                // Eliminar nodo, retornar resultado.
                nodoAnterior.setSiguiente(null);
                return nodoAux;
            }
        }
    }
    
    // Pila está vacía.
    @Override
    public boolean esVacia() {
        return (pilaBase.getPrimero() == null);
    }
    
}
