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
        System.out.println("");
        
        // Buscar en etiqueta. Imprimir el resultado.
        INodo<Persona> resPer1 = lista.buscar("2");
        resPer1.imprimir();
        System.out.println("");
        
        Persona persona1 = resPer1.getDato();
        System.out.println("Nombre: " + persona1.getNombre() + " " + persona1.getApellido());
        System.out.println("");
        
        // Eliminar un nodo.
        lista.eliminar("2");
        lista.imprimir();
        System.out.println("");
        
        // Modificar el nombre del nodo. 1 cambia su apellido a Gonzalez.
        
        // Creo un nodo con la persona buscada.
        INodo<Persona> resPer2 = lista.buscar("1");
        resPer2.getDato().setApellido("Gonzalez");
        System.out.println("Cambio apellido: " + resPer2.getDato().getNombre() + " " + resPer2.getDato().getApellido());
        System.out.println("");
        
    }
}
