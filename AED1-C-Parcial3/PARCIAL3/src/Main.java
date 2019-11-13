import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
                
        // Árbol para el padrón de afiliados.       
        TArbolAfiliado padron = new TArbolAfiliado();
        
         /**
         * Paso 1:
         *
         * a partir del archivo "padron.txt", cargarle al padron sus afiliados
         *
         */
        ManejadorArchivosGenerico mag = new ManejadorArchivosGenerico();
        
        // Leer el archivo y cargarlo en un array.
        String archPadron = "src/padron.txt";
        
        String[] lineasPadron = mag.leerArchivo(archPadron);
        
        // Recorrer linea a linea el array, obtener los datos separados por coma.
        // Crear afiliado, crear TElementoAB, insertar el elemento en árbol Padrón.
        for (String linea : lineasPadron) {
            
            String[] datos = linea.split(",");
            Afiliado afiliado = new Afiliado(Integer.valueOf(datos[0]), datos[1], datos[2]);
            TElementoAB<Afiliado> elAfiliado = new TElementoAB(datos[0], afiliado);
            padron.insertar(elAfiliado);
        }
                
        /**
         * Paso 2:
         *
         * 2.1 - a partir del archivo "historicas.txt", cargarle al afiliado las consultas historicas
         *
         */
        // Leer el archivo y cargarlo en un array.
        String archivoHistoricas = "src/historicas.txt";
        
        String[] lineasHistoricas = mag.leerArchivo(archivoHistoricas);

        // Recorrer el array, obtener los datos de la consulta para cada linea.
        // Crear la consulta, buscar en el padrón al afiliado, si existe: cargar la consulta histórica.
        for (String linea : lineasHistoricas) {
            String[] datos = linea.split(",");
            Consulta auxHistorica = new Consulta(datos[1], datos[2], Integer.valueOf(datos[3]), Integer.valueOf(datos[4]));
            if (padron.buscar(datos[0]) != null) {
                padron.buscar(datos[0]).getDatos().cargarConsultaHistorica(auxHistorica);
            }
        }
              
       /**
         * Paso 3:
         *
         * obtener el arbol de especialidades
         *
         */
       
        TArbolBB arbolEspecialidad = padron.obtenerArbolEspecialidades();
        
        Lista<Especialidad> listaInorden = arbolEspecialidad.inorden();
        
        int cantElementos = listaInorden.cantElementos();
        
        System.out.println("Cantidad de Especialidades: " + cantElementos);
        
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

