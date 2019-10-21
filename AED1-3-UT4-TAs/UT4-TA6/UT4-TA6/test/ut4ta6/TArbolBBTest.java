/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4ta6;
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

/**
 *
 * @author Diego
 */
public class TArbolBBTest {

    TArbolBB arbol1;
    TArbolBB arbol2;
    TElementoAB elem1;
    TElementoAB elem2;
    TElementoAB elem3;
    TElementoAB elem4;
    TElementoAB elem5;
    TElementoAB elem6;
    TElementoAB elem7;
    TElementoAB elem8;
    TElementoAB elem9;
    TElementoAB elem10;
    TElementoAB elem11;
    TElementoAB elem12;

    public TArbolBBTest() {
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
    public void testEliminarNodo() {

        //*****************************************
        //
        // Arbol 12-25-14-1-33-88-45-2-7-66-5-99
        //
        //
        //*****************************************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(12, "12");
        elem2 = new TElementoAB(25, "25");
        elem3 = new TElementoAB(14, "14");
        elem4 = new TElementoAB(1, "1");
        elem5 = new TElementoAB(33, "33");
        elem6 = new TElementoAB(88, "88");
        elem7 = new TElementoAB(45, "45");
        elem8 = new TElementoAB(2, "2");
        elem9 = new TElementoAB(7, "7");
        elem10 = new TElementoAB(66, "66");
        elem11 = new TElementoAB(5, "5");
        elem12 = new TElementoAB(99, "99");

        // Sub equipo B
        // a) Insertar elementos 12-25-14-1-33-88-45-2-7-66-5-99
        arbol1.insertar(elem1);
        arbol1.insertar(elem2);
        arbol1.insertar(elem3);
        arbol1.insertar(elem4);
        arbol1.insertar(elem5);
        arbol1.insertar(elem6);
        arbol1.insertar(elem7);
        arbol1.insertar(elem8);
        arbol1.insertar(elem9);
        arbol1.insertar(elem10);
        arbol1.insertar(elem11);
        arbol1.insertar(elem12);

        // b) Emitir por consola el recorrido inorden
        System.out.println(arbol1.inOrden());

        // c) Eliminar del árbol los elementos con las siguientes claves: 99, 15, 2, 12, 77, 33
        arbol1.eliminar(99);
        String eliminar1 = arbol1.inOrden();
        arbol1.eliminar(15);
        String eliminar2 = arbol1.inOrden();
        arbol1.eliminar(2);
        String eliminar3 = arbol1.inOrden();
        arbol1.eliminar(12);
        String eliminar4 = arbol1.inOrden();
        arbol1.eliminar(77);
        String eliminar5 = arbol1.inOrden();
        arbol1.eliminar(33);
        String eliminar6 = arbol1.inOrden();

        // d) Emitir por consola los recorridos en inorden, preorden y postorden
        System.out.println("Inorden");
        System.out.println(arbol1.inOrden());
        System.out.println("Preorden");
        System.out.println(arbol1.preOrden());
        System.out.println("Postorden");
        System.out.println(arbol1.postOrden());

        // e) Verificar que la salida, luego de efectuar cada eliminación, es la esperada
        
        System.out.println("Eliminar nodo 99: " + eliminar1);
        System.out.println("Eliminar nodo 15: " + eliminar2);
        System.out.println("Eliminar nodo 2: " + eliminar3);
        System.out.println("Eliminar nodo 12: " + eliminar4);
        System.out.println("Eliminar nodo 77: " + eliminar5);
        System.out.println("Eliminar nodo 33: " + eliminar6);

        
        assertEquals("1-2-5-7-12-14-25-33-45-66-88", eliminar1);
        assertEquals("1-2-5-7-12-14-25-33-45-66-88", eliminar2);
        assertEquals("1-5-7-12-14-25-33-45-66-88", eliminar3);
        assertEquals("1-5-7-14-25-33-45-66-88", eliminar4);
        assertEquals("1-5-7-14-25-33-45-66-88", eliminar5);
        assertEquals("1-5-7-14-25-45-66-88", eliminar6);
        
    }
}
