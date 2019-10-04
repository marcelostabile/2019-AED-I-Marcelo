/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

import tdaarbolbb.*;

/**
 *
 * @author Diego
 */
public class TArbolAfiliados<IAfiliado> extends TArbolBB {

    public void inOrden(Lista<IAfiliado> unaLista) {
        if (!esVacio()) {
            raiz.inOrden(unaLista);
        }
    }

}
