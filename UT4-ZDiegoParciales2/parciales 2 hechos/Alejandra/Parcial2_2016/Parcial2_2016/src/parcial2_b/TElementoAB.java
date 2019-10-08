package parcial2_b;


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
    public String preOrden() {
        String temp = "";
        temp = temp + " " + etiqueta;
        if (hijoIzq != null){
            temp = temp + hijoIzq.preOrden();   
        }
        if (hijoDer != null){
            temp = temp + hijoDer.preOrden();    
        }
        return temp;
    }

    @Override
    public String postOrden(){
        String temp="";
        if(hijoIzq!=null){
            temp = hijoIzq.postOrden();
        }        
        if (hijoDer!=null){
            temp = temp + hijoDer.postOrden();
        }
        temp = temp + " " + etiqueta;
        return temp;
    }

    @Override
    public Integer obtenerTamaño() {
        Integer temp=0;
        if(hijoIzq!=null){
            temp = temp+hijoIzq.obtenerTamaño();
        }
        temp += 1;
        if (hijoDer!=null){
            temp = temp + hijoDer.obtenerTamaño();
        }
        return temp;
    }

    @Override
    public Integer obtenerAltura() {
         if (hijoIzq == null && hijoDer == null){
            return 0;            
        }else if (hijoIzq == null && hijoDer != null){
            return 1 + hijoDer.obtenerAltura();
        }else if (hijoDer == null && hijoIzq != null){
            return 1 + hijoIzq.obtenerAltura();
        }else{
            return 1 + Math.max(hijoIzq.obtenerAltura(),hijoDer.obtenerAltura());
        }      
            
    }

    @Override
    public Comparable obtenerMaximo() {
         if (hijoIzq == null && hijoDer == null){
            return this.etiqueta;            
        }else if (hijoIzq == null && hijoDer != null){
            if(this.etiqueta.compareTo(hijoDer.obtenerMaximo())>0){
                return this.etiqueta;
            }else{
                return hijoDer.obtenerMaximo();
            }
        }else if (hijoDer == null && hijoIzq != null){
            if(this.etiqueta.compareTo(hijoIzq.obtenerMaximo())>0){
                return this.etiqueta;
            }else{
                return hijoIzq.obtenerMaximo();
            }
        }else{
            if(hijoDer.obtenerMaximo().compareTo(hijoIzq.obtenerMaximo())>0){
                if(this.etiqueta.compareTo(hijoDer.obtenerMaximo())>0){
                    return this.etiqueta;
                }else{
                    return hijoDer.obtenerMaximo();
                }
            }else{
                if(this.etiqueta.compareTo(hijoIzq.obtenerMaximo())>0){
                    return this.etiqueta;
                }else{
                    return hijoIzq.obtenerMaximo();
                }
            }
        }      
            
    }  

    @Override
    public Comparable obtenerMinimo() {
         if (hijoIzq == null && hijoDer == null){
            return this.etiqueta;            
        }else if (hijoIzq == null && hijoDer != null){
            if(this.etiqueta.compareTo(hijoDer.obtenerMinimo())<0){
                return this.etiqueta;
            }else{
                return hijoDer.obtenerMinimo();
            }
        }else if (hijoDer == null && hijoIzq != null){
            if(this.etiqueta.compareTo(hijoIzq.obtenerMinimo())<0){
                return this.etiqueta;
            }else{
                return hijoIzq.obtenerMinimo();
            }
        }else{
            if(hijoDer.obtenerMinimo().compareTo(hijoIzq.obtenerMinimo())<0){
                if(this.etiqueta.compareTo(hijoDer.obtenerMinimo())<0){
                    return this.etiqueta;
                }else{
                    return hijoDer.obtenerMinimo();
                }
            }else{
                if(this.etiqueta.compareTo(hijoIzq.obtenerMinimo())<0){
                    return this.etiqueta;
                }else{
                    return hijoIzq.obtenerMinimo();
                }
            }
        }      
            
    } 
    @Override
    public int obtenerCantidadHojas() {
        if (hijoIzq == null && hijoDer == null){
            return 1;            
        }else if (hijoIzq == null && hijoDer != null){
            return 0 + hijoDer.obtenerCantidadHojas();
        }else if (hijoDer == null && hijoIzq != null){
            return 0 + hijoIzq.obtenerCantidadHojas();
        }else{
            return hijoIzq.obtenerCantidadHojas()+hijoDer.obtenerCantidadHojas(); 
        }  
    }
    @Override
    public String obtenerHojasConNivel(int cont) {
        if (hijoIzq == null && hijoDer == null){
            return "(Hoja "+this.etiqueta+"/ Nivel "+cont+") ";            
        }else if (hijoIzq == null && hijoDer != null){
            return hijoDer.obtenerHojasConNivel(cont+1);
        }else if (hijoDer == null && hijoIzq != null){
            return hijoIzq.obtenerHojasConNivel(cont+1);
        }else{
            return hijoIzq.obtenerHojasConNivel(cont+1)+hijoDer.obtenerHojasConNivel(cont+1); 
        }  
    }

    @Override
    public int obtenerPorNivel(int cont, int nivel) {
        if(cont==nivel){
            return 1;
        }else{
            if (hijoIzq == null && hijoDer == null){
                return 0;      
            }else if (hijoIzq == null && hijoDer != null){
                return 0 + hijoDer.obtenerPorNivel(cont+1,nivel);
            }else if (hijoDer == null && hijoIzq != null){
                return 0 + hijoIzq.obtenerPorNivel(cont+1,nivel);
            }else{
                return hijoIzq.obtenerPorNivel(cont+1,nivel)+hijoDer.obtenerPorNivel(cont+1,nivel); 
            } 
        }
         
    }
    @Override
    public Boolean esABB() {
         if (hijoIzq == null && hijoDer == null){
            return true;            
        }else if (hijoIzq == null && hijoDer != null){
            return (this.etiqueta.compareTo(hijoDer.getEtiqueta())<0)==hijoDer.esABB();
        }else if (hijoDer == null && hijoIzq != null){
            return (this.etiqueta.compareTo(hijoIzq.getEtiqueta())>0)==hijoIzq.esABB();
        }else{
            return (((this.etiqueta.compareTo(hijoDer.getEtiqueta())<0)==hijoDer.esABB())==((this.etiqueta.compareTo(hijoIzq.getEtiqueta())>0)==hijoIzq.esABB()));
        }      
            
    }
    
    @Override
    public Integer buscarConNivel(Comparable unaEtiqueta, int cont) {

        if (unaEtiqueta.equals(etiqueta)) {
            return cont;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscarConNivel(unaEtiqueta, cont+1);
            } else {
                return -1;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscarConNivel(unaEtiqueta, cont+1);
        } else {
            return -1;
        }
    }
    @Override
    public Producto mayorValor(int claveMenor, int claveMayor){
        Producto prod=(Producto) this.getDatos();
        if((claveMenor<=prod.getValor())&&(prod.getValor()>=claveMayor)){
            if (hijoIzq != null) {
                Producto prodIzq=hijoIzq.mayorValor(claveMenor, claveMayor);
                if(prodIzq!=null){
                    if(prodIzq.getValor()>prod.getValor()){
                        prod=prodIzq;
                    }
                }
            } 
            if (hijoDer != null) {
               Producto prodDer=hijoDer.mayorValor(claveMenor, claveMayor);
                if(prodDer!=null){
                    if(prodDer.getValor()>prod.getValor()){
                        prod=prodDer;
                    }
                } 
            }
            return prod;
        }else{
            prod=null;
            if (hijoIzq != null) {
                Producto prodIzq=hijoIzq.mayorValor(claveMenor, claveMayor);
                if(prodIzq!=null){
                    prod=prodIzq;
                }
            } 
            if (hijoDer != null) {
               Producto prodDer=hijoDer.mayorValor(claveMenor, claveMayor);
                if(prodDer!=null){
                    if(prod!=null){
                        if(prodDer.getValor()>prod.getValor()){
                            prod=prodDer;
                        }
                    }else{
                        prod=prodDer;
                    }
                    
                } 
            }
            return prod;
        }
        
    }
}
