package utpilas;

/**
 * @author EQUIPO
 */
public class Nodo<T> implements INodo<T> {

    private final Comparable etiqueta;
    private T dato;
    private INodo<T> siguiente = null;

    /*
    * Constructor.
    */
    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    /*
    * Constructor.
    */
    public Nodo() {
        this.etiqueta = null;
    }

    /**
    * Etiqueta.
    * 
    * @return etiqueta.
    */        
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }
    
    /**
     * Retorna el dato contenido en el nodo.
     *
     * @return Dato contenido en el nodo.
     */
    @Override
    public T getDato() {
        return this.dato;
    }

    /**
     * Asigna un dato al nodo.
     *
     * @param dato a asignar.
     */
    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Retorna el siguiente nodo al nodo actual.
     *
     * @return Siguiente nodo del actual
     */
    @Override
    public INodo<T> getSiguiente() {
        return this.siguiente;
    }

    /**
     * Asigna el siguiente nodo al nodo actual.
     *
     * @param nodo Nodo a asignar como siguiente.
     */
    @Override
    public void setSiguiente(INodo<T> nodo) {
        this.siguiente = nodo;
    }
    
    /**
    * Imprimir.
    * 
    * Imprime la etiqueta y el dato en formato String.   
    */ 
    @Override
    public void imprimir() {
        System.out.println(this.etiqueta + " " + dato.toString());
    }

    /**
    * Imprimir Etiqueta.
    * 
    * Imprime solo la etiqueta.
    */ 
    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }
    
    /**
     * Equals.
     * Compara que el dato del nodo sea igual al dato del nodo proporcionado.
     *
     * @param unNodo
     * @return verdadero o falso.
     */
    @Override
    public boolean equals(INodo<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
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
     * Clonar un nodo
     * @return un nodo.
     */
    @Override
    public Nodo<T> clonar() {
        return new Nodo<>(this.etiqueta, this.dato);
    }

}
