/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdaarbolbb;

import java.util.LinkedList;

/**
 *
 * @author Agustín
 */
public class TArbolAVL<T> extends TArbolBB<T>{
   
    
    
    
    public TArbolAVL() {
        TElementoAVL<T> raiz = null;
    }
    
    public TElementoAVL<T> getRaiz(){
        return (TElementoAVL) raiz;
    } 
         
    /**
     * @param unElemento
     * @return True si logra insertarlo y false en caso contrario.
     */
    @Override
    public boolean insertar (IElementoAB<T> unElemento){
        TElementoAVL<T> nuevoElemento = new TElementoAVL<T>(unElemento.getEtiqueta(),unElemento.getDatos());
        if (insertar(nuevoElemento)!= null){
            return true;
        }
        return false;
    }
    public TElementoAVL<T> insertar(TElementoAVL<T> unElemento) {
        if (esVacio()) {
            raiz = unElemento;
            return (TElementoAVL)raiz;
        } else {
            this.raiz =  getRaiz().insertar(unElemento);
            return (TElementoAVL)raiz;
        }
    }  
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (!esVacio()) {
            this.raiz = getRaiz().eliminar(unaEtiqueta);
        }
    }
    
    
    
    
    
    
    

    
    
    
}
