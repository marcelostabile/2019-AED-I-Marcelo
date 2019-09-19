/*
 * INTERFASE
 */
package ut04arbolbinario;

/**
 * @author EQUIPO.
 */
public interface IManejadorArchivos {

    /**
     * ESCRIBIR ARCHIVO
     *
     * @param archivo.
     * @param listaLineas (lista con las lineas del archivo).
     */
    void escribirArchivo(String archivo, String[] listaLineas);

    /**
     * LEER ARCHIVO
     *
     * @param archivo (lista con las lineas del archivo).
     * @return String[] lista.
     */
    String[] leerArchivo(String archivo);
    
}
