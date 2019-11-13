
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
public interface IEspecialidad {
    
    String getEspecialidad();
    void setEspecialidad(String esp);
    int getFrecuencia();
    void agregaConsulta(Consulta laConsulta);
    List<Consulta> getConsultas();
   
}
