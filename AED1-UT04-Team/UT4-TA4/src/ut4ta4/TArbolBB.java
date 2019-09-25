package ut4ta4;

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
        if (esVacio()) {
            return null;
        } else {
            return raiz.preOrden();
        }
    }
    
    @Override
    // Recorrido inOrden.
    public String inOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.inOrden();
        }
    }
    
    @Override
    // Recorrido postOrden.
    public String postOrden() {
        if (esVacio()) {
            return null;
        } else {
            return raiz.postOrden();
        }
    }
    
    @Override
    // Eliminar un nodo dada una etiqueta.
    public void eliminar(Comparable unaEtiqueta) {
        
        // Verificamos si el árbol contiene elementos o está vacío.
        if (raiz != null) { 
            raiz = raiz.eliminar(unaEtiqueta);
        }
        else {
            // Sino, mensaje en consola.
            System.out.println("El árbol no contiene elementos.");
        }
    }

    /**
     * Obtener el nivel donde se encuentra una etiqueta dada.
     * 
     * @param unaEtiqueta
     * @return 
     */
    @Override
    public int obtenerNivel(Comparable unaEtiqueta) { 
        if (raiz != null) { 
            return raiz.obtenerNivel(unaEtiqueta);
        } 
        else {
            return -1;
        }
    }


    @Override
    public int obtenerAltura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerTamanio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Obtener la cantidad de hojas.
     * 
     * @return int
     */
    @Override
    public int obtenerCantidadHojas() { 
        if (!this.esVacio()) { 
            return this.obtenerCantidadHojas();
        } 
        else {
            return 0;
        }
    }
    
    
    
}
