/*
 * MANEJADOR DE ARCHIVOS.
 */
package utmanejadorarchivos;

/**
 * @author mstabile
 */
public class UTManejadorArchivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /**
         * MANEJADOR DE ARCHIVOS.
         */
        // Definir la carpeta de los archivos.
        String workFolder = "src/utmanejadorarchivos/";
        // Definir los archivos de trabajo.
        String archOrigen = workFolder + "txtListaDeAutos.txt";
        String archSeleccion = workFolder + "txtAutosBuscados.txt";
        String archResultados = workFolder + "txtListaResultados.txt";
        // Instanciar el manejador de archivos.
        IManejadorArchivos manejadorArchivos = new ManejadorArchivosGenerico();
        
        /**
         * LEER ARCHIVO.
         */
        // Leer el archivo y retornar un array.
        String[] lineasArchivo1 = manejadorArchivos.leerArchivo(archOrigen);
        // Para cada registro en el array.
        for (String linea : lineasArchivo1) {
            // Separo los campos de un registro e instancio un objeto a partir de él.
            String[] reg = linea.split(",");
            TAuto autoNuevo = new TAuto(reg[0], reg[1], reg[2]);

//            // Instancio un nuevo nodo.
//            TElementoAB unElemento = new TElementoAB(autoNuevo.getMatricula(), autoNuevo);
//            
//            // Insertar el nodo en el árbol.
//            arbolAutos.insertar(unElemento);

        }
    }
}
