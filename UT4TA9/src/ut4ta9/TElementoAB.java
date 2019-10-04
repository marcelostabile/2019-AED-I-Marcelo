package ut4ta9;

public class TElementoAB<T> implements IElementoAB<T> {

    protected Comparable etiqueta;
    protected IElementoAB hijoIzq;
    protected IElementoAB hijoDer;
    protected T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public IElementoAB getHijoIzq() {
        return hijoIzq;
    }

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

    @Override
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        Nodo<T> unNodo = new Nodo<>(this.getEtiqueta(), this.getDatos());
        unaLista.insertar(unNodo);

        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }
    }

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

    @Override
    public String preOrden() {
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(imprimir());
        if (hijoIzq != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoIzq().preOrden());
        }
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().preOrden());
        }
        return tempStr.toString();
    }

    @Override
    public String postOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        if (hijoDer != null) {
            tempStr.append(getHijoDer().postOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        return tempStr.toString();
    }

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

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(IElementoAB elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(IElementoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public IElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private IElementoAB quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }

        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
        // tiene los dos hijos, buscamos el lexicograficamente anterior
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
        setHijoIzq(null);  // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        return elHijo;
    }

    @Override
    public boolean esCompleto() {
        if ((hijoIzq != null && hijoDer == null) || (hijoIzq == null && hijoDer != null)) {
            return false;
        }
        if (hijoIzq != null) {
            return hijoIzq.esCompleto();

        }
        if (hijoDer != null) {
            return hijoDer.esCompleto();
        }
        return true;
    }

    @Override
    public int obtenerCantidadHojas() {
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        } else if (hijoIzq == null && hijoDer != null) {
            return hijoDer.obtenerCantidadHojas();
        } else if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.obtenerCantidadHojas();
        } else {
            return hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();
        }
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (this.etiqueta.compareTo(unaEtiqueta) == 0) {
            return 0;
        } else if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
            } else {
                return 0;
            }
        } else if (hijoDer != null) {
            return 1 + hijoDer.obtenerNivel(unaEtiqueta);
        } else {
            return 0;
        }

    }

    @Override
    public int obtenerAltura() {
        int T1 = -1;
        int T2 = -1;
        if (this.hijoIzq != null) {
            T1 = this.hijoIzq.obtenerAltura();
        }
        if (this.hijoDer != null) {
            T2 = this.hijoDer.obtenerAltura();
        }
        if (T1 > T2) {
            return T1 + 1;
        } else {
            return T2 + 1;
        }
    }

    @Override
    public int obtenerTamaño() {
        int T1 = 0;
        int T2 = 0;
        if (hijoIzq != null) {
            T1 += hijoIzq.obtenerTamaño();
        }
        if (hijoDer != null) {
            T2 += hijoDer.obtenerTamaño();
        }
        return T1 + T2 + 1;
    }

    /**
     * Retorna cantidades de nodos internos no completos
     *
     * @return cantidad de nodos internos no completos
     */
    @Override
    public int internosNoCompletos() {
        int noCompletos = 0;

        // Si es hoja, retorno 0
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 0;
        }

        // Si tiene izquierdo...
        if (this.hijoIzq != null) {
            if (this.hijoDer == null) // ... pero a la vez es interno no completo
            {
                noCompletos += 1 + this.hijoIzq.internosNoCompletos();
            } else // ... pero tiene ambos hijos
            {
                noCompletos += 0 + this.hijoIzq.internosNoCompletos();
            }
        }

        // Si tiene izquierdo...
        if (this.hijoDer != null) {
            if (this.hijoIzq == null) // ... pero a la vez es interno no completo
            {
                noCompletos += 1 + this.hijoDer.internosNoCompletos();
            } else // ... pero tiene ambos hijos
            {
                noCompletos += 0 + this.hijoDer.internosNoCompletos();
            }
        }

        // Retorno total.
        return noCompletos;
    }

    /**
     * Retorna cantidades de nodos internos completos
     *
     * @return cantidad de nodos internos completos
     */
    @Override
    public int internosCompletos() {
        int completos = 0;

        // Si es hoja, retorno 0
        if (this.hijoIzq == null && this.hijoDer == null) {
            return 0;
        }

        // Si tiene izquierdo...
        if (this.hijoIzq != null) {
            completos += this.hijoIzq.internosCompletos();
        }

        // Si tiene derecho...
        if (this.hijoDer != null) {
            completos += this.hijoDer.internosCompletos();
        }

        // Evalúo actual en postorden para volver
        if (this.hijoIzq != null && this.hijoDer != null) {
            completos += 1;
        }

        // Retorno total
        return completos;
    }

    @Override
    public String obtenerHojasConNivel(int cont) {
        if (hijoIzq == null && hijoDer == null) {
            return "(Hoja: " + this.etiqueta + ", Nivel: " + cont + ") ";
        } else if (hijoIzq == null && hijoDer != null) {
            return hijoDer.obtenerHojasConNivel(cont + 1);
        } else if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.obtenerHojasConNivel(cont + 1);
        } else {
            return hijoDer.obtenerHojasConNivel(cont + 1) + hijoIzq.obtenerHojasConNivel(cont + 1);
        }
    }

    @Override
    public boolean esABB() {
        if (hijoIzq == null && hijoDer == null) {
            return true;
        } else if (hijoIzq == null && hijoDer != null) {
            return (this.getEtiqueta().compareTo(hijoDer.getEtiqueta()) < 0) == hijoDer.esABB();
        } else if (hijoIzq != null && hijoDer == null) {
            return (this.getEtiqueta().compareTo(hijoIzq.getEtiqueta()) > 0) == hijoIzq.esABB();
        } else {
            return ((this.getEtiqueta().compareTo(hijoDer.getEtiqueta()) < 0) == hijoDer.esABB()) == ((this.getEtiqueta().compareTo(hijoIzq.getEtiqueta()) > 0) == hijoIzq.esABB());
        }
    }

    /**
     * Retorna mayor elemento del sub-árbol
     *
     * @return elemento mayor
     */
    @Override
    public TElementoAB<T> obtenerMayorElemento() {
        // Si es el último a la derecha, es el mayor
        if (this.getHijoDer() == null) {
            return this;
        }

        // Sigo buscando en los elementos a la derecha
        return this.getHijoDer().obtenerMayorElemento();
    }

    /**
     * Retorna menor elemento del sub-árbol
     *
     * @return elemento menor
     */
    @Override
    public TElementoAB<T> obtenerMenorElemento() {
        // Si es el último a la izquierda, es el menor
        if (this.getHijoIzq() == null) {
            return this;
        }

        // Sigo buscando en los elementos a la izquierda
        return this.getHijoIzq().obtenerMenorElemento();
    }

    /**
     * Retorna clave inmediata posterior
     *
     * @param etiqueta clave del elemento
     * @return clave del elemento
     */
    @Override
    public Comparable obtenerClaveInmediataPosterior(Comparable etiqueta) {
        return obtenerClaveInmediataPosterior(etiqueta, null);
    }

    /**
     * Retorna clave inmediata anterior
     *
     * @param etiqueta clave del elemento
     * @return clave del elemento
     */
    @Override
    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta) {
        return obtenerClaveInmediataAnterior(etiqueta, null);
    }

    /**
     * Retorna clave inmediata posterior
     *
     * @param etiqueta clave del elemento
     * @param sucesor auxiliar para guardar sucesor
     * @return clave del elemento
     */
    @Override
    public Comparable obtenerClaveInmediataPosterior(Comparable etiqueta, Comparable sucesor) {

        // Si el actual es el buscado
        if (this.etiqueta.equals(etiqueta)) {
            if (this.hijoDer != null) {
                return this.hijoDer.obtenerMenorElemento().getEtiqueta();
            }
        } // Si la clave buscada es menor, busco en árbol izquierdo y actualizo sucesor
        else if (etiqueta.compareTo(this.etiqueta) < 0) {
            sucesor = this.etiqueta;
            if (this.hijoIzq != null) {
                return this.hijoIzq.obtenerClaveInmediataPosterior(etiqueta, sucesor);
            }
        } // Si la clave buscada es mayor, busco en árbol derecho
        else {
            if (this.hijoDer != null) {
                return this.hijoDer.obtenerClaveInmediataPosterior(etiqueta, sucesor);
            }
        }
        // Retorno sucesor
        return sucesor;
    }

    /**
     * Retorna clave inmediata anterior
     *
     * @param etiqueta clave del elemento
     * @param predecesor auxiliar para guardar predecesor
     * @return clave del elemento
     */
    @Override
    public Comparable obtenerClaveInmediataAnterior(Comparable etiqueta, Comparable predecesor) {

        // Si el actual es el buscado
        if (this.etiqueta.equals(etiqueta)) {
            if (this.hijoIzq != null) {
                return this.hijoIzq.obtenerMayorElemento().getEtiqueta();
            }
        } // Si la clave buscada es menor, busco en árbol izquierdo
        else if (etiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                return this.hijoIzq.obtenerClaveInmediataAnterior(etiqueta, predecesor);
            }
        } // Si la clave buscada es mayor, busco en árbol derecho y actualizo predecesor
        else {
            predecesor = this.etiqueta;
            if (this.hijoDer != null) {
                return this.hijoDer.obtenerClaveInmediataAnterior(etiqueta, predecesor);
            }
        }
        // Retorno predecesor
        return predecesor;
    }

    /**
     * Retorna padre del elemento con la clave buscada
     *
     * @param clave
     * @return elemento padre
     */
    @Override
    public TElementoAB<T> obtenerPadre(Comparable clave) {

        // Busco por izquierda o derecha
        if (clave.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                if (this.hijoIzq.getEtiqueta().equals(clave)) {
                    return this;
                } else {
                    return this.hijoIzq.obtenerPadre(clave);
                }
            }
        } else {
            if (this.hijoDer != null) {
                if (this.hijoDer.getEtiqueta().equals(clave)) {
                    return this;
                } else {
                    return this.hijoDer.obtenerPadre(clave);
                }
            }
        }

        // No encontré
        return null;
    }
}
