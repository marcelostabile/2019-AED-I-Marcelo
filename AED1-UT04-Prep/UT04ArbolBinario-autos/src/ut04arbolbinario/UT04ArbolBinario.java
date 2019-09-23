/*
 * MAIN
 */
package ut04arbolbinario;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author EQUIPO
 */
public class UT04ArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        /**
         * PARTE 1
         * 
         * Armar un árbol e ingresar registros de autos.
         * 
         * Imprimir por consola los resultados en preorden, inorden y postorden.
         */
        
        // Archivos de trabajo.
        String workFolder = "src/ut04arbolbinario/";
        
        String archOrigen = workFolder + "txtListaDeAutos.txt";
        String archBuscados = workFolder + "txtAutosBuscados.txt";
        String archResultados = workFolder + "txtListaResultados.txt";
        
        // Cargar lista de autos en árbol.
        IArbolBB arbolAutos = new TArbolBB();

        // Lista auxiliar de resultados cargados.
        ArrayList<String> resultadoInsertados = new ArrayList<>();

        // MANEJADOR DE ARCHIVOS para cargar árbol de autos.
        IManejadorArchivos manejadorArchivos = new ManejadorArchivosGenerico();
        
        // Cargo las lineas del archivo y luego ingreso los registros al árbol.
        String[] lineasArchivo1 = manejadorArchivos.leerArchivo(archOrigen);

        for (String linea : lineasArchivo1) {
            
            // Obtengo los registros de cada linea e instancio un nuevo auto a partir de cada registro.
            String[] reg = linea.split(",");
            
            TAuto autoNuevo = new TAuto(reg[0], reg[1], reg[2]);

            // Instancio un nuevo elemento a partir del auto.
            TElementoAB unElemento = new TElementoAB(autoNuevo.getMatricula(), autoNuevo);
            
            // Insertar el auto en el árbol.
            arbolAutos.insertar(unElemento);
            
            // Agrego la etiqueta en el registro de autos insertados.
            resultadoInsertados.add(unElemento.getEtiqueta().toString());
        }

        // Imprimir registros insertados.
        System.out.println("* * * PARTE A - IMPRIMIR REGISTROS INSERTADOS * * *");
        System.out.println("");
        System.out.println("Pre-Orden: " + arbolAutos.preOrden());
        System.out.println("In-Orden: " + arbolAutos.inOrden());
        System.out.println("Post-Orden: " + arbolAutos.postOrden());
        System.out.println("");
        
        /**
         * PARTE 2
         * 
         * Cargar una segunda lista de matriculas que se buscan.
         * 
         * Buscarlas en el árbol de autos y guardar en un archivo de texto el resultado.
         */
        
        // Cargar lista de autos en árbol.
        IArbolBB arbolBuscados = new TArbolBB();

        // Lista auxiliar de resultados cargados.
        ArrayList<String> resultadoEncontrados = new ArrayList<>();
        
        // MANEJADOR DE ARCHIVOS para cargar árbol de autos buscados a partir de su matrícula.
        
        // Cargo las lineas del archivo y luego ingreso los registros al árbol.
        String[] lineasArchivo2 = manejadorArchivos.leerArchivo(archBuscados);

        for (int i = 0; i < lineasArchivo2.length; i++) {

            // Busco el elemento en el árbol de autos.
            TElementoAB resultadoBusqueda = arbolAutos.buscar(lineasArchivo2[i]);

            // Guardo el resultado en una lista de salida (si el resultado no es nulo).
            if (resultadoBusqueda != null) {
                
                // Agrego el elemento resultado a un árbol.
                arbolBuscados.insertar(new TElementoAB(resultadoBusqueda.etiqueta, resultadoBusqueda.getDatos()));
                
                // Agrego el elemento resultado a una lista.
                resultadoEncontrados.add(resultadoBusqueda.getEtiqueta().toString());
            }
        }

        // Imprimir registros de elementos encontrados.
        System.out.println("* * * PARTE B - IMPRIMIR REGISTROS ENCONTRADOS * * *");
        System.out.println("");
        
        System.out.println("Imprimir Array Insertados: " + Arrays.toString(resultadoInsertados.toArray()));
        System.out.println("");

        System.out.println("Pre-Orden: " + arbolBuscados.preOrden());
        System.out.println("In-Orden: " + arbolBuscados.inOrden());
        System.out.println("Post-Orden: " + arbolBuscados.postOrden());
        System.out.println("");

        System.out.println("Imprimir Array Encontrados: " + Arrays.toString(resultadoEncontrados.toArray()));
        System.out.println("");
        
        /**
         * Guardar los resultados en un archivo de textos.
         * 
         * Si no existe, lo crea automáticamente; si existe, agrega registros al final.
         */
        
        // Convertir el arraylist en string[]
        String[] regEncontrados = resultadoEncontrados.toArray(args);
        
        // Escribir en el archivo.
        manejadorArchivos.escribirArchivo(archResultados, regEncontrados);

        /**
         * PARTE 3
         * 
         * Eliminar 3 nodos.
         */
        System.out.println("* * * PARTE C - IMPRIMIR REGISTROS LUEGO DE LA ELIMINACIÓN * * *");
        System.out.println("");
        
        System.out.println("Árbol original impreso en In-Orden: " + arbolAutos.inOrden());
        System.out.println("");

        // Eliminar registros.
        arbolAutos.eliminar("BCD44952");
        arbolAutos.eliminar("DEF21546");
        arbolAutos.eliminar("FGH64589");
        arbolAutos.eliminar("HIJ46854");
        arbolAutos.eliminar("JKL25698");

        // Imprimir resultado luego de la eliminación.
        System.out.println("Árbol RESULTADO (In-Orden): " + arbolAutos.inOrden());
        System.out.println("");
        
        /**
         * PARTE 4
         * 
         * Analizaremos una expresión aritmética.
         * 
         * ( ( 2 + 3 ) * 10 ) + ( 10 * ( 2 + 3 ) ) = 120
         */
        
        // Expresiones.
        String expresionAritmetica1 = "((2+3)*10)+(10*(2+3))";  // 120
        String expresionAritmetica2 = "(2+3*10)+(10*2+3)";      // 55
        String expresionAritmetica3 = "(2+3*10+10*2+3)";        // 55
        
        // Analizador de expresiones.
        IAnalizadorExpresiones analizaExpr1 = new AnalizadorExpresiones();
        IAnalizadorExpresiones analizaExpr2 = new AnalizadorExpresiones();
        IAnalizadorExpresiones analizaExpr3 = new AnalizadorExpresiones();
        
        // Cargar las expresiones en el atributo String expresionRecibida.
        analizaExpr1.setExpresion(expresionAritmetica1);
        analizaExpr2.setExpresion(expresionAritmetica2);
        analizaExpr3.setExpresion(expresionAritmetica3);
        
        // Imprimir las expresiones en consola.
        analizaExpr1.imprimirExpresion();
        analizaExpr1.imprimirResultado();
        
        analizaExpr2.imprimirExpresion();
        analizaExpr2.imprimirResultado();
        
        analizaExpr3.imprimirExpresion();
        analizaExpr3.imprimirResultado();

        
        
        
        
        
        
    }
}
