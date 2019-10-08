package SegundoParcial;

import java.util.LinkedList;

public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operaci�n
     */
    public boolean insertar(IElementoAB<T> unElemento);

    /**
     * Busca un elemento dentro del �rbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar. .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param unaEtiqueta
     * @return
     */
    public void eliminar(Comparable unaEtiqueta);

    /**
     * Imprime en PreOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();

    /**
     * Imprime en InOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    /**
     * Imprime en PostOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden();

    /**
     *
     *
     * @return una LinkedList con las etiquetas del recorrido.
     *
     */
    public LinkedList<Comparable> inorden();

    /**
     * Altura total de arbol
     *
     * @return
     */
    public int obtenerAltura();

    /**
     * Cantidad de elementos
     *
     * @return
     */
    public int obtenerTamanio();

    /**
     * Nivel de una etiqueta
     *
     * @param unaEtiqueta
     * @return
     */
    public int obtenerNivel(Comparable unaEtiqueta);

    /**
     * Cantiadad de hojas
     *
     * @return
     */
    public int obtenerCantidadHojas();

    /**
     * Clave menor
     *
     * @return
     */
    public Comparable obtenerMenorClave();

    /**
     * Clave mayor
     *
     * @return
     */
    public Comparable obtenerMayorClave();

    /**
     * Clave anterior
     *
     * @param clave
     * @return
     */
    public Comparable claveAnterior(Comparable clave);

    /**
     * Cantidad de elementos en un nivel
     *
     * @param nivel
     * @return
     */
    public int cantNodosNivel(int nivel);

    /**
     * Cantidad de hojas
     *
     * 
     */
    public void listarHojas();

    /**
     * Es arbol de busqueda?
     *
     * @return
     */
    public boolean esArbolBusqueda();

}
