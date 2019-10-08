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
public class TElementoAVL<T> extends TElementoAB<T> implements IElementoAB <T>{
    
    
    private Integer balance;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    public TElementoAVL(Comparable unaEtiqueta, T unosDatos) {
        super(unaEtiqueta,unosDatos);        
        balance = 0;
    }
    
    
    public TElementoAVL<T> insertar(TElementoAVL<T> unElemento) {
        if (unElemento.getEtiqueta() != null) {
            if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {
                    hijoIzq = getHijoIzq().insertar(unElemento);
                } else {
                    hijoIzq = unElemento;
                }
            } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
                if (hijoDer != null) {
                    hijoDer = getHijoDer().insertar(unElemento);
                } else {
                    hijoDer = unElemento;
                }
            } else {
                return unElemento;
            }
            //Revisamos balance
            if (hijoIzq != null && hijoDer != null) {
                balance = hijoDer.obtenerAltura() - hijoIzq.obtenerAltura();
            } else {
                if (hijoIzq != null) {
                    balance = -hijoIzq.obtenerAltura();
                } else {
                    balance = hijoDer.obtenerAltura();
                }
            }
            
            if (hijoIzq != null) {
                if (balance < -1 ) {
                    return rotacionDerecha(this);
                }
                if (balance < -1 ) {
                    hijoDer = rotacionDerecha((TElementoAVL)this.hijoDer);
                    return rotacionIzquierda(this);
                }
            }

            if (hijoDer != null) {
                if (balance > 1 ) {
                    return rotacionIzquierda(this);
                }

                if (balance > 1 ) {
                    hijoIzq = rotacionIzquierda((TElementoAVL)this.hijoIzq);
                    return rotacionDerecha(this);
                }
            }
            return this;
        } else {
            return null;
        }
    }
    @Override
    public TElementoAVL eliminar(Comparable unaEtiqueta){
        IElementoAB eliminado = super.eliminar(unaEtiqueta);
        if (hijoIzq != null && hijoDer != null) {
                balance = hijoDer.obtenerAltura() - hijoIzq.obtenerAltura();
            } else {
                if (hijoIzq != null) {
                    balance = -hijoIzq.obtenerAltura();
                } else if (hijoDer!= null){
                    balance = hijoDer.obtenerAltura();
                }
            }
            
            if (hijoIzq != null) {
                if (balance < -1 ) {
                    return rotacionDerecha(this);
                }
                if (balance < -1 ) {
                    hijoDer = rotacionDerecha((TElementoAVL)this.hijoDer);
                    return rotacionIzquierda(this);
                }
            }

            if (hijoDer != null) {
                if (balance > 1 ) {
                    return rotacionIzquierda(this);
                }

                if (balance > 1 ) {
                    hijoIzq = rotacionIzquierda((TElementoAVL)this.hijoIzq);
                    return rotacionDerecha(this);
                }
            }
            return (TElementoAVL)eliminado;
        
    }
    public int getBalance(){
        return this.balance;
    }
    public void setBalance(int nuevoBalance){
        this.balance = nuevoBalance;
    }
    public T getDatos() {
        return datos;
    }
    
    public TElementoAVL getHijoIzq(){
        return (TElementoAVL) hijoIzq;
    }
 
    public TElementoAVL getHijoDer(){
        return (TElementoAVL) hijoDer;
    }
    
    public void setHijoIzq(TElementoAVL elemento) {
        this.hijoIzq = elemento;

    }    
    
    public void setHijoDer(TElementoAVL elemento) {
        this.hijoDer = elemento;
    }
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    TElementoAVL<T> rotacionIzquierda(TElementoAVL<T> unNodo) {
        TElementoAVL<T> k1 = unNodo;
        TElementoAVL<T> k2 = k1.getHijoDer();

        k1.setHijoDer(k2.getHijoIzq());
        k2.setHijoIzq(k1);

        return k2;
    }

    TElementoAVL<T> rotacionDerecha(TElementoAVL<T> unNodo) {
        TElementoAVL<T> k1 = unNodo;
        TElementoAVL<T> k2 = k1.getHijoIzq();

        k1.setHijoIzq(k2.getHijoDer());
        k2.setHijoDer(k1);

        return k2;
    }    
       
    

   @Override
    public int obtenerAltura() {
        int A = 0;
        int B = 0;
        if (hijoIzq != null) {
            A = hijoIzq.obtenerAltura();
        }
        if (hijoDer != null) {
            B = hijoDer.obtenerAltura();
        }
        return 1 + maximo(A, B);
    }    
    
    
       	

    private int maximo(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }
    
}
