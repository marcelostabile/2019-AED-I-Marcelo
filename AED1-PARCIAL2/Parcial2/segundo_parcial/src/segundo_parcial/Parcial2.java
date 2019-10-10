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
         * MANEJADOR DE ARCHIVOS.
         */
        String CarpetaDeTrabajo = "src/segundo_parcial/";

        IManejadorArchivosGenerico ManejadorArchivos = new ManejadorArchivosGenerico();

        /**
         * CARGAR LISTA DE AFILIADOS.
         */
        Lista<Afiliado> listaAfiliados = new Lista<>();
        
        // Cargar archivo padron.txt
        String[] lineasArchivo1 = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "padron.txt");

        for (String linea : lineasArchivo1) {

            String[] c = linea.split(",");
            // Crear el afiliado.
            Afiliado afiliadoNuevo = new Afiliado(Integer.parseInt(c[0]), c[1], c[2]);
            // Crear el nodo.
            Nodo<Afiliado> nodoNuevo = new Nodo(afiliadoNuevo.getCedula(), afiliadoNuevo);
            // Insertar nodo en la lista.
            listaAfiliados.insertar(nodoNuevo);
        }
        
        // probando.
        System.out.println(listaAfiliados.cantElementos());
        
        /**
         * CARGAR CONSULTAS AGENDADAS.
         */
        String[] lineasAgendadas = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "agendadas.txt");
        
        for (String linea : lineasAgendadas) {

            String[] c = linea.split(",");
            // CI
            String afiliadoCI = c[0];
            // Fecha
            String fecha = c[1];
            // Especialidad
            String especialidad = c[2];
            // Médico
            int medicoCI = Integer.parseInt(c[3]);
            // Resultado
            int resultadoId = Integer.parseInt(c[4]);
            
            // Crear la consulta.
            Consulta consultaAux = new Consulta(fecha, especialidad, medicoCI, resultadoId);
            // Buscar afiliado en la lista de afiliados.
            Nodo<Afiliado> nodoAfiliado = listaAfiliados.buscar(afiliadoCI);
            // Cargar la consulta en el afiliado (si lo encontró).
            if (nodoAfiliado != null) { 
                nodoAfiliado.getDato().cargarConsultaPendiente(consultaAux);
            }
        }

        /**
         * CARGAR CONSULTAS HISTÓRICAS.
         */
        String[] lineasHisto = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "historicas.txt");
        
        for (String linea : lineasHisto) {
            
            String[] c = linea.split(",");
            // CI
            String afiliadoCI = c[0];
            // Fecha
            String fecha = c[1];
            // Especialidad
            String especialidad = c[2];
            // Médico
            int medicoCI = Integer.parseInt(c[3]);
            // Resultado
            int resultadoId = Integer.parseInt(c[4]);

            // Crear la consulta.
            Consulta consultaAux = new Consulta(fecha, especialidad, medicoCI, resultadoId);
            // Buscar afiliado en la lista de afiliados.
            Nodo<Afiliado> nodoAfiliado = listaAfiliados.buscar(afiliadoCI);
            // Cargar la consulta en el afiliado (si lo encontró).
            if (nodoAfiliado != null) { 
                nodoAfiliado.getDato().cargarConsultaHistorica(consultaAux);
            }
        }

        /**
         * ÁRBOL PARA EL PADRON AFILIADOS.
         */
        TArbolPadronAfiliados padronAfiliados = new TArbolPadronAfiliados();

        // Cargar el árbol a partir de la lista de afiliados.
        padronAfiliados.cargarDesdeLista(listaAfiliados);
        
        
        // probando con afiliado 974192.
        // System.out.println(padronAfiliados.buscar(974192).getDatos().getNombre());
        
    }
}
