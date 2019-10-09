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
        
        Nodo afiliadoNuevo = listaAfiliados.getPrimero();
        
        while (afiliadoNuevo != null) {
            
            TElementoAB<Afiliado> afiNuevo = new TElementoAB(afiliadoNuevo.getEtiqueta(), afiliadoNuevo);
            
            arbolResultado.insertar(afiNuevo);
        }
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
    

