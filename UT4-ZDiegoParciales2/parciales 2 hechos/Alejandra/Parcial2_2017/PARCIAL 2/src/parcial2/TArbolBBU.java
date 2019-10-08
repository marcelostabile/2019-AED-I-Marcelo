package parcial2;



import java.util.LinkedList;
import static parcial2.ManejadorArchivosGenerico.leerArchivo;

public class TArbolBBU implements IArbolBBU {

    private  TNodoAlumnoAB raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBBU() {
        raiz = null;
    }
    public void cargar(String archivo){
        String[] lineas = leerArchivo(archivo);
        int cont=0;
        for(String lin:lineas){
            cont++;
            String[] partes=lin.split(",");
            this.insertar(new TNodoAlumnoAB(Integer.valueOf(partes[0]),new Alumno(Integer.valueOf(partes[0]), partes[1],partes[2])));
        }
    }
   
    /**
     * @param unaEtiqueta
     * @return
     */
   
    @Override
    public TNodoAlumnoAB buscar(Comparable unaEtiqueta) {
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

    public boolean esVacio() {
        return (raiz == null);
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

    /**
     *
     * @return
     */
    public TNodoAlumnoAB getraiz() {
        return this.raiz;
    }

    @Override
    public boolean insertar(TNodoAlumnoAB unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return true;
        } else {
            return raiz.insertar(unElemento);
        }
    }

    @Override
    public TArbolBBU armarIndiceCarrera(Comparable laCarrera) {
        if (esVacio()) {
            return null;
        } else {
            TArbolBBU res  = new TArbolBBU();
            raiz.indizar(res, laCarrera);
            return res;
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

    

}
