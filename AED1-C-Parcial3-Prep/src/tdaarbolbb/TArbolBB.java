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
    public Lista<T> preOrdenLista() {
        Lista<T> listaPreOrden = new Lista<>();
        if (!esVacio()) {

            raiz.preOrdenLista(listaPreOrden);
        }
        return listaPreOrden;
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

    @Override
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

    public int mayorValor(int x, int y) {
        if (esVacio()) {
            return 0;
        } else {
            return raiz.mayorValor(x, y);
        }
    }

    public int mayorValor2(int x, int y) {
        if (esVacio()) {
            return 0;
        } else {
            return Integer.valueOf(raiz.mayorValor2(x, y).getEtiqueta().toString());
        }
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
    public TArbolBB armarIndiceCarrera(Comparable laCarrera) {
        if (esVacio()) {
            return null;
        } else {
            TArbolBB res = new TArbolBB();
            raiz.indizar(res, laCarrera);
            return res;
        }
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
    public int longTray() {
        if (raiz == null) {
            return 0;
        } else {
            return raiz.longTray(1);
        }
    }

    /**
     * Determina si este árbol BB es AVL
     *
     * @return verdadero si es árbol AVL
     */
    @Override
    public boolean esArbolAvl() {
        Integer esAvl;

        if (this.raiz == null) {
            return true;
        }

        esAvl = this.raiz.esArbolAvl();

        // Retorno verdadero si fue distinto de nulo
        // y falso si es nulo);
        return (esAvl != null);
    }

    @Override
    public boolean cumpleAVL() {
        Integer[] cumple = {null};

        if (this.raiz == null) {
            return true;
        }

        this.raiz.cumpleAVL(cumple);
        if (cumple[0] != null) {
            return ((cumple[0] >= -1) || (cumple[0] <= 1));
        } else {
            return false;
        }
    }

    @Override
    public int nivelClave(Comparable unaClave) {
        if (raiz == null) {
            return -1;
        }

        return raiz.nivelClave(unaClave);
    }

    @Override
    public int nivelMasProfundo() {
        if (raiz != null) {
            return raiz.nivelMasProfundo();
        }
        return 0;
    }

    @Override
    public void listarClavesyFrecuencias(String[] claves, int[] FE, int[] FNE) {
        if (this.esVacio()) {
            return;
        }
        int[] indice = new int[1];
        this.getRaiz().listarClavesyFrecuencias(claves, FE, FNE, indice);
    }

    @Override
    public void actualizarFrecuencias(Comparable clave) {
        if (this.esVacio()) {
            return;
        }
        // Actualizo la frecuencia que corresponde a la clave
        this.getRaiz().actualizarFrecuencias(clave);
    }

    @Override
    public long calcularCosto(int[] FrecExito, int[] FrecNoExito) {
        if (raiz == null) {
            return 0;
        }

        int[] contador = new int[]{0};
        int[] contSinUso = new int[]{0};
        return raiz.calcularCosto(FrecExito, FrecNoExito, contador, contSinUso, 0);
    }

    @Override
    public Lista<T> clavesNivel(int unNivel) {
        Lista listaClaves = new Lista();
        if (raiz != null) {
            raiz.clavesNivel(unNivel, listaClaves);
        }
        return listaClaves;
    }

}
