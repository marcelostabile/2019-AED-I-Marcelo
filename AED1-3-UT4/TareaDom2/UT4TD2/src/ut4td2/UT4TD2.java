/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4td2;

import java.util.ArrayList;

/**
 *
 * @author mstabile
 */
public class UT4TD2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        // Instancias.
        
        
        // Manejador de archivos.
        IManejadorArchivosGenerico ManejadorArchivos = new ManejadorArchivosGenerico();
        
        // Archivos.
        String CarpetaDeTrabajo = "src/UT4TD2/";
        String arch1 = "Entrada.txt";
        
        // Crear árbol binario.
        IArbolBB<String> arbolClaves = new TArbolBB<>();
        
        // Cargar datos en el árbol binario.
        String[] lineasArchivo1 = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + arch1);
        for (String linea : lineasArchivo1) {
            String[] c = linea.split("");
            IElementoAB<String> elementoNuevo = new TElementoAB(c[0], c[0]);
            arbolClaves.insertar(elementoNuevo);
        }
        
        
        
        
        


    }
    
}
