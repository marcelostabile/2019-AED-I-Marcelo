package pruebas;

public class Producto {

    private Comparable etiqueta;
    private String nombre;
    private Integer precio;
    private Integer stock;

    public Producto(Comparable etiqueta, int unPrecio) {
        this.etiqueta = etiqueta;        
        this.stock = 0;
        this.precio = unPrecio;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getValor() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void agergarStock(Integer stock) {
        this.stock += stock;
    }

    // restarStock devolverá -1 si se pretende extraer más de lo que hay... 
    // y el campo stock quedará inalterado
    public Integer restarStock(Integer stock) {
        if (stock > this.stock) {
            return -1;
        } else {
            setStock(this.stock - stock);
            return this.stock;
        }
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public String toString(){
        return "Etiqueta: " + this.etiqueta + ", Nombre: " + this.nombre;
    }
}
