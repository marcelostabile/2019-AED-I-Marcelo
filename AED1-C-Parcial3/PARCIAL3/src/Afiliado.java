/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aruib_000
 */
public class Afiliado implements IAfiliado {
    
    private int cedula; 
    private String nombre;
    private String apellido;
    Lista<Consulta> historia;
    Lista<Consulta> pendientes;
    
     public Afiliado (int unaCedula, String unNombre, String unApellido) {
        this.cedula = unaCedula;
        this.nombre = unNombre;
        this.apellido = unApellido;
        this.historia = new Lista();
        this.pendientes = new Lista();
    }

    @Override
    public int getCedula() {
        return cedula;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }
    
    @Override
    public Lista<Consulta> getConsultasHistoricas(){
        return this.historia;
    }
    
    @Override
    public Lista<Consulta> getConsultasPendientes(){
        return this.pendientes;
    }
    
    @Override
    public String imprimir() {
        String losDatos = ("Cedula: " + cedula + ",    Nombre: " + nombre + ",    Apellido: " + apellido);
        return losDatos;
    }
    
    @Override
    public void cargarConsultaHistorica(Consulta unaConsulta){
        
        Nodo<Consulta> unNodo = new Nodo(unaConsulta.getFecha(), unaConsulta);
        this.historia.insertar(unNodo);
    }
    
    @Override
    public void cargarConsultaPendiente(Consulta unaConsulta){
        
        Nodo<Consulta> unNodo = new Nodo(unaConsulta.getFecha(), unaConsulta);
        this.pendientes.insertar(unNodo);
    }
    
   
   
    
}    
