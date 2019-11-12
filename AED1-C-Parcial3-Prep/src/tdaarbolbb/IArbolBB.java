package tdaarbolbb;

import TDALista.*;
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
     */
    public void eliminar(Comparable unaEtiqueta);

    /**
     * Imprime en InOrden los elementos del �rbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    public String preOrden();

    public String postOrden();

    public IElementoAB getRaiz();

    public int internosNoCompletos();

    public int internosCompletos();

    public boolean esABB();

    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta);

    public TElementoAB<T> obtenerPadre(Comparable clave);

    public Lista<TElementoAB> obtenerNodosNivel(int unNivel);

    public void inOrden(ILista<T> unaLista);

    public Lista<T> inorden();

    public String obtenerHojasConNivel();

    public TArbolBB armarIndiceCarrera(Comparable laCarrera);

    public LinkedList<T> inOrdenLinkedList();

    public int longTray();

    public boolean esArbolAvl();

    public boolean cumpleAVL();

    public int nivelClave(Comparable unaClave);

    public int nivelMasProfundo();

    public int obtenerAltura();

    public void listarClavesyFrecuencias(String[] claves, int[] FE, int[] FNE);

    public void actualizarFrecuencias(Comparable clave);

    public Lista<T> preOrdenLista();

    public long calcularCosto(int[] FrecExito, int[] FrecNoExito);
    
    public Lista<T> clavesNivel(int unNivel);
}
