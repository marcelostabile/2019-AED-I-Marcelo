package ut4ta6;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
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

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * RECORRIDO PREORDEN. Imprime en preorden el árbol separado por guiones.
     *
     * @return un string con el resultado.
     */
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
     * @Override public void inOrden(Object unaLista) { throw new
     * UnsupportedOperationException("Not supported yet."); //To change body of
     * generated methods, choose Tools | Templates. }
     *
     * @return un string con el resultado.
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
     * RECORRIDO POSTORDEN. Imprime en postorden el árbol separado por guiones.
     *
     * @return un string con el resultado.
     */
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

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
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
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

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
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
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

    /*
    version Marcelo
    
    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {

        // Si el nodo actual es la etiqueta búscada.
        if (this.etiqueta.compareTo(unaEtiqueta) == 0) {
            return 0;
        } else {
            if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
                // Si la etiqueta buscada es menor a la etiqueta del nodo, revisa el hijo izq.
                if (hijoIzq != null) {
                    return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
                } else {
                    return 0;
                }
            }
            // Si la etiqueta buscada es mayor a la etiqueta del nodo, revisa el hijo der.
            if (hijoDer != null) {
                return 1 + hijoDer.obtenerNivel(unaEtiqueta);
            } else {
                // Si no la encuentra y no tiene más hijos, retorna 0.
                return 0;
            }
        }
    }
     */
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

    /*
    version Marcelo
    @Override
    public int obtenerCantidadHojas() {
        
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        }
        
        if (hijoIzq == null && hijoDer != null) {
            return hijoDer.obtenerCantidadHojas();
        }
        
        if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.obtenerCantidadHojas();
        }
        
        return hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();
    }
     */
//    /**
//     * Obtener la cantidad de hojas.
//     * 
//     * @return int
//     */
//    @Override
//    public int obtenerCantidadHojas() { 
//        
//        // Si no tiene hijos, es una hoja, devuelve uno.
//        if (hijoIzq == null && hijoDer == null) {
//            return 1;
//        }
//
//        // Inicializo la cantidad de hojas.
//        int hojasIzquierdo = 0;
//        int hojasDerecho = 0;
//        
//        // Si tiene Hijo Izquierdo.
//        if (hijoIzq != null) {
//            hojasIzquierdo = hijoIzq.obtenerCantidadHojas();
//        }
//        
//        // Si tiene Hijo Derecho.
//        if (hijoDer != null) {
//            hojasDerecho = hijoDer.obtenerCantidadHojas();
//        }
//        
//        // Retorna el valor.
//        return hojasIzquierdo + hojasDerecho;
//    }
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

    public void inOrden(Object unaLista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
