package segundo_parcial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bernardo Rychtenberg
 */
public class TArbolPadronAfiliados extends TArbolBB<Afiliado> implements IArbolPadronAfiliados {

    @Override
    public TArbolPadronAfiliados cargarDesdeLista(Lista<Afiliado> listaAfiliados) {
        
        // Acá se debe implementar el método 1 del parcial. 
        TArbolPadronAfiliados arbolResultado = new TArbolPadronAfiliados();
        
        // Consigo el nodo del afiliado a partir de la lista.
        Nodo<Afiliado> afiliadoNuevo = listaAfiliados.getPrimero();
        
        while (afiliadoNuevo != null) {

            // Consigo afiliado a partir del nodo.
            Afiliado afiliadoAux = afiliadoNuevo.getDato();

            // Crear TElementoAB a partir del afiliado.
            TElementoAB<Afiliado> elementoNuevo = new TElementoAB(afiliadoAux.getCedula(), afiliadoAux);

            // Insertar el elemento afiliado en el árbol resultado.
            arbolResultado.insertar(elementoNuevo);
            
            // Siguiente afiliado.
            afiliadoNuevo = afiliadoNuevo.getSiguiente();
        }
        // Devolver resultado.
        return arbolResultado;
    }
    
    @Override
    public TArbolBB<Afiliado> obtenerConsultasDelDia(String fecha) { 
        
        // Árbol de resultado.
        TArbolBB<Afiliado> arbolResultado = new TArbolBB<>();
        
        // Lista de afiliados a partir del árbol actual.
        Lista<Afiliado> listaAfiliados = this.inorden();
                
        // Si la lista no está vacía, comienzo a recorrer la lista de afiliados.
        if (!listaAfiliados.esVacia()) { 
            
            // Nodo del afiliado.
            Nodo<Afiliado> nodoAfiliado = listaAfiliados.getPrimero();
            
            while (nodoAfiliado != null) { 
                
                // Obtengo el afiliado.
                Afiliado afiliadoAux = nodoAfiliado.getDato();
                
                // Verifico que el afiliado tiene consultas agendadas.
                if ( !afiliadoAux.pendientes.esVacia()) {
                
                    // Obtengo sus consultas pendientes.
                    Nodo<Consulta> nodoConsulta = afiliadoAux.pendientes.getPrimero();
                    
                    while (nodoConsulta != null) {
                    
                        // Obtengo la consulta.
                        Consulta consultaAux = nodoConsulta.getDato();

                        // Si la consulta tiene el mismo día. Creo el elemento Afiliado y lo inserto en el árbol.
                        //String fechaConsulta = consultaAux.getFecha();

                        if (consultaAux.getFecha().equals(fecha)) {

                            TElementoAB<Afiliado> afiAux = new TElementoAB(afiliadoAux.getCedula(), afiliadoAux);
                            
                            arbolResultado.insertar(afiAux);
                        }
                        // siguiente.
                        nodoConsulta = nodoConsulta.getSiguiente();
                    }
                }
                // Siguiente afiliado.
                nodoAfiliado = nodoAfiliado.getSiguiente();
            }
        }
        return arbolResultado;
    }
    
    @Override
    public Integer cantidadConsultasdelDia(){
        // Acá se debe implementar el método 3 del parcial. 

        // Fecha de hoy. 
        String fechaActual = "20191008";   // Fecha harcodeada!!!
        
        // Obtengo los afiliados con consultas de hoy y los transformo en lista para usar el método cantElementos().
        TArbolBB<Afiliado> consultasDelDia = this.obtenerConsultasDelDia(fechaActual);
        
        Lista<Afiliado> listaAfiliadosConConsulta = consultasDelDia.inorden();
        
        return listaAfiliadosConConsulta.cantElementos();
    }
} 
    

