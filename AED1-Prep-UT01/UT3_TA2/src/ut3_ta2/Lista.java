/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_ta2;

/**
 *
 * @author Grupo 1
 */
public class Lista<E> implements ILista<E> {

    private INodo<E> primero;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(INodo<E> nodo) {
        if (esVacia()) {
            primero = nodo;
        } else {
            INodo aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
    }

    @Override
    public INodo buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            INodo aux = primero;
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
        INodo aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            INodo temp1 = aux;
            INodo temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
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

    @Override
    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            INodo temp = primero;
            while (temp != null) {
                temp.imprimir();
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
            INodo temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    public INodo getPrimero() {
        return primero;
    }

    public void setPrimero(INodo unNodo) {
        this.primero = unNodo;
    }

    public INodo quitarPrimero() {
        INodo aux;
        INodo x = null;
        aux = getPrimero();
        if (!esVacia()) {
            x = getPrimero();
            eliminar((Comparable) aux);
        }
        return x;
    }

    @Override
    public void insertarOrdenado(INodo<E> unNodo) {
        INodo<E> actual;
        INodo<E> siguiente;

        // Si la lista está vacía, lo defino como primero
        if (this.esVacia()) {
           this.setPrimero(unNodo);
        }
        else {
            // Valido que no exista ya el nodo
            actual = this.getPrimero();
            siguiente = actual.getSiguiente();

            // Caso primer elemento ya es mayor
            if (actual.compareTo(unNodo.getEtiqueta()) > 0) {
                // Lo agrego primero a la lista
                unNodo.setSiguiente(actual);
            }
            // Caso de un sólo elemento y es menor
            else if (siguiente == null) {
                // Lo agrego como siguiente y último
                actual.setSiguiente(unNodo);
                unNodo.setSiguiente(null);
            }
            // Caso sólo dos elementos y estamos entre medio
            else if (actual.compareTo(unNodo.getEtiqueta()) < 0 && siguiente.compareTo(unNodo.getEtiqueta()) > 0) {
                actual.setSiguiente(unNodo);
                unNodo.setSiguiente(siguiente);
            }
            else {
                // Recorro la lista y voy comparando hasta encontrar un hueco o llegar al final
                while(actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                    siguiente = actual.getSiguiente();
                    // Llegué al final de la lista, lo inserto al final
                    if (siguiente == null) {
                        actual.setSiguiente(unNodo);
                        unNodo.setSiguiente(null);
                    }
                    // Si actual es menor y el siguiente es mayor, encontré un hueco
                    else if (actual.compareTo(unNodo.getEtiqueta()) < 0 && siguiente.compareTo(unNodo.getEtiqueta()) > 0) {
                        // Se inserta unNodo en el hueco encontrado y dejo de recorrer la lista
                        actual.setSiguiente(unNodo);
                        unNodo.setSiguiente(siguiente);
                        break;
                    }
                }
            }
        }
    }
    
        public boolean insertarOrdenadoNombre(INodo<E> nodo)
    {
        boolean insertado = false;
        if (this.primero == null)
        {
            this.primero = nodo;
            insertado = true;
        } else if (this.primero.getEtiqueta().compareTo(nodo.getEtiqueta()) == 1)
            {
                nodo.setSiguiente(this.primero);
                this.primero=nodo;
                insertado = true;
            } else 
                {
                    INodo aux = this.primero;
                    while (aux.getSiguiente()!= null && nodo.getEtiqueta().compareTo(this.primero.getEtiqueta()) == -1 )
                        aux = aux.getSiguiente();
                    
                    nodo.setSiguiente(aux.getSiguiente());
                    aux.setSiguiente(nodo);
                   insertado = true;
                }
        
       
       return insertado;
    }
}
