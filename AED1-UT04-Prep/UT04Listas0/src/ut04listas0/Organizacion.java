/*
 * CLASE ORGANIZACION
 */
package ut04listas0;

/**
 * @author EQUIPO
 */
public class Organizacion { 
    
    /*
     * Atributos.
     */
    private String nombreOrganizacion;
    
    // Lista de personas pertenecientes a la organización.
    public ILista<Persona> listaPersonas = new Lista<>();
    
    /*
     * Métodos.
     */
    public String getNombre() { return this.nombreOrganizacion; }
    
    public void setNombre(String nombreOrg) { this.nombreOrganizacion = nombreOrg; }
    
}
