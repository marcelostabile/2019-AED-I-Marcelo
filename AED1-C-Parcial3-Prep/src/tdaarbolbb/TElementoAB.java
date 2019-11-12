package tdaarbolbb;

import TDALista.*;
import java.util.LinkedList;
import pruebas.*;

public class TElementoAB<T> implements IElementoAB<T> {

    protected Comparable etiqueta;
    protected IElementoAB hijoIzq;
    protected IElementoAB hijoDer;
    protected T datos;
    private int frec;
    private int frecNEizq;
    private int frecNEder;

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
     * @return the frec
     */
    public int getFrec() {
        return frec;
    }

    /**
     * @param frec the frec to set
     */
    public void setFrec(int frec) {
        this.frec = frec;
    }

    /**
     * @return the frecNEizq
     */
    public int getFrecNEizq() {
        return frecNEizq;
    }

    /**
     * @param frecNEizq the frecNEizq to set
     */
    public void setFrecNEizq(int frecNEizq) {
        this.frecNEizq = frecNEizq;
    }

    /**
     * @return the frecNEder
     */
    public int getFrecNEder() {
        return frecNEder;
    }

    /**
     * @param frecNEder the frecNEder to set
     */
    public void setFrecNEder(int frecNEder) {
        this.frecNEder = frecNEder;
    }

    public void incFrec() {
        this.setFrec(this.getFrec() + 1);
    }

    public void incFNEIzq() {
        this.setFrecNEizq(this.getFrecNEizq() + 1);

    }

