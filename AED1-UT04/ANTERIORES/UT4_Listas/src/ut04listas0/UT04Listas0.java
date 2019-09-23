/*
 * LISTAS.
 */
package ut04listas0;

/**
 * @author mstabile.
 */
public class UT04Listas0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear una organización.
        Organizacion miEmpresa = new Organizacion();
        miEmpresa.setNombre("Addams Company");
        
        // Crear funcionarios y sus nodos.
        Persona func1 = new Persona("Morticia", "Addams", "14567893");
        func1.setEdad(22);
        
        Persona func2 = new Persona("Homero", "Addams", "25468791");
        func2.setEdad(22);
        
        Persona func3 = new Persona("Lucas", "Addams", "36549871");
        func3.setEdad(22);
        
        Persona func4 = new Persona("Merlina", "Addams", "16547893");
        func4.setEdad(22);
        
        INodo<Persona> nodoFunc1 = new Nodo (func1.getId(), func1);
        INodo<Persona> nodoFunc2 = new Nodo (func2.getId(), func2);
        INodo<Persona> nodoFunc3 = new Nodo (func3.getId(), func3);
        INodo<Persona> nodoFunc4 = new Nodo (func4.getId(), func4);

        // Insertar los funcionarios en la lista de la organización.
        miEmpresa.listaPersonas.insertar(nodoFunc1);
        miEmpresa.listaPersonas.insertar(nodoFunc2);
        miEmpresa.listaPersonas.insertar(nodoFunc3);
        miEmpresa.listaPersonas.insertar(nodoFunc4);
        
        // Imprimir funcionarios (nodos sin ordenar).
        miEmpresa.listaPersonas.imprimir();

        // Imprimir cantidad de personas en la empresa.
        System.out.println("Cantidad de funcionarios: " + miEmpresa.listaPersonas.cantElementos());

        // Eliminar con el método nuevo.
        System.out.println("Funcionario eliminado: " + miEmpresa.listaPersonas.eliminarRetornandoNodo("14567893"));

        // Imprimir cantidad de personas en la empresa.
        System.out.println("Cantidad de funcionarios: " + miEmpresa.listaPersonas.cantElementos());
    }
    
}
