package parcial2fromta9;

public interface ILista<E> {

    /**
     * Método encargado de agregar un nodo al final de la lista.
     *
     * @param nodo - Nodo a agregar
     */
    public void insertar(INodo<E> nodo);

    /**
     * Método encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    public INodo buscar(Comparable clave);

    /**
     * Método encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminación haya sido efectuada con éxito.
     */
    public boolean eliminar(Comparable clave);
   
    
    /**
     * Método encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return Retorna el nodo eliminado.
     */
    public INodo eliminarNodo(Comparable clave);

    /**
     * Método encargado de imprimir en consola las claves de los nodos
     * contenidos en la lista.
     */
    public String imprimir();

    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * par�metro.
     *
     * @param separador Separa las claves
     * @return
     */
    public String imprimir(String separador);

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vac�a, retornar 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Si tiene elementos o no.
     */
    public boolean esVacia();

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo de la lista.
     */
    public INodo<E> getPrimero();

    /**
     * Insertar nodo ordenado (INSERCIÓN DIRECTA).
     * 
     * @param nodo (INodo--E--)
     */
    void insertarNodoOrdenado(INodo<E> nodo);

}
