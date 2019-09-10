package ut3_ta2;

public interface IPersona{

    /**
     * Retorna la cédula de identidad de la Persona.
     *
     * @return Documento de la persona.
     */
    public String getDocumento();

    public void setDocumento(String documento);

    /**
     * Retorna el primer nombre de la persona.
     *
     * @return Primer Nombre.
     */
    public String getPrimerNombre();

    public void setPrimerNombre(String primerNombre);

    /**
     * Retorna el segundo nombre de la persona.
     *
     * @return Segundo Nombre.
     */
    public String getSegundoNombre();

    public void setSegundoNombre(String segundoNombre);


    /**
     * Retorna el primer apellido de la persona.
     *
     * @return Primer Apellido.
     */
    public String getPrimerApellido();

    public void setPrimerApellido(String primerApellido);

    /**
     * Retorna el segundo apellido de la persona.
     *
     * @return Segundo Apellido.
     */
    public String getSegundoApellido();

    public void setSegundoApellido(String segundoApellido);

    /**
     * Retorna el sueldo minimo de la persona
     *
     * @return Sueldo minimo.
     */
    public Double getSueldoMinimo();

    public void setSueldoMinimo(Double sueldo);

    /**
     * Retorna si la persona fue o no contratada.
     *
     * @return persona contratada si o no. 
     */
    public Boolean getContratado();

    public void setContratado(Boolean contratado);

}