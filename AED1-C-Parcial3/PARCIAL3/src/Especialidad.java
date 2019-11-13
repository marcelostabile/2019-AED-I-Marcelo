import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aruib_000
 */
public class Especialidad implements IEspecialidad {
    
    String especialidad;
    List<Consulta> consultas;
    
    public Especialidad (String esp){
        especialidad = esp;
        consultas = new LinkedList();
    }
    
    @Override
    public String getEspecialidad() {
        return especialidad;
    }
    
    @Override
    public void setEspecialidad(String esp){
        this.especialidad = esp;
    }

    @Override
    public int getFrecuencia(){
        return consultas.size();
    }
    
    @Override
    public void agregaConsulta(Consulta laConsulta){
        consultas.add(laConsulta);
    }
    
    @Override
    public List<Consulta> getConsultas(){
        return this.consultas;
    }
    
}
