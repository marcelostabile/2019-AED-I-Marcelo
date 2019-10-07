/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author EQUIPO 1
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

    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return this.hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return this.hijoDer;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB unElemento) {
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

    @Override
    public String preOrden() {
        String resultado = "";
        resultado += getEtiqueta().toString() + "-";
        if(hijoIzq != null){
            resultado += hijoIzq.preOrden();
        }if(hijoDer != null){
            resultado += hijoDer.preOrden();
        }
        return resultado;
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
        String resultado = "";
        if(hijoIzq != null){
            resultado += hijoIzq.postOrden();
        }
        if(hijoDer != null){
            resultado += hijoDer.postOrden();
        }
        resultado += getEtiqueta().toString()+" ";
        return resultado;    
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