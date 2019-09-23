package parcial1;

public class Parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /* 1 Instanciar un padrón de afiliados 
         2 Cargar los afiliados 
         3 Cargar las consultas a realizar e históricas de los afiliados 
         4 Aplicar el método a desarrollar (actualizarConsultas)
         5 Imprimir por pantalla la lista devuelta en el método anterior */
        
        /**
         * Instanciamos el hospital.
         */
        PadronAfiliados padronAfiliados = new PadronAfiliados();
        
        /**
         * Cargar lista de afiliados.
         * 
         * Separamos los campos.
         * Creamos un afiliado a partir de cada linea: cédula, nombre, apellido.
         * Crear nodo e insertarlo en la lista.
         */
        String[] lineasPadron = ManejadorArchivosGenerico.leerArchivo("src/parcial1/padron.txt");

        for (String linea : lineasPadron) {
            String[] c = linea.split(",");
            IAfiliado afiNuevo = new Afiliado(Integer.parseInt(c[0]), c[1], c[2]);
            INodo<IAfiliado> nodoAfiNuevo = new Nodo(afiNuevo.getCedula(), afiNuevo);
            padronAfiliados.padronAfiliados.insertar(nodoAfiNuevo);
        }
        
        /**
         * Cargar listas de consultas agendadas.
         */
        String[] lineasAgendadas = ManejadorArchivosGenerico.leerArchivo("src/parcial1/agendadas.txt");

        // Etiqueta del nodo de consulta.
        int id1 = 0;
        
        for (String linea : lineasAgendadas) {
            
            String[] c = linea.split(",");
            int afiCI = Integer.parseInt(c[0]);
            int resultadoId = Integer.parseInt(c[4]);
            IConsulta conAux = new Consulta(c[1], c[2], Integer.parseInt(c[3]), resultadoId);

            // Creo un nodo de tipo consulta (para luego agregarlo a la lista).
            INodo<IConsulta> nodoConsulta = new Nodo(id1, conAux);
            id1 += 1;

            // Buscar afiliado en el padron cargado.
            INodo<IAfiliado> nodoAfi = padronAfiliados.padronAfiliados.buscar(afiCI);
            
            // Si existe el afiliado, ingresar la consulta en la lista de consultas.
            if (nodoAfi != null) {
                ILista<IConsulta> afiliadoConsultasAnotadas = nodoAfi.getDato().getConsultasAnotadas();
                afiliadoConsultasAnotadas.insertar(nodoConsulta);
            }
        }

        /**
         * Cargar listas de consultas históricas.
         */
        String[] lineasHisto = ManejadorArchivosGenerico.leerArchivo("src/parcial1/historicas.txt");

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

            // Buscar afiliado en el padron cargado.
            INodo<IAfiliado> nodoAfi = padronAfiliados.padronAfiliados.buscar(afiCI);
            
            // Si existe el afiliado, ingresar la consulta en la lista de consultas.
            if (nodoAfi != null) {
                ILista<IConsulta> afiliadoConsultasHistoricas = nodoAfi.getDato().getConsultasHistoricas();
                afiliadoConsultasHistoricas.insertar(nodoConsulta);
            }
        }
        
        /**
         * Imprimir estadisticas iniciales.
         */
        int totalConAnotadas = 0;
        int totalConHistoricas = 0;

        INodo<IAfiliado> nodoAfiliado = padronAfiliados.padronAfiliados.getPrimero();
        while (nodoAfiliado != null) { 
            
            // Obtener consultas del afiliado.
            ILista<IConsulta> listaConsultasAnotadas = nodoAfiliado.getDato().getConsultasAnotadas();
            ILista<IConsulta> listaConsultasHistoricas = nodoAfiliado.getDato().getConsultasHistoricas();
            
            // Sumar en el total de consultas.
            totalConAnotadas += listaConsultasAnotadas.cantElementos();
            totalConHistoricas += listaConsultasHistoricas.cantElementos();
            
            nodoAfiliado = nodoAfiliado.getSiguiente();
        }
        
        System.out.println();
        System.out.println("ESTADISTICAS INICIALES");
        System.out.println();
        System.out.println("Cantidad de afiliados: " + padronAfiliados.padronAfiliados.cantElementos());
        System.out.println("Cant. Consultas Agendadas: " + totalConAnotadas);
        System.out.println("Cant. Consultas Históricas: " + totalConHistoricas);
        int totalConsultas = totalConAnotadas + totalConHistoricas;
        System.out.println("Total de Consultas: " + totalConsultas);
        System.out.println();
        
        /**
         * EJECUTANDO LA ACTUALIZACIÓN DE CONSULTAS.
         */
        ILista <IAfiliado> padronDeudores = padronAfiliados.actualizarConsultas();
        
        /**
         * Imprimir estadisticas finales.
         */
        totalConAnotadas = 0;
        totalConHistoricas = 0;

        nodoAfiliado = padronAfiliados.padronAfiliados.getPrimero();
        while (nodoAfiliado != null) {
            
            // Obtener consultas del afiliado.
            ILista<IConsulta> listaConsultasAnotadas = nodoAfiliado.getDato().getConsultasAnotadas();
            ILista<IConsulta> listaConsultasHistoricas = nodoAfiliado.getDato().getConsultasHistoricas();

            // Sumar en el total de consultas.
            totalConAnotadas += listaConsultasAnotadas.cantElementos();
            totalConHistoricas += listaConsultasHistoricas.cantElementos();
            
            nodoAfiliado = nodoAfiliado.getSiguiente();
        }
        
        System.out.println("ESTADISTICAS FINALES");
        System.out.println();
        System.out.println("Se procesan las consultas del día.");
        System.out.println();
        System.out.println("Cantidad de afiliados: " + padronAfiliados.padronAfiliados.cantElementos());
        System.out.println("Cant. Consultas Agendadas: " + totalConAnotadas);
        System.out.println("Cant. Consultas Históricas: " + totalConHistoricas);
        totalConsultas = totalConAnotadas + totalConHistoricas;
        System.out.println("Total de Consultas: " + totalConsultas);
        System.out.println();
        
        System.out.println("DEUDORES");
        System.out.println();
        
        // Tomo el primer nodo de la lista padronDeudores.
        INodo<IAfiliado> nodoAfiliadoDeudor = padronDeudores.getPrimero();
        
        // Recorro la lista de deudores.
        while (nodoAfiliadoDeudor != null) {
        
            // Afiliado.
            IAfiliado afiliadoDeudor = nodoAfiliadoDeudor.getDato();
            
            // Historicas del afiliado.
            ILista<IConsulta> afiliadoConsultasHistoricas = nodoAfiliadoDeudor.getDato().getConsultasHistoricas();
            
            // Tomo la primer consulta.
            INodo<IConsulta> nodoConsulta = afiliadoConsultasHistoricas.getPrimero();
            
            // Recorro todas sus consultas.
            while (nodoConsulta != null) { 
            
                System.out.println("CI: " + afiliadoDeudor.getCedula() + 
                        " Fecha: " + nodoConsulta.getDato().getFechaConsulta() + 
                        " (" + afiliadoDeudor.getNombre() + " " + afiliadoDeudor.getApellido() + ")");
                
                nodoConsulta = nodoConsulta.getSiguiente();
            }
            
            nodoAfiliadoDeudor = nodoAfiliadoDeudor.getSiguiente();
        }
        System.out.println("Cant. de Deudores: " + padronDeudores.cantElementos());
        System.out.println();
        
        
        
    }
}
