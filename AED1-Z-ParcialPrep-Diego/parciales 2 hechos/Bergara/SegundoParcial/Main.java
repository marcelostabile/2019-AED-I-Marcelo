/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TArbolBB a0 = new TArbolBB();
        TArbolBB a1 = new TArbolBB();

        TElementoAB b0 = new TElementoAB(1, 1);
        TElementoAB b1 = new TElementoAB(2, 0);
        TElementoAB b2 = new TElementoAB(3, 0);
        TElementoAB b3 = new TElementoAB(4, 0);
        TElementoAB b4 = new TElementoAB(5, 0);
        TElementoAB b5 = new TElementoAB(6, 0);
        TElementoAB b6 = new TElementoAB(7, 0);

        a0.insertar(b3);
        a0.insertar(b1);
        a0.insertar(b0);
        a0.insertar(b2);
        a0.insertar(b5);
        a0.insertar(b4);
        a0.insertar(b6);

        System.out.println(a0.obtenerAltura());
        System.out.println(a0.esArbolBusqueda());
        System.out.println(a0.inOrden());
        System.out.println(a0.obtenerTamanio());
        System.out.println(a0.postOrden());
        System.out.println(a0.preOrden());
        a0.listarHojas();
        System.out.println(a0.obtenerMayorClave());
        System.out.println(a0.obtenerMenorClave());
        System.out.println(a0.obtenerNivel(5));
        System.out.println(a0.cantNodosNivel(1));
        System.out.println("");
        System.out.println("");
        
        TElementoAB b02 = new TElementoAB(1, 1);
        TElementoAB b12 = new TElementoAB(2, 0);
        TElementoAB b22 = new TElementoAB(3, 0);
        TElementoAB b32 = new TElementoAB(4, 0);
        TElementoAB b42 = new TElementoAB(5, 0);
        TElementoAB b52 = new TElementoAB(6, 0);
        TElementoAB b62 = new TElementoAB(7, 0);
        
        a1.insertar(b02);
        a1.insertar(b12);
        a1.insertar(b22);
        a1.insertar(b32);
        a1.insertar(b42);
        a1.insertar(b52);
        a1.insertar(b62);
        
        System.out.println(a1.obtenerAltura());
        System.out.println(a1.esArbolBusqueda());
        System.out.println(a1.inOrden());
        System.out.println(a1.obtenerTamanio());
        System.out.println(a1.postOrden());
        System.out.println(a1.preOrden());
        a1.listarHojas();
        System.out.println(a1.obtenerMayorClave());
        System.out.println(a1.obtenerMenorClave());
        System.out.println(a1.obtenerNivel(5));
        System.out.println(a1.cantNodosNivel(1));
    }

}
