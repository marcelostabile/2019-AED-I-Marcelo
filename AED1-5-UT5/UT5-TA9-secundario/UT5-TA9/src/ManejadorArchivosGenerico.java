/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class ManejadorArchivosGenerico {

    /**
     * @param nombreCompletoArchivo
     * @param listaLineasArchivo lista con las lineas del archivo
     * @throws IOException
     */
    public  void escribirArchivo(String nombreCompletoArchivo,
            String[] listaLineasArchivo) {
        FileWriter fw;
        try {
            fw = new FileWriter(nombreCompletoArchivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < listaLineasArchivo.length; i++) {
                String lineaActual = listaLineasArchivo[i];
                bw.write(lineaActual);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        }
    }

    public String[] leerArchivo(String nombreCompletoArchivo) {
        FileReader fr;
        LinkedList<String> listaLineasArchivo = new LinkedList<>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null) {
                listaLineasArchivo.add(lineaActual);
                lineaActual = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        }
        //System.out.println("Archivo leído satisfactoriamente");

        return listaLineasArchivo.toArray(new String[0]);
    }
    public boolean archivoExiste(String nombreCompletoArchivo) {

        FileReader fr;

        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }


    public void imprimirLeerLineas(String nombreCompletoArchivo) {

        FileReader fr;
        LinkedList<String> listaLineasArchivo = new LinkedList<>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null) {
                System.out.println(lineaActual);
                listaLineasArchivo.add(lineaActual);
                lineaActual = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        }
        System.out.println("Archivo leido satisfactoriamente");

    }
}
