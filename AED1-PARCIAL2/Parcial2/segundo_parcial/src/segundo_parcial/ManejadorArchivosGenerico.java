package segundo_parcial;

/**
 * @author EQUIPO 1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * MANEJADOR DE ARCHIVOS
 *
 * Leer y escribir en archivos.
 */
public class ManejadorArchivosGenerico implements IManejadorArchivosGenerico {

    /**
     * ESCRIBIR ARCHIVO
     * 
     * @param archivo
     * @param listaLineas (lista con las lineas del archivo)
     */
    @Override
    public void escribirArchivo(String archivo, String[] listaLineas) {  

        FileWriter fw;
        try {
            fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < listaLineas.length; i++) {
                String lineaActual = listaLineas[i];
                bw.write(lineaActual);
                bw.newLine();
            }
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
    @Override
    public String[] leerArchivo(String archivo) {

        FileReader fr;
        ArrayList<String> listaLineas = new ArrayList<String>();
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String lineaActual = br.readLine();
            while (lineaActual != null) {
                listaLineas.add(lineaActual);
                lineaActual = br.readLine();
            }
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
