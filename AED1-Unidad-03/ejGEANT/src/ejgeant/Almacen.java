package ejgeant;

public class Almacen implements IAlmacen {

    private String nombre;
    private Lista<Producto> listaProductos;
    private String telefono;
    private String direccion;
    
    public Almacen(String nombre, String direccion, String telefono) {
    this.nombre = nombre;
    this.telefono = telefono;
    this.direccion = direccion;
    listaProductos = new Lista();
    }
     
    @Override
    public String imprimirProductos() {
        String devolver = "";
        Nodo<Producto> aux = listaProductos.getPrimero();
        Producto unProducto;
        while (aux != null) {
            unProducto = aux.getDato();
            devolver += unProducto.getEtiqueta() + ", " + unProducto.getNombre() + ", " + unProducto.getPrecio() + ", " + unProducto.getStock() + "\n";
            aux = aux.getSiguiente();
        }
        return devolver;        
    }

    
    @Override
    public String imprimirSeparador(String separador) {
        return this.listaProductos.imprimir(separador);
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        return this.listaProductos.buscar(clave).getDato();
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        return null;
    }

    @Override
    public int cantidadProductos() {
        return this.listaProductos.cantElementos();
    }

    public void agregarProductoOrdenadoNombre(IProducto unProducto) {
    }

    @Override
    public void listarOrdenadoPorNombre() {
        // TODO Auto-generated method stub
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;        
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Lista<Producto> getListaProductos() {
        return listaProductos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo aux = new Nodo(unProducto,unProducto.getEtiqueta());
        listaProductos.insertar(aux);
    }

    @Override
    public boolean eliminarProducto(Comparable clave) {
        return listaProductos.eliminar(clave);
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Nodo<Producto> aux = listaProductos.buscar(clave);
        Producto unProducto = aux.getDato();
        Integer stockHabria = unProducto.getStock() + cantidad; // Cantidad que tendrìa que haber despues de agregar stock
        unProducto.agregarStock(cantidad);                      // Operacion de agregar stock
        if (unProducto.getStock() == stockHabria){
            return true;
        }
        else {   
            return false;
        }
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Nodo<Producto> aux = listaProductos.buscar(clave);
        Producto unProducto = aux.getDato();
        Integer stockHabria = unProducto.getStock() + cantidad; // Cantidad que tendrìa que haber despues de agregar stock
        unProducto.restarStock(cantidad);                      // Operacion de agregar stock
        return unProducto.getStock();
    }
    
    public Integer calcularStock() {
        Integer monto = 0;
        Nodo<Producto> aux = listaProductos.getPrimero();
        while (aux != null){
            monto += aux.getDato().getPrecio()*aux.getDato().getStock();
            aux = aux.getSiguiente();
        }
        return monto;
    }
}
