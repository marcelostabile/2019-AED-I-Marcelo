package ejgeant;

public class Producto implements IProducto {

    private String nombre;
    private Integer precio;
    private Integer stock;
    private String etiqueta;
    
    public Producto(String etiqueta, String nombre, Integer precio){
        this.etiqueta = etiqueta;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = 0;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Integer getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    public void agregarStock(Integer stock) {
        this.stock += stock;
    }
    
// restarStock devolverá -1 si se pretende extraer más de lo que hay... 
    // y el campo stock quedará inalterado
    public Integer restarStock(Integer stock) {
       return this.stock -= stock;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

}
