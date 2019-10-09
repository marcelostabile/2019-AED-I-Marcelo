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
         * PADRON AFILIADOS.
         */
        TArbolPadronAfiliados padronAfiliados = new TArbolPadronAfiliados();
        
        /**
         * LISTA DE AFILIADOS.
         */
        Lista<Afiliado> listaAfiliados = new Lista<>();

        String CarpetaDeTrabajo = "src/segundo_parcial/";

        IManejadorArchivosGenerico ManejadorArchivos = new ManejadorArchivosGenerico();
        
        String[] lineasArchivo1 = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "padron.txt");

        for (String linea : lineasArchivo1) {

            String[] c = linea.split(",");
            
            IAfiliado afiliadoNuevo = new Afiliado(Integer.parseInt(c[0]), c[1], c[2]);
            
            Nodo<Afiliado> nodoNuevo = new Nodo(afiliadoNuevo.getCedula(), afiliadoNuevo);
            
            listaAfiliados.insertar(nodoNuevo);
        }
        
        /**
         * CARGAR CONSULTAS.
         */
        String[] lineasAgendadas = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "agendadas.txt");

        // Etiqueta del nodo de consulta.
        int id1 = 0;
        
        for (String linea : lineasAgendadas) {
            
            String[] c = linea.split(",");
            String afiCI = c[0];
            String fecha = c[1];
            int medicoCI = Integer.parseInt(c[3]);
            int resultadoId = Integer.parseInt(c[4]);
            Consulta conAux = new Consulta(afiCI, fecha, medicoCI, resultadoId);

//            INodo<Consulta> nodoConsulta = new Nodo(id1, conAux);
//            id1 += 1;

            // Buscar afiliado en el padron cargado.
            Nodo<Afiliado> nodoAfi = listaAfiliados.buscar(afiCI);
            
            if (nodoAfi != null) { 
                nodoAfi.getDato().cargarConsultaPendiente(conAux);
            }
        }
        
        /**
         * CARGAR CONSULTAS.
         */
        String[] lineasHisto = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + "historicas.txt");

        // Etiqueta del nodo de consulta.
//        int id2 = 0;
        
        for (String linea : lineasHisto) {
            
            String[] c = linea.split(",");
            String afiCI = c[0];
            String fecha = c[1];
            int medicoCI = Integer.parseInt(c[3]);
            int resultadoId = Integer.parseInt(c[4]);
            Consulta conAux = new Consulta(afiCI, fecha, medicoCI, resultadoId);

//            INodo<Consulta> nodoConsulta = new Nodo(id1, conAux);
//            id1 += 1;

            // Buscar afiliado en el padron cargado.
            INodo<Afiliado> nodoAfi = listaAfiliados.buscar(afiCI);
            
            if (nodoAfi != null) { 
                nodoAfi.getDato().cargarConsultaHistorica(conAux);
            }
        }
        
        /**
         * CARGAR PADRON
         */
         padronAfiliados.cargarDesdeLista(listaAfiliados);
         
         /**
          * IMPRIMIR INORDEN
          */
         
         
         
    }
    
}
