/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut03.dom01.ej01;

/**
 *
 * @author Marcelo.
 */
public class UT03Dom01EJ01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Crear los nodos.
        Nodo<Nodo> nodo1 = new Nodo("1", "A");
        Nodo<Nodo> nodo2 = new Nodo("2", "B");
        Nodo<Nodo> nodo3 = new Nodo("3", "C");

        // Agregar referencias de siguiente a cada nodo.
        nodo1.setSiguiente(nodo2);
        nodo2.setSiguiente(nodo3);
        
        // Agregarlos a la lista.
        Lista<Nodo> lista1 = new Lista();
        lista1.setPrimero(nodo1);
        
        System.out.println("Imprimiendo lista inicial...");
        lista1.imprimir();
        
        // Crear nodo nuevo.
        Nodo<Nodo> nodo4 = new Nodo("4", "D");
        
        // A) Insertar nodo 4 a nodo 1.
        nodo4.setSiguiente(nodo1);
        lista1.setPrimero(nodo4);
        
        System.out.println("Imprimiendo: Insertamos nodo 4 en lugar de nodo 1...");
        lista1.imprimir();
        
        // B) Insertar nodo 4 entre nodo 1 y nodo 2.
        lista1.setPrimero(nodo1);
        
        /* 
         * Busca nodo1, clave "1". 
         * Referencia nodo1.siguiente en nodo4.siguiente.
         * Referencia nodo4 en nodo1.siguiente.
         */
        nodo4.setSiguiente(lista1.buscar("1").getSiguiente());
        nodo1.setSiguiente(nodo4);   
    
        System.out.println("Imprimiendo: insertamos nodo 4 entre nodo 1 y nodo 2...");
        lista1.imprimir();
        
        // C) Eliminar nodo2 de la lista.
        lista1.eliminar("2");

        System.out.println("Imprimiendo: eliminamos nodo2 de la lista...");
        lista1.imprimir();

    }    
}
