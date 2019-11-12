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
public class TElementoAVL<T> extends TElementoAB<T> {

    private Integer balance;
    private int altura;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    public TElementoAVL(Comparable unaEtiqueta, T unosDatos) {
        super(unaEtiqueta, unosDatos);
        balance = 0;
    }

    public int getAltura() {
        return altura;
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
                if (balance < -1) {
                    return rotacionDerecha(this);
                }
                if (balance < -1) {
                    hijoDer = rotacionDerecha((TElementoAVL) this.hijoDer);
                    return rotacionIzquierda(this);
                }
            }

            if (hijoDer != null) {
                if (balance > 1) {
                    return rotacionIzquierda(this);
                }

                if (balance > 1) {
                    hijoIzq = rotacionIzquierda((TElementoAVL) this.hijoIzq);
                    return rotacionDerecha(this);
                }
            }
            return this;
        } else {
            return null;
        }
    }

    @Override
    public TElementoAVL eliminar(Comparable unaEtiqueta) {
        IElementoAB eliminado = super.eliminar(unaEtiqueta);
        if (hijoIzq != null && hijoDer != null) {
            balance = hijoDer.obtenerAltura() - hijoIzq.obtenerAltura();
        } else {
            if (hijoIzq != null) {
                balance = -hijoIzq.obtenerAltura();
            } else if (hijoDer != null) {
                balance = hijoDer.obtenerAltura();
            }
        }

        if (hijoIzq != null) {
            if (balance < -1) {
                return rotacionDerecha(this);
            }
            if (balance < -1) {
                hijoDer = rotacionDerecha((TElementoAVL) this.hijoDer);
                return rotacionIzquierda(this);
            }
        }

        if (hijoDer != null) {
            if (balance > 1) {
                return rotacionIzquierda(this);
            }

            if (balance > 1) {
                hijoIzq = rotacionIzquierda((TElementoAVL) this.hijoIzq);
                return rotacionDerecha(this);
            }
        }
        return (TElementoAVL) eliminado;

    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int nuevoBalance) {
        this.balance = nuevoBalance;
    }

    public T getDatos() {
        return datos;
    }

    public TElementoAVL getHijoIzq() {
        return (TElementoAVL) hijoIzq;
    }

    public TElementoAVL getHijoDer() {
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

    /**
     * Actualiza el valor de la altura del elemento
     */
    public void actualizarAltura() {
        int lh = -1;
        /* altura rama izquierda */
        int rh = -1;
        /* altura rama derecha */
        if (hijoIzq != null) {
            lh = hijoIzq.obtenerAltura();
        }
        if (hijoDer != null) {
            rh = hijoDer.obtenerAltura();
        }
        altura = 1 + Math.max(lh, rh);
    }

    /**
     * Realiza esta rotacion cuando el desbalance proviene del hijo izquierdo
     * del hijo izquierdo (Rotacion doble izquierda).
     *
     * @param nodo El nodo en el que se da el desbalance
     * @return El nodo con las rotaciones aux.
     */
    private TElementoAVL<T> rotacionLL(TElementoAVL nodo) {
        TElementoAVL<T> aux = nodo.getHijoIzq();
        nodo.setHijoIzq(aux.getHijoDer());
        aux.setHijoDer(nodo);
        nodo.actualizarAltura();
        aux.actualizarAltura();
        return aux;
    }

    /**
     * Realiza esta rotacion cuando el desbalance proviene del hijo derecho del
     * hijo derecho.
     *
     * @param nodo El nodo en el que se da el desbalance
     * @return El nodo con las rotaciones hechas, aux.
     */
    private TElementoAVL<T> rotacionRR(TElementoAVL nodo) {
        TElementoAVL<T> aux = nodo.getHijoDer();
        nodo.setHijoDer(aux.getHijoIzq());
        aux.setHijoIzq(nodo);
        nodo.actualizarAltura();
        aux.actualizarAltura();
        return aux;
    }

    /**
     * Realiza la rotacion cuando el desbalance proviene del hijo derecho del
     * hijo izquierdo.
     *
     * @param nodo El nodo en el que se da el desbalance
     * @return El nodo con las rotaciones hechas.
     */
    private TElementoAVL<T> rotacionLR(TElementoAVL nodo) {
        nodo.setHijoIzq(rotacionRR(nodo.getHijoIzq()));
        return rotacionLL(nodo);
    }

    /**
     * Realiza la rotacion cuando el desbalance viene del hijo izquierdo del
     * hijo derecho.
     *
     * @param nodo El nodo en el que se da el desbalance
     * @return El nodo con las rotaciones hechas.
     */
    private TElementoAVL<T> rotacionRL(TElementoAVL nodo) {
        nodo.setHijoDer(rotacionLL(nodo.getHijoDer()));
        return rotacionRR(nodo);
    }

    /**
     * Checkea si el nodo esta balanceado o no.
     *
     * @return true si esta balanceado, false si no.
     */
    private boolean isBalanceado() {
        int altHI = -1;
        if (hijoIzq != null) {
            altHI = hijoIzq.obtenerAltura();
        }
        int altHD = -1;
        if (hijoDer != null) {
            altHD = hijoDer.obtenerAltura();
        }
        return Math.abs(altHD - altHI) <= 1;
    }

    /**
     * Busca si un nodo dentro del elemento esta desbalanceado y, en caso de
     * estarlo, se realiza las operaciones necesarias para rebalancear los
     * subarboles del elemento (ramas).
     *
     * @return El subarbol balanceado.
     */
    public TElementoAVL<T> balancear() {
        if (!isBalanceado()) {
            int hLL = -2;
            int hLR = -2;
            int hRL = -2;
            int hRR = -2;
            if (hijoIzq != null) {
                if (hijoIzq.getHijoIzq() != null) {
                    hLL = hijoIzq.getHijoIzq().obtenerAltura();
                } else {
                    hLL = -1;
                }
                if (hijoIzq.getHijoDer() != null) {
                    hLR = hijoIzq.getHijoDer().obtenerAltura();
                } else {
                    hLR = -1;
                }
            }
            if (hijoDer != null) {
                if (hijoDer.getHijoIzq() != null) {
                    hRL = hijoDer.getHijoIzq().obtenerAltura();
                } else {
                    hRL = -1;
                }
                if (hijoDer.getHijoDer() != null) {
                    hRR = hijoDer.getHijoDer().obtenerAltura();
                } else {
                    hRR = -1;
                }
            }
            if ((hLL > hLR) && (hLL > hRL) && (hLL > hRR)) {
                return rotacionLL(this);
            } else if ((hLR > hRL) && (hLR > hRR)) {
                return rotacionLR(this);
            } else if (hRL > hRR) {
                return rotacionRL(this);
            } else {
                return rotacionRR(this);
            }
        }
        return this;
    }

}
