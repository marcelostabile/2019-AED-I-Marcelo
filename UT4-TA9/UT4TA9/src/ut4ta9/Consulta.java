package ut4ta9;

/**
 * @author EQUIPO 1
 */
public class Consulta implements IConsulta {

    public String fecha;
    public String especialidad;
    public Integer medico;

    /* 
     * Resultado
     * 0:Anotada 1:Concurrió 2:No concurrió.
     */
    public Integer resultado;

    /* 
     * Constructor.
     */
    public Consulta (String fecha, String especialidad, Integer medico, Integer resultado) {
        this.fecha = fecha;
        this.especialidad = especialidad;
        this.medico = medico;
        this.resultado = resultado;
    }
    
    /*
     * Fecha de consulta.
     */
    @Override
    public String getFechaConsulta() {
        return this.fecha;
    }
    
    @Override
    public void setFechaConsulta(String unaFecha) {
        this.fecha = unaFecha;
    }
    
    /**
     * Especialidad.
     */
    @Override
    public String getEspecialidad(){
        return this.especialidad;
    }
    
    @Override
    public void setEspecialidad(String unaEspecialidad) {
        this.especialidad = unaEspecialidad;
    }

    /**
     * Médico de la consulta.
     */
    @Override
    public Integer getMedico() {
        return this.medico;
    }
    
    @Override
    public void setMedico(Integer unaCIMedico) {
        this.medico = unaCIMedico;
    }

    /**
     * Resultado de la consulta.
     *
     * 0 anotada, pendiente. 
     * 1 concurrió. 
     * 2 no concurrió.
     */
    @Override
    public Integer getResultado() {
        return this.resultado;
    }
    
    @Override
    public void setResultado(Integer unResultado) {
        this.resultado = unResultado;
    }
}
