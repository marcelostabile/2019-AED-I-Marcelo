/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2td5;

/**
 *
 * @author estudiante.fit
 */
public class UT2TD5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        // Manejador de archivos.
        IManejadorArchivosGenerico ManejadorArchivos = new ManejadorArchivosGenerico();
        
        // Carpeta de trabajo.
        String CarpetaDeTrabajo = "src/ut2td5/";
        String arch1 = "Entrada.txt";
        
        // Cargar datos en String[].
        String[] lineasArchivo = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + arch1);
                
        // imprimir resultados.
        Auxiliar auxiliar = new Auxiliar();
        
        int resEntero = auxiliar.buscarEntero();
        float resFlotante = auxiliar.buscarFlotante();
        String resCadena = auxiliar.buscarString();
        
        System.out.println("El entero leído es: " + resEntero);
        
        System.out.println("El número de punto flotante es:" + resFlotante);
        
        System.out.println("La cadena leída es " + resCadena);
        
        System.out.println("¡Hola " + resCadena + "! La suma de " + resEntero + " y " + resFlotante 
                + " es " + (resEntero+resFlotante));

        System.out.println("La división entera de " + resEntero + " y " + resFlotante 
                + " es " + (resEntero/resFlotante)
                + " y su resto es " + (resEntero%resFlotante));

    }
    
}
