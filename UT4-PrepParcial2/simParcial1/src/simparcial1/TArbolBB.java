package simparcial1;

public class TArbolBB<T> implements IArbolBB<T> {

    protected IElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @param unElemento
     * @return
     */
    @Override
    public boolean insertar(IElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @SuppressWarnings("unchecked")
    public IElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    /**
     * @return recorrida en inorden del arbol, null en caso de ser vacío
     */
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }

    /**
     * @return recorrida en preOrden del arbol, null en caso de ser vacío
     */
    /**
     * @return
     */
    public boolean esVacio() {
        return (raiz == null);
    }

    /**
     * @return True si habían elementos en el árbol, false en caso contrario
     */
    public boolean vaciar() {
        if (!esVacio()) {
            raiz = null;
            return true;
        }
        return false;
    }

    @Override
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }


    @Override
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public IElementoAB getRaiz() {

        return this.raiz;
    }

    public boolean esCompleto() {
        if (esVacio()) {
            return false;
        } else {
            return raiz.esCompleto();
        }
    }

    public int obtenerCantidadHojas() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerCantidadHojas();
        }
    }

    public int obtenerNivel(Comparable unaEtiqueta) {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerNivel(unaEtiqueta);
        }
    }

    public int obtenerAltura() {

        if (raiz != null) {
            return raiz.obtenerAltura();
        }
        return 0;
    }

    public int obtenerTamaño() {
        if (raiz != null) {
            return raiz.obtenerTamaño();
        }
        return 0;
    }

    @Override
    public int internosNoCompletos() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.internosNoCompletos();
        }
    }

    @Override
    public int internosCompletos() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.internosCompletos();
        }
    }

    // imprime el nivel de las hojas
    @Override
    public String obtenerHojasConNivel() {
        if (esVacio()) {
            return "No hay hojas";
        } else {
            return raiz.obtenerHojasConNivel(0);
        }
    }

    @Override
    public boolean esABB() {
        if (esVacio()) {
            return true;
        } else {
            return raiz.esABB();
        }
    }

    @Override
    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta) {
        return raiz.obtenerClaveInmediataAnterior(etiqueta);
    }

    @Override
    public TElementoAB<T> obtenerPadre(Comparable clave) {
        return raiz.obtenerPadre(clave);
    }
}
