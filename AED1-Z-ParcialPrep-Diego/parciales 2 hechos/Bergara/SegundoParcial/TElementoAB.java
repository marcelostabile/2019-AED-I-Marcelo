package SegundoParcial;

import java.util.LinkedList;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private IElementoAB hijoIzq;
    private IElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    @Override
    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public IElementoAB getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(IElementoAB unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public IElementoAB buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    /**
     *
     * @param unaLista
     */
    @Override
    public void inOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);
        }
        unaLista.add(this.getEtiqueta());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(etiqueta.toString());

        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(hijoIzq.preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(hijoDer.preOrden());
        }

        return tempStr.toString();
    }

    /**
     *
     * @return
     */
    @Override
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(hijoIzq.postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(hijoDer.postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }

        tempStr.append(etiqueta);
        return tempStr.toString();
    }

    /**
     *
     * @return
     */
    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    /**
     *
     * @return
     */
    @Override
    public T getDatos() {
        return datos;
    }

    /**
     *
     * @param elemento
     */
    @Override
    public void setHijoIzq(IElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    /**
     *
     * @param elemento
     */
    @Override
    public void setHijoDer(IElementoAB elemento) {
        this.hijoDer = elemento;
    }

    /**
     *
     * @param unaEtiqueta
     * @return
     */
    @Override
    public IElementoAB<T> eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }
        if (unaEtiqueta.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return this.quitaElNodo();
    }

    /**
     *
     * @return
     */
    @Override
    public IElementoAB quitaElNodo() {
        if (hijoIzq == null && hijoDer == null) {
            return null;
        } else if (hijoIzq == null) {
            return hijoDer;
        } else if (hijoDer == null) {
            return hijoIzq;
        } else {
            IElementoAB elHijo = hijoIzq;
            IElementoAB elPadre = this;
            while (elHijo.getHijoDer() != null) {
                elPadre = elHijo;
                elHijo = elHijo.getHijoDer();
            }
            if (elPadre != this) {
                elPadre.setHijoDer(elHijo.getHijoIzq());
                elHijo.setHijoIzq(hijoIzq);
            }
            elHijo.setHijoDer(hijoDer);
            return elHijo;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int obtenerAltura() {
        if (hijoIzq == null && hijoDer == null) {
            return 0;
        } else if (hijoIzq == null && hijoDer != null) {
            return 1 + hijoDer.obtenerAltura();
        } else if (hijoDer == null && hijoIzq != null) {
            return 1 + hijoIzq.obtenerAltura();
        } else {
            return 1 + Math.max(hijoIzq.obtenerAltura(), hijoDer.obtenerAltura());
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int obtenerTamanio() {
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        } else if (hijoIzq == null && hijoDer != null) {
            return 1 + hijoDer.obtenerTamanio();
        } else if (hijoDer == null && hijoIzq != null) {
            return 1 + hijoIzq.obtenerTamanio();
        } else {
            return 1 + hijoIzq.obtenerTamanio() + hijoDer.obtenerTamanio();
        }
    }

    /**
     *
     * @param unaEtiqueta
     * @return
     */
    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(etiqueta) == 0) {
            return 0;
        } else {
            if (unaEtiqueta.compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {
                    return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
                } else {
                    return -1;
                }
            } else {
                if (unaEtiqueta.compareTo(etiqueta) > 0) {
                    if (hijoDer != null) {
                        return 1 + hijoDer.obtenerNivel(unaEtiqueta);

                    } else {
                        return -1;
                    }

                } else {
                    return -1;
                }
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int obtenerCantidadHojas() {
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        } else if (hijoIzq == null && hijoDer != null) {
            return 0 + hijoDer.obtenerCantidadHojas();
        } else if (hijoDer == null && hijoIzq != null) {
            return 0 + hijoIzq.obtenerCantidadHojas();
        } else {
            return hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();
        }
    }

    @Override
    public Comparable obtenerMenorClave() {
        if (hijoIzq == null) {
            return (int) this.etiqueta;
        } else {
            return hijoIzq.obtenerMenorClave();
        }

    }

    @Override
    public Comparable obtenerMayorClave() {
        if (hijoDer == null) {
            return this.etiqueta;
        } else {
            return hijoDer.obtenerMayorClave();
        }
    }

    @Override
    public Comparable claveAnterior(Comparable clave) {
        if (hijoIzq == null && hijoDer == null) {
            return -1;
        } else {
            if (clave.compareTo(etiqueta) < 0) {
                if (hijoIzq != null && hijoIzq.getEtiqueta() == clave) {
                    return this.etiqueta;
                } else {
                    return hijoIzq.claveAnterior(clave);
                }
            } else {
                if (clave.compareTo(etiqueta) > 0) {
                    if (hijoDer != null && hijoDer.getEtiqueta() == clave) {
                        return this.etiqueta;
                    } else {
                        return hijoDer.claveAnterior(clave);
                    }
                } else {
                    return -1;
                }
            }

        }

    }

    @Override
    public int cantNodosNivel(int nivel) {
        int izq = 0;
        int der = 0;
        if (nivel == 0) {
            return 1;
        } else {
            if (hijoIzq != null) {
                izq = izq + hijoIzq.cantNodosNivel(nivel - 1);
            }
            if (hijoDer != null) {
                der = der + hijoDer.cantNodosNivel(nivel - 1);
            }
            return izq + der;
        }

    }

    /**
     * listamos las hojas y sus niveles
     *
     * @param cont
     */
    @Override
    public void listarHojas(Integer cont) {
        cont++;
        if (hijoIzq == null && hijoDer == null) {
            System.out.print(this.getEtiqueta().toString());
            System.out.println(" - en Nivel: " + cont);
        } else {
            if (hijoIzq != null) {
                hijoIzq.listarHojas(cont);
            }
            if (hijoDer != null) {
                hijoDer.listarHojas(cont);
            }
        }
    }

    @Override
    public boolean esArbolBusqueda() {
        boolean izq = true;
        boolean der = true;
        if (hijoIzq == null && hijoDer == null) {
            return true;
        } else {
            if (hijoIzq != null) {
                if ((this.getEtiqueta().compareTo(hijoIzq.getEtiqueta())) > 0) {
                    return izq && hijoIzq.esArbolBusqueda();
                } else {
                    return false;
                }
            }
            if (hijoDer != null) {
                if ((this.getEtiqueta().compareTo(hijoDer.getEtiqueta())) < 0) {
                    return der && hijoDer.esArbolBusqueda();
                } else {
                    return false;
                }
            }
            return izq && der;

        }

    }
}
