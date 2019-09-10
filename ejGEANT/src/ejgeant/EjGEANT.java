/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejgeant;

/**
 *
 * @author usuario
 */
public class EjGEANT {

    public static void main(String[] args) {
        // TODO code application logic here
        Almacen geant = new Almacen("Geant","Av. la playa 1332","26820000");
                
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/ejgeant/altas.txt");
        for (String linea : lineas) {
            //    public Producto(String etiqueta, String nombre, Integer precio)
            String[] c = linea.split(",");
            Producto productito = new Producto(c[0], c[1], Integer.parseInt(c[2]));
            geant.insertarProducto(productito);
        }
        System.out.println(geant.imprimirProductos());
        
        System.out.println("AGREGAR STOCK");
        Producto gelatina = geant.buscarPorCodigo("1000088");
        System.out.println(gelatina.getEtiqueta() + ", " + gelatina.getNombre() + ", " + gelatina.getStock());
        geant.agregarStock("1000088", 999999999);
        System.out.println(gelatina.getEtiqueta() + ", " + gelatina.getNombre() + ", " + gelatina.getStock());
        System.out.println();
    
        System.out.println("RESTAR STOCK");
        geant.restarStock("1000088", 444444444);
        System.out.println(gelatina.getEtiqueta() + ", " + gelatina.getNombre() + ", " + gelatina.getStock());

        System.out.println("Eliminando un producto del stock");
        System.out.println("Productos en stock:" + geant.getListaProductos().cantElementos());
        geant.eliminarProducto("1000097"); // Se elimina "1000097, HELADO FRUTILLA RECREO, 73, 0"
        System.out.println("Productos en stock:" + geant.getListaProductos().cantElementos());
        System.out.println();

        System.out.println("Monto total:" + geant.calcularStock());
        System.out.println("Eliminación múltiple del stock, leyendo el archivo de bajas");
        String[] lineasb = ManejadorArchivosGenerico.leerArchivo("src/ejgeant/elim.txt");
        for (String linea : lineasb) {
            String[] c = linea.split(",");
            INodo<Producto> paux = geant.getListaProductos().buscar(c[0]);
            geant.getListaProductos().eliminar(c[0]);
        }       
        System.out.println("Productos en stock:" + geant.getListaProductos().cantElementos());
        System.out.println();

        System.out.println("Monto total:" + geant.calcularStock()); //hay que afinarlo, da siempre igual
    }

}