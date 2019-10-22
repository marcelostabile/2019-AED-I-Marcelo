package ut4td2;

/**
 * @author EQUIPO 1
 */
public class Nodo<E> implements INodo<E> {

    private final Comparable etiqueta;
    private E dato;
    private INodo<E> siguiente = null;

    /*
    * Constructor.
    */
    public Nodo(Comparable etiqueta, E dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    /*
    * Constructor.
    */
    public Nodo() {
        this.etiqueta = null;
    }

    /*
    * Dato.
    */    
    @Override
    public E getDato() {
        return this.dato;
    }

    @Override
    public void setDato(E dato) {
        this.dato = dato;
    }

    /*
    * Siguiente.
    */ 
    @Override
    public INodo<E> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(INodo<E> nodo) {
        this.siguiente = nodo;
    }
    
    /*
    * Imprimir.
    */ 
    @Override
    public void imprimir() {
        System.out.println(this.etiqueta + " " + dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }
    
    /*
     * Equals.
     *
     * @param unNodo
     * @return
     */
    @Override
    public boolean equals(INodo<E> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

    /*
    * Etiqueta.
    */        
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * CompareTo
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
    
    /**
     * Clonado del nodo.
     */
    @Override
    public Nodo<E> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

}

    /**
    @Override
    public void setSiguiente(INodo<E> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public boolean equals(INodo<E> unNodo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
