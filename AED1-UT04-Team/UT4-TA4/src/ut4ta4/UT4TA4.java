/*
 * UT4-TA4
 */
package ut4ta4;

/**
 *
 * @author EQUIPO
 */
public class UT4TA4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * CREAR EL ÁRBOL.
         */
        
        IArbolBB<Integer> arbol1 = new TArbolBB<>();
        IArbolBB<Integer> arbol2 = new TArbolBB<>();
        IArbolBB<Integer> arbol3 = new TArbolBB<>();
        
        /**
         * MANEJADOR DE ARCHIVOS.
         */
        
        // Definir la carpeta de los archivos.
        String workFolder = "src/ut4ta4/";
        
        // Definir los archivos de trabajo.
        String arch1 = workFolder + "claves1.txt";
        String arch2 = workFolder + "claves2.txt";
        String arch3 = workFolder + "claves3.txt";
        
        // Instanciar el manejador de archivos.
        IManejadorArchivos manejadorArchivos = new ManejadorArchivosGenerico();

        /**
         * ARCHIVO 1.
         */
        
        // Leer el archivo y retornar un array.
        // Cambiando esta linea seleccionamos el archivo que queremos usar (arch1, arch2 o arch3).
        String[] lineasArchivo1 = manejadorArchivos.leerArchivo(arch1);
        
        // Para cada registro en el array.
        for (String linea1 : lineasArchivo1) { 

            // Creo un elemento con cada linea y lo inserto en el árbol.
            TElementoAB unElemento1 = new TElementoAB(linea1, linea1);
            //arbol1.insertar(unElemento1);
        }
        
        /**
         * ARCHIVO 2.
         */
        String[] lineasArchivo2 = manejadorArchivos.leerArchivo(arch2);
        for (String linea2 : lineasArchivo2) { 
            TElementoAB unElemento2 = new TElementoAB(linea2, linea2);
            arbol2.insertar(unElemento2);
        }

        /**
         * ARCHIVO 3.
         */
        String[] lineasArchivo3 = manejadorArchivos.leerArchivo(arch3);
        for (String linea3 : lineasArchivo3) { 
            TElementoAB unElemento3 = new TElementoAB(linea3, linea3);
            arbol3.insertar(unElemento3);
        }

        /**
         * RESULTADOS.
         */
        System.out.println("ÁRBOL 1");
        System.out.println("");
        System.out.println("Cantidad de hojas: " + arbol1.obtenerCantidadHojas());
        System.out.println("El elemento se encuentra en el nivel " + arbol1.obtenerNivel(5376));
        System.out.println("");
        
        System.out.println("ÁRBOL 2");
        System.out.println("");
        System.out.println("Cantidad de hojas: " + arbol2.obtenerCantidadHojas());
        System.out.println("El elemento se encuentra en el nivel " + arbol3.obtenerNivel(104));
        System.out.println("");
        
        System.out.println("ÁRBOL 3");
        System.out.println("");
        System.out.println("Cantidad de hojas: " + arbol3.obtenerCantidadHojas());
        System.out.println("El elemento se encuentra en el nivel " + arbol3.obtenerNivel(437));
        System.out.println("");
        
    }
}
