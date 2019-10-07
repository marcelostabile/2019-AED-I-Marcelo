import java.util.ArrayList;
import java.util.Arrays;
import manejadorarchivos.ManejadorArchivosGenerico;

/**
 *
 * @author EQUIPO 1
 */
public class UT4TA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        TArbolBB arbol = new TArbolBB();

        ManejadorArchivosGenerico elmanejador = new ManejadorArchivosGenerico();
         ArrayList<String> resultadoInsertar = new ArrayList<>(); 
        String[] listaClaves = elmanejador.leerArchivo("src/clavesPrueba.txt");
        for (int i = 0; i < listaClaves.length; i++) {
            TElementoAB elem = new TElementoAB(listaClaves[i], listaClaves[i]);
            arbol.insertar(elem);
            resultadoInsertar.add(elem.getEtiqueta().toString());
        }
        
        System.out.println("\n*** PARTE A *** \nImprimir clavesPrueba en pre-orden \n");
        System.out.println("Pre-Orden: " + arbol.preOrden());
        elmanejador.escribirArchivo("src/resultadoInsertar.txt", resultadoInsertar.toArray(args));

    
        // 2
        
        String[] lineasClaves = elmanejador.leerArchivo("src/consultaPrueba.txt");
        ArrayList<String> salida = new ArrayList<>(); 
        
        for (int i = 0; i < lineasClaves.length; i++) {
            TElementoAB resultado = arbol.buscar(lineasClaves[i]);
            if (resultado != null){   
                salida.add(resultado.getEtiqueta().toString());      
            }   
        }
        
        System.out.println("\n*** PARTE B *** \nImprimir clavesPrueba \n");
        String xOrden = arbol.inOrden();
        String postOrden = arbol.postOrden();
        String [] salidaInorden = xOrden.split("-");
        String [] salidaPostOrden = postOrden.split("-");
        
        System.out.println("Claves en Inorden:  " + Arrays.toString(salidaInorden));
        System.out.println("Claves en PostOrden: " + Arrays.toString(salidaPostOrden));
        elmanejador.escribirArchivo("src/resultadoClaves.txt", salida.toArray(args));

        
       
    }


}
