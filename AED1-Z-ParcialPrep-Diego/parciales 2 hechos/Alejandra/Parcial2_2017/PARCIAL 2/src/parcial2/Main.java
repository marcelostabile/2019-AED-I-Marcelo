package parcial2;

import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBBU ucu  = new TArbolBBU();
       // cargar los alumnos en el árbol "ucu" desde el archivo de datos "datos.csv"
        ucu.cargar("src/parcial2/Datos.csv");
        //System.out.println(ucu.obtenerTamaño());
        
                
        String laCarrera =  "Derecho";   // se indicará en el pizarrón
        
        TArbolBBU porCarrera = ucu.armarIndiceCarrera(laCarrera);
        //System.out.println(porCarrera.);
        System.out.println(porCarrera.obtenerTamaño());
        
        // escribir en el archivo "salida.txt" el listado emitido de los alumnos
        // de la carrera indicada, en orden alfabético ascendente
        
        
    }

   

}

