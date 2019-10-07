/*
 * UT4TA9
 */
package ut4ta9;

/**
 *
 * @author EQUIPO 1.
 */
public class UT4TA9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /**
         * 1 Instanciar un padrón de afiliados 2 Cargar los afiliados 3 Cargar
         * las consultas a realizar e históricas de los afiliados 4 Aplicar el
         * método a desarrollar (actualizarConsultas) 5 Imprimir por pantalla la
         * lista devuelta en el método anterior
         */
        /**
         * Instanciamos el hospital.
         */
        PadronAfiliados padronAfiliados = new PadronAfiliados();

        /**
         * CARPETA DE LOS ARCHIVOS.
         */
        String CarpetaDeTrabajo = "src/ut4ta9/";

        /**
         * Cargar lista de afiliados.
         *
         * Separamos los campos. Creamos un afiliado a partir de cada linea:
         * cédula, nombre, apellido. Crear nodo e insertarlo en la lista.
         */
        String[] lineasPadron = ManejadorArchivosGenerico.leerArchivo(CarpetaDeTrabajo + "padron.txt");

        for (String linea : lineasPadron) {

            String[] c = linea.split(",");
            IAfiliado afiliadoNuevo = new Afiliado(Integer.parseInt(c[0]), c[1], c[2]);
            IElementoAB<IAfiliado> elementoAfiNuevo = new TElementoAB(afiliadoNuevo.getCedula(), afiliadoNuevo);
            padronAfiliados.insertar(elementoAfiNuevo);
        }

        /**
         * Cargar listas de consultas agendadas.
         */
        String[] lineasAgendadas = ManejadorArchivosGenerico.leerArchivo(CarpetaDeTrabajo + "agendadas.txt");

        // Etiqueta del nodo de consulta.
        int id1 = 0;

        for (String linea : lineasAgendadas) {

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
         * Cargar listas de consultas históricas.
         */
        String[] lineasHisto = ManejadorArchivosGenerico.leerArchivo(CarpetaDeTrabajo + "historicas.txt");

        // Etiqueta del nodo de consulta.
        int id2 = 0;

        for (String linea : lineasHisto) {

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
         * Imprimir estadisticas iniciales.
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
        System.out.println("Se actualizaron las consultas de los afiliados.");

        /**
         * Imprimir estadisticas actualizadas.
         */
        System.out.println("\nESTADÍSTICAS LUEGO DE LA ACTUALIZACIÓN\n");
        System.out.println("Cantidad de afiliados: " + padronAfiliados.cantidadAfiliados());
        System.out.println("Cant. Consultas Agendadas: " + padronAfiliados.cantidadConsultasAgendadas());
        System.out.println("Cant. Consultas Históricas: " + padronAfiliados.cantidadConsultasHistoricas());
        System.out.println("Total de Consultas: " + padronAfiliados.totalConsultas());
        System.out.println("");

        System.out.println("ÁRBOL DE AFILIADOS DEUDORES inOrden \n");
        TArbolBB<Afiliado> listadoContaduria = padronAfiliados.listadoContaduria();
        System.out.println(listadoContaduria.inOrden());
        System.out.println("");
        System.out.println("\nLista deudores\n");

        padronAfiliados.getListaDeudores().imprimir();
        System.out.println(""
                + "");
        System.out.println("ÁRBOL DE AFILIADOS INACTIVOS inOrden \n");
        TArbolBB<Afiliado> listadoInactivos = padronAfiliados.listadoInactivos();
        System.out.println(listadoInactivos.inOrden());
        System.out.println("");

        // escribir en un archivo
        INodo<IAfiliado> nodoActual = padronAfiliados.getListaInactivos().getPrimero();
        IAfiliado afiliadoActual = nodoActual.getDato();
        while (nodoActual != null) {
            if (afiliadoActual != null) {
                afiliadoActual = nodoActual.getDato();
                String[] arregloLineas = new String[1];
                arregloLineas[0] = afiliadoActual.toString();
                ManejadorArchivosGenerico.escribirArchivo(CarpetaDeTrabajo + "salida.txt", arregloLineas);
            }
            nodoActual = nodoActual.getSiguiente();
        }

        /**
         * Imprimir estadisticas finales.
         */
        System.out.println("\nESTADISTICAS FINALES");
        System.out.println("\nEjecuto limpiar...");
        padronAfiliados.limpiar();
        System.out.println("Cantidad de afiliados: " + padronAfiliados.cantidadAfiliados());
        System.out.println("Cant. Consultas Agendadas: " + padronAfiliados.cantidadConsultasAgendadas());
        System.out.println("Cant. Consultas Históricas: " + padronAfiliados.cantidadConsultasHistoricas());
        System.out.println("Total de Consultas: " + padronAfiliados.totalConsultas());

    }

}
