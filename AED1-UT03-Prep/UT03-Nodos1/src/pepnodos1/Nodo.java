/*
 * PEP1
 */
package pepnodos1;

/**
 * 
 * @author MS
 */
public class Nodo<T> implements INodo<T> {
    
    // Atributos.
    private final Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;
    
    // Constructor 1.
    public Nodo() {
        this.etiqueta = null;
    }

    // Constructor 2.
    public Nodo(Comparable Etiqueta, T Dato) {
        this.etiqueta = Etiqueta;
        this.dato = Dato;
    }
    
    // Etiqueta.
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }
    
    // Dato.
    @Override
    public T getDato() {
        return this.dato;
    }
    
    @Override
    public void setDato(T datoNuevo) {
        this.dato = datoNuevo;
    }
    
    // Siguiente.
    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }
    
    @Override
    public void setSiguiente(INodo<T> siguienteNuevo) {
        this.siguiente = siguienteNuevo;
    }

    // Clonar.
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }
    
    // Comparar.
    public boolean equals(Nodo otroNodo) { 
        return this.dato.equals(otroNodo.getDato());
    }
    
    // Comparar etiqueta.
    @Override
    public int compareTo(Comparable otraEtiqueta) {
        return this.etiqueta.compareTo(otraEtiqueta);
    }
    
    // Imprimir nodo.
    @Override
    public void imprimir() {
        System.out.println(this.etiqueta + ", " + this.dato.toString());
    }
    
    // Imprimir Etiqueta.
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

}
