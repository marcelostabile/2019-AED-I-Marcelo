package ut04arbolbinario;

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
    





    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
