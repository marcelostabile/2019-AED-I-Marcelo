
/**
 * @author EQUIPO 1
 */
public class TArbolBB<T> {

    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    // Atributos.
    private IElementoAB<T> raiz;

    // Constructor.
    public TArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    // Buscar.
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (esVacio()) {
            return null;
        } else {
            return raiz.buscar(unaEtiqueta);
        }
    }

    // EsVacio.
    public boolean esVacio() {
        return (raiz == null);
    }

    public String preOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }
    
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }
    
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }
}
