/*
 * CLASE NODO.
 */
package ut04arboles0;

/**
 * @author EQUIPO.
 */
public class Nodo<T> implements INodo<T> {

    // Atributos.
    private Comparable etiqueta;
    private T dato;
    
    // Atributos para referencias.
    private INodo<T> padre = null;
    private INodo<T> hojaIzquierda = null;
    private INodo<T> hojaDerecha = null;

    // Constructor.
    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    // Etiqueta.
    @Override
    public Comparable getEtiqueta() { 
        return this.etiqueta; 
    }

    @Override
    public void setEtiqueta(Comparable etiqueta) {
        this.etiqueta = etiqueta;
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

    // Padre.
    @Override
    public INodo<T> getPadre() { 
        return this.padre; 
    }

    @Override
    public void setPadre(Nodo padre) { 
        this.padre = padre; 
    }
    
    // Hoja Izquierda.
    @Override
    public INodo<T> getHojaIzquierda() { 
        return this.hojaIzquierda; 
    }
    
    @Override
    public void setHojaIzquierda(Nodo hojaIzquierda) { 
        this.hojaIzquierda = hojaIzquierda; 
    }    
    
    // Hoja Derecha.
    @Override
    public INodo<T> getHojaDerecha() { 
        return this.hojaDerecha; 
    }
    
    @Override
    public void setHojaDerecha(Nodo hojaDerecha) { 
        this.hojaDerecha = hojaDerecha; 
    }

    @Override
    public Nodo<T> clonarSinReferencias() {
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
