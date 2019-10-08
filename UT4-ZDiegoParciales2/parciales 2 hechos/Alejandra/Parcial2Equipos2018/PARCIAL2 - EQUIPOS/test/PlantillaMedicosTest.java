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
 * @author usuario
 */
public class PlantillaMedicosTest {
    
    

    /**
     * Test of obtenerDirectorio method, of class PlantillaMedicos.
     */
    @Test
    public void testObtenerDirectorio1() {
        System.out.println("obtenerDirectorio especialidad no existente");
        String laEspecialidad = "uwu";
        PlantillaMedicos hospital = new PlantillaMedicos();
        /*LAS SIGUIENTES LINEAS PUEDEN SERVIR PARA HACER PRUEBAS*/
        TElementoAB<Medico> nodo1 = new TElementoAB<>(8, new Medico(8, "Maria", "Cardiologia", 2013));
        TElementoAB<Medico> nodo2 = new TElementoAB<>(5, new Medico(5, "Valentina", "Cirugia", 2014));
        TElementoAB<Medico> nodo3 = new TElementoAB<>(3, new Medico(3, "Jose", "Pediatria", 2013));
        TElementoAB<Medico> nodo4 = new TElementoAB<>(6, new Medico(6, "Ana", "Cirugia", 2013));
        TElementoAB<Medico> nodo5 = new TElementoAB<>(4, new Medico(4, "Florencia", "Pediatria", 2013));
        TElementoAB<Medico> nodo6 = new TElementoAB<>(2, new Medico(2, "Juan", "Cardiologia", 2001));
        TElementoAB<Medico> nodo7 = new TElementoAB<>(1, new Medico(1, "Pedro", "Cirugia", 2017));
        TElementoAB<Medico> nodo8 = new TElementoAB<>(7, new Medico(9,"Martin", "Pediatria", 2015));
        hospital.insertar(nodo1);
        hospital.insertar(nodo2);
        hospital.insertar(nodo3);
        hospital.insertar(nodo4);
        hospital.insertar(nodo5);
        hospital.insertar(nodo6);
        hospital.insertar(nodo7);
        hospital.insertar(nodo8);
        
        TArbolBB expResult = new TArbolBB();
        int tamaño1=expResult.obtenerTamanio();
        TArbolBB result = hospital.obtenerDirectorio(laEspecialidad);
        int tamaño2=result.obtenerTamanio();
        assertEquals(tamaño1, tamaño2);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testObtenerDirectorio2() {
        System.out.println("obtenerDirectorio con arbol base vacio");
        String laEspecialidad = "uwu";
        PlantillaMedicos hospital = new PlantillaMedicos();
        /*LAS SIGUIENTES LINEAS PUEDEN SERVIR PARA HACER PRUEBAS*/
        
        TArbolBB expResult = null;
        //int tamaño1=expResult.obtenerTamanio();
        TArbolBB result = hospital.obtenerDirectorio(laEspecialidad);
        //int tamaño2=result.obtenerTamanio();
        //assertEquals(tamaño1, tamaño2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testObtenerDirectorio3() {
        System.out.println("obtenerDirectorio especialidad existente (Cardiologia)");
        String laEspecialidad = "Cardiologia";
        PlantillaMedicos hospital = new PlantillaMedicos();
        /*LAS SIGUIENTES LINEAS PUEDEN SERVIR PARA HACER PRUEBAS*/
        TElementoAB<Medico> nodo1 = new TElementoAB<>(8, new Medico(8, "Maria", "Cardiologia", 2013));
        TElementoAB<Medico> nodo2 = new TElementoAB<>(5, new Medico(5, "Valentina", "Cirugia", 2014));
        TElementoAB<Medico> nodo3 = new TElementoAB<>(3, new Medico(3, "Jose", "Pediatria", 2013));
        TElementoAB<Medico> nodo4 = new TElementoAB<>(6, new Medico(6, "Ana", "Cirugia", 2013));
        TElementoAB<Medico> nodo5 = new TElementoAB<>(4, new Medico(4, "Florencia", "Pediatria", 2013));
        TElementoAB<Medico> nodo6 = new TElementoAB<>(2, new Medico(2, "Juan", "Cardiologia", 2001));
        TElementoAB<Medico> nodo7 = new TElementoAB<>(1, new Medico(1, "Pedro", "Cirugia", 2017));
        TElementoAB<Medico> nodo8 = new TElementoAB<>(7, new Medico(9,"Martin", "Pediatria", 2015));
        hospital.insertar(nodo1);
        hospital.insertar(nodo2);
        hospital.insertar(nodo3);
        hospital.insertar(nodo4);
        hospital.insertar(nodo5);
        hospital.insertar(nodo6);
        hospital.insertar(nodo7);
        hospital.insertar(nodo8);
        
        TArbolBB expResult = new TArbolBB();
        int tamaño1=2;
        TArbolBB result = hospital.obtenerDirectorio(laEspecialidad);
        int tamaño2=result.obtenerTamanio();
        assertEquals(tamaño1, tamaño2);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
