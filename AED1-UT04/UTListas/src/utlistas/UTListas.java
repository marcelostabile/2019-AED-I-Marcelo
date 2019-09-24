/*
 * UTListas
 */
package utlistas;

/**
 *
 * @author mstabile
 */
public class UTListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear lista.
        ILista<Persona> lista = new Lista<>();
        
        // Crear personas.
        Persona per1 = new Persona("Marcelo", "Stabile", "1");
        Persona per2 = new Persona("Juan", "Perez", "2");
        Persona per3 = new Persona("Jorge", "Lopez", "3");
        
        // Crear nodos.
        INodo<Persona> nodoP1 = new Nodo<>(per1.getId(), per1);
        INodo<Persona> nodoP2 = new Nodo<>(per2.getId(), per2);
        INodo<Persona> nodoP3 = new Nodo<>(per3.getId(), per3);
        
        // Insertar nodos en la lista.
        lista.insertarNodoOrdenado(nodoP1);
        lista.insertarNodoOrdenado(nodoP2);
        lista.insertarNodoOrdenado(nodoP3);
        
        //Imprimir por pantalla.
        lista.imprimir();
        
    }
}
