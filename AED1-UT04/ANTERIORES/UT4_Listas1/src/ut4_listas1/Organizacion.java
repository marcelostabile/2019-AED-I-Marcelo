/*
 * CLASE ORGANIZACION.
 */
package ut4_listas1;

/**
 * @author mstabile.
 */
public class Organizacion { 
    
    /*
     * Atributos.
     */
    private String nombreOrganizacion;
    
    /**
     * Lista de personas pertenecientes a la organización.
     */
    public ILista<Persona> listaPersonas = new Lista<>();
    
    /**
     * Obtener el nombre de la organización.
     * 
     * @return el nombre.
     */
    public String getNombre() { 
        return this.nombreOrganizacion; 
    }

    /**
     * Asignar nombre de la organización.
     * 
     * @param nombreNuevo - el nuevo nombre.
     */
    public void setNombre(String nombreNuevo) { 
        this.nombreOrganizacion = nombreNuevo; 
    }
    
}
