/*
 * 
 * Lista Encadenada 1
 */
package pkg02.listaencadenada1;

/**
 *
 * @author Marcelo Stabile
 */
public class ListaEncadenada1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Instanciamos nodos nuevos.
        Nodo nodo1 = new Nodo(1, null);
        Nodo nodo2 = new Nodo(2, null);
        Nodo nodo3 = new Nodo(3, null);
        
        // Los nodos no están enlazados.
        // Imprimimos su valor.
        System.out.println(nodo1);
        System.out.println(nodo2);
        System.out.println(nodo3);
        
        // Enlazamos los nodos.
        nodo1.prox = nodo2;
        nodo2.prox = nodo3;
        nodo3.prox = null;
        
        // Imprimimos lista con el método WHILE.
        System.out.println("Imprimimos lista con el método WHILE.");
        imprimirLista(nodo1);
        
        // Imprimir inverso.
        imprimirListaInverso(nodo1);
    }

    private static void imprimirLista(Nodo lista) {
        
        // Declaramos nodo según lista.
        Nodo nodo = lista;
        
        // Imprimimos lista.
        // Declaramos que nodo pasa a ser el próximo nodo.
        while (nodo != null) {
            
            System.out.println(nodo);
            nodo = nodo.prox;
        }
        // Imprimimos un espacio en blanco.
        System.out.println();
    }
    
    private static void imprimirListaInverso(Nodo lista) {
        
        // Si la lista está vacía, no hace nada.
        if (lista == null) return;
        
        // Separar CABEZA y COLA.
        Nodo cabeza = lista;
        Nodo cola = lista.prox;
        
        // Imprimir inverso.
        imprimirListaInverso(cola);
        System.out.println(cabeza); 
    }
}
