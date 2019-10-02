package ut4ta9;

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
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento);

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer();

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

    public void inOrden(Lista<T> unaLista);

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
     * Determina si es completo.
     *
     * @return boolean - verdadero = es completo.
     */
    public boolean esCompleto();

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
     * Retorna la altura del árbol cuya raíz es el nodo actual.
     *
     * @return altura del subárbol.
     */
    public int obtenerAltura();

    /**
     * Obtener la tamaño de un árbol.
     *
     * Retorna el tamaño del árbol cuya raíz es el nodo actual.
     *
     * @return tamaño del subárbol.
     */
    public int obtenerTamanio();

    /**
     * Obtener la cantidad de hojas.
     *
     * @return int
     */
    public int obtenerCantidadHojas();

    /**
     * Retorna cantidades de nodos internos no completos
     *
     * @return cantidad de nodos internos no completos
     */
    public int internosNoCompletos();

    /**
     * Retorna cantidades de nodos internos completos
     *
     * @return cantidad de nodos internos completos
     */
    public int internosCompletos();

    /**
     * Devuelve el mayor elemento.
     *
     * @return TElementoAB<T>.
     */
    public TElementoAB<T> obtenerMayorElemento();

    /**
     * Devuelve el menor elemento.
     *
     * @return TElementoAB<T>.
     */
    public TElementoAB<T> obtenerMenorElemento();

    /**
     * Retorna clave inmediata anterior
     *
     * @param etiqueta clave del elemento
     * @return clave del elemento
     */
    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta);

    /**
     * Retorna clave inmediata anterior
     *
     * @param etiqueta clave del elemento
     * @param predecesor auxiliar para guardar predecesor
     * @return clave del elemento
     */
    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta, Comparable predecesor);

    /**
     * Retorna clave inmediata posterior
     *
     * @param etiqueta clave del elemento
     * @return clave del elemento
     */
    public Comparable obtenerClaveInmediataPosterior(Comparable etiqueta);

    /**
     * Retorna clave inmediata posterior
     *
     * @param etiqueta clave del elemento
     * @param sucesor auxiliar para guardar sucesor
     * @return clave del elemento
     */
    public Comparable obtenerClaveInmediataPosterior(Comparable etiqueta, Comparable sucesor);

    /**
     * Retorna padre del elemento con la clave buscada
     *
     * @param clave
     * @return elemento padre
     */
    public TElementoAB<T> obtenerPadre(Comparable clave);

    /**
     * Devuelve un string con las hojas de un nivel.
     *
     * @param cont
     * @return string
     */
    public String obtenerHojasConNivel(int cont);

    /**
     * Retorna si este es un árbol de búsqueda.
     *
     * @return boolean.
     */
    public boolean esABB();

}
