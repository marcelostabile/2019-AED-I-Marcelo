/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simparcial1;

/**
 *
 * @author bernardorychtenberg
 */
public interface IAfiliado {
    
    /**
     * Obtiene la cédula del afiliado.
     *
     * @return Cédula del afiliado
     */
    public Integer getCedula();
    
    public void setCedula(Integer unaCedula);
    
     /**
     * Obtiene el nombre del afiliado.
     *
     * @return Nombre de la persona afiliada.
     */
    public String getNombre();
    
    public void setNombre(String unNombre);
    
    
     /**
     * Obtiene el apellido del afiliado
     *
     * @return Apellido de la persona afiliada.
     */
    public String getApellido();
    
    public void setApellido(String unApellido);
    
     /**
     * Obtiene el listado de las consultas históricas de un afiliado.
     *
     * @return Lista de consultas históricas
     */
    public ILista<IConsulta> getConsultasHistoricas();
    
    /**
     * Obtiene el listado de las consultas en las que el afiliado se encuentra anotado. 
     *
     * @return Lista de consultas anotadas.
     */
    public ILista<IConsulta> getConsultasAnotadas();

}
