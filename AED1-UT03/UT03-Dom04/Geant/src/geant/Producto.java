/*
 * PRODUCTO
 */
package geant;

/**
 *
 * @author mstabile
 */
public class Producto {
    
    // Nombre, Identificación, Precio Unitario, StockActual.
    String nombre;
    String id;
    Double prunit;
    int cantidad;
    
    public Producto (String nombre, String id, Double precioUnitario, int cantidad) {
        
        this.nombre = nombre;
        this.id = id;
        this.prunit = precioUnitario;
        this.cantidad = cantidad;
    }

    // Precio Unitario.
    public void setPrecioUnitario(double nuevoPrecioUnitario) {
        
        this.prunit = nuevoPrecioUnitario;
    }

    public double getPrecioUnitario() {
        
        return this.prunit;
    }

    // Stock.
    public void agregarStock(int cantidad) {
        
        this.cantidad += cantidad;
    }

    public void quitarStock(int cantidad) {
        
        this.cantidad -= cantidad;
    }

    public int getStock() {
        
        return this.cantidad;
    }

}
