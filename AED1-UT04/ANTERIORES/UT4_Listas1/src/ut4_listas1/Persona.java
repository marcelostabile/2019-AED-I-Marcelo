/*
 * CLASE PERSONA.
 */
package ut4_listas1;

/**
 * @author mstabile.
 */
public class Persona {
    
    // Atributos.
    private final String id;
    private String nombre;
    private String apellido;
    private int edad = 0;
//    private String sexo = null;
//    private String domicilio = null;
//    private String telefono = null;
//    private String celular = null;
    
    /*
     * Constructor.
    */
    public Persona(String nombre, String apellido, String id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getId() { return this.id; }
    
    public String getNombre() { return this.nombre; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getApellido() { return this.apellido; }
    
    public void setApellido(String apellido) { this.apellido = apellido; }
    
    public int getEdad() { return this.edad; }
    
    public void setEdad(int edad) { this.edad = edad; }
    
//    public String getSexo() { return this.sexo; }
    
//    public void setSexo(String sexo) { this.sexo = sexo; }
//    
//    public String getDomicilio() { return this.domicilio; }
    
//    public void setDomicilio(String domicilio) { this.domicilio = domicilio; }
//    
//    public String getTelefono() { return this.telefono; }
    
//    public void setTelefono(String telefono) { this.telefono = telefono; }
//    
//    public String getCelular() { return this.celular; }
    
//    public void setCelular(String celular) { this.celular = celular; }

}
