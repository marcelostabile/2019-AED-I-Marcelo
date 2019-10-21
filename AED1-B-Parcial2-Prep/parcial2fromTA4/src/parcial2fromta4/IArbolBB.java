package parcial2fromta4;

public interface IArbolBB<T> {

    /**
     * Obtener la raiz, si no existe retorna null.
     * @return raiz.
     */
    public IElementoAB getRaiz();
            
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
     * EsVacio.
     */
    public boolean esVacio();
            
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
     * Determina si el árbol es completo.
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
     * @return altura del árbol.
     */
    public int obtenerAltura();

    /**
     * Obtener el tamaño de un árbol.
     * 
     * @return tamaño del árbol.
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

