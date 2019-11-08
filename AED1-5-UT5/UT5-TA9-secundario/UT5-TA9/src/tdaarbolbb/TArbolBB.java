package tdaarbolbb;

import TDALista.*;
import java.util.LinkedList;

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
    
    @Override
    public Lista<TElementoAB> obtenerNodosNivel(int unNivel) {
        Lista<TElementoAB> listaElementos = new Lista();
        return raiz.obtenerNodosNivel(listaElementos, unNivel);
    }
    
    @Override
    public void inOrden(ILista<T> unaLista) {
        if (!esVacio()) {
            raiz.inOrden(unaLista);
        }
    }
    
    @Override
    public Lista<T> inorden() {
        Lista<T> nuevaLista = null;
        
        if (this.raiz == null) {
            return nuevaLista;
        }
        
        nuevaLista = new Lista<T>();
        this.raiz.inOrden(nuevaLista);
        return nuevaLista;
    }
    
    @Override
    public LinkedList<T> inOrdenLinkedList() {
        LinkedList<T> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;
        
    }
    
    @Override
    public int calcularCosto(int[] FrecExito, int[] FrecNoExito) {
        if (raiz != null) {
            int[] indice = {0};
            return raiz.calcularCosto(FrecExito, FrecNoExito, indice, 1);
        } else {
            return 0;
        }
    }
    
    @Override
    public void cuentaFrec(Comparable unaClave) {
        if (!esVacio()) {
            raiz.cuentaFrec(unaClave);
        }
    }
    
    @Override
    public void completarVectores(String[] claves, int[] frecExito, int[] frecNoExito) {
        
        if (!esVacio()) {
            int cantidadElementos = claves.length;
            frecExito = new int[cantidadElementos + 1];
            frecNoExito = new int[cantidadElementos + 1];
            
            raiz.completarVectores(claves, frecExito, frecNoExito);
        }
        
    }
    
}
