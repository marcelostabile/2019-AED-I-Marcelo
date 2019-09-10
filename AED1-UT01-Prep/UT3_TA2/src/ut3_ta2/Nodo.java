/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_ta2;

public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    public Nodo() {
        this.etiqueta = null;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public void imprimir() {
        System.out.println(this.etiqueta + " " + dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

    /**
     *
     * @param unNodo
     * @return
     */
    public boolean equals(Nodo unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

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
    public boolean equals(INodo<T> unNodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
