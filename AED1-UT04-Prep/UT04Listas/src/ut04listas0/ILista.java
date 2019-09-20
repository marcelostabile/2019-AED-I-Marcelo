/* 
 * INTERFASE ILISTA 
 */
package ut04listas0;

/**
 * @author EQUIPO
 */
public interface ILista<T> {

    /**
     * Agregar un nodo al final de la lista.
     *
     * @param nodo - Nodo para agregar.
     */
    public void insertar(INodo<T> nodo);

    /**
     * Buscar un nodo por su etiqueta.
     *
     * @param clave - Clave del nodo a buscar.
     * @return Devuelve el nodo encontrado o en caso contrario null.
     */
    public INodo buscar(Comparable clave);

    /**
     * Eliminar un nodo con la clave indicada.
     *
     * @param clave - Clave del nodo a eliminar.
     * @return Devuelve true en caso de que la eliminación haya sido efectuada con éxito.
     */
    public boolean eliminar(Comparable clave);

    /**
     * Eliminar un nodo con la clave indicada.
     *
     * @param clave - Clave del nodo a eliminar.
     * @return Devuelve el nodo eliminado.
     */
    public INodo eliminarRetornandoNodo(Comparable clave);

    
    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Devuelve false si tiene elementos o true si es vacia.
     */
    public boolean esVacia();

    /**
     * Retorna la cantidad de elementos de la lista. 
     * En caso de que la lista este vacía, retornar 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    public int cantElementos();

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo de la lista.
     */
    public INodo<T> getPrimero();
    
//    /**
//     * Insertar ordenado por SELECCIÓN DIRECTA.
//     * 
//     * @param unNodo
//     */
//    public void insertarOrdenadoSeleccionDirecta(INodo<T> unNodo);
//
//    /**
//     * Insertar ordenado por INSERCIÓN DIRECTA.
//     * 
//     * @param unNodo
//     */
//    public void insertarOrdenadoInsercionDirecta(INodo<T> unNodo);
//
//    /**
//     * Retornar una lista nueva con estos elementos ordenada por clave.
//     */
//    public ILista<T> reordenarListaPorClave();
//
//    /**
//     * Retornar una lista nueva con estos elementos ordenada por un campo del dato.
//     * En este ejemplo, nombre del elemento.
//     */
//    public ILista<T> reordenarListaPorDatoNombre();

    /**
     * Imprime en consola las claves de los nodos contenidos en la lista.
     */
    public String imprimir();

    /**
     * Devuelve un String con las claves separadas por el separador de parámetro.
     *
     * @param separador Separa las claves
     * @return
     */
    public String imprimir(String separador);

}
