package ut04arbolbinario;

/**
 * @author EQUIPO
 */
public class TArbolBB<T> implements IArbolBB<T> {

    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

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

    // Recorrido preOrden.
    
    // Recorrido inOrden.
    
    // Recorrido postOrden.
    
    
    
    
    
    
    
    
}
