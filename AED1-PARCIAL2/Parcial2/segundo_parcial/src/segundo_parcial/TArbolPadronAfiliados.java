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
        
        // Creo una lista de los afiliados. La recorro para obtener las consultas de cada uno.
        //TArbolPadronAfiliados elPadron = new TArbolPadronAfiliados();
        
        Lista<Afiliado> listaAfiliados = this.inorden();
        
        if (listaAfiliados != null) { 
            
            // Nodo del afiliado.
            Nodo<Afiliado> nodoAfiliado = listaAfiliados.getPrimero();
            
            while (nodoAfiliado != null) {
                
                // Obtengo el afiliado.
                Afiliado afiliadoAux = nodoAfiliado.getDato();
                
                if ( !afiliadoAux.pendientes.esVacia()) {
                
                    // Obtengo sus consultas pendientes.
                    Nodo<Consulta> nodoConsulta = afiliadoAux.pendientes.getPrimero();
                    
                    while (nodoConsulta != null) {
                    
                        // Obtengo la consulta.
                        Consulta consultaAux = nodoConsulta.getDato();

                        // Si la consulta tiene el mismo día. Creo el elemento Afiliado y lo inserto en el árbol.
                        String fechaConsulta = consultaAux.getFecha();

                        if (fechaConsulta.equals(fecha)) {

                            TElementoAB<Afiliado> unElemento = new TElementoAB(afiliadoAux.getCedula(), afiliadoAux);
                            arbolResultado.insertar(unElemento);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
} 
    

