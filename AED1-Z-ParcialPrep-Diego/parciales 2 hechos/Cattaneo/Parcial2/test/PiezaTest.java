import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruno Cattáneo
 */
public class PiezaTest {
    
    Pieza piezaBien, piezaError1, piezaError2, piezaNull, piezaVacio;
    
    @Before
    public void setUp() {
        piezaBien = new Pieza("K", "10.20", "Pump", 10, 10);
        piezaError1 = new Pieza("K", ".20", "Pump", 10, 10);
        piezaError2 = new Pieza("K", "20", "Pump", 10, 10);
        piezaNull = new Pieza("K", null, "Pump", 10, 10);
        piezaVacio = new Pieza("K", "", "Pump", 10, 10);
    }

    /**
     * Test of obtenerRubro method, of class Pieza.
     */
    @Test
    public void testObtenerRubro_bien() {
        assertEquals(piezaBien.obtenerRubro(), "10");
    }
    
    /**
     * Test of obtenerRubro method, of class Pieza.
     */
    @Test
    public void testObtenerRubro_error() {
        assertEquals(piezaError1.obtenerRubro(), "");
        assertEquals(piezaError2.obtenerRubro(), "20");
    }
    
    /**
     * Test of obtenerRubro method, of class Pieza.
     */
    @Test
    public void testObtenerRubro_null() {
        assertEquals(piezaNull.obtenerRubro(), "");
    }
    
    /**
     * Test of obtenerRubro method, of class Pieza.
     */
    @Test
    public void testObtenerRubro_vacio() {
        assertEquals(piezaVacio.obtenerRubro(), "");
    }
    
}
