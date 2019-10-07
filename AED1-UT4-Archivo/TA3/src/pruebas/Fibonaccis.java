/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

/**
 *
 * @author Diego
 */
public class Fibonaccis {

    public static int fibonacciFactorialIterativo(int n) {
        int fact = n;
        while (n > 1) {
            n = n - 1;
            fact = fact * n;
        }
        return fact;
    }

    public static int fibonacciFactorialRecursivo(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fibonacciFactorialRecursivo(n - 1);
        }
    }

    public static int fibonacciBinario(int k, int[] contador) {
        contador[0] = contador[0] + 1;
        if (k == 0 | k == 1) {
            return k;
        } else {

            return fibonacciBinario(k - 1, contador) + fibonacciBinario(k - 2, contador);
        }
    }

    public static int[] fibonacciLineal(int n, int[] contador) {
        int[] resultado = new int[2];
        if (n == 1) {
            resultado[0] = n;
            resultado[1] = 0;
            return resultado;
        } else {
            contador[0] = contador[0] + 1;
            resultado = fibonacciLineal(n - 1, contador);
            int[] fin = new int[2];
            fin[0] = resultado[0] + resultado[1];
            fin[1] = resultado[0];
            return fin;
        }
    }
}
