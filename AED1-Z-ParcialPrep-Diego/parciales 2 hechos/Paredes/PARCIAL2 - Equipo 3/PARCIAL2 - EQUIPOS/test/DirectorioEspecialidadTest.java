/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.LinkedList;
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
public class DirectorioEspecialidadTest {
    
    public DirectorioEspecialidadTest() {
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

    /**
     * Test of listadoIngresos method, of class DirectorioEspecialidad.
     */
    @Test
    public void testListadoIngresos() {
        PlantillaMedicos hospital = new PlantillaMedicos();
        IElementoAB<Medico> IElementoAB1 = new TElementoAB<>(8, new Medico(8, "Maria", "Cardiologia", 2013));
        IElementoAB<Medico> IElementoAB2 = new TElementoAB<>(5, new Medico(5, "Valentina", "Cirugia", 2014));
        IElementoAB<Medico> IElementoAB3 = new TElementoAB<>(3, new Medico(3, "Jose", "Pediatria", 2013));
        IElementoAB<Medico> IElementoAB4 = new TElementoAB<>(6, new Medico(6, "Ana", "Cirugia", 2013));
        IElementoAB<Medico> IElementoAB5 = new TElementoAB<>(4, new Medico(4, "Florencia", "Pediatria", 2013));
        IElementoAB<Medico> IElementoAB6 = new TElementoAB<>(2, new Medico(2, "Juan", "Cardiologia", 2001));
        IElementoAB<Medico> IElementoAB7 = new TElementoAB<>(1, new Medico(1, "Pedro", "Cirugia", 2017));
        IElementoAB<Medico> IElementoAB8 = new TElementoAB<>(7, new Medico(7, "Martin", "Pediatria", 2015));

        
        hospital.insertar(IElementoAB1);
        hospital.insertar(IElementoAB2);
        hospital.insertar(IElementoAB3);
        hospital.insertar(IElementoAB4);
        hospital.insertar(IElementoAB5);
        hospital.insertar(IElementoAB6);
        hospital.insertar(IElementoAB7);
        hospital.insertar(IElementoAB8);
        
       
        DirectorioEspecialidad miDirectorio = hospital.obtenerDirectorio("Cirugia");
        System.out.println("listadoIngresos");
        int añoDeIngreso = 2014;
        int cantidadMedicos = 2;
        //Como yo ya se que hay dos medicos dedicados a la cirugía que cumplen
        //con que su año de ingreso es post 2014, entonces la función debería
        // devolver una linked list de 2 elementos.
        int result = miDirectorio.listadoIngresos(añoDeIngreso).size();
        assertEquals(result, cantidadMedicos);
        
    }
    
}
