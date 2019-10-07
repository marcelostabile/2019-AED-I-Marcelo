/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_ta2;

/**
 *
 * @author equipo 1
 */
class Persona implements IPersona {
    
    private String cedula;
    private String nombre;
    private String segundoNombre;
    private String apellido;
    private String segundoApellido;
    private double sueldo;
    private boolean contratado;
    
    Persona(String cedula, String nombre, String segundoNombre, String apellido, String segundoApellido, double sueldo, boolean contratado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.nombre = segundoNombre;
        this.apellido = apellido;
        this.apellido = segundoApellido;
        this.sueldo = sueldo;
        this.contratado = contratado;
    }

    public String getDocumento() {
        return this.cedula;
    }

    public void setDocumento(String documento) {
        this.cedula = documento;
    }

    public String getPrimerNombre() {
        return this.nombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.nombre = primerNombre;
    }

    public String getSegundoNombre() {
        return this.segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.nombre = segundoNombre;
    }    
    
    public String getPrimerApellido() {
        return this.apellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.apellido = primerApellido;
    }
    public String getSegundoApellido() {
        return this.segundoApellido;
    }    

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }    

    public Double getSueldoMinimo() {
        return this.sueldo;
    }

    public void setSueldoMinimo(Double sueldo) {
        this.sueldo = sueldo;
    }    

    public Boolean getContratado() {
        return this.contratado;
    }    
        
    @Override
    public void setContratado(Boolean contratado) {
        this.contratado = contratado;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }

}