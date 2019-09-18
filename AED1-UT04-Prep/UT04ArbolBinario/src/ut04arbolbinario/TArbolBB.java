package ut04arbolbinario;

/**
 * @author EQUIPO
 */
public class TArbolBB<T> implements IArbolBB<T> {

    // public static final String separadorGuion = "-";

    // Atributos.
    private IElementoAB<T> raiz;

    // Constructor.
    public TArbolBB() {
        this.raiz = null;
    }

    // Insertar.
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } 
        else {
            return raiz.insertar(unElemento);
        }
    }

    // Buscar.
    @Override
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

    @Override
    // Recorrido preOrden.
    public String preOrden() {
        return raiz.preOrden();
    }
    
    @Override
    // Recorrido inOrden.
    public String inOrden() {
        return raiz.inOrden();
    }
    
    @Override
    // Recorrido postOrden.
    public String postOrden() {
        return raiz.postOrden();
    }
    
}
