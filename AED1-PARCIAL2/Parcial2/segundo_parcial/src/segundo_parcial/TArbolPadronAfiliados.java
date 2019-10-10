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
    public TArbolBB<Afiliado> cargarDesdeLista(Lista<Afiliado> listaAfiliados) {
        
        // Acá se debe implementar el método 1 del parcial. 
        TArbolBB<Afiliado> arbolResultado = new TArbolBB<>();
        
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
        
        TArbolBB<Afiliado> arbolResultado = new TArbolBB<>();
        
        TArbolPadronAfiliados padronAfiliados = new TArbolPadronAfiliados();
        
        TElementoAB<Afiliado> afiliado = padronAfiliados.getRaiz();
        

        
        
        
        return arbolResultado;
    }
    
    @Override
    public Integer cantidadConsultasdelDia(){
        // Acá se debe implementar el método 3 del parcial. 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
} 
    

