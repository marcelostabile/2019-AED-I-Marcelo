/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static pruebas.Fibonaccis.*;

/**
 *
 * @author Diego
 */
public class FibonaccisTest {

    /**
     *
     */
    public FibonaccisTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }

    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     *
     */
    @Before
    public void setUp() {
    }

    /**
     *
     */
    @After
    public void tearDown() {
    }

    /**
     *
     */
    public void testFibinario() {
        System.out.println("fibonacci binario");
        int[] contador = {0};
        int resultado = fibonacciBinario(15, contador);
        int expResultado = 8;
        System.out.println(contador[0]);
        assertEquals(resultado, expResultado);
    }

    /**
     * Test of fibonacciLineal method, of class FibonacciLineal.
     */
    @Test
    public void testFibonacciLineal() {
        System.out.println("fibonacci lineal");
        int n = 8;
        int[] expResult = {21, 13};
        int[] contador = {0};
        int[] result = fibonacciLineal(n, contador);
        System.out.println(contador[0]);
        assertArrayEquals(expResult, result);
    }
}
