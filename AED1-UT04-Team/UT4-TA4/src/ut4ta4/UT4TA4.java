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
        IArbolBB<Integer> arbolTA4 = new TArbolBB<>();
        
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
        
        // Leer el archivo y retornar un array.
        String[] lineasArchivo = manejadorArchivos.leerArchivo(arch1);
        
        // Para cada registro en el array.
        for (String linea : lineasArchivo) { 
            
            String[] reg = linea.split(",");
            
            TElementoAB<Integer> unElemento = new TElementoAB(reg[0], reg[1]);
            
            arbolTA4.insertar(unElemento);
            
        }
    }
    
}
