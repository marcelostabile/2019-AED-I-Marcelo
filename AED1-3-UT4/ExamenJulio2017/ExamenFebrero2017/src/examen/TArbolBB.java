package examen;

import java.util.ArrayList;

/**
 * @author Programacion2
 * @param <T>
 *
 */
public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    public TArbolBB() {
        raiz = null;
    }

    /**
     * @return
     */
    private boolean esVacio() {
        return (raiz == null);
    }

    @Override
    public ArrayList<T> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
