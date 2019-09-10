package ut3_ta2;

public interface IEmpresaReclutadora{

    public String getDireccion();

    public void setDireccion(String direccion);

    public String getTelefono();

    public void setTelefono(String telefono);

    public String getNombre();

    public ILista getListaPersonas();

    /**
     * Incorporar una nueva persona.
     *
     * @param unaPersona
     */
    public void insertarPersona(IPersona unaPersona);

    /**
     * Eliminar personas que ya no quieren que se les busque empleo.
     *
     * @param documento
     * @return
     */
    public boolean eliminar(String documento);


    /**
     * Imprime la lista de personas
     *
     * @return
     */
    public String imprimirPersonas();


    /**
     * Dado un separador ej.:",", ";", imprime las personas separadas por tal
     * caracter
     *
     * @param separador
     * @return
     */
    public String imprimirSeparador(String separador);

     /**
     * Modifica el sueldo de una persona.
     *
     * @param clave
     * @param sueldo
     * @return
     */
    public Boolean modificarSueldo(String clave, Double sueldo);

    /**
     * Simular la contratación de una persona
     *
     * @param clave
     * @return
     */
    public Integer contratarPersona(String clave);

    /**
     * Dado el documento de una persona, retornar la existencia de la misma. 
     *
     * @param documento
     * @return
     */
    public IPersona buscarPorCodigo(String documento);

    /**
     * Listar todas las personas registradas, ordenadas por primer nombre y primer apellido, presentando
     * ademas su salario minimo. Imprime por consola la lista de todas las personas
     * registrados y su sueldo minimo.
     */
    public void listarOrdenadoPorNombreYApellido();

    /**
     * Busca una persona por su nombre.
     *
     * @param nombre
     * @return
     */
    public IPersona buscarPorNombre(String nombre);

    /**
     * Retorna el total de sueldos minimos de todas las personas en busca de trabajo en la empresa.
     *
     * @return
     */
    public Double calcularCostoTotalDeRRHH();

    /**
     * Retorna todas las personas con trabajo contatado. 
     *
     * @return
     */
    public ILista getListaPersonasConTrabajo();


}
