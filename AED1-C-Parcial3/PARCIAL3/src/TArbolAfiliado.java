/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aruib_000
 */
public class TArbolAfiliado extends TArbolBB<Afiliado> implements IArbolAfiliados {
    
    /**
     *
     */
      
    
    @Override
    public TArbolBB<Especialidad> obtenerArbolEspecialidades(){ 
        
        // Creo el árbol especialidades.
        TArbolBB<Especialidad> arbolEsp = new TArbolBB<>();
        
        // Crear lista de afiliados.
        Nodo<Afiliado> afiliado = this.inorden().getPrimero();
        
        // Recorrer los afiliados.
        while (afiliado != null) {
            
            // obtener consultas histo. del afiliado.
            Nodo<Consulta> clta = afiliado.getDato().getConsultasHistoricas().getPrimero();
            
            // Recorrer las consultas del afiliado.
            while (clta != null) {
            
                // Si la especialidad no existe en el árbol, creo una nueva.
                if (arbolEsp.buscar(clta.getDato().getEspecialidad()) == null) {

                    Especialidad espNueva = new Especialidad(clta.getDato().getEspecialidad());
                    TElementoAB<Especialidad> espNuevaArbol = new TElementoAB(clta.getDato().getEspecialidad(), espNueva);
                    arbolEsp.insertar(espNuevaArbol);
                }
                
                // Agrego la consulta a la especialidad, en el árbol.
                arbolEsp.buscar(clta.getDato().getEspecialidad()).getDatos().agregaConsulta(clta.getDato());
                
                clta = clta.getSiguiente();
            }
            afiliado = afiliado.getSiguiente();
        }
        // Retornar el árbol.
        return arbolEsp;
    }
} 
    

