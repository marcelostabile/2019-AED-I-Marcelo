package parcial2_b;


//import static arbolbinariodef.ManejadorArchivosGenerico.leerArchivo;
import java.util.LinkedList;

public class TArbolBB<T> implements IArbolBB<T> {

    private IElementoAB<T> raiz;

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
    @Override
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
    @Override
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
    public LinkedList<Comparable> inorden() {
        LinkedList<Comparable> listaInorden = null;
        if (!esVacio()) {
            listaInorden = new LinkedList<>();
            raiz.inOrden(listaInorden);
        }
        return listaInorden;

    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = this.raiz.eliminar(unaEtiqueta);
        }
    }

    @Override
    public String preOrden() {        
        if (raiz == null){
            return "arbol vacio";
        }else {
            return raiz.preOrden();
        }        
    }

    @Override
    public String postOrden() {
        if (raiz == null){
            return "arbol vacio";
        }else {
            return raiz.postOrden();
        }
    }

    @Override
    public Integer obtenerTamaño() {
        
         if (raiz == null){
            return 0;
        }else {
            return raiz.obtenerTamaño();
        }
    }

    @Override
    public Integer obtenerAltura() {
        if (raiz == null){
            return -1;
        }else {
            return raiz.obtenerAltura();
        }        
    }

    @Override
    public Comparable obtenerMaximo() {
        if (raiz == null){
            return null;
        }else {
            return raiz.obtenerMaximo();
        }        
    }
    
    @Override
    public Comparable obtenerMinimo() {
        if (raiz == null){
            return null;
        }else {
            return raiz.obtenerMinimo();
        }        
    }

    @Override
    public int obtenerCantidadHojas() {
         if (raiz == null){
            return 0;
        }else {
            return raiz.obtenerCantidadHojas();
        }
    }
    @Override
    public String obtenerHojasConNivel() {
         if (raiz == null){
            return "El arbol esta vacio.";
        }else {
            return raiz.obtenerHojasConNivel(0);
        }
    }
    @Override
    public int obtenerPorNivel(int nivel) {
         if (raiz == null){
            return 0;
        }else {
            return raiz.obtenerPorNivel(0,nivel);
        }
    }

    @Override
    public Boolean esABB() {
        if (raiz == null){
            return false;
        }else {
            return raiz.esABB();
        }
    }
    @Override
    public void cargarArchivo(String archivo){
        
    }

    @Override
    public Integer buscarConNivel(Comparable unaEtiqueta) {
        if (raiz == null){
            return -1;
        }else {
            return raiz.buscarConNivel(unaEtiqueta,0);
        }
    }
    public Comparable mayorValor(int claveMenor, int claveMayor){
        if (raiz == null){
            return -1;
        }else {
            return raiz.mayorValor(claveMenor, claveMayor).getCodigo();
        }
    }

    

   
}
