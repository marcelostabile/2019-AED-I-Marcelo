import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Cattáneo
 */
public class TArbolPiezasTest {
    
    TArbolPiezas arbolBien, arbolVacio;
    
    @Before
    public void setUp() {
        // Nuevo árbol con piezas
        arbolBien = new TArbolPiezas();
        arbolBien.insertar(new TElementoAB<>("K", new Pieza("K", "10.20", "Pump", 10, 10)));
        arbolBien.insertar(new TElementoAB<>("Z", new Pieza("Z", "10.30", "Pump2", 10, 20)));
        arbolBien.insertar(new TElementoAB<>("Y", new Pieza("Z", "20.20", "Pump3", 10, 20)));
        // Nuevo árbol vacío
        arbolVacio = new TArbolPiezas();
    }

    /**
     * Test of piezasPorRubro method, of class TArbolPiezas.
     */
    @Test
    public void testPiezasPorRubro_vacio() {
        // Genero árbol de árbol vacío, para ningún rubro
        TArbolPiezas arbolGenerado = arbolVacio.piezasPorRubro("");
        // Compruebo que está vacío
        assertTrue(arbolGenerado.esVacio());
        // Genero para rubro 10 (árbol vacío, debe generar vacío)
        arbolGenerado = arbolVacio.piezasPorRubro("10");
        // Compruebo que está vacío
        assertTrue(arbolGenerado.esVacio());
    }
    
    /**
     * Test of piezasPorRubro method, of class TArbolPiezas.
     */
    @Test
    public void testPiezasPorRubro_bien() {
        // Genero árbol de árbol con piezas, para ningún rubro
        TArbolPiezas arbolRubroVacio = arbolBien.piezasPorRubro("");
        // Árbol debe estar vacío
        assertTrue(arbolRubroVacio.esVacio());
        // Compruebo que están piezas "K" ("10.20"), "Z" ("10.30"), e "Y" ("20.20") en el original
        assertNotNull(arbolBien.buscar("K"));
        assertNotNull(arbolBien.buscar("Y"));
        assertNotNull(arbolBien.buscar("Z"));
        // Genero para rubro 10 (árbol con piezas, debe generar para dos piezas: "K" y "Z" según sus rubros)
        TArbolPiezas arbolRubro10 = arbolBien.piezasPorRubro("10");
        // Compruebo que no está vacío
        assertFalse(arbolRubro10.esVacio());
        // Compruebo que están piezas "10.20" ("K") y "10.30" ("Z"), pero NO "20.20" ("Y")
        assertNotNull(arbolRubro10.buscar("10.20"));
        assertNotNull(arbolRubro10.buscar("10.30"));
        assertNull(arbolRubro10.buscar("20.20"));
    }

    /**
     * Test of cantYvalorStock method, of class TArbolPiezas.
     */
    @Test
    public void testCantYvalorStock_vacio() {
        // Genero cantidad y stock para un árbol vacío (debe ser todo cero)
        int cantYValorStock[] = arbolVacio.cantYvalorStock();
        // Compruebo cantidad y stock
        assertEquals(cantYValorStock[0], 0);
        assertEquals(cantYValorStock[1], 0);
    }
    
    /**
     * Test of cantYvalorStock method, of class TArbolPiezas.
     */
    @Test
    public void testCantYvalorStock_bien() {
        // Genero cantidad y stock para un árbol de 3 piezas
        int cantYValorStock[] = arbolBien.cantYvalorStock();
        // Compruebo cantidad y stock
        assertEquals(cantYValorStock[0], 30);
        assertEquals(cantYValorStock[1], 500);
        
    }
    
}
