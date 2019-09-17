/*
 * CLASE LISTA.
 */
package ut04listas0;

/**
 * @author EQUIPO.
 */
public class Lista<T> implements ILista<T> {

    // Atributo.
    private INodo<T> primero;

    // Constructor.
    public Lista() {
        primero = null;
    }
    
    // Insertar.
    @Override
    public void insertar(INodo<T> nodoNuevo) {
        if (esVacia()) {
            primero = nodoNuevo;
        } 
        else {
            INodo nodoAux = primero;
            
            while (nodoAux.getSiguiente() != null) {
                nodoAux = nodoAux.getSiguiente();
            }
            nodoAux.setSiguiente(nodoNuevo);
        }
    }
    
    // Buscar.
    @Override
    public INodo buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } 
        else {
            INodo nodoAux = primero;
            
            while (nodoAux != null) {
                if (nodoAux.getEtiqueta().equals(clave)) {
                    return nodoAux;
                }
                nodoAux = nodoAux.getSiguiente();
            }
        }
        return null;
    }
    
    // Eliminar.
    @Override
    public boolean eliminar(Comparable clave) {
        // Caso de lista vacía.
        if (esVacia()) {
            return false;
        }
        // Caso donde solo hay un primero y es la clave buscada.
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        
        INodo nodoAux = primero;

        // Caso donde primero es la clave buscada y hay otros elementos.        
        if (nodoAux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            INodo temp1 = nodoAux;
            INodo temp = nodoAux.getSiguiente();
            primero = temp;
            return true;
        }
        
        // Caso el elemento está en la lista y no es el primero.
        while (nodoAux.getSiguiente() != null) {
            if (nodoAux.getSiguiente().getEtiqueta().equals(clave)) {
                INodo temp = nodoAux.getSiguiente();
                nodoAux.setSiguiente(temp.getSiguiente());
                return true;
            }
            nodoAux = nodoAux.getSiguiente();
        }
        
        return false;
    }

    /** 
     * Eliminar retornando el nodo eliminado.
     */
    public INodo eliminarRetornandoNodo(Comparable etiqueta) {

        // Caso: la lista está vacía o la etiqueta no está en la lista.
        if (primero == null || buscar(etiqueta) == null) {
            return null;
        }
        
        // Caso: primero coincide con la búsqueda.
        if (primero.getEtiqueta().equals(etiqueta)) {
            
            // Hago un clon de "primero".
            INodo nodoAux = new Nodo(primero.getEtiqueta(), primero.getDato());
            
            // Si es único, elimino "primero". Sino el siguiente pasa a la cabecera.
            if (primero.getSiguiente() == null) {
                primero = null;
            }
            else {
                primero = nodoAux.getSiguiente();
                nodoAux.setSiguiente(null);
            }
            // Devuelvo el nodo eliminado.
            return nodoAux;
        } 
        else {
        // Caso: el elemento está en el resto de la lista.
        
            // Recorro la lista hasta encontrarlo y eliminarlo.
            INodo nodoActual = primero;
            INodo nodoAux = null;
            
            while(nodoActual != null) { 
                if (nodoActual.getSiguiente().getEtiqueta().equals(etiqueta)) { 
                    nodoAux = new Nodo(nodoActual.getSiguiente().getEtiqueta(), nodoActual.getSiguiente().getDato());
                    nodoActual.setSiguiente(nodoAux.getSiguiente());
                    nodoAux.setSiguiente(null);
                }
                nodoActual = nodoActual.getSiguiente();
            }
            // Devuelvo el nodo eliminado.
            return nodoAux;
        }
    }
    
    // Devuelve si la lista está vacía.
    @Override
    public boolean esVacia() {
        return primero == null;
    }
    
    // Devuelve la cantidad de elementos.
    @Override
    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            //System.out.println("Cantidad de elementos 0.");
            return 0;
        } 
        else {
            INodo aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }
    
    // Devuelve el primer elemento.
    @Override
    public INodo getPrimero() {
        return primero;
    }


    // Imprime en consola las claves de los nodos contenidos en la lista.
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

    // Devuelve un String con las claves separadas por el separador de parámetro.
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

//    /**
//     * Insertar ordenado por SELECCIÓN DIRECTA.
//     * 
//     * @param unNodo
//     */
//    public void insertarOrdenadoSeleccionDirecta(INodo<T> unNodo);
//
//    /**
//     * Insertar ordenado por INSERCIÓN DIRECTA.
//     * 
//     * @param unNodo
//     */
//    public void insertarOrdenadoInsercionDirecta(INodo<T> unNodo);
//
//    /**
//     * Retornar una lista nueva con estos elementos ordenada por clave.
//     */
//    public ILista<T> reordenarListaPorClave();
//
//    /**
//     * Retornar una lista nueva con estos elementos ordenada por un campo del dato.
//     * En este ejemplo, nombre del elemento.
//     */
//    public ILista<T> reordenarListaPorDatoNombre();
    
}
