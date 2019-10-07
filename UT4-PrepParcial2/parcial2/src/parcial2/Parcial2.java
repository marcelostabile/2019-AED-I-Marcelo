/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author mstabile
 */
public class Parcial2 {

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
        String workFolder = "src/parcial2/";
        
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
        // Creo un elemento con cada linea y lo inserto en el árbol.
        for (String linea1 : lineasArchivo1) { 
            TElementoAB unElemento1 = new TElementoAB(linea1, linea1);
            arbol1.insertar(unElemento1);
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
        System.out.println("Altura del árbol: " + arbol1.obtenerAltura());
        System.out.println("Tamaño del árbol: " + arbol1.obtenerTamanio());
        System.out.println("Cantidad de hojas: " + arbol1.obtenerCantidadHojas());
        String nro1 = "5354";
        System.out.println("El elemento " + nro1 + " se encuentra en el nivel " + arbol1.obtenerNivel(nro1));
        System.out.println("");
        
        System.out.println("ÁRBOL 2");
        System.out.println("");
        System.out.println("Altura del árbol: " + arbol2.obtenerAltura());
        System.out.println("Tamaño del árbol: " + arbol2.obtenerTamanio());
        System.out.println("Cantidad de hojas: " + arbol2.obtenerCantidadHojas());
        String nro2 = "192";
        System.out.println("El elemento " + nro2 + " se encuentra en el nivel " + arbol1.obtenerNivel(nro2));
        System.out.println("");
        
        System.out.println("ÁRBOL 3");
        System.out.println("");
        System.out.println("Altura del árbol: " + arbol3.obtenerAltura());
        System.out.println("Tamaño del árbol: " + arbol3.obtenerTamanio());
        System.out.println("Cantidad de hojas: " + arbol3.obtenerCantidadHojas());
        String nro3 = "256";
        System.out.println("El elemento " + nro3 + " se encuentra en el nivel " + arbol1.obtenerNivel(nro3));
        System.out.println("");
        
    }
}
