package examen;

public class Nodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;

    }

    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;

    }

    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

   
   

}
