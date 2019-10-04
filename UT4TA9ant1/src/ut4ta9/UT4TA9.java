/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4ta9;

/**
 *
 * @author estudiante.fit
 */
public class UT4TA9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * Instanciamos el hospital.
         */
        IArbolBB<IAfiliado> padronAfiliados = new TArbolBB();

        /**
         * MANEJADOR DE ARCHIVOS.
         */
        // Definir la carpeta de los archivos.
        String workFolder = "src/ut4ta9/";

        // Definir los archivos de trabajo.
        String arch1 = workFolder + "padron.txt";
        String arch2 = workFolder + "historicas.txt";
        String arch3 = workFolder + "agendadas2.txt";

        // Instanciar el manejador de archivos.
        IManejadorArchivos manejadorArchivos = new ManejadorArchivosGenerico();

        /**
         * ARCHIVO 1. padron
         */
        // Leer el archivo y retornar un array.
        // Cambiando esta linea seleccionamos el archivo que queremos usar (arch1, arch2 o arch3).
        String[] lineasArchivo1 = manejadorArchivos.leerArchivo(arch1);

        // Para cada registro en el array.
        for (String linea1 : lineasArchivo1) {

            // Creo un elemento con cada linea y lo inserto en el árbol.
            TElementoAB unElemento1 = new TElementoAB(linea1, linea1);
            padronAfiliados.insertar(unElemento1);
        }

        /**
         * ARCHIVO 2. agendadas
         */
        String[] lineasArchivo2 = manejadorArchivos.leerArchivo(arch2);

        // Etiqueta del nodo de consulta.
        int id1 = 0;

        for (String linea2 : lineasArchivo2) {
            String[] c = linea2.split(",");
            String afiCI = c[0];
            int resultadoId = Integer.parseInt(c[4]);
            IConsulta conAux = new Consulta(c[1], c[2], Integer.parseInt(c[3]), resultadoId);

            // Creo un nodo de tipo consulta (para luego agregarlo a la lista).
            INodo<IConsulta> nodoConsulta = new Nodo(id1, conAux);
            id1 += 1;

            // Buscar afiliado en el padron cargado.
            IElementoAB<IAfiliado> nodoAfi = padronAfiliados.buscar(afiCI);

            // Si existe el afiliado, ingresar la consulta en la lista de consultas.
            if (nodoAfi != null) {
                ILista<IConsulta> afiliadoConsultasAnotadas = nodoAfi.getDatos().getConsultasAgendadas();
                afiliadoConsultasAnotadas.insertar(nodoConsulta);
            }
        }

        /**
         * Cargar listas de consultas históricas.
         */
        String[] lineasHisto = manejadorArchivos.leerArchivo(arch3);

        // Etiqueta del nodo de consulta.
        int id2 = 0;

        for (String linea : lineasHisto) {

            String[] c = linea.split(",");

            // Cédula del afiliado, Id del Resultado y Creación de Consulta.
            String afiCI = c[0];//Integer.parseInt(c[0]);
            int resultadoId = Integer.parseInt(c[4]);
            IConsulta conAux = new Consulta(c[1], c[2], Integer.parseInt(c[3]), resultadoId);

            // Creo un nodo de tipo consulta (para luego agregarlo a la lista).
            INodo<IConsulta> nodoConsulta = new Nodo(id2, conAux);
            id2 += 1;

            // Buscar afiliado en el padron cargado.
            IElementoAB<IAfiliado> nodoAfi = padronAfiliados.buscar(afiCI);

            // Si existe el afiliado, ingresar la consulta en la lista de consultas.
            if (nodoAfi != null) {
                ILista<IConsulta> afiliadoConsultasHistoricas = nodoAfi.getDatos().getConsultasHistoricas();
                afiliadoConsultasHistoricas.insertar(nodoConsulta);
            }
        }

        /**
         * EJECUTANDO LA ACTUALIZACIÓN DE CONSULTAS.
         */
        Lista<IAfiliado> padronDeudores = new Lista();
    
        padronAfiliados.inOrden(padronDeudores);
        
        System.out.println(padronDeudores.cantElementos());
        

//        /**
//         * Imprimir estadisticas finales.
//         */
//        totalConAnotadas = 0;
//        totalConHistoricas = 0;
//
//        nodoAfiliado = padronAfiliados.padronAfiliados.getPrimero();
//        while (nodoAfiliado != null) {
//            
//            // Obtener consultas del afiliado.
//            ILista<IConsulta> listaConsultasAnotadas = nodoAfiliado.getDato().getConsultasAnotadas();
//            ILista<IConsulta> listaConsultasHistoricas = nodoAfiliado.getDato().getConsultasHistoricas();
//
//            // Sumar en el total de consultas.
//            totalConAnotadas += listaConsultasAnotadas.cantElementos();
//            totalConHistoricas += listaConsultasHistoricas.cantElementos();
//            
//            nodoAfiliado = nodoAfiliado.getSiguiente();
//        }
//        
//        /**
//         * deudores
//         */
//        
//        // Tomo el primer nodo de la lista padronDeudores.
//        INodo<IAfiliado> nodoAfiliadoDeudor = padronDeudores.getPrimero();
//        
//        // Recorro la lista de deudores.
//        while (nodoAfiliadoDeudor != null) {
//        
//            // Afiliado.
//            IAfiliado afiliadoDeudor = nodoAfiliadoDeudor.getDato();
//            
//            // Historicas del afiliado.
//            ILista<IConsulta> afiliadoConsultasHistoricas = nodoAfiliadoDeudor.getDato().getConsultasHistoricas();
//            
//            // Tomo la primer consulta.
//            INodo<IConsulta> nodoConsulta = afiliadoConsultasHistoricas.getPrimero();
//            
//            // Recorro todas sus consultas.
//            while (nodoConsulta != null) { 
//            
//                System.out.println("CI: " + afiliadoDeudor.getCedula() + 
//                        " Fecha: " + nodoConsulta.getDato().getFechaConsulta() + 
//                        " (" + afiliadoDeudor.getNombre() + " " + afiliadoDeudor.getApellido() + ")");
//                
//                nodoConsulta = nodoConsulta.getSiguiente();
//            }
//            
//            nodoAfiliadoDeudor = nodoAfiliadoDeudor.getSiguiente();
//        }
//        System.out.println("Cant. de Deudores: " + padronDeudores.cantElementos());
//        System.out.println();
//
//        /**
//         * AFILIADOS POR ESPECIALIDAD.
//         */
//        String especialidad = "Dermatologia";
//        
//        System.out.println("AFILIADOS POR ESPECIALIDAD: " + especialidad);
//        System.out.println();
//        
//        ILista<IAfiliado> afiliadosPorEspecialidad = padronAfiliados.afiliadosPorEspecialidad(especialidad);
//        
//        if (!afiliadosPorEspecialidad.esVacia()) {
//            
//            INodo<IAfiliado> nodoAfiliadoEspecialidad = afiliadosPorEspecialidad.getPrimero();
//
//            while (nodoAfiliadoEspecialidad != null) {
//                // Afiliado.
//                IAfiliado afiEsp = nodoAfiliadoEspecialidad.getDato();
//                System.out.println("CI: " + afiEsp.getCedula() + 
//                        "   Nombre: " + afiEsp.getNombre() + 
//                        " " + afiEsp.getApellido() + 
//                        "   Esp: " + especialidad);
//                nodoAfiliadoEspecialidad = nodoAfiliadoEspecialidad.getSiguiente();
//            }
//        }
//        else {
//            System.out.println("No hay registros.");
//        }
//        System.out.println();
//    }
    }
}
