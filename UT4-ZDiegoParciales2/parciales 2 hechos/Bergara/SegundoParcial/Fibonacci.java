/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

/**
 *
 * @author adilsonmagalhaes
 */
public class Fibonacci {

    public Fibonacci() {
    }

    ;
    public int fiboRecursivo(int n, int cont[]) {
        if (n == 0 || n == 1) {
            cont[0]++;
            return n;
        } else {
            cont[0]++;
            return fiboRecursivo((n - 2), cont) + fiboRecursivo((n - 1), cont);
        }

    }

    public int[] fiboLineal(int n, int[] cont) {
        int[] result = new int[2];
        if (n == 1 || n == 0) {
            cont[0]++;
            result[0] = n;
            result[1] = 0;
            return result;
        } else {
            cont[0]++;
            result[0] = fiboRecursivo((n - 2), cont);
            result[1] = fiboRecursivo((n - 1), cont);

            return result;
        }

    }

}
