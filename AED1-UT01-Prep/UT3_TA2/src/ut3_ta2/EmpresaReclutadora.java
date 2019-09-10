/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_ta2;

/**
 *
 * @author grupo 1
 */
public class EmpresaReclutadora implements IEmpresaReclutadora {

    private String nombre;
    private String direccion;
    public static Lista<Persona> listaOrdenadaNombre;
    public static Lista<Persona> listaOrdenadaApellido;
    public static Lista<Persona> listaOrdenadaCedula;
    private Lista listaPersonasConTrabajo;
    private Lista listaPersonas;
    
    public EmpresaReclutadora(String nombre) {
        this.nombre = nombre;
        listaPersonas = new Lista();
        listaPersonasConTrabajo = new Lista();
        listaOrdenadaNombre = new Lista();
        listaOrdenadaApellido = new Lista();
        listaOrdenadaCedula = new Lista();
    }

    @Override
    public Lista getListaPersonas() {
        return this.listaPersonas;
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTelefono() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTelefono(String telefono) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarPersona(IPersona unaPersona) {
        if (unaPersona != null) {
            Nodo<Persona> nodo = new Nodo(unaPersona.getDocumento(), unaPersona);
            this.listaPersonas.insertar(nodo);
        }
    }

    @Override
    public boolean eliminar(String documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imprimirPersonas() {
        INodo<Persona> aux = new Nodo<Persona>();
        aux = getListaPersonas().getPrimero();
        while (aux.getDato() != null) {
            aux.imprimir();
            aux = aux.getSiguiente();
        }
        return "Fin de la impresión";
    }

    @Override
    public String imprimirSeparador(String separador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean modificarSueldo(String clave, Double sueldo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer contratarPersona(String clave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPersona buscarPorCodigo(String documento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarOrdenadoPorNombreYApellido() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IPersona buscarPorNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double calcularCostoTotalDeRRHH() {

        double valor;
        valor = 0;

        INodo<Persona> aux = listaPersonas.getPrimero();
        while (aux != null) {
            valor += aux.getDato().getSueldoMinimo();
            aux = aux.getSiguiente();
        }
        return valor;
    }

    @Override
    public ILista getListaPersonasConTrabajo() {
        return listaPersonasConTrabajo;
    }
    
    
    public ILista getListaOrdenadaNombre() {
        return listaOrdenadaNombre;
    }
    
    public ILista getListaOrdenadaApellido() {
        return listaOrdenadaApellido;
    }
    
    public ILista getListaOrdenadaCedula() {
        return listaOrdenadaCedula;
    }
}
