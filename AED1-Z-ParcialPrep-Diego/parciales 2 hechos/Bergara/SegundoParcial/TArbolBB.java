package SegundoParcial;


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
    public void eliminar (Comparable etiqueta){
        if (raiz != null ){
            raiz = raiz.eliminar (etiqueta);
        }
    }

    @Override
    public int obtenerTamanio() {
        if (raiz == null){
            return 0;
        }else {
            return raiz.obtenerTamanio();
        }
    }
    
    @Override
    public int obtenerAltura()
    {
        if (raiz == null ){return -1;}
        else{return raiz.obtenerAltura();}
    }   
    
    @Override
    public int obtenerNivel(Comparable etiqueta)
    {
        if (raiz == null ){return -1;}
        else{return raiz.obtenerNivel(etiqueta);}
    }
    
    @Override
    public int obtenerCantidadHojas()
    {
        if (raiz == null ){return 0;}
        else{return raiz.obtenerCantidadHojas();}
    }
    
    @Override
    public Comparable obtenerMenorClave()
    {
        if (raiz == null ){return null;}
        else{return raiz.obtenerMenorClave();}
    }
    
    @Override
    public Comparable obtenerMayorClave()
    {
        if (raiz == null ){return null;}
        else{return raiz.obtenerMayorClave();}
    }
    
    @Override
    public Comparable claveAnterior(Comparable clave)
    {
        if (raiz == null ){return -1;}
        else{return raiz.claveAnterior(clave);}
    }
    
    @Override
    public int cantNodosNivel(int nivel)
    {
        if (raiz == null ){return -1;}
        else{return raiz.cantNodosNivel(nivel);}
    }
    
    @Override
    public void listarHojas()
    {
        if (raiz != null ){raiz.listarHojas(0);}
        else{System.out.println("Arbol vacío");}
    }
    
    @Override
    public boolean esArbolBusqueda()
    {
        if (raiz != null ){return raiz.esArbolBusqueda();}
        else{return false;}
    }
    
}
