/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundo_parcial;

/**
 *
 * @author mstabile
 */
public interface IManejadorArchivosGenerico {

    /**
     * ESCRIBIR ARCHIVO
     *
     * @param archivo
     * @param listaLineas (lista con las lineas del archivo)
     */
    public void escribirArchivo(String archivo, String[] listaLineas);

    /**
     * LEER ARCHIVO
     *
     * @param archivo
     * @return String[]
     */
    public String[] leerArchivo(String archivo);
    
}
