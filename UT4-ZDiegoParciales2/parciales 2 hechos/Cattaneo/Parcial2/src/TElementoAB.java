
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
        hijoIzq = null;
        hijoDer = null;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
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

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        TElementoAB<T> resultado;
        
        resultado = null;
        if (this.getEtiqueta().compareTo(unaEtiqueta) == 0){
            resultado = this;
        }
        else {
            if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
                if (this.getHijoIzq() != null)
                    resultado = this.getHijoIzq().buscar(unaEtiqueta);
            }
            else {
                if (this.getHijoDer() != null)
                    resultado = this.getHijoDer().buscar(unaEtiqueta);
            }
        }
                
        return resultado;
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        Comparable unaEtiqueta;
        
        unaEtiqueta = elemento.getEtiqueta();
        if (unaEtiqueta.compareTo(this.getEtiqueta()) == 0) {
            return false;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.getHijoIzq() == null)
                this.setHijoIzq(elemento);
            else 
                return this.getHijoIzq().insertar(elemento);
        }
        else {
            if (this.getHijoDer() == null)
                this.setHijoDer(elemento);
            else 
                return this.getHijoDer().insertar(elemento);
        }
        return true;
    }

    @Override
    public void inOrden(Lista<T> unaLista) {
        // Hijo izquierdo
        if (this.getHijoIzq() != null)
            this.getHijoIzq().inOrden(unaLista);
        
        // Inserto este elemento
        unaLista.insertar(new Nodo<>(this.getEtiqueta(), this.getDatos()));
        
        // Hijo derecho
        if (this.getHijoDer() != null)
            this.getHijoDer().inOrden(unaLista);
    }

}
