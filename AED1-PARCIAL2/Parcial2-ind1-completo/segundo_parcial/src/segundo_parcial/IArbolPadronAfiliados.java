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
public interface IArbolPadronAfiliados {

    
    public TArbolPadronAfiliados cargarDesdeLista(Lista<Afiliado> listaAfiliados);
    public TArbolBB<Afiliado> obtenerConsultasDelDia(String fecha);
    public Integer cantidadConsultasdelDia();
    
}
