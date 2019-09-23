/*
 * ARBOL BINARIO.
 */
package ut04arbolbexpresiones;

/**
 * @author mstabile
 */
public class TArbolB<T> implements IArbolB<T> {

    // Atributos.
    private IElementoAB<T> raiz;

    // Constructor.
    public TArbolB() {
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
    @Override
    public boolean esVacio() {
        return (raiz == null);
    }

    // Recorrido preOrden.
    @Override
    public String recorrerPreOrden() {
        return raiz.preOrden();
    }

    // Recorrido inOrden.
    @Override
    public String recorrerInOrden() {
        return raiz.inOrden();
    }

    // Recorrido postOrden.
    @Override
    public String recorrerPostOrden() {
        return raiz.postOrden();
    }

    // Eliminar un nodo dada una etiqueta.
    @Override
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
}
