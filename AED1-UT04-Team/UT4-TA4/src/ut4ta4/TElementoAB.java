package ut4ta4;
/*
 * ELEMENTO
 */

/**
 * @author EQUIPO.
 */
class TElementoAB<T> implements IElementoAB<T> {

    protected Comparable etiqueta;
    protected TElementoAB hijoIzq;
    protected TElementoAB hijoDer;
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
     * BUSCAR UN ELEMENTO en los hijos y sus subárboles.
     * 
     * @return El elemento encontrado. Sino retorna null.
     */ 
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        // Este es el elemento buscado, retorno este.
        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } 
        else {
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
     * INSERTAR UN ELEMENTO.
     * 
     * @param unElemento
     * @return un booleano.
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        
        /**
          * Selecciona el hijo izquierdo si el valor es menor.
          * Si hijoIzq está vacío, lo inserta allí, retorna true.
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
         * Selecciona el hijo derecho si el valor es mayor.
         * Si hijoIzq está vacío, lo inserta allí, retorna true.
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
     * RECORRIDO PREORDEN.
     * Imprime en preorden el árbol separado por guiones.
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
     * RECORRIDO INORDEN.
     * Imprime en inorden el árbol separado por guiones.
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
    
    /**
     * RECORRIDO POSTORDEN.
     * Imprime en postorden el árbol separado por guiones.
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
     * Obtener el nivel donde se encuentra una etiqueta dada.
     * 
     * @param unaEtiqueta
     * @return int - el nivel donde se encuentra.
     */
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
            } 
            else {
                // Si no la encuentra y no tiene más hijos, retorna 0.
                return 0;
            }
        }
    }
    
    /**
     * Obtener la cantidad de hojas.
     * 
     * @return int
     */
    @Override
    public int obtenerCantidadHojas() { 
        
        // Si no tiene hijos, es una hoja, devuelve uno.
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        }
        
        // Inicializo la cantidad de hojas.
        int hojasIzquierdo = 0;
        int hojasDerecho = 0;
        
        // Si tiene Hijo Izquierdo.
        if (hijoIzq != null) {
            hojasIzquierdo = hijoIzq.obtenerCantidadHojas();
        }
        
        // Si tiene Hijo Derecho.
        if (hijoDer != null) {
            hojasDerecho = hijoDer.obtenerCantidadHojas();
        }
        
        // Retorna el valor.
        return hojasIzquierdo + hojasDerecho;
    }

    @Override
    public int obtenerAltura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerTamanio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
