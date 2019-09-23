/*
 * CLASE NODO.
 */
package ut4_listas1;

/**
 * @author EQUIPO.
 */
public class Nodo<T> implements INodo<T> {

    // Atributos.
    private Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    // Constructor.
    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    public Nodo() {
        this.etiqueta = null;
    }

    // Etiqueta.
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void setEtiqueta(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
    }

    // Dato.
    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }
    
    // Siguiente.
    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }
    
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void setSiguiente(INodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }
    
    @Override
    public void imprimir() {
        System.out.println(this.etiqueta + " " + dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    @Override
    public boolean equals(INodo unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
    
    @Override
    public int compareTo(INodo<T> unNodo) {
        return this.etiqueta.compareTo(unNodo.getEtiqueta());
    }

    
}
