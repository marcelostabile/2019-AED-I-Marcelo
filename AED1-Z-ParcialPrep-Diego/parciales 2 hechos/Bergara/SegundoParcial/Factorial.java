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
public class Factorial {
    public int factorial(int n){//Agregamos Por precondicion tiene que ser un numero mayor o igual a 0
        if(n<0){
            System.out.println("No se puede calcular factorial de valores negativos");
            return -1;
        }
        else{
            if(n==0){
                return 1;
            }
            else{
                return n*factorial(n-1);
            }
        }
        
    }
    
    public int factorialIteractivo(int n){
        int fact=n;
        while(n>1){
            n-=1;
            fact=fact*n;
        }
        return fact;
        
    }
    
    
}
