package ut4ta5;

/**
 *
 * @author EQUIPO 1
 */
public class Fibonaccis {

    public int fibonacciBinario(int k, int[] contador) {
        contador[0] = contador[0] + 1;
        if (k == 0 | k == 1) {
            return k;
        } else {

            return fibonacciBinario(k - 1, contador) + fibonacciBinario(k - 2, contador);
        }
    }

//El algoritmo tiene un orden del tiempo de ejecución O(N), siendo N el input del usuario.
    public int[] fibonacciLineal(int n, int[] contador) {
        int[] resultado = new int[2];       // O(1)
        if (n == 1) {                      // O(1)
            resultado[0] = n;              // O(1)
            resultado[1] = 0;              // O(1)
            return resultado;              // O(1)
        } else {
            contador[0] = contador[0] + 1;                      // O(1)
            resultado = fibonacciLineal(n - 1, contador);       // O(N)
            int[] fin = new int[2];                             // O(1)
            fin[0] = resultado[0] + resultado[1];               // O(1)
            fin[1] = resultado[0];                              // O(1)
            return fin;                                         // O(1)
        }
    }

}
