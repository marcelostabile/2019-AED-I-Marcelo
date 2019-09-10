/*
 * MAIN
 */
package geant;

/**
 *
 * @author mstabile
 */
public class Geant {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear empresa.
        Empresa empresa = new Empresa();
        
        // Crear productos.
        Producto prod1 = new Producto("Café", "1", 35.00, 12);
        Producto prod2 = new Producto("Mate", "2", 65.00, 12);
        Producto prod3 = new Producto("Pan", "3", 50.00, 10);
        Producto prod4 = new Producto("Leche", "4", 25.00, 24);
        Producto prod5 = new Producto("Manteca", "5", 60.00, 10);
        Producto prod6 = new Producto("Dulce de Leche", "6", 100.00, 5);

        // Informar valor economico.
        empresa.informarValorEconomico();
        System.out.println();
        
        // Incorporar productos al almacen de la empresa.
        empresa.incorporarProducto(prod1);
        empresa.incorporarProducto(prod2);
        empresa.incorporarProducto(prod3);
        empresa.incorporarProducto(prod4);
        empresa.incorporarProducto(prod5);
        empresa.incorporarProducto(prod6);

        // Informar valor economico.
        empresa.informarValorEconomico();
        System.out.println();
        
        // Modificamos el stock de productos.
        empresa.agregarStock("1", 12);
        empresa.agregarStock("2", 6);

        // Informar valor economico.
        empresa.informarValorEconomico();
        System.out.println();

        empresa.quitarStock("3", 5);
        empresa.quitarStock("2", 4);

        // Indicar las existencias de un producto en el almacen.
        System.out.println("Stock de " + empresa.consultarStock("1"));
        System.out.println("Stock de " + empresa.consultarStock("2"));
        System.out.println("Stock de " + empresa.consultarStock("3"));
        System.out.println("Stock de " + empresa.consultarStock("4"));
        System.out.println("Stock de " + empresa.consultarStock("5"));
        System.out.println("Stock de " + empresa.consultarStock("6"));
        System.out.println();
        
        // Informar valor economico.
        empresa.informarValorEconomico();
        System.out.println();
        
        // Eliminar un producto.
        empresa.eliminarProducto("1");
        System.out.println("Producto eliminado");
        System.out.println();
        
        // Informar valor economico.
        empresa.informarValorEconomico();
        System.out.println();
        
        // Listado de productos existentes, orden por nombre, indicar stock.
        // empresa.listarExistencias();
        
    }
}
