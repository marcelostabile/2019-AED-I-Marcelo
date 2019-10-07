package parcial1;

/**
 * @author EQUIPO 1
 */
public class PadronAfiliados implements TPadronAfiliados {

    /**
     * Lista de afiliados al hospital.
     */
    public ILista<IAfiliado> padronAfiliados = new Lista<>();

    /**
     * Actualiza las consultas y devuelva una lista de los afiliados deudores, 
     * @return ILista de tipo IAfiliado: padronDeudores
     */
    @Override
    public ILista<IAfiliado> actualizarConsultas() {

        // Crear lista de deudores.
        ILista<IAfiliado> padronDeudores = new Lista();
        
        // Si la lista de afiliados no es vacía.
        if (!padronAfiliados.esVacia()) {
            
            // Tomo el primer afiliado.
            INodo<IAfiliado> nodoAfiliado = padronAfiliados.getPrimero();
            
            // Recorro todos los afiliados.
            while (nodoAfiliado != null) {
                
                // Consultas del afiliado.
                ILista<IConsulta> consultasAgendadas = nodoAfiliado.getDato().getConsultasAnotadas();
                ILista<IConsulta> consultasHistoricas = nodoAfiliado.getDato().getConsultasHistoricas();

                // Tomo la primer consulta.
                INodo<IConsulta> nodoConsulta = consultasAgendadas.getPrimero();
                INodo<IConsulta> nodoConsultaAux = new Nodo<>();

                // Recorro todas sus consultas.
                while (nodoConsulta != null) { 
    
                    // Obtengo la consulta.
                    IConsulta consulta = nodoConsulta.getDato();
    
                    if (consulta.getResultado() != 0) { 
    
                        nodoConsultaAux = nodoConsulta.clonar();
    
                        consultasHistoricas.insertar(nodoConsulta);
    
                        if (consulta.getResultado() == 2) { 
                            
                            INodo<IAfiliado> nodoAfiliadoAux = nodoAfiliado.clonar();
                            
                            padronDeudores.insertar(nodoAfiliadoAux);
                        }
                        consultasAgendadas.eliminar(nodoConsulta.getEtiqueta());
                    }
                    nodoConsulta = nodoConsultaAux.getSiguiente();
                } 
                nodoAfiliado = nodoAfiliado.getSiguiente();
            }
        }
        return padronDeudores;
    }
}
