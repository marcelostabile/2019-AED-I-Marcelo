/*
 * Arrays 1
 */
package pkg01.arrays1;

/**
 *
 * @author Marcelo Stabile
 */
public class Arrays1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Crear array.
        String[] manoDerecha;
        
        // Dimencionamiento.
        manoDerecha = new String[5];
        
        // Asignación de valores.
        manoDerecha[0] = "Pulgar";
        manoDerecha[1] = "Indice";
        manoDerecha[2] = "Medio";
        manoDerecha[3] = "Anular";
        manoDerecha[4] = "Meñique";
        
        MostrarNombre(manoDerecha, 5);
        MostrarNombre(manoDerecha, 4);
        MostrarNombre(manoDerecha, 3);
        MostrarNombre(manoDerecha, 2);
        MostrarNombre(manoDerecha, 1);
    }
    
    private static void MostrarNombre(String[] mano, int NroDedo) { 
        
        // Mostrar nombre del dedo indicado.
        // Se pasa el nro del 1 al 5, para coincidir con el indice, resto 1.
        System.out.println(mano[NroDedo-1]);
    }
}
