/*
 * MANEJADOR GENÉRICO DE ARCHIVOS 2019.
 */
package ManejadorArchivosGenerico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * MANEJADOR GENÉRICO DE ARCHIVOS
 *
 * Lectura y Escritura en Archivos.
 */
public class ManejadorArchivosGenerico {

    /**
     * ESCRIBIR ARCHIVO
     * 
     * @param archivo
     * @param listaLineas (lista con las lineas del archivo)
     */
    public static void escribirArchivo(String archivo, String[] listaLineas) {  

        // Instancia FileWriter.
        FileWriter fw;
        
        try { 
            // Inicializar FileWriter con archivo y 'true' indica agregar lineas al final. 
            fw = new FileWriter(archivo, true);
            // Inicializar BufferedWriter con el FileWriter creado.
            BufferedWriter bw = new BufferedWriter(fw);
            // Para cada registro en la lista.
            for (int i = 0; i < listaLineas.length; i++) { 
                // Tomo el registro actual.
                String lineaActual = listaLineas[i];
                // Escribimos la linea en el archivo.
                bw.write(lineaActual);
                bw.newLine();
            }
            // Cerrar el BW y el FW.
            bw.close();
            fw.close();
            
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + archivo);
            e.printStackTrace();
        }
    }

    /**
     * LEER ARCHIVO
     * 
     * @param archivo
     * @param listaLineas (lista con las lineas del archivo)
     */
    public static String[] leerArchivo(String archivo) {

        // Instancia FileReader.
        FileReader fr;
        // Crear un arraylist.
        ArrayList<String> listaLineas = new ArrayList<String>();
        
        try {
            // Inicializar FileWriter con archivo.
            fr = new FileReader(archivo);
            // Inicializar BufferedWriter con el FileWriter creado.
            BufferedReader br = new BufferedReader(fr);
            // Lectura de todas las lineas hasta el final.
            String lineaActual = br.readLine();
            while (lineaActual != null) {
                listaLineas.add(lineaActual);
                lineaActual = br.readLine();
            }
            // Cerrar el BW y el FW.
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo " + archivo);
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + archivo);
            e.printStackTrace();
        }

        System.out.println("Archivo leido satisfactoriamente (" + archivo + ")");

        return listaLineas.toArray(new String[0]);
    }
}
