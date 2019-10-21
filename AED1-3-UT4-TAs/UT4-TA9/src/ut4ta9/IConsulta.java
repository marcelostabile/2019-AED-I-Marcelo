/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4ta9;

import java.util.Date;

/**
 *
 * @author bernardorychtenberg
 */
public interface IConsulta {
    
    
    /**
     * Obtiene la fecha de la consulta.
     *
     * @return Fecha de la consulta
     */
    public String getFechaConsulta();
    public void setFechaConsulta(String unaFecha);
    
    /**
     * Obtiene la especialidad de la consulta.
     *
     * @return Especialidad de la consulta
     */
    public String getEspecialidad();
    public void setEspecialidad(String unaEspecialidad);
    
    /**
     * Obtiene el médico de la consulta.
     *
     * @return Cédula del médico de la consulta
     */
    public Integer getMedico();
    public void setMedico(Integer unaCIMedico);
    
    /**
     * Obtiene el resultado de la consulta.
     *
     * @return Resultado de la consulta. 
     * 0 si todavía no se ha producido. 
     * 1 si el afiliado concurrió. 
     * 2 si el afiliado no concurrió.
     */
    public Integer getResultado();
    public void setResultado(Integer unResultado);
    
}
