package ut4td2;

/**
 * @author EQUIPO 1
 */
public class Lista<E> implements ILista<E> {

    private INodo<E> primero;

    public Lista() {
        this.primero = null;
    }

    /**
     * Método encargado de agregar un nodo al final de la lista.
     * 
     * @param nodoNuevo - Nodo a agregar
     */
    @Override
    public void insertar(INodo nodoNuevo) { 
        
        // Si la lista está vacía, inserto en primero.
        if (esVacia()) {
            primero = nodoNuevo;
            
        } else {
            // La lista contiene elemento, lo inserto al final.
            INodo<E> nodoAux = primero;
            
            while (nodoAux.getSiguiente() != null) {
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nodoNuevo);
        }
    }

    /**
     * Método encargado de buscar un nodo cuya clave es la indicada.
     *
     * @param clave - Clave del nodo a buscar.
     * @return El nodo encontrado. En caso de no encontrarlo, retornar null.
     */
    @Override
    public INodo buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo aux = this.primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    /**
     * Método encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return True en caso de que la eliminación haya sido efectuada con éxito.
     */
    @Override
    public boolean eliminar(Comparable clave) {
        
        // Si lista vacía.
        if (esVacia()) {
            return false;
        }
        
        // Si solo existe primero.
        if (this.primero.getSiguiente() == null) {
            
            // Si el primer elemento coincide con el buscado.
            if (this.primero.getEtiqueta().equals(clave)) {
                this.primero = null;
                return true;
            }
        }
        
        // Si hay más elemento.
        INodo aux = this.primero;
        
        // El primero coincide, pero hay más elementos.
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            
            //Eliminamos el primer elemento
            INodo temp1 = aux;
            INodo temp = aux.getSiguiente();
            
            // El siguiente pasa a ser primero.
            this.primero = temp;
            
            return true;
        }
        
        // Buscamos en el resto de la lista.
        while (aux.getSiguiente() != null) {
            
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                
                INodo temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }   

    /**
     * Método encargado de eliminar un nodo cuya clave es la indicada.
     *
     * @param clave Clave del nodo a eliminar.
     * @return Retorna el nodo eliminado.
     */
    @Override
    public INodo eliminarNodo(Comparable clave) {
        
        // Creamos el nodo auxiliar.
        INodo nodoAux = new Nodo();
        
        // Si la lista es vacía, retorna nodo auxiliar vacío.
        if (esVacia()) {
            return nodoAux;
        } 
        
        // Caso: nodo primero.
        nodoAux = this.primero.clonar();
        
        if (nodoAux.getEtiqueta().equals(clave) && nodoAux.getSiguiente() == null) {
            // Nodo primero coincide y es único en la lista, retorna primero.
            this.primero = null;
            return nodoAux;
            
        } else if (nodoAux.getEtiqueta().equals(clave) && nodoAux.getSiguiente() != null) {
            // Nodo primero coincide y existen otros nodos en la lista.
            // this.primero = nodoAux.getSiguiente().clonar(); o si no tengo clonar:
            this.primero = new Nodo(nodoAux.getSiguiente().getEtiqueta(), nodoAux.getSiguiente().getDato());
            this.primero.setSiguiente(nodoAux.getSiguiente().getSiguiente());
            return nodoAux;
        }
        
        // Caso: hay más registros.
        while (nodoAux.getSiguiente() != null) {
            
            if (nodoAux.getSiguiente().getEtiqueta().equals(clave)) {
                INodo temp = nodoAux.getSiguiente();
                nodoAux.setSiguiente(temp.getSiguiente());
                return temp;
            }
            nodoAux = nodoAux.getSiguiente();
        }
        return nodoAux;
    }
    
    /**
     * Método encargado de imprimir en consola las claves de los nodos
     * contenidos en la lista.
     */
    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            INodo temp = this.primero;
            while (temp != null) {
                temp.imprimir();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }
    
    /**
     * Retorna un String con las claves separadas por el separador pasado por
     * par�metro.
     *
     * @param separador Separa las claves
     * @return
     */
    @Override
    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            INodo temp = this.primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    /**
     * Retorna la cantidad de elementos de la lista. En caso de que la lista
     * este vac�a, retornar 0.
     *
     * @return Cantidad de elementos de la lista.
     */
    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            //System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = this.primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }
    
