/*
 * EMPRESA
 */
package geant;

/**
 *
 * @author mstabile
 */
public class Empresa {
    
    public String nombre = "Grandeza y Elegancia ANte Todo";
    
    // Lista para almacenar los productos.
    private ILista<Nodo> almacen = new Lista<>();

    // Valor Economico del stock.
    Double ValorEconomico = 0.00;
    
    // Constructor.
    public Empresa () {

    }

    public void incorporarProducto(Producto unProducto) {

        // Creamos el nodo.
        Nodo nodoAux = new Nodo(unProducto.id, unProducto);
        
        // Lista vacía, primer producto es primero de la lista.
        if (almacen.esVacia()) {
            almacen.setPrimero(nodoAux);
        } else {
        // Lista con elementos, se inserta al final.
        almacen.insertar(nodoAux);
        }
        
        this.ValorEconomico += (unProducto.prunit * unProducto.cantidad);
    }

    public void eliminarProducto(Comparable clave) {
        
        // Buscar nodo.
        Nodo nodoAux = almacen.buscar(clave);

        // Busco el producto.
        Producto prodAux = (Producto) nodoAux.getDato();
        
        this.ValorEconomico -= (prodAux.prunit * prodAux.cantidad);
        
        almacen.eliminar(clave);
    }
        
    public void agregarStock(Comparable clave, int cantidad) {
       
        // Busco el nodo.
        Nodo nodoAux = almacen.buscar(clave);
        
        // Busco el producto.
        Producto prodAux = (Producto) nodoAux.getDato();
        
        // Modifico incrementando la cantidad.
        int stockInicial = prodAux.getStock();
        
        prodAux.cantidad += cantidad;
        
        this.ValorEconomico += (prodAux.prunit * prodAux.cantidad);
        
        int stockFinal = prodAux.getStock();
        
        System.out.println("Stock Inicial de " + prodAux.nombre + ": " + stockInicial);
        System.out.println("Se incrementó el stock en: " + cantidad);
        System.out.println("Stock Final: " + stockFinal);
        System.out.println();
    }

    public void quitarStock(Comparable clave, int cantidad) {
        
        // Busco el nodo.
        Nodo nodoAux = almacen.buscar(clave);
        
        // Busco el producto.
        Producto prodAux = (Producto) nodoAux.getDato();
        
        // Modifico quitan cantidad.
        int stockInicial = prodAux.getStock();
        
        prodAux.cantidad -= cantidad;
        
        this.ValorEconomico -= (prodAux.prunit * prodAux.cantidad);
        
        int stockFinal = prodAux.getStock();
        
        System.out.println("Stock Inicial de " + prodAux.nombre + ": " + stockInicial);
        System.out.println("Se quitaron del stock: " + cantidad);
        System.out.println("Stock Final: " + stockFinal);
        System.out.println();
    }
    
    public String consultarStock(Comparable clave) {
        
        // Busco el nodo, busco el producto, retorno el stock.
        Nodo nodoAux = almacen.buscar(clave);
        
        Producto prodAux = (Producto) nodoAux.getDato();
        
        String rtnAux = (prodAux.nombre + ": " + prodAux.getStock()); 
        
        return rtnAux;
    }
    
    public void informarValorEconomico() {
        
        System.out.println("Valor Económico a la fecha: " + this.ValorEconomico);
    }
}
