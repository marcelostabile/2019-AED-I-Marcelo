/**
 * CLASE TArbolBB.
 */
package ut4ta9;

/**
 * @author EQUIPO 1.
 */
public class TArbolBB<T> implements IArbolBB<T> {

    // Atributos.
    private IElementoAB<T> raiz;

    public static final String separadorGuion = "-";

    // Constructor.
    public TArbolBB() {
        this.raiz = null;
    }

    /**
     * Devuelve la raiz, si no existe retorna null.
     *
     * @return raiz.
     */
    @Override
    public IElementoAB<T> getRaiz() {
        return this.raiz;
    }

    /**
     * Asignar raiz.
     * 
     * @param unaRaiz.
     */
    public void setRaiz(IElementoAB<T> unaRaiz) {
        this.raiz = unaRaiz;
    }

    /**
     * Insertar un elemento.
     *
     * @param unElemento
     * @return boolean.
     */
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * Buscar un elemento.
     * 
     * @param unaEtiqueta (Comparable).
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * Devuelve si la raíz está vacía, teniendo valor null.
     * 
     * @return boolean.
     */
    @Override
    public boolean esVacio() {
        return (raiz == null);
    }

    /** 
     * Recorrido en preOrden.
     */
    @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    /** 
     * Recorrido en inOrden.
     */
    @Override
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    // Recorrido en inOrden, pasando una ILista<T>.
    @Override
    public void inOrden(Lista<T> unaLista) {
        if (!esVacio()) {
            raiz.inOrden(unaLista);
        }
    }

    /** 
     * Recorrido en postOrden.
     */
    @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }

    /** 
     * Eliminar un nodo dada una etiqueta.
     */
    @Override
    public void eliminar(Comparable unaEtiqueta) {

        // Verificamos si el árbol contiene elementos o está vacío.
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        } else {
            System.out.println("El árbol no contiene elementos.");
        }
    }

    /**
     * Determina si el árbol es completo.
     *
     * @return boolean <- verdadero = es completo.
     */
    @Override
    public boolean esCompleto() {
        // Verificamos si el árbol NO contiene elemento (raíz == null).
        if (esVacio()) {
            return false;
        } else {
            return raiz.esCompleto();
        }
    }

    /**
     * Obtener el nivel donde se encuentra una etiqueta dada.
     *
     * @param unaEtiqueta
     * @return integer.
     */
    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (esVacio()) {
            return -1;
        } else {
            return raiz.obtenerNivel(unaEtiqueta);
        }
    }

    /**
     * Obtener la altura de un árbol.
     *
     * @return altura del árbol.
     */
    @Override
    public int obtenerAltura() {
        if (raiz != null) {
            return raiz.obtenerAltura();
        }
        return 0;
    }

    /**
     * Obtener el tamaño de un árbol.
     *
     * @return tamaño del árbol.
     */
    @Override
    public int obtenerTamanio() {
        if (raiz != null) {
            return raiz.obtenerTamanio();
        }
        return 0;
    }

    /**
     * Obtener la cantidad de hojas.
     *
     * @return integer.
     */
    @Override
    public int obtenerCantidadHojas() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerCantidadHojas();
        }
    }

    /**
     * Retorna cantidades de nodos internos no completos.
     *
     * @return integer. Cantidad de nodos internos no completos.
     */
    @Override
    public int internosNoCompletos() {
        if (esVacio()) {
            return 0;
        } else 
        {
            return raiz.internosNoCompletos();
        }
    }

    /**
     * Retorna cantidades de nodos internos completos.
     *
     * @return integer. Cantidad de nodos internos completos.
     */
    @Override
    public int internosCompletos() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.internosCompletos();
        }
    }

    /**
     * Retorna clave inmediata anterior.
     *
     * @param etiqueta clave del elemento.
     * @return clave del elemento.
     */
    @Override
    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta) {
        return raiz.obtenerClaveInmediataAnterior(etiqueta);
    }

    /**
     * Retorna clave inmediata anterior.
     *
     * @param etiqueta clave del elemento.
     * @param predecesor auxiliar para guardar predecesor.
     * @return clave del elemento.
     */
    @Override
    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta, Comparable predecesor) {
        return raiz.obtenerClaveInmediataAnterior(etiqueta, predecesor);
    }

    /**
     * Retorna clave inmediata posterior
     *
     * @param etiqueta clave del elemento
     * @return clave del elemento
     */
    @Override
    public Comparable obtenerClaveInmediataPosterior(Comparable etiqueta) {
        return raiz.obtenerClaveInmediataPosterior(etiqueta);
    }

    /**
     * Retorna clave inmediata posterior
     *
     * @param etiqueta clave del elemento
     * @param sucesor auxiliar para guardar sucesor
     * @return clave del elemento
     */
    @Override
    public Comparable obtenerClaveInmediataPosterior(Comparable etiqueta, Comparable sucesor) {
        return raiz.obtenerClaveInmediataPosterior(etiqueta, sucesor);
    }

    /**
     * Retorna padre del elemento con la clave buscada
     *
     * @param clave
     * @return elemento padre
     */
    @Override
    public TElementoAB<T> obtenerPadre(Comparable clave) {
        return raiz.obtenerPadre(clave);
    }

    /**
     * Devuelve un string con las hojas de un nivel.
     *
     * @return string
     */
    @Override
    public String obtenerHojasConNivel(int cont) {
        if (esVacio()) {
            return "No hay hojas";
        } else {
            return raiz.obtenerHojasConNivel(cont);
        }
    }

    /**
     * Retorna si este es un árbol de búsqueda.
     *
     * @return boolean.
     */
    @Override
    public boolean esABB() {
        if (esVacio()) {
            return true;
        } else {
            return raiz.esABB();
        }
    }

}
