package ut4ta4;

public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operacián
     */
    public boolean insertar(TElementoAB<T> unElemento);

    /**
     * Busca un elemento dentro del árbol.
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden();
   
    /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta 
     */
    public void eliminar(Comparable unaEtiqueta);

    /**
     * Obtener el nivel donde se encuentra una etiqueta dada.
     * 
     * @param unaEtiqueta
     * @return 
     */
    public int obtenerNivel(Comparable unaEtiqueta);
    
    /**
     * Obtener la altura de un árbol.
     * 
     * @return altura del árbol.
     */
    public int obtenerAltura();

    /**
     * Obtener la tamaño de un árbol.
     * 
     * @return tamaño del árbol.
     */
    public int obtenerTamanio();

}

