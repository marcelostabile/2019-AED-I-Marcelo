import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
                
               
        TArbolAfiliado padron = new TArbolAfiliado();
        
         /**
         * Paso 1:
         *
         * a partir del archivo "padron.txt", cargarle al padron sus afiliados
         *
         */
        
                
        /**
         * Paso 2:
         *
         * 2.1 - a partir del archivo "historicas.txt", cargarle al afiliado las consultas historicas
         *
         */
       
              
       /**
         * Paso 3:
         *
         * obtener el arbol de especialidades
         *
         */
       
        TArbolBB arbolEspecialidad = padron.obtenerArbolEspecialidades();
        
        Lista<Especialidad> listaInorden = arbolEspecialidad.inorden();
        
        int cantElementos = listaInorden.cantElementos();
        
        String[] claves = new String[cantElementos + 1];
        int[] frecExito = new int[cantElementos + 1];
        int[] frecNoExito = new int[cantElementos+1];
        
        /**
        * Paso 4
        * acá rellenar vectores y  armar arbol optimo
        */
                       
              
         /**
        * Paso 5
        * mostrar el costo, el inorden y el preoden de el arbol optimo obtenido
        */
        
       
    }
}

