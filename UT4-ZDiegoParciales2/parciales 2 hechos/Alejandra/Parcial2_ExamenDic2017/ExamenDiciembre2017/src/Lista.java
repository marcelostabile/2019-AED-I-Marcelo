
public class Lista<E> implements ILista<E> {

    private Nodo<E>  primero;

    public Lista() {
        primero = null;
    }

    public Lista(Nodo<E> unNodo) {
        this.primero = unNodo;
    }

    public void insertar(Nodo<E> unNodo) {
        if (esVacia()) {
            primero = unNodo;
        } else {
            Nodo<E> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unNodo);
        }
    }

    public Nodo<E> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            Nodo<E> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        Nodo<E> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            Nodo<E> temp1 = aux;
            Nodo<E> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                Nodo<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            Nodo<E> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                aux += temp.getEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            Nodo<E> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

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

    public boolean esVacia() {
        return primero == null;
    }

    public Nodo<E> getPrimero() {
        return primero;
    }

    public void Ordenar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Nodo<E> quitarPrimero() {
        Nodo tempNodo = getPrimero();
        if (tempNodo != null) {
            this.primero = tempNodo.getSiguiente();
            tempNodo.setSiguiente(null);
        }
        return tempNodo;
    }

 
}