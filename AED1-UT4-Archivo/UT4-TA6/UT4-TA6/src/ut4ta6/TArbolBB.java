package ut4ta6;

public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

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
    public boolean insertar(TElementoAB<T> unElemento) {
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
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
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
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (esVacio()) {
            return -1;
        } else {
            return raiz.obtenerNivel(unaEtiqueta);
        }
    }

    /*
    version Marcelo
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (raiz != null) {
            return raiz.obtenerNivel(unaEtiqueta);
        } else {
            return -1;
        }
    }
     */
    @Override
    public int obtenerAltura() {
        if (raiz != null) {
            return raiz.obtenerAltura();
        }
        return 0;
    }

    @Override
    public int obtenerTamanio() {
        if (raiz != null) {
            return raiz.obtenerTamanio();
        }
        return 0;
    }

    @Override
    public int obtenerCantidadHojas() {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.obtenerCantidadHojas();
        }
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    // Recorrido preOrden.
    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }

    // Recorrido postOrden.
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }
}
