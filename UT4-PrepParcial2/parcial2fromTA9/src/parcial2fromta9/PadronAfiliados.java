package parcial2fromta9;

/**
 * @author EQUIPO 1
 */
public class PadronAfiliados implements IPadronAfiliados {

    /**
     * Lista de afiliados al hospital.
     */
    private Lista<IAfiliado> listaAfiliados = new Lista<>();
    private Lista<IAfiliado> listaDeudores = new Lista<>();
    private Lista<IAfiliado> listaInactivos = new Lista<>();

    /**
     * Árbol binario de afiliados al hospital.
     */
    private TArbolAfiliados<IAfiliado> arbolAfiliados = new TArbolAfiliados<>();

    private TArbolAfiliados<IAfiliado> arbolDeudores = new TArbolAfiliados<>();

    private TArbolAfiliados<IAfiliado> arbolInactivos = new TArbolAfiliados<>();

    public ILista<IAfiliado> getListaAfiliados() {
        listaAfiliados = new Lista<>();
        arbolAfiliados.inOrden(listaAfiliados);
        return listaAfiliados;
    }

    public ILista<IAfiliado> getListaDeudores() {
        listaDeudores = new Lista<>();
        arbolDeudores.inOrden(listaDeudores);
        return listaDeudores;
    }

    public ILista<IAfiliado> getListaInactivos() {
        listaInactivos = new Lista<>();
        arbolInactivos.inOrden(listaInactivos);
        return listaInactivos;
    }

    public void insertar(IElementoAB<IAfiliado> elementoAfiliado) {
        arbolAfiliados.insertar(elementoAfiliado);
    }

    public IElementoAB<IAfiliado> buscar(int etiqueta) {
        return arbolAfiliados.buscar(etiqueta);
    }

    /**
     * Actualiza las consultas y devuelva una lista de los afiliados deudores,
     *
     * @return ILista de tipo IAfiliado: padronDeudores
     */
    @Override
    public void actualizarConsultas() {

        // Si la lista de afiliados no es vacía.
        if (!arbolAfiliados.esVacio()) {

            // Tomo el primer afiliado.
            INodo<IAfiliado> nodoAfiliado = getListaAfiliados().getPrimero();

            // Recorro todos los afiliados.
            while (nodoAfiliado != null) {

                // Consultas del afiliado.
                ILista<IConsulta> consultasAgendadas = nodoAfiliado.getDato().getConsultasAnotadas();
                ILista<IConsulta> consultasHistoricas = nodoAfiliado.getDato().getConsultasHistoricas();

                // Tomo la primera consulta.
                INodo<IConsulta> nodoConsulta = consultasAgendadas.getPrimero();
                INodo<IConsulta> nodoConsultaAux = new Nodo<>();

                if (nodoConsulta == null) {
                    arbolInactivos.insertar(new TElementoAB(nodoAfiliado.getEtiqueta(), nodoAfiliado.getDato()));
                }
                // Recorro todas sus consultas.
                while (nodoConsulta != null) {

                    // Obtengo la consulta.
                    IConsulta consulta = nodoConsulta.getDato();

                    if (consulta.getResultado() != 0) {

                        nodoConsultaAux = nodoConsulta.clonar();

                        consultasHistoricas.insertar(nodoConsulta);

                        if (consulta.getResultado() == 2) {

                            IElementoAB<IAfiliado> elementoAfiliadoAux = new TElementoAB(nodoAfiliado.getEtiqueta(), nodoAfiliado.getDato());
                            arbolDeudores.insertar(elementoAfiliadoAux);
                        }
                        consultasAgendadas.eliminar(nodoConsulta.getEtiqueta());
                    }
                    nodoConsulta = nodoConsultaAux.getSiguiente();
                }
                nodoAfiliado = nodoAfiliado.getSiguiente();
            }
        }
    }

