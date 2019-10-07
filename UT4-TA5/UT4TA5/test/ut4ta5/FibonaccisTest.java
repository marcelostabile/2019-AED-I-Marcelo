/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4ta5;

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
public class FibonaccisTest {

    Fibonaccis fibo = new Fibonaccis();

    public FibonaccisTest() {
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
    public void testFibinario() {
        System.out.println("fibonacci binario");
        int[] contador = {0};
        int resultado = fibo.fibonacciBinario(15, contador);
        int expResultado = 610;
        System.out.println(contador[0]);
        assertEquals(resultado, expResultado);
    }

    @Test
    public void testFibonacciLineal() {
        System.out.println("fibonacci lineal");
        int n = 8;
        int[] expResult = {21, 13};
        int[] contador = {0};
        int[] result = fibo.fibonacciLineal(n, contador);
        System.out.println(contador[0]);
        assertArrayEquals(expResult, result);
    }
}
