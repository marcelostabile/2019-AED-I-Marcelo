/*
 * CLASE TElementoAB.
 */
package ut4ta9;


/**
 * @author EQUIPO.
 */
class TElementoAB<T> implements IElementoAB<T> {

    // Atributos.
    protected Comparable etiqueta;
    protected TElementoAB hijoIzq;
    protected TElementoAB hijoDer;
    protected T datos;

    // Constructor.
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    // Etiqueta.
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    // Hijo Izquierdo.
    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;
    }

    // Hijo Derecho.
    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    // Datos.
    @Override
    public T getDatos() {
        return this.datos;
    }

    /**
     * INSERTAR UN ELEMENTO.
     *
     * @param unElemento
     * @return boolean.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {

        /**
         * Si el valor es menor que la etiqueta.
         *    Si el hijoIzq está vacío, lo inserta allí, retorna true.
         */
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } 
        /**
         * Si el valor es mayor que la etiqueta.
         *    Si el hijoIzq está vacío, lo inserta allí, retorna true.
         */
        else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } 
        // Si ya existe el elemento con la misma etiqueta, devuelve false.
        else {
            return false;
        }
    }



    
    
    /**
     * BUSCAR UN ELEMENTO en los hijos y sus subárboles.
     *
     * @return El elemento encontrado. Sino retorna null.
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        // Este es el elemento buscado, retorno este.
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else {
            // Busqueda en el árbol izquierdo.
            if (unaEtiqueta.compareTo(etiqueta) < 0) {
                if (hijoIzq != null) {
                    return getHijoIzq().buscar(unaEtiqueta);
                } else {
                    return null;
                }
            }
            // Busqueda en el árbol izquierdo.
            if (unaEtiqueta.compareTo(etiqueta) > 0) {
                if (hijoDer != null) {
                    return getHijoDer().buscar(unaEtiqueta);
                } else {
                    return null;
                }
            }
        }
        // No lo encontró, retorna null.
        return null;
    }

    /**
     * RECORRIDO PREORDEN. Imprime en preorden el árbol separado por guiones.
     *
     * @return un string con el resultado.
     */
    @Override
    public String preOrden() {

        // String auxiliar.
        StringBuilder strAux = new StringBuilder();

        // Agregamos raiz.
        strAux.append(etiqueta.toString());

        // Si existe, agregamos hijoIzq.
        if (hijoIzq != null) {
            strAux.append("-");
            strAux.append(getHijoIzq().preOrden());
        }

        // Si existe, agregamos hijoDer.
        if (hijoDer != null) {
            strAux.append("-");
            strAux.append(getHijoDer().preOrden());
        }

        // Retornamos el string.
        return strAux.toString();
    }

    /**
     * RECORRIDO INORDEN. Imprime en inorden el árbol separado por guiones.
     *
     * @return un string con el resultado.
     */
    @Override
    public String inOrden() {

        // String auxiliar.
        StringBuilder strAux = new StringBuilder();

        // Si existe, agregamos hijoIzq.
        if (hijoIzq != null) {
            strAux.append(getHijoIzq().inOrden());
        }

        // Agregamos raiz.
        strAux.append(etiqueta.toString());
        strAux.append("-");

        // Si existe, agregamos hijoDer.
        if (hijoDer != null) {
            strAux.append(getHijoDer().inOrden());
        }

        // Retornamos el string.
        return strAux.toString();
    }

    //@Override
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
    
    /**
     * RECORRIDO POSTORDEN. Imprime en postorden el árbol separado por guiones.
     *
     * @return un string con el resultado.
     */
    @Override
    public String postOrden() {

        // String auxiliar.
        StringBuilder strAux = new StringBuilder();

        // Si existe, agregamos hijoIzq.
        if (hijoIzq != null) {
            strAux.append(getHijoIzq().postOrden());
        }

        // Si existe, agregamos hijoDer.
        if (hijoDer != null) {
            strAux.append(getHijoDer().postOrden());
        }

        // Agregamos raiz.
        strAux.append(etiqueta.toString());
        strAux.append("-");

        // Retornamos el string.
        return strAux.toString();
    }

//    /**
//     * Imprimir.
//     * 
//     * @return etiqueta del nodo convertida en string.
//     */
//    public String imprimir() {
//        return (etiqueta.toString());
//    }
    
    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param unaEtiqueta
     * @return el elemento eliminado o null.
     */
    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {

        // Inicializo el resultado en null, sería lo retornado si no existe el nodo a eliminar.
        TElementoAB resultadoEliminacion = null;

        // Comprobar cuantos hijos tiene el elemento.
        boolean existeHijoIzq = this.getHijoIzq() != null;
        boolean existeHijoDer = this.getHijoDer() != null;

        // Verifico el subárbol izquierdo.
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            // Si tiene un hijo izquierdo, actualizo su valor.
            if (existeHijoIzq) {
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            // Retorna al padre su mismo hijo.
            return this;
        }

        // Verifoco el subárbol derecho.
        if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            // Si tiene un hijo derecho, actualizo su valor.
            if (existeHijoDer) {
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            }
            // Retorna al padre su mismo hijo.
            return this;
        }

        // Quitar efectivamente el nodo y lo retorna a su padre.
        return quitarNodo();
    }

    /**
     * Quitar el nodo.
     *
     * @return el nodo eliminado.
     */
    private TElementoAB quitarNodo() {

        // Si no tiene hijo izquierdo o es hoja, puede retornar nulo.
        if (this.hijoIzq == null) {
            return hijoDer;
        }

        // Si no tiene hijo derecho.
        if (this.hijoDer == null) {
            return hijoIzq;
        }

        // Es un nodo completo, tiene ambos hijos.
        TElementoAB elPadre = this;
        TElementoAB elHijo = hijoIzq;

        // El hijo es el más a la derecha del subárbol izquierdo.
        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }

        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }

        // El hijo quedará en lugar de este.
        elHijo.hijoDer = hijoDer;

        return elHijo;

    }
    
    /**
     * Determina si es completo.
     * 
     * @return boolean - verdadero = es completo.
     */
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
    
    /**
     * Obtener el nivel donde se encuentra una etiqueta dada.
     *
     * @param unaEtiqueta
     * @return int - el nivel donde se encuentra.
     */
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

    /**
     * Obtener la altura de un árbol.
     * 
     * Retorna la altura del árbol cuya raíz es el nodo actual.
     * @return altura del subárbol.
     */
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

    /**
     * Obtener la tamaño de un árbol.
     * 
     * Retorna el tamaño del árbol cuya raíz es el nodo actual.
     * @return tamaño del subárbol.
     */
    @Override
    public int obtenerTamanio() {
        int T1 = 0;
        int T2 = 0;
        if (hijoIzq != null) {
            T1 += hijoIzq.obtenerTamanio();
        }
        if (hijoDer != null) {
            T2 += hijoDer.obtenerTamanio();
        }
        return T1 + T2 + 1;
    }
    
    /**
     * Obtener la cantidad de hojas.
     *
     * @return int
     */
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
    
    /**
     * Devuelve el mayor elemento.
     * 
     * @return TElementoAB<T>.
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
     * Devuelve el menor elemento.
     * 
     * @return TElementoAB<T>.
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
    
    /**
     * Devuelve un string con las hojas de un nivel.
     * 
     * @param cont
     * @return string
     */
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

    /**
     * Retorna si este es un árbol de búsqueda.
     * 
     * @return boolean.
     */
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

    
}
