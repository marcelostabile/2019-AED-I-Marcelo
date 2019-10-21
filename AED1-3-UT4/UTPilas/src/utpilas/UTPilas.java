/*
 * UTPilas
 */
package utpilas;

/**
 *
 * @author mstabile
 */
public class UTPilas {

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
        Persona per4 = new Persona("Ana", "Martinez", "4");
        Persona per5 = new Persona("Lorena", "Gonzales", "5");
        Persona per6 = new Persona("Pedro", "Gomez", "6");
        Persona per7 = new Persona("Lorenzo", "Rodriguez", "7");
        Persona per8 = new Persona("Fernando", "Dominguez", "8");
        Persona per9 = new Persona("Pablo", "Fernandez", "9");

        // Crear nodos.
        INodo<Persona> nodoP1 = new Nodo<>(per1.getId(), per1);
        INodo<Persona> nodoP2 = new Nodo<>(per2.getId(), per2);
        INodo<Persona> nodoP3 = new Nodo<>(per3.getId(), per3);
        INodo<Persona> nodoP4 = new Nodo<>(per4.getId(), per4);
        INodo<Persona> nodoP5 = new Nodo<>(per5.getId(), per5);
        INodo<Persona> nodoP6 = new Nodo<>(per6.getId(), per6);
        INodo<Persona> nodoP7 = new Nodo<>(per7.getId(), per7);
        INodo<Persona> nodoP8 = new Nodo<>(per8.getId(), per8);
        INodo<Persona> nodoP9 = new Nodo<>(per9.getId(), per9);

        // Insertar nodos en la lista.
        lista.insertarNodoOrdenado(nodoP1);
        lista.insertarNodoOrdenado(nodoP2);
        lista.insertarNodoOrdenado(nodoP3);
        lista.insertarNodoOrdenado(nodoP4);
        lista.insertarNodoOrdenado(nodoP5);
        lista.insertarNodoOrdenado(nodoP6);
        lista.insertarNodoOrdenado(nodoP7);
        lista.insertarNodoOrdenado(nodoP8);
        lista.insertarNodoOrdenado(nodoP9);

        //Imprimir la lista por pantalla.
        lista.imprimir();
        System.out.println("");

        // Crear una pila.
        IPila<Persona> pilaPersonas = new Pila<>();

        // Buscar en lista los id 2, 4, 6, 8; y apilarlos en la pila con el menor arriba.
        pilaPersonas.apilar(nodoP8);
        pilaPersonas.apilar(nodoP6);
        pilaPersonas.apilar(nodoP4);
        pilaPersonas.apilar(nodoP2);

        // Desapilarlos uno a uno e ir imprimiendo por pantalla los resultados.
        System.out.println("IMPRIMIR EN ORDEN (2,4,6,8)");
        System.out.println("");
        
        System.out.println("2: " + pilaPersonas.desapilar().getDato().getId());
        System.out.println("4: " + pilaPersonas.desapilar().getDato().getId());
        System.out.println("6: " + pilaPersonas.desapilar().getDato().getId());
        System.out.println("8: " + pilaPersonas.desapilar().getDato().getId());
        
    }
}
