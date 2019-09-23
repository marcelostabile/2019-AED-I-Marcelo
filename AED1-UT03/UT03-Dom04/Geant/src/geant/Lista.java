/*
 * LISTA
 */
package geant;

/**
 *
 * @author mstabile
 */
public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    /**
     * Insertar un Nodo al final de la lista.
     * 
     * Si lista está vacía, establece nuevo nodo como primero.
     * Sino, busca el último nodo fijandose si actual.siguiente es nulo.
     * Cuando lo encuentra, actual.siguiente tendrá referencia al nuevo nodo.
     */
    @Override
    public void insertar(Nodo<T> unNodo) {
        
        if (esVacia()) {
            primero = unNodo;
        
        } else {
            Nodo<T> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    /**
     * Busca un Nodo en la lista.
     * 
     * Si lista está vacía, retorna null.
     * Sino, itera mientras nodo actual no sea nulo o se encuentre el buscado.
     * Si lo encuentra, retorna su nodo, sino retorna null.
     */
    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
            
        } else {
            Nodo<T> aux = primero;
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
     * Elimina un nodo de la lista.
     */   
    @Override
    public boolean eliminar(Comparable clave) {

        // Si la lista es vacia, retorna false.
        if (esVacia()) {
            return false;
        }

        // Si primero es el buscado y no tiene siguiente, lo elimina, retorna true.
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        
        // Si primero es el buscado y tiene un siguiente, asigna al siguiente como primero.
        Nodo<T> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            Nodo<T> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }

        // Sino, continua iterando hasta encontrar un nodo que corresponda o que siguiente sea null.
        while (aux.getSiguiente() != null) {
            
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<T> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;
            }
            
            aux = aux.getSiguiente();
        }
        return false;
    }

    // Imprimir nodo.
    @Override
    public void imprimir() {

        if (!esVacia()) {
            
            Nodo<T> temp = primero;
            
            while (temp != null) {
                temp.imprimir();
                temp = temp.getSiguiente();
            }
        }
    }

    // Imprimir nodo con separador.
    @Override
    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;
    }

    // Retorna la cantidad de elementos de la lista.
    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            Nodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    // Retorna boolean si la lista es vacia.
    @Override
    public boolean esVacia() {
        return primero == null;
    }

    // Devuelve el primero.
    public Nodo<T> getPrimero() {
        return primero;
    }

    // Establece el nodo que recibe como primero.
    @Override
    public void setPrimero(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    public Nodo quitarPrimero2() {
        Nodo aux;
        Nodo x = null;
        aux = getPrimero();
        if (!esVacia()) {
            x = getPrimero();
            eliminar((Comparable) aux);
        }
        return x;
    }

    // Quitar el primero.
    public Nodo quitarPrimero() {
        
        Nodo<T> aux = this.getPrimero().clonar();
        setPrimero(getPrimero().getSiguiente());
        return aux;
    }

    public Nodo<T> obtenerMayor() {
        Nodo aux = getPrimero();
        Nodo mayor = getPrimero();
        while (aux != null) {
            if (mayor.getEtiqueta().compareTo(aux.getEtiqueta()) < 1) {
                mayor = aux;
            }
            aux = aux.getSiguiente();
        }
        return mayor;
    }

    public Nodo<T> obtenerMenor() {
        Nodo aux = getPrimero();
        Nodo menor = getPrimero();
        while (aux != null) {
            if (menor.getEtiqueta().compareTo(aux.getEtiqueta()) > 1) {
                menor = aux;
            }
            aux = aux.getSiguiente();
        }
        return menor;
    }

    public void quitarMenor2() {
        Nodo menor = obtenerMenor();
        eliminar(menor.getEtiqueta());
    }

    public Nodo<T> quitarMenor() {
        Nodo<T> anterior, actual, menor, auxMenor;

        if (this.esVacia()) {
            return null;
        }

        actual = this.getPrimero();
        menor = this.getPrimero();
        anterior = null;
        auxMenor = null;

        while (actual != null) {
            if (actual.compareTo(menor.getEtiqueta()) < 0) {
                menor = actual;
                auxMenor = anterior;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (auxMenor == null) {
            this.setPrimero(menor.getSiguiente());
        } else {
            auxMenor.setSiguiente(menor.getSiguiente());
        }
        menor.setSiguiente(null);

        // Retorno nodo menor
        return menor;
    }

    public void quitarMayor() {
        Nodo mayor = obtenerMayor();
        eliminar(mayor.getEtiqueta());
    }

    public Lista insercionDirecta() {
        
        // Crear nueva lista y crear nodo auxiliar.
        Lista<T> nuevaLista = new Lista<T>();
        Nodo<T> aux;
        
        // auxiliar es primero.
        aux = getPrimero();
        
        // Si primero es nulo, retorna la lista vacia.
        if (aux == null) {
            return nuevaLista;
        }
        
        // Mientras que auxiliar no sea nulo, iterar.
        while (aux != null) {
            
            // Quitamos el primero.
            Nodo<T> x = quitarPrimero();
            
            // Lo insertamos ordenado en la nueva lista ordenado.
            nuevaLista.insertarOrdenado(x);
            
            // pasamos al siguiente.
            aux = aux.getSiguiente();
        }
        // Retornamos la lista ordenada.
        return nuevaLista;
    }

    public Lista<T> seleccionDirecta() {
        Lista<T> nuevaLista;

        nuevaLista = new Lista<>();

        if (this.esVacia()) {
            return nuevaLista;
        }

        while (!this.esVacia()) {
            nuevaLista.insertar(this.quitarMenor().clonar());
        }

        return nuevaLista;
    }

    public void insertarOrdenado(Nodo<T> nodo) {
        
        Nodo<T> actual;
        Nodo<T> siguiente;

        // Si la lista está vacía, el nodo recibido será el primero
        if (this.esVacia()) {
            setPrimero(nodo);
            
        } else {
            
            // Válido que no exista ya el nodo
            if (this.buscar(nodo.getEtiqueta()) == null) {
                actual = this.getPrimero();
                siguiente = actual.getSiguiente();

                // Caso: primer elemento es mayor.
                if (actual.compareTo(nodo.getEtiqueta()) > 0) {
                    
                    // Lo agrego primero a la lista
                    nodo.setSiguiente(actual);
                    this.primero = nodo;
                } 
                // Caso: de un sólo elemento y es menor
                else if (siguiente == null) {
                    
                    // Lo agrego como siguiente y último
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                    
                } 
                // Caso sólo dos elementos y estamos entre medio
                else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(siguiente);
                } 
                else {
                    
                    // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                    while (actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        siguiente = actual.getSiguiente();
                        
                        // Llegué al final de la lista, lo inserto al final
                        if (siguiente == null) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(null);
                            break;
                        } 
                        // Si actual es menor y el siguiente es mayor, encontré un hueco
                        else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                            
                            // Se inserta nodo en el hueco encontrado y dejo de recorrer la lista
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(siguiente);
                            break;
                        }
                    }
                }
            }
        }
    }
}
