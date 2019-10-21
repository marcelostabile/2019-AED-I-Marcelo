/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simparcial1;

/**
 *
 * @author estudiante.fit
 */
public class SimParcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        /**
         * MANEJADOR DE ARCHIVOS.
         */
        IManejadorArchivosGenerico ManejadorArchivos = new ManejadorArchivosGenerico();
        
        /**
         * CARGAR PADRÓN DE AFILIADOS.
         */
        PadronAfiliados padronAfiliados = new PadronAfiliados();
        
        // Carpeta de trabajo.
        String CarpetaDeTrabajo = "src/simParcial1/";

        String arch1 = "padron.txt";
        String arch2 = "agendadas.txt";
        String arch3 = "historicas.txt";
        
        String archSalida1 = "salida.txt";
        
        /**
         * PADRON DE AFILIADOS.
         * 
         * Separamos los campos. Creamos un afiliado a partir de cada linea:
         * cédula, nombre, apellido. Crear nodo e insertarlo en la lista.
         */
        String[] lineasArchivo1 = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + arch1);

        for (String linea : lineasArchivo1) {

            String[] c = linea.split(",");
            
            IAfiliado afiliadoNuevo = new Afiliado(Integer.parseInt(c[0]), c[1], c[2]);
            
            IElementoAB<IAfiliado> elementoAfiNuevo = new TElementoAB(afiliadoNuevo.getCedula(), afiliadoNuevo);
            
            padronAfiliados.insertar(elementoAfiNuevo);
        }

        /**
         * CONSULTAS AGENDADAS.
         */
        String[] lineasArchivo2 = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + arch2);

        // Etiqueta del nodo de consulta.
        int id1 = 0;

        for (String linea : lineasArchivo2) {

            String[] c = linea.split(",");
            int afiliadoCI = Integer.parseInt(c[0]);
            int resultadoId = Integer.parseInt(c[4]);
            IConsulta conAux = new Consulta(c[1], c[2], Integer.parseInt(c[3]), resultadoId);

            // Creo un nodo de tipo consulta (para luego agregarlo a la lista).
            INodo<IConsulta> nodoConsulta = new Nodo(id1, conAux);
            id1 += 1;

            IElementoAB<IAfiliado> elementoAfi = padronAfiliados.buscar(afiliadoCI);

            if (elementoAfi != null) {
                ILista<IConsulta> afiliadoConsultasAnotadas = elementoAfi.getDatos().getConsultasAnotadas();
                
                // Insertar en lista de consultas del afiliado
                afiliadoConsultasAnotadas.insertar(nodoConsulta);
            }
        }

        /**
         * CONSULTAS HISTÓRICAS.
         */
        String[] lineasArchivo3 = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo + arch3);

        // Etiqueta del nodo de consulta.
        int id2 = 0;

        for (String linea : lineasArchivo3) {

            String[] c = linea.split(",");

            // Cédula del afiliado, Id del Resultado y Creación de Consulta.
            int afiCI = Integer.parseInt(c[0]);
            int resultadoId = Integer.parseInt(c[4]);
            IConsulta conAux = new Consulta(c[1], c[2], Integer.parseInt(c[3]), resultadoId);

            // Creo un nodo de tipo consulta (para luego agregarlo a la lista).
            INodo<IConsulta> nodoConsulta = new Nodo(id2, conAux);
            id2 += 1;

            IElementoAB<IAfiliado> elementoAfi = padronAfiliados.buscar(afiCI);

            // Si existe el afiliado, ingresar la consulta en la lista de consultas.
            if (elementoAfi != null) {
                ILista<IConsulta> afiliadoConsultasHistoricas = elementoAfi.getDatos().getConsultasHistoricas();
                afiliadoConsultasHistoricas.insertar(nodoConsulta);
            }
        }

        /**
         * ESTADÍSTICAS INICIALES.
         */
        System.out.println("\nESTADÍSTICAS INICIALES\n");
        System.out.println("Cantidad de afiliados: " + padronAfiliados.cantidadAfiliados());
        System.out.println("Cant. Consultas Agendadas: " + padronAfiliados.cantidadConsultasAgendadas());
        System.out.println("Cant. Consultas Históricas: " + padronAfiliados.cantidadConsultasHistoricas());
        System.out.println("Total de Consultas: " + padronAfiliados.totalConsultas());

        /**
         * ACTUALIZACIÓN DE CONSULTAS.
         */
        padronAfiliados.actualizarConsultas();
        System.out.println("");
        System.out.println("SE ACTUALIZARON LAS CONSULTAS!");

        /**
         * ESTADÍSTICAS ACTUALIZADAS.
         */
        System.out.println("\nESTADÍSTICAS LUEGO DE ACTUALIZAR CONSULTAS\n");
        System.out.println("Cantidad de afiliados: " + padronAfiliados.cantidadAfiliados());
        System.out.println("Cant. Consultas Agendadas: " + padronAfiliados.cantidadConsultasAgendadas());
        System.out.println("Cant. Consultas Históricas: " + padronAfiliados.cantidadConsultasHistoricas());
        System.out.println("Total de Consultas: " + padronAfiliados.totalConsultas());
        System.out.println("");

        System.out.println("ÁRBOL DE AFILIADOS DEUDORES inOrden\n");
        TArbolBB<Afiliado> listadoContaduria = padronAfiliados.listadoContaduria();
        System.out.println(listadoContaduria.inOrden());

        System.out.println("\nLISTA DE DEUDORES\n");
        padronAfiliados.getListaDeudores().imprimir();

        System.out.println("\nÁRBOL DE AFILIADOS INACTIVOS inOrden \n");
        TArbolBB<Afiliado> listadoInactivos = padronAfiliados.listadoInactivos();
        System.out.println(listadoInactivos.inOrden());

        /**
         * ESCRIBIR EN UN ARCHIVO LA LISTA DE INACTIVOS
         */
        
        // Tomo el primer nodo de la lista de inactivo.
        INodo<IAfiliado> nodoActual = padronAfiliados.getListaInactivos().getPrimero();
        
        // Recorro la lista de afiliados inactivos y la voy escribiendo en el archivo.
        IAfiliado afiliadoActual = nodoActual.getDato();
        
        while (nodoActual != null) { 
            
            if (afiliadoActual != null) { 
                
                afiliadoActual = nodoActual.getDato();
                
                String[] arregloLineas = new String[1];
                
                arregloLineas[0] = afiliadoActual.toString();
                
                ManejadorArchivos.escribirArchivo(CarpetaDeTrabajo + archSalida1, arregloLineas);
            }
            nodoActual = nodoActual.getSiguiente();
        }

        /**
         * IMPRIMIR ESTADÍSTICAS FINALES.
         */
        System.out.println("\nESTADISTICAS FINALES");
        
        System.out.println("\nEjecuto limpiar...");
        padronAfiliados.limpiar();
        
        System.out.println("Cantidad de afiliados: " + padronAfiliados.cantidadAfiliados());
        System.out.println("Cant. Consultas Agendadas: " + padronAfiliados.cantidadConsultasAgendadas());
        System.out.println("Cant. Consultas Históricas: " + padronAfiliados.cantidadConsultasHistoricas());
        System.out.println("Total de Consultas: " + padronAfiliados.totalConsultas());

        /**
         * ESCRIBIR EN UN ARCHIVO LA LISTA DE NODOS COMPLETOS
         */
        
        // Crear instancia de árbol de búsqueda.
        IArbolBB arbolito = new TArbolBB<>();
        
        // insertar los elementos en el árbol, leyendo los elementos del archivo.

        String CarpetaDeTrabajo9 = "src/simParcial1/";

        String arch9 = "claves1.txt";
        
        String archSalidaNivel = "salidaNivelDeHojas.txt";
        
        String[] lineasArchivo9 = ManejadorArchivos.leerArchivo(CarpetaDeTrabajo9 + arch9);

        for (String linea : lineasArchivo9) {
            
            IElementoAB<String> elemento = new TElementoAB<>(linea, linea);
            
            arbolito.insertar(elemento);
        }
        
        System.out.println("\nEs ABB: " + arbolito.esABB() + "\n");
        
        System.out.println("Internos Completos: " + arbolito.internosCompletos() + "\n");
        
        System.out.println(arbolito.obtenerHojasConNivel());
        
        /**
         * Registrar los valores en un archivo de texto.
         */
        
        String[] listaHojaConNivel = arbolito.obtenerHojasConNivel().replace(" ", "").split("-");
        
        ManejadorArchivos.escribirArchivo(CarpetaDeTrabajo + archSalidaNivel, listaHojaConNivel);
        
    }

}
