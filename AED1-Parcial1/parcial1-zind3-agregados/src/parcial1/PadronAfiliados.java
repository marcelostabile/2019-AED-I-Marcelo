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

    /**
     * Consulta que retorna los afiliados a una especialidad particular.
     */
    @Override
    public ILista<IAfiliado> afiliadosPorEspecialidad(String especialidad) {
        
        // Crear lista de retorno.
        ILista<IAfiliado> afiliadosPorEspecialidad = new Lista<>();
        
        // Si la lista de afiliados no es vacía.
        if (!padronAfiliados.esVacia()) {
            
            // Tomo el primer afiliado.
            INodo<IAfiliado> nodoAfiliado = padronAfiliados.getPrimero();
            
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
    
    public void imprimirEstadisticas() {
        
        // Totales
        int totalConAnotadas = 0;
        int totalConHistoricas = 0;
        int totalConsultas = 0;
        
        // Tomo el primer nodo del padrón de afiliados.
        INodo<IAfiliado> nodoAfiliado = padronAfiliados.getPrimero();
        
        // Recorro el padrón calculando los totales.
        while (nodoAfiliado != null) { 

            // Obtener consultas del afiliado.
            ILista<IConsulta> listaConsultasAnotadas = nodoAfiliado.getDato().getConsultasAnotadas();
            ILista<IConsulta> listaConsultasHistoricas = nodoAfiliado.getDato().getConsultasHistoricas();
            
            // Sumar en el total de consultas.
            totalConAnotadas += listaConsultasAnotadas.cantElementos();
            totalConHistoricas += listaConsultasHistoricas.cantElementos();
            
            nodoAfiliado = nodoAfiliado.getSiguiente();
        }
        // Calculo el total de las consultas.
        totalConsultas = totalConAnotadas + totalConHistoricas;
        
        // Imprimo todo.
        System.out.println("ESTADISTICAS");
        System.out.println();
        System.out.println("Cantidad de afiliados: " + padronAfiliados.cantElementos());
        System.out.println("Cant. Consultas Agendadas: " + totalConAnotadas);
        System.out.println("Cant. Consultas Históricas: " + totalConHistoricas);
        System.out.println("Total de Consultas: " + totalConsultas);
        System.out.println();
    }
    

}
