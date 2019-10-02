/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4ta9;

/**
 *
 * @author mstabile
 */
public interface IManejadorArchivos {

    /**
     * ESCRIBIR ARCHIVO
     *
     * @param archivo
     * @param listaLineas (lista con las lineas del archivo)
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
