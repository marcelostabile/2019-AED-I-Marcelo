
package ut4ta5;

/**
 *
 * @author EQUIPO 1
 */
public class UT4TA5 {

    public static void main(String[] args) {

        Fibonaccis fib = new Fibonaccis();

        int[] contador = {0};

        int nro = 15;
        
        int fibonacciBinario = fib.fibonacciBinario(nro, contador);
        System.out.println(fibonacciBinario);

        int[] fibonacciLineal = fib.fibonacciLineal(nro, contador);
        System.out.println(fibonacciLineal[0]);

    }
}
