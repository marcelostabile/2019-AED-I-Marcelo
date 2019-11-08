/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tdaarbolbb.*;
import TDALista.*;

/**
 *
 * @author K
 */
public class CalculadorMatricesOptimoTest {

    TArbolBB<Integer> elArbol;
    CalculadorMatricesOptimo abo;
    int cantElementos;
    String[] claves;
    String nodosInOrden = "";
    int[] frecExito;
    int[] frecNoExito;

    public CalculadorMatricesOptimoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        elArbol = new TArbolBB();
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();

        String[] lineas = manejadorArchivos.leerArchivo("src/palabras2.txt");
        cantElementos = lineas.length;

        abo = new CalculadorMatricesOptimo(cantElementos);
        claves = new String[cantElementos + 1];
        frecExito = new int[cantElementos + 1];
        frecNoExito = new int[cantElementos + 1];

        for (int i = 0; i < cantElementos; i++) {
            String[] datos = lineas[i].split(" ");
            claves[i + 1] = datos[0].trim();
            frecExito[i + 1] = Integer.parseInt(datos[1]);
        }
        String[] lineas2 = manejadorArchivos.leerArchivo("src/nopalabras2.txt");
        for (int i = 0; i <= cantElementos; i++) {
            frecNoExito[i] = Integer.parseInt(lineas2[i]);
        }

        abo.calcularMatrices(cantElementos, frecExito, frecNoExito);

        abo.armarArbolBinario(0, cantElementos, claves, elArbol);