    public void incFNEDer() {
        this.setFrecNEder(this.getFrecNEder() + 1);
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
        }
        if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
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
    public void preOrdenLista(Lista<T> unaLista) {
        unaLista.insertar(new Nodo<T>(this.etiqueta, this.getDatos()));
        if (hijoIzq != null) {
            hijoIzq.preOrdenLista(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.preOrdenLista(unaLista);
        }
    }

    @Override
    public void inOrdenLista(Lista<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrdenLista(unaLista);

        }
        unaLista.insertar(new Nodo<T>(this.etiqueta, this.getDatos()));
        if (hijoDer != null) {
            hijoDer.inOrdenLista(unaLista);
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
        }
        if (hijoIzq == null && hijoDer != null) {
            return hijoDer.obtenerCantidadHojas();
        }
        if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.obtenerCantidadHojas();
        } else {
            return hijoIzq.obtenerCantidadHojas() + hijoDer.obtenerCantidadHojas();
        }
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (this.etiqueta.compareTo(unaEtiqueta) == 0) {
            return 0;
        }
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
            } else {
                return 0;
            }
        }
        if (hijoDer != null) {
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
    public String obtenerHojasConNivel(int contador) {
        if (hijoIzq == null && hijoDer == null) {
            return "Hoja: " + this.etiqueta + ", Nivel: " + contador + "\n";
        }
        if (hijoIzq == null && hijoDer != null) {
            return hijoDer.obtenerHojasConNivel(contador + 1);
        }
        if (hijoIzq != null && hijoDer == null) {
            return hijoIzq.obtenerHojasConNivel(contador + 1);
        } else {
            return hijoDer.obtenerHojasConNivel(contador + 1) + hijoIzq.obtenerHojasConNivel(contador + 1);
        }
    }

    @Override
    public boolean esABB() {
        if (hijoIzq == null && hijoDer == null) {
            return true;
        }
        if (hijoIzq == null && hijoDer != null) {
            return (this.getEtiqueta().compareTo(hijoDer.getEtiqueta()) < 0) == hijoDer.esABB();
        }
        if (hijoIzq != null && hijoDer == null) {
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
        }
        if (this.hijoDer != null) {
            if (this.hijoDer.getEtiqueta().equals(clave)) {
                return this;
            } else {
                return this.hijoDer.obtenerPadre(clave);
            }
        }

        // No encontré
        return null;
    }

    @Override
    public Lista<TElementoAB> obtenerNodosNivel(Lista<TElementoAB> listaElementos, int unNivel) {

        if (unNivel == 0) {
            listaElementos.insertar(new Nodo<>(this.etiqueta, this));
        }
        if (hijoIzq != null) {
            hijoIzq.obtenerNodosNivel(listaElementos, unNivel - 1);
        }
        if (hijoDer != null) {
            hijoDer.obtenerNodosNivel(listaElementos, unNivel - 1);
        }
        return listaElementos;
    }

    @Override
    public int mayorValor(Comparable claveMenor, Comparable claveMayor) {
        Producto prod = (Producto) this.getDatos();
        if ((claveMenor.compareTo(this.getEtiqueta()) <= 0) && (claveMayor.compareTo(this.getEtiqueta()) >= 0)) {
            if (hijoIzq != null) {
                Producto prodIzq = hijoIzq.mayorValor2(claveMenor, claveMayor);
                if (prodIzq != null) {
                    if (prodIzq.getValor() > prod.getValor()) {
                        prod = prodIzq;
                    }
                }
            }
            if (hijoDer != null) {
                Producto prodDer = hijoDer.mayorValor2(claveMenor, claveMayor);
                if (prodDer != null) {
                    if (prodDer.getValor() > prod.getValor()) {
                        prod = prodDer;
                    }
                }
            }
            return Integer.valueOf(prod.getEtiqueta().toString());
        } else {
            prod = null;
            if (hijoIzq != null) {
                Producto prodIzq = hijoIzq.mayorValor2(claveMenor, claveMayor);
                if (prodIzq != null) {
                    prod = prodIzq;
                }
            }
            if (hijoDer != null) {
                Producto prodDer = hijoDer.mayorValor2(claveMenor, claveMayor);
                if (prodDer != null) {
                    if (prod != null) {
                        if (prodDer.getValor() > prod.getValor()) {
                            prod = prodDer;
                        }
                    } else {
                        prod = prodDer;
                    }

                }
            }
            return Integer.valueOf(prod.getEtiqueta().toString());
        }
    }

    @Override
    public Producto mayorValor2(Comparable claveMenor, Comparable claveMayor) {
        Producto prod = (Producto) this.getDatos();
        if ((claveMenor.compareTo(this.getEtiqueta()) <= 0) && (claveMayor.compareTo(this.getEtiqueta()) >= 0)) {
            if (hijoIzq != null) {
                Producto prodIzq = hijoIzq.mayorValor2(claveMenor, claveMayor);
                if (prodIzq != null) {
                    if (prodIzq.getValor() > prod.getValor()) {
                        prod = prodIzq;
                    }
                }
            }
            if (hijoDer != null) {
                Producto prodDer = hijoDer.mayorValor2(claveMenor, claveMayor);
                if (prodDer != null) {
                    if (prodDer.getValor() > prod.getValor()) {
                        prod = prodDer;
                    }
                }
            }
            return prod;
        } else {
            prod = null;
            if (hijoIzq != null) {
                Producto prodIzq = hijoIzq.mayorValor2(claveMenor, claveMayor);
                if (prodIzq != null) {
                    prod = prodIzq;
                }
            }
            if (hijoDer != null) {
                Producto prodDer = hijoDer.mayorValor2(claveMenor, claveMayor);
                if (prodDer != null) {
                    if (prod != null) {
                        if (prodDer.getValor() > prod.getValor()) {
                            prod = prodDer;
                        }
                    } else {
                        prod = prodDer;
                    }

                }
            }
            return prod;
        }
    }

    @Override
    public void inOrden(ILista<T> unaLista) {
        // Hijo izquierdo
        if (this.getHijoIzq() != null) {
            this.getHijoIzq().inOrden(unaLista);
        }

        // Inserto este elemento
        unaLista.insertar(new Nodo<>(this.getEtiqueta(), this.getDatos()));

        // Hijo derecho
        if (this.getHijoDer() != null) {
            this.getHijoDer().inOrden(unaLista);
        }
    }

    @Override
    public void indizar(TArbolBB indice, Comparable laCarrera) {
        Alumno alumno = (Alumno) this.getDatos();
        if (alumno.getCarrera().equals(laCarrera)) {
            indice.insertar(new TElementoAB(alumno.getApellido(), alumno));
        }
        if (hijoIzq != null) {
            hijoIzq.indizar(indice, laCarrera);
        }
        if (hijoDer != null) {
            hijoDer.indizar(indice, laCarrera);
        }
    }

    /**
     *
     * @param unaLista
     */
    @Override
    public void inOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.add(this.getDatos());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    @Override
    public boolean unaFuncion(Comparable x) {
        if (etiqueta.equals(x)) {
            return true;
        }
        boolean A = false;
        boolean B = false;
        if (hijoIzq != null) {
            getHijoIzq().unaFuncion(x);
        }
        if (hijoDer != null) {
            getHijoDer().unaFuncion(x);
        }
        return A && B;
    }

    @Override
    public int longTray(int anterior) {
        int suma = anterior;
        if (hijoIzq != null) {
            suma = suma + hijoIzq.longTray(anterior + 1);
        } else {
            suma += anterior + 1;
        }
        if (hijoDer != null) {
            suma = suma + hijoDer.longTray(anterior + 1);
        } else {
            suma += anterior + 1;
        }
        return suma;
    }

    @Override
    public Integer esArbolAvl() {
        Integer alturaIzq, alturaDer; // Integer para poder retornar null

        alturaIzq = alturaDer = -1;
        if (this.getHijoIzq() != null) {
            alturaIzq = this.getHijoIzq().esArbolAvl();
        }

        if (this.getHijoDer() != null) {
            alturaDer = this.getHijoDer().esArbolAvl();
        }

        // Si en retorno ya vengo con "error" (no es AVL)
        // sigo retornando el error.
        if (alturaIzq == null || alturaDer == null) {
            return null;
        } else {
            // Determino si la diferencia está OK
            if (Math.abs(alturaDer - alturaIzq) > 1) // Retorno nulo para agarrar en la vuelta
            {
                return null;
            } else // Sigo retornando la altura
            {
                return Math.max(alturaIzq + 1, alturaDer + 1);
            }
        }
    }

    @Override
    public Integer cumpleAVL(Integer[] cumple) {
        Integer[] alturaIzq = {0};
        Integer[] alturaDer = {0};

        alturaIzq[0] = alturaDer[0] = -1;

        if (this.getHijoIzq() != null) {
            alturaIzq[0] = this.getHijoIzq().cumpleAVL(alturaIzq);
        }

        if (this.getHijoDer() != null) {
            alturaDer[0] = this.getHijoDer().cumpleAVL(alturaDer);
        }

        // Si en retorno ya vengo con "error" (no es AVL)
        // sigo retornando el error.
        if (alturaIzq[0] == null || alturaDer[0] == null) {
            return null;
        } else {
            // Determino si la diferencia está OK
            if (Math.abs(alturaDer[0] - alturaIzq[0]) > 1) // Retorno nulo para agarrar en la vuelta
            {
                return null;
            } else // Sigo retornando la altura
            {
                return Math.max(alturaIzq[0] + 1, alturaDer[0] + 1);
            }
        }
    }

    @Override
    public int nivelClave(Comparable unaClave) {
        int nivel = 0;

        if (unaClave.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                nivel = hijoIzq.nivelClave(unaClave);
            } else {
                return -2;
            }
        } else if (unaClave.compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                nivel = hijoDer.nivelClave(unaClave);
            } else {
                return -2;
            }
        } else {
            return 1;
        }

        // Si vengo retornando negativo...
        if (nivel <= 0) {
            return (nivel - 1);
        } else {
            return (nivel + 1);
        }
    }

    @Override
    public int nivelMasProfundo() {
        int N1 = 1;
        int N2 = 1;

        if (hijoIzq != null) {
            N1 = 1 + hijoIzq.nivelMasProfundo();
        }

        if (hijoDer != null) {
            N2 = 1 + hijoDer.nivelMasProfundo();
        }

        return Math.max(N1, N2);
    }

    public void listarClavesyFrecuencias(String[] claves, int[] FE, int[] FNE, int[] indice) {
        if (hijoIzq != null) {
            hijoIzq.listarClavesyFrecuencias(claves, FE, FNE, indice);
        } else {
            FNE[indice[0]] = this.getFrecNEizq();
            indice[0]++;
        }
        claves[indice[0]] = this.etiqueta.toString();
        FE[indice[0]] = this.getFrec();

        if (hijoDer != null) {
            hijoDer.listarClavesyFrecuencias(claves, FE, FNE, indice);
        } else {
            FNE[indice[0]] = this.getFrecNEder();
            indice[0]++;
        }
    }

    @Override
    public void actualizarFrecuencias(Comparable unaClave) {
        if (unaClave.compareTo(this.etiqueta) == 0) {
            // Actualizo frecuencia de éxito si encuentro clave
            this.incFrec();
        } else if (unaClave.compareTo(this.etiqueta) < 0) {
            // Caso que debo buscar por izquierda
            if (this.hijoIzq == null) {
                // No puedo ir por izquierda, así que actualizo su freqNoExito
                this.incFNEIzq();
            } else {
                // Sigo buscando recursivamente por izquierda
                this.hijoIzq.actualizarFrecuencias(unaClave);
            }
        } else {
            // Caso que debo buscar por derecha
            if (this.hijoDer == null) {
                // No puedo ir por derecha, así que actualizo su freqNoExito
                this.incFNEDer();
            } else {
                // Sigo buscando recursivamente por derecha
                this.hijoDer.actualizarFrecuencias(unaClave);
            }
        }
    }

    @Override
    public int calcularCosto(int[] FrecExito, int[] FrecNoExito, int[] indiceFE, int[] indiceFNE, int nivel) {
        int costoTotal = 0;

        // Nivel actual de este nodo
        nivel = nivel + 1;

        if (this.hijoIzq != null) {
            costoTotal += this.hijoIzq.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, nivel);
        } else {
            costoTotal += FrecNoExito[indiceFE[0]] * (nivel + 1);
            indiceFE[0]++;
        }

        // CASO DE ÉXITO
        // el indice del K
        // Acumlo ai*hi
        costoTotal += FrecExito[indiceFE[0]] * nivel;

        if (this.hijoDer != null) {
            costoTotal += this.hijoDer.calcularCosto(FrecExito, FrecNoExito, indiceFE, indiceFNE, nivel);
        } else {
            costoTotal += FrecNoExito[indiceFE[0]] * (nivel + 1);
            indiceFE[0]++;
        }

        return costoTotal;
    }

    @Override
    public void clavesNivel(int unNivel, Lista<T> claves) {
        if (unNivel == 1) {
            claves.insertar(new Nodo<>(etiqueta, datos));
            return;
        }

        if (hijoIzq != null) {
            hijoIzq.clavesNivel(unNivel - 1, claves);
        }

        if (hijoDer != null) {
            hijoDer.clavesNivel(unNivel - 1, claves);
        }
    }
}