    /**
     * Indica si la lista contiene o no elementos.
     *
     * @return Si tiene elementos o no.
     */
    @Override
    public boolean esVacia() {
        return this.primero == null;
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo de la lista.
     */
    @Override
    public INodo<E> getPrimero() {
        return this.primero;
    }

    /**
     * Insertar nodo ordenado (INSERCIÓN DIRECTA).
     * 
     * @param nodo (INodo--E--)
     */
    public void insertarNodoOrdenado(INodo<E> nodo) {
        
        INodo<E> nodoActual;
        INodo<E> nodoSiguiente;

        // Si la lista está vacía, lo asignamos como primero
        if (this.esVacia()) {
           this.primero = nodo;
        }
        else {
            // Si la lista contiene elementos, buscamos que el nodo no exista.
            if (this.buscar(nodo.getEtiqueta()) == null) { 
                nodoActual = this.primero;
                nodoSiguiente = nodoActual.getSiguiente();

                // Caso: primero es mayor.
                if (nodoActual.compareTo(nodo.getEtiqueta()) > 0) { 
                    // Lo agregamos primero en la lista.
                    nodo.setSiguiente(nodoActual);
                    this.primero = nodo;
                } 
                else {
                    // Recorremos la lista hasta encontrar su lugar.
                    while (nodoSiguiente != null && nodoSiguiente.compareTo(nodo.getEtiqueta()) < 0){
                        nodoActual = nodoActual.getSiguiente();
                        nodoSiguiente = nodoActual.getSiguiente();
                    }
                    nodoActual.setSiguiente(nodo);
                    nodo.setSiguiente(nodoSiguiente);
                }
            }
        }
    }
}

//
//    public void setPrimero(INodo unNodo) {
//        this.primero = unNodo;
//    }
//
//    public INodo quitarPrimero() {
//        INodo aux;
//        INodo x = null;
//        aux = getPrimero();
//        if (!esVacia()) {
//            x = getPrimero();
//            eliminar((Comparable) aux);
//        }
//        return x;
//    }
//
//    @Override
//    public void insertarOrdenado(INodo<E> nodo) {
//        INodo<E> actual;
//        INodo<E> siguiente;
//
//        // Si la lista está vacía, lo defino como primero
//        if (this.esVacia()) {
//           this.primero = nodo;
//        }
//        else {
//            // Valido que no exista ya el nodo
//            if (this.buscar(nodo.getEtiqueta()) == null) {
//                actual = this.getPrimero();
//                siguiente = actual.getSiguiente();
//                
//                // Caso primer elemento ya es mayor
//                if (actual.compareTo(nodo.getEtiqueta()) > 0) {
//                    // Lo agrego primero a la lista
//                    nodo.setSiguiente(actual);
//                    this.primero = nodo;
//                }
//                // Caso de un sólo elemento y es menor
//                else if (siguiente == null) {
//                    // Lo agrego como siguiente y último
//                    actual.setSiguiente(nodo);
//                    nodo.setSiguiente(null);
//                }
//                // Caso sólo dos elementos y estamos entre medio
//                else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
//                    actual.setSiguiente(nodo);
//                    nodo.setSiguiente(siguiente);
//                }
//                else {
//                    // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
//                    while(actual.getSiguiente() != null) {
//                        actual = actual.getSiguiente();
//                        siguiente = actual.getSiguiente();
//                        // Llegué al final de la lista, lo inserto al final
//                        if (siguiente == null) {
//                            actual.setSiguiente(nodo);
//                            nodo.setSiguiente(null);
//                            break;
//                        }
//                        // Si actual es menor y el siguiente es mayor, encontré un hueco
//                        else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
//                            // Se inserta nodo en el hueco encontrado y dejo de recorrer la lista
//                            actual.setSiguiente(nodo);
//                            nodo.setSiguiente(siguiente);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    @Override
//    public Lista<E> insercionDirecta() {
//        Lista<E> ordenada = new Lista();
//        while (primero != null) {
//            ordenada.insertarOrdenado(primero);
//            eliminar(primero.getEtiqueta());
//        }
//        return ordenada;
//    }
//}