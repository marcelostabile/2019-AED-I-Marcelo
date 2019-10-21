/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segundo_parcial;

/**
 *
 * @author Bernardo Rychtenberg
 */
public class Parcial2 {
    
    public static void main(String[] args){
        
        // 1) Instanciar y cargar los afiliados a una lista de afiliados desde padron.txt. 
        // 2) Instanciar y cargar las consultas a partir de los archivos historicos.txt y agendadas.txt
        // 3) Aplicar el método de carga de afiliados a partir de una lista (invocando el método cargarDesdeLista)
        // 3.1) Imprimir por pantalla la recorrida in orden del árbol resultante. 
        // 4) Aplicar el método obtenerConsultasDelDia para obtener las consultas del día de la fecha. 
        // 4.1) Descargar a un archivo el resultado de la recorrida del árbol resultante in orden.
        // 5) Obtener la cantidad de consultas en el día e imprimirla por pantalla.
        
        /**
         * 1) Instanciar y cargar los afiliados a una lista de afiliados desde padron.txt. 
         * 
         */
        
        String CarpetaDeTrabajo = "src/segundo_parcial/";

        IManejadorArchivosGenerico ManejadorArchivos = new ManejadorArchivosGenerico();

        // Lista para los afiliados.
        Lista<Afiliado> listaAfiliados = new Lista<>();
        
        // Cargar archivo padron.txt
        String[] lineasArchivo1 = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "padron.txt");

        for (String linea : lineasArchivo1) {
            String[] c = linea.split(",");
            
            // Crear el afiliado, el nodo y insertar en la lista.
            Afiliado afiliadoNuevo = new Afiliado(Integer.parseInt(c[0]), c[1], c[2]);
            Nodo<Afiliado> nodoNuevo = new Nodo(afiliadoNuevo.getCedula(), afiliadoNuevo);
            listaAfiliados.insertar(nodoNuevo);
        }
        
        /**
         * 2) Instanciar y cargar las consultas a partir de los archivos historicos.txt y agendadas.txt
         * 
         */

        // Cargar consultas agendadas.
        String[] lineasAgendadas = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "agendadas.txt");
        
        for (String linea : lineasAgendadas) {
            String[] c = linea.split(",");
            
            Integer afiliadoCI = Integer.parseInt(c[0]);        // CI
            String fecha = c[1];                                // Fecha
            String especialidad = c[2];                         // Especialidad
            int medicoCI = Integer.parseInt(c[3]);              // Médico CI
            int resultadoId = Integer.parseInt(c[4]);           // Resultado
            
            // Crear la consulta y buscar afiliado en la lista de afiliados.
            Consulta consultaAux = new Consulta(fecha, especialidad, medicoCI, resultadoId);
            
            Nodo<Afiliado> nodoAfiliado = listaAfiliados.buscar(afiliadoCI);
            
            // Si el afiliado existe, se carga la consulta en su lista de pendientes.
            if (nodoAfiliado != null) { 
                nodoAfiliado.getDato().cargarConsultaPendiente(consultaAux);
            }
        }

        // Cargar consultas históricas.
        String[] lineasHisto = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "historicas.txt");
        
        for (String linea : lineasHisto) {
            String[] c = linea.split(",");
            
            Integer afiliadoCI = Integer.parseInt(c[0]);        // CI
            String fecha = c[1];                                // Fecha
            String especialidad = c[2];                         // Especialidad
            int medicoCI = Integer.parseInt(c[3]);              // Médico CI
            int resultadoId = Integer.parseInt(c[4]);           // Resultado

            // Crear la consulta y buscar el afiliado en la lista de afiliados.
            Consulta consultaAux = new Consulta(fecha, especialidad, medicoCI, resultadoId);

            Nodo<Afiliado> nodoAfiliado = listaAfiliados.buscar(afiliadoCI);

            // Si el afiliado existe, se carga la consulta en su lista de históricos.
            if (nodoAfiliado != null) { 
                nodoAfiliado.getDato().cargarConsultaHistorica(consultaAux);
            }
        }

        /**
         * 3) Aplicar el método de carga de afiliados a partir de una lista (invocando el método cargarDesdeLista)
         * 
         */
        
        // Árbol para el padrón de afiliados.
        TArbolPadronAfiliados elPadron = new TArbolPadronAfiliados();

        // Cargar el árbol a partir de la lista de afiliados.
        TArbolPadronAfiliados arbolAfiliados = elPadron.cargarDesdeLista(listaAfiliados);
        
        /**
         * 3.1) Imprimir por pantalla la recorrida in orden del árbol resultante. 
         * 
         */
        
        System.out.println("Afiliados (inOrden): " + arbolAfiliados.inOrden() + "\n");
        
        /**
         * 4) Aplicar el método obtenerConsultasDelDia para obtener las consultas del día de la fecha. 
         * 
         */

        // Creo un árbol para los afiliados con consultas del día.
        TArbolBB<Afiliado> consultasDelDia = arbolAfiliados.obtenerConsultasDelDia("20191008");
        
        System.out.println("Consultas del día (inOrden): " + consultasDelDia.inOrden() + "\n");
        
        /**
         * 4.1) Descargar a un archivo el resultado de la recorrida del árbol resultante in orden.
         * 
         */

        // Cargo la lista con los elementos del recorrido en inorden.
        Lista<Afiliado> listaDescarga = consultasDelDia.inorden();
        
        // Tomo el primer nodo de la lista. Recorro la lista y la voy escribiendo en el archivo.
        Nodo<Afiliado> nodoActual = listaDescarga.getPrimero();
        
        while (nodoActual != null) { 

            String[] arregloLineas = new String[1];

            arregloLineas[0] =  Integer.toString(nodoActual.getDato().getCedula());
                
            ManejadorArchivos.escribirArchivo(CarpetaDeTrabajo + "AfiliadosConsultasDelDia.txt", arregloLineas);

            nodoActual = nodoActual.getSiguiente();
        }
        
        /**
         * 5) Obtener la cantidad de consultas en el día e imprimirla por pantalla.
         * 
         */
        System.out.println("Cantidad de consultas del día: " + arbolAfiliados.cantidadConsultasdelDia());
        
    }
}