        nodosInOrden = "";
        Lista arbolinorden = elArbol.inorden();
        INodo aux = arbolinorden.getPrimero();
        while (aux != null) {
            nodosInOrden = nodosInOrden + (String) aux.getDato();
            aux = aux.getSiguiente();
            if (aux != null) {
                nodosInOrden = nodosInOrden + " - ";
            }
        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEncontrarOptimo() {
        System.out.println("Costo óptimo del árbol: " + abo.P[0][cantElementos]);
        assertEquals(abo.P[0][cantElementos], 76);

    }

    @Test
    public void testTrayectoriaPonderadaPreOrden() {
        TArbolBB elArbol2 = new TArbolBB();
        TElementoAB nodoRaton = new TElementoAB(4, "Raton");
        TElementoAB nodoGato = new TElementoAB(5, "Gato");
        TElementoAB nodoPerro = new TElementoAB(3, "Perro");
        TElementoAB nodoZorro = new TElementoAB(2, "Zorro");

        elArbol2.insertar(nodoRaton);
        elArbol2.insertar(nodoGato);
        elArbol2.insertar(nodoPerro);
        elArbol2.insertar(nodoZorro);

        System.out.println("Costo de trayectoria ponderada árbol PreOrden: " + elArbol2.calcularCosto(frecExito, frecNoExito));

        assertEquals(elArbol2.calcularCosto(frecExito, frecNoExito), 78);

    }

    @Test
    public void testTrayectoriaPonderadaInOrden() {

        TArbolBB elArbol3 = new TArbolBB();
        TElementoAB nodoRaton = new TElementoAB(4, "Raton");
        TElementoAB nodoGato = new TElementoAB(5, "Gato");
        TElementoAB nodoPerro = new TElementoAB(3, "Perro");
        TElementoAB nodoZorro = new TElementoAB(2, "Zorro");
        elArbol3.insertar(nodoGato);
        elArbol3.insertar(nodoPerro);
        elArbol3.insertar(nodoRaton);
        elArbol3.insertar(nodoZorro);

        System.out.println("Costo de trayectoria ponderada árbol InOrden " + elArbol3.calcularCosto(frecExito, frecNoExito));

        assertEquals(elArbol3.calcularCosto(frecExito, frecNoExito), 81);

    }

    @Test
    public void testArbolCuentaFrec()
    {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico(); 
        String[] lineasLibro = manejadorArchivos.leerArchivo("src/libro.txt");
        String[] lineasClaves = manejadorArchivos.leerArchivo("src/palabras claves.txt");
        String[] lineasFiltrarPalabra = manejadorArchivos.leerArchivo("src/filtrar palabra.txt");

        TArbolBB unArbolLibro = new TArbolBB();

        for (int i = 0; i < lineasLibro.length; i++) { 
            String[] datosLibro = lineasLibro[i].split(" ");
            
            for (int j = 0; j < datosLibro.length; j++) {
                unArbolLibro.cuentaFrec(datosLibro[j]);
            }
        }

        String[] claves = new String[lineasClaves.length ];
        
        TArbolBB elArbolClaves = new TArbolBB();
        
        for (int i = 0; i < lineasClaves.length; i++) {
            //String[] datos = lineasClaves[i].split("\n");
            TElementoAB elementoPalabra = new TElementoAB(lineasClaves[i], lineasClaves[i]);
            elArbolClaves.insertar(elementoPalabra);
            claves[i] = lineasClaves[i];
        }
        
        // Código para cargar los datos en el árbol.
        
        assertEquals(, );
    }

    @Test
    public void testArbolCompletaVectores() 
    {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico(); 
        String[] lineasLibro = manejadorArchivos.leerArchivo("src/libro.txt");
        String[] lineasClaves = manejadorArchivos.leerArchivo("src/palabras claves.txt");
        String[] lineasFiltrarPalabra = manejadorArchivos.leerArchivo("src/filtrar palabra.txt");

        TArbolBB unArbolLibro = new TArbolBB();

        for (int i = 0; i < lineasLibro.length; i++) { 
            String[] datosLibro = lineasLibro[i].split(" ");
            
            for (int j = 0; j < datosLibro.length; j++) {
                unArbolLibro.cuentaFrec(datosLibro[j]);
            }
        }

        String[] claves = new String[lineasClaves.length ];
        
        TArbolBB elArbolClaves = new TArbolBB();
        
        for (int i = 0; i < lineasClaves.length; i++) {
            //String[] datos = lineasClaves[i].split("\n");
            TElementoAB elementoPalabra = new TElementoAB(lineasClaves[i], lineasClaves[i]);
            elArbolClaves.insertar(elementoPalabra);
            claves[i] = lineasClaves[i];
        }
        
        // Código para cargar los datos en el árbol.
        
        assertEquals(, );
    }

    @Test
    public void testElementoCuentaFrec() 
    {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico(); 
        String[] lineasLibro = manejadorArchivos.leerArchivo("src/libro.txt");
        String[] lineasClaves = manejadorArchivos.leerArchivo("src/palabras claves.txt");
        String[] lineasFiltrarPalabra = manejadorArchivos.leerArchivo("src/filtrar palabra.txt");

        TArbolBB unArbolLibro = new TArbolBB();

        for (int i = 0; i < lineasLibro.length; i++) { 
            String[] datosLibro = lineasLibro[i].split(" ");
            
            for (int j = 0; j < datosLibro.length; j++) {
                unArbolLibro.cuentaFrec(datosLibro[j]);
            }
        }

        String[] claves = new String[lineasClaves.length ];
        
        TArbolBB elArbolClaves = new TArbolBB();
        
        for (int i = 0; i < lineasClaves.length; i++) {
            //String[] datos = lineasClaves[i].split("\n");
            TElementoAB elementoPalabra = new TElementoAB(lineasClaves[i], lineasClaves[i]);
            elArbolClaves.insertar(elementoPalabra);
            claves[i] = lineasClaves[i];
        }
        
        // Código para cargar los datos en el árbol.
        
        assertEquals(, );
    }

    @Test
    public void testElementoCompletaVectores() 
    {
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico(); 
        String[] lineasLibro = manejadorArchivos.leerArchivo("src/libro.txt");
        String[] lineasClaves = manejadorArchivos.leerArchivo("src/palabras claves.txt");
        String[] lineasFiltrarPalabra = manejadorArchivos.leerArchivo("src/filtrar palabra.txt");

        TArbolBB unArbolLibro = new TArbolBB();

        for (int i = 0; i < lineasLibro.length; i++) { 
            String[] datosLibro = lineasLibro[i].split(" ");
            
            for (int j = 0; j < datosLibro.length; j++) {
                unArbolLibro.cuentaFrec(datosLibro[j]);
            }
        }

        String[] claves = new String[lineasClaves.length ];
        
        TArbolBB elArbolClaves = new TArbolBB();
        
        for (int i = 0; i < lineasClaves.length; i++) {
            //String[] datos = lineasClaves[i].split("\n");
            TElementoAB elementoPalabra = new TElementoAB(lineasClaves[i], lineasClaves[i]);
            elArbolClaves.insertar(elementoPalabra);
            claves[i] = lineasClaves[i];
        }
        
        // Código para cargar los datos en el árbol.
        
        assertEquals(, );

    }
    
}
