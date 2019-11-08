package TDALista;

public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        primero = null;
    }

    public Lista(Nodo<T> unNodo) {
        this.primero = unNodo;
    }

    @Override
    public void insertar(Nodo<T> unNodo) {
        if (esVacia()) {
            setPrimero(unNodo);
        } else {
            Nodo<T> aux = getPrimero();
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<T> aux = getPrimero();
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            Nodo aux = getPrimero();
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return getPrimero() == null;
    }

    @Override
    public Nodo<T> getPrimero() {
        return primero;
    }

    /**
     * @param primero the primero to set
     */
    public void setPrimero(Nodo<T> primero) {

        this.primero = primero;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        } else {
            Nodo<T> aux = getPrimero();
            if (this.primero.getEtiqueta().equals(clave)) {
                this.primero = this.primero.getSiguiente();
                return true;
            }
            while (aux.getSiguiente() != null) {
                if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                    Nodo<T> unNodo = aux.getSiguiente().getSiguiente();
                    aux.getSiguiente().setSiguiente(null);
                    aux.setSiguiente(unNodo);
                    return true;
                }
                aux = aux.getSiguiente();
            }
        }
        return false;

    }

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<T> temp = getPrimero();
            while (temp != null) {
                temp.imprimirEtiqueta();
                aux += temp.getEtiqueta() + " ";
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    @Override
    public String imprimir(String separador) {
        String aux;
        if (esVacia()) {
            return "";
        } else {
            Nodo<T> temp = getPrimero();
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public Nodo<T> quitarPrimero() {

        if (esVacia()) {
            System.out.println("Lista vacia");
            return null;
        } else {
            Nodo<T> aux = this.primero;
            this.primero = aux.getSiguiente();
            aux.setSiguiente(null);
            return aux;
        }
    }

    public void EliminarDuplicados() {
        Nodo<T> aux = this.primero;
        Lista<T> verif = new Lista<T>();
        while (aux != null) {
            if (verif.buscar(aux.getEtiqueta()) == null) {
                Nodo<T> nuevo = new Nodo(aux.getEtiqueta(), aux.getDato());
                verif.insertar(nuevo);
            }
            aux = aux.getSiguiente();

        }
        this.primero = verif.primero;
    }

    public void insertarPrincipio(Nodo<T> nodo) {
        if (primero == null) {
            primero = nodo;
        } else {
            nodo.setSiguiente(primero);
            primero = nodo;
        }
    }

    public void invertir() {
        Lista retorno = new Lista();

        while (primero != null) {
            retorno.insertarPrincipio(this.quitarPrimero());

        }
        primero = retorno.getPrimero();
    }

    public boolean insertarOrdenado(Nodo<T> unNodo) {
        Nodo auxiliar = primero;
        // Si la lista se encuentra vacia, entonces inserta el Nodo al principio.
        if (esVacia() == true) {
            primero = unNodo;
            return true;
        } else {
            while (auxiliar != null) {
                if (unNodo.compareTo(auxiliar.getEtiqueta()) <= 0) {//si es menor al primer elemento
                    unNodo.setSiguiente(primero);
                    primero = unNodo;
                    return true;
                } else if (unNodo.compareTo(auxiliar.getEtiqueta()) > 0 && auxiliar.getSiguiente() == null) {
                    //Si el elemento es mayor al ultimo elemento de la lista, se insertara al final.
                    auxiliar.setSiguiente(unNodo);
                    return true;
                } else {
                    //Si el elemento se encuentra en el medio de la lista.
                    if (unNodo.compareTo(auxiliar.getEtiqueta()) > 0 && unNodo.compareTo(auxiliar.getSiguiente().getEtiqueta()) <= 0) {
                        unNodo.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(unNodo);
                        return true;
                    }

                }
                auxiliar = auxiliar.getSiguiente();
            }
        }
        return false;
    }
    
    
}
