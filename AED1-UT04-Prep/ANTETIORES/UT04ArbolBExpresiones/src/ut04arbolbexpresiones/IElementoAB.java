package ut04arbolbexpresiones;

public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public TElementoAB<T> getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(TElementoAB<T> elemento);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos();
    
    /**
     * Retorna el valor del siguiente nodo (usado en listas).
     * 
     */
    public TElementoAB getSiguiente();

    /**
     * Asignar el siguiente del nodo (usado en listas).
     * 
     */
    public void setSiguiente(TElementoAB elSiguiente);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(TElementoAB<T> elemento);

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden();

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @return String conteniendo el PostOrden
     */
    public String postOrden();

    /**
     * Elimina un elemento dada una etiqueta.
     * 
     * @param unaEtiqueta
     * @return el elemento eliminado o null.
     */
    public TElementoAB eliminar(Comparable unaEtiqueta);

    /**
     * Clonar el nodo.
     */
    TElementoAB<T> clonar();

    /**
     * Compara la etiqueta del nodo con la etiqueta pasada por param.
     * 
     * @param etiqueta
     * @return 
     */
    int compareTo(Comparable etiqueta);

    /**
     * Compara este nodo con otro nodo.
     * 
     * @param unNodo
     * @return 
     */
    int compareTo(IElementoAB<T> unNodo);

    /**
     * Compara si el nodo es igual a otro.
     * 
     * @param unNodo
     * @return 
     */
    boolean equals(IElementoAB unNodo);

    /**
     * Imprime info del nodo.
     */
    void imprimir();

    /**
     * Imprimir la etiqueta del nodo.
     */
    void imprimirEtiqueta();
    
}
