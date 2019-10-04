package ut4ta9;

/**
 * @author EQUIPO 1
 */
public class PadronAfiliados implements IPadronAfiliados {

    /**
     * Lista de afiliados al hospital.
     */
    public IArbolBB<IAfiliado> padronAfiliados = new TArbolBB<>();

    @Override
    public Lista<Afiliado> limpiar() {
        Lista<Afiliado> eliminados = new Lista();
        int cont = 0;

        INodo<Afiliado> a = this.padronAfiliados.inOrden(Lista<T> unaLista).getPrimero();
        INodo<IConsulta> s = a.getDato().listaConsultasAnotadas.getPrimero();
        while (a != null) {
            while (s != null) {

                if (s.getDato().getResultado() == 2) {
                    cont += 1;
                }
                s = s.getSiguiente();
            }
            if (cont > 1) {
                Nodo eliminado = new Nodo(s.getEtiqueta(), s.getDato());
                eliminados.insertar(eliminado);
                this.padronAfiliados.eliminar(a.getEtiqueta());
            }
            a = a.getSiguiente();
        }
        return eliminados;
    }

    // Crear lista de deudores.
    //ILista<IAfiliado> padronDeudores = new Lista();
//    /**
//     * Actualiza las consultas y devuelva una lista de los afiliados deudores, 
//     * @return ILista de tipo IAfiliado: padronDeudores
//     */
//    @Override
//    public ILista<IAfiliado> actualizarConsultas() {
//
//        // Crear lista de deudores.
//        ILista<IAfiliado> padronDeudores = new Lista();
//        
//        // Si la lista de afiliados no es vacía.
//        if (!padronAfiliados.esVacia()) {
//            
//            // Tomo el primer afiliado.
//            INodo<IAfiliado> nodoAfiliado = padronAfiliados.getPrimero();
//            
//            // Recorro todos los afiliados.
//            while (nodoAfiliado != null) {
//                
//                // Consultas del afiliado.
//                ILista<IConsulta> consultasAgendadas = nodoAfiliado.getDato().getConsultasAnotadas();
//                ILista<IConsulta> consultasHistoricas = nodoAfiliado.getDato().getConsultasHistoricas();
//
//                // Tomo la primer consulta.
//                INodo<IConsulta> nodoConsulta = consultasAgendadas.getPrimero();
//                INodo<IConsulta> nodoConsultaAux = new Nodo<>();
//
//                // Recorro todas sus consultas.
//                while (nodoConsulta != null) { 
//    
//                    // Obtengo la consulta.
//                    IConsulta consulta = nodoConsulta.getDato();
//    
//                    if (consulta.getResultado() != 0) { 
//    
//                        nodoConsultaAux = nodoConsulta.clonar();
//    
//                        consultasHistoricas.insertar(nodoConsulta);
//    
//                        if (consulta.getResultado() == 2) { 
//                            
//                            INodo<IAfiliado> nodoAfiliadoAux = nodoAfiliado.clonar();
//                            
//                            padronDeudores.insertar(nodoAfiliadoAux);
//                        }
//                        consultasAgendadas.eliminar(nodoConsulta.getEtiqueta());
//                    }
//                    nodoConsulta = nodoConsultaAux.getSiguiente();
//                } 
//                nodoAfiliado = nodoAfiliado.getSiguiente();
//            }
//        }
//        return padronDeudores;
//    }
//
//    /**
//     * Consulta que retorna los afiliados a una especialidad particular.
//     */
//    @Override
//    public ILista<IAfiliado> afiliadosPorEspecialidad(String especialidad) {
//        
//        // Crear lista de retorno.
//        ILista<IAfiliado> afiliadosPorEspecialidad = new Lista<>();
//        
//        // Si la lista de afiliados no es vacía.
//        if (!padronAfiliados.esVacia()) {
//            
//            // Tomo el primer afiliado.
//            INodo<IAfiliado> nodoAfiliado = padronAfiliados.getPrimero();
//            
//            // Recorro todos los afiliados.
//            while (nodoAfiliado != null) {
//                
//                // Consultas del afiliado.
//                ILista<IConsulta> consultasAgendadas = nodoAfiliado.getDato().getConsultasAnotadas();
//
//                // Tomo la primer consulta.
//                INodo<IConsulta> nodoConsulta = consultasAgendadas.getPrimero();
//
//                // Recorro todas sus consultas.
//                while (nodoConsulta != null) { 
//    
//                    // Obtengo la consulta y la comparo con el param recibido.
//                    IConsulta consulta = nodoConsulta.getDato();
//    
//                    if (consulta.getEspecialidad().equals(especialidad)) { 
//                        afiliadosPorEspecialidad.insertarNodoOrdenado(nodoAfiliado.clonar());
//                    }
//                    
//                    nodoConsulta = nodoConsulta.getSiguiente();
//                }
//                
//                nodoAfiliado = nodoAfiliado.getSiguiente();
//            }
//        }
//        
//        return afiliadosPorEspecialidad;
//    }
}