    /**
     * Consulta que retorna los afiliados a una especialidad particular.
     */
    @Override
    public ILista<IAfiliado> afiliadosPorEspecialidad(String especialidad) {

        // Crear lista de retorno.
        ILista<IAfiliado> afiliadosPorEspecialidad = new Lista<>();

        // Si la lista de afiliados no es vacía.
        if (!listaAfiliados.esVacia()) {

            // Tomo el primer afiliado.
            INodo<IAfiliado> nodoAfiliado = listaAfiliados.getPrimero();

            // Recorro todos los afiliados.
            while (nodoAfiliado != null) {

                // Consultas del afiliado.
                ILista<IConsulta> consultasAgendadas = nodoAfiliado.getDato().getConsultasAnotadas();

                // Tomo la primer consulta.
                INodo<IConsulta> nodoConsulta = consultasAgendadas.getPrimero();

                // Recorro todas sus consultas.
                while (nodoConsulta != null) {

                    // Obtengo la consulta y la comparo con el param recibido.
                    IConsulta consulta = nodoConsulta.getDato();

                    if (consulta.getEspecialidad().equals(especialidad)) {
                        afiliadosPorEspecialidad.insertarNodoOrdenado(nodoAfiliado.clonar());
                    }

                    nodoConsulta = nodoConsulta.getSiguiente();
                }

                nodoAfiliado = nodoAfiliado.getSiguiente();
            }
        }

        return afiliadosPorEspecialidad;
    }

    public TArbolBB<Afiliado> listadoContaduria() {
        return arbolDeudores;
    }

    public TArbolBB<Afiliado> listadoInactivos() {
        return arbolInactivos;
    }

    @Override
    public ILista<Afiliado> limpiar() {
        ILista<Afiliado> eliminados = new Lista();
        int contadorConsultas = 0;

        INodo<IAfiliado> auxAfiliado = getListaAfiliados().getPrimero();

        while (auxAfiliado != null) {
            INodo<IConsulta> consultaAfiliado = auxAfiliado.getDato().getConsultasAnotadas().getPrimero();

            while (consultaAfiliado != null) {

                if (consultaAfiliado.getDato().getResultado() == 2) {
                    contadorConsultas += 1;
                }
                consultaAfiliado = consultaAfiliado.getSiguiente();
            }
            if (contadorConsultas > 1) {
                eliminados.insertar(new Nodo(auxAfiliado.getEtiqueta(), auxAfiliado.getDato()));
                arbolAfiliados.eliminar(auxAfiliado.getEtiqueta());
            }
            auxAfiliado = auxAfiliado.getSiguiente();
        }
        return eliminados;
    }

    /**
     * Imprimir estadisticas iniciales.
     */
    public int cantidadConsultasAgendadas() {
        int totalConAnotadas = 0;

        INodo<IAfiliado> nodoAfiliado = getListaAfiliados().getPrimero();
        while (nodoAfiliado != null) {

            // Obtener consultas del afiliado.
            ILista<IConsulta> listaConsultasAnotadas = nodoAfiliado.getDato().getConsultasAnotadas();

            // Sumar en el total de consultas.
            totalConAnotadas += listaConsultasAnotadas.cantElementos();

            nodoAfiliado = nodoAfiliado.getSiguiente();
        }
        return totalConAnotadas;
    }

    public int cantidadConsultasHistoricas() {
        int totalConHistoricas = 0;

        INodo<IAfiliado> nodoAfiliado = getListaAfiliados().getPrimero();
        while (nodoAfiliado != null) {

            // Obtener consultas del afiliado.
            ILista<IConsulta> listaConsultasHistoricas = nodoAfiliado.getDato().getConsultasHistoricas();

            // Sumar en el total de consultas.
            totalConHistoricas += listaConsultasHistoricas.cantElementos();

            nodoAfiliado = nodoAfiliado.getSiguiente();
        }
        return totalConHistoricas;
    }

    public int totalConsultas() {
        return cantidadConsultasAgendadas() + cantidadConsultasHistoricas();
    }

    public int cantidadAfiliados() {
        return getListaAfiliados().cantElementos();
    }

}
