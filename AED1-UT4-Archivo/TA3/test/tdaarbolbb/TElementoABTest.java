/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdaarbolbb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class TElementoABTest {

    TArbolBB arbol1;
    TArbolBB arbol2;
    TElementoAB elem1;
    TElementoAB elem2;
    TElementoAB elem3;
    TElementoAB elem4;
    TElementoAB elem5;
    TElementoAB elem6;

    public TElementoABTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testObtenerAltura() {

        //*****************************************
        //
        // Arbol 3-4-5-8-9-11 me tiene que dar altura 3  
        //
        //        5
        //       / \
        //      3   8
        //       \   \
        //        4   9
        //             \
        //              11   
        //
        //*****************************************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(5, "5");
        elem2 = new TElementoAB(3, "3");
        elem3 = new TElementoAB(8, "8");
        elem4 = new TElementoAB(4, "4");
        elem5 = new TElementoAB(9, "9");
        elem6 = new TElementoAB(11, "11");

        arbol1.insertar(elem1);
        arbol1.insertar(elem2);
        arbol1.insertar(elem3);
        arbol1.insertar(elem4);
        arbol1.insertar(elem5);
        arbol1.insertar(elem6);

        System.out.println("Altura árbol 3-4-5-8-9-11: " + arbol1.obtenerAltura());
        assertEquals(3, arbol1.obtenerAltura());

    }

    @Test
    public void testObtenerAltura2() {

        //*****************************************
        //
        // Arbol un nodo (5), me tiene que dar altura 0  
        //
        //        5
        //       / \
        //      X   X
        //      
        //*****************************************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(5, "5");

        arbol1.insertar(elem5);

        System.out.println("Altura árbol un nodo: " + arbol1.obtenerAltura());
        assertEquals(0, arbol1.obtenerAltura());

    }

    @Test
    public void testObtenerAltura3() {

        //*****************************************
        //
        // Arbol vacío, me tiene que dar altura 0
        //
        //*****************************************
        arbol1 = new TArbolBB();

        System.out.println("Altura árbol vacío: " + arbol1.obtenerAltura());
        assertEquals(0, arbol1.obtenerAltura());

    }

    @Test
    public void testObtenerTamaño() {

        //*****************************************
        //
        // Arbol 3-4-5-8-9-11 me tiene que dar tamaño 6
        //
        //        5
        //       / \
        //      3   8
        //       \   \
        //        4   9
        //             \
        //              11   
        //
        //*****************************************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(5, "5");
        elem2 = new TElementoAB(3, "3");
        elem3 = new TElementoAB(8, "8");
        elem4 = new TElementoAB(4, "4");
        elem5 = new TElementoAB(9, "9");
        elem6 = new TElementoAB(11, "11");

        arbol1.insertar(elem1);
        arbol1.insertar(elem2);
        arbol1.insertar(elem3);
        arbol1.insertar(elem4);
        arbol1.insertar(elem5);
        arbol1.insertar(elem6);

        System.out.println("Tamaño con 6 nodos: " + arbol1.obtenerTamaño());
        assertEquals(6, arbol1.obtenerTamaño());

    }

    @Test
    public void testObtenerTamaño2() {

        //*****************************************
        //
        // Arbol 3-4-5-8-9-11 me tiene que dar tamaño 6
        //
        //        5
        //       / \
        //      3   8
        //*****************************************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(5, "5");
        elem2 = new TElementoAB(3, "3");
        elem3 = new TElementoAB(8, "8");

        arbol1.insertar(elem1);
        arbol1.insertar(elem2);
        arbol1.insertar(elem3);

        System.out.println("Tamaño con 3 nodos: " + arbol1.obtenerTamaño());
        assertEquals(3, arbol1.obtenerTamaño());

    }

    @Test
    public void testObtenerTamaño3() {

        //*****************************************
        //
        // Arbol vacío
        //
        //*****************************************
        arbol1 = new TArbolBB();

        System.out.println("Tamaño árbol vacío: " + arbol1.obtenerTamaño());
        assertEquals(0, arbol1.obtenerTamaño());

    }

    @Test
    public void testInOrden() {

        //*****************************************
        //
        // Arbol inorden debe ser 3-4-5-8-9-11 
        //
        //        5
        //       / \
        //      3   8
        //       \   \
        //        4   9
        //             \
        //              11   
        //
        //*****************************************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(5, "5");
        elem2 = new TElementoAB(3, "3");
        elem3 = new TElementoAB(8, "8");
        elem4 = new TElementoAB(4, "4");
        elem5 = new TElementoAB(9, "9");
        elem6 = new TElementoAB(11, "11");

        arbol1.insertar(elem1);
        arbol1.insertar(elem2);
        arbol1.insertar(elem3);
        arbol1.insertar(elem4);
        arbol1.insertar(elem5);
        arbol1.insertar(elem6);

        System.out.println("Inorden 6 nodos: " + arbol1.inOrden());
        assertEquals("3-4-5-8-9-11", arbol1.inOrden());

    }

    @Test
    public void testInOrden2() {

        //*****************************************
        //
        // Arbol inorden debe ser 3-4-5-8-9-11 
        //
        //        5
        //         \
        //          8
        //           \
        //            9
        //             \
        //              11   
        //
        //*****************************************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(5, "5");
        elem3 = new TElementoAB(8, "8");
        elem5 = new TElementoAB(9, "9");
        elem6 = new TElementoAB(11, "11");

        arbol1.insertar(elem1);
        arbol1.insertar(elem3);
        arbol1.insertar(elem5);
        arbol1.insertar(elem6);

        System.out.println("Inorden 4 nodos: " + arbol1.inOrden());
        assertEquals("5-8-9-11", arbol1.inOrden());

    }

    @Test
    public void testInOrden3() {

        //*****************************************
        //
        // Arbol inorden vacío
        //
        //*****************************************
        arbol1 = new TArbolBB();

        System.out.println("Inorden árbol vacío: " + arbol1.inOrden());
        assertEquals(null, arbol1.inOrden());

    }
    

    @Test
    public void testNivel() {
        //***************
        //
        // Arbol 3-4-5-8-9-11 me tiene que dar dos hojas (4 y 11)    
        //
        //        5
        //       / \
        //      3   8
        //       \   \
        //        4   9
        //             \
        //              11   
        //
        //***************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(5, "5");
        elem2 = new TElementoAB(3, "3");
        elem3 = new TElementoAB(8, "8");
        elem4 = new TElementoAB(4, "4");
        elem5 = new TElementoAB(9, "9");
        elem6 = new TElementoAB(11, "11");

        arbol1.insertar(elem1);
        arbol1.insertar(elem2);
        arbol1.insertar(elem3);
        arbol1.insertar(elem4);
        arbol1.insertar(elem5);
        arbol1.insertar(elem6);

        //System.out.println("Cantidad de hojas: " + arbol1.obtenerCantidadHojas());
        assertEquals(2, arbol1.obtenerCantidadHojas());

        arbol1 = new TArbolBB();
        //System.out.println("Cantidad de hojas: " + arbol1.obtenerCantidadHojas());
        assertEquals(0, arbol1.obtenerCantidadHojas());        
    }    
}