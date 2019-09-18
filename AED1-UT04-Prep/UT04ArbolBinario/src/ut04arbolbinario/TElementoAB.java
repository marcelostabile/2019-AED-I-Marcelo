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
    public boolean insertar(TElementoAB unElemento) {
        
        // Selecciona el hijo izquierdo si el valor es menor.
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            // Si hijoIzq está vacío, lo inserta allí, retorna true.
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } 
        // Selecciona el hijo derecho si el valor es mayor.
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Imprimir.
    public String imprimir() {
        return (etiqueta.toString());
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
    public String inOrden() {
        String resultado = "";
        if(hijoIzq != null){
            resultado += hijoIzq.inOrden();
        }
        resultado += getEtiqueta().toString()+" ";
        if(hijoDer != null){
            resultado += hijoDer.inOrden();
        }
        return resultado;
    }    

    @Override
    public String postOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T getDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
