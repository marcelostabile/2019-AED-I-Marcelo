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
         * Instanciamos el padron de afiliados.
         */
        PadronAfiliados padronAfiliados = new PadronAfiliados();

        /**
         * Cargar lista de afiliados.
         * 
         * Registro de Afiliado: cédula, nombre, apellido.
         */
        String[] lineasPadron = ManejadorArchivosGenerico.leerArchivo("src/parcial1/padron2.txt");
        
        for (String linea : lineasPadron) {
            String[] c = linea.split(",");
            
            IAfiliado afiNuevo = new Afiliado(Integer.parseInt(c[0]), c[1], c[2]);
            INodo<IAfiliado> nodoAfiNuevo = new Nodo(afiNuevo.getCedula(), afiNuevo);
            
            padronAfiliados.padronAfiliados.insertar(nodoAfiNuevo);
        }
        
        /**
         * Cargar listas de consultas agendadas.
         * 
         * Registro de Consulta: cédula afiliado, fecha, especialidad, ci médico, resultado
         */
        String[] lineasAgendadas = ManejadorArchivosGenerico.leerArchivo("src/parcial1/agendadas2.txt");
        
        // Etiqueta del nodo de consulta.
        int idCon1 = 0;    
        for (String linea : lineasAgendadas) {
            String[] c = linea.split(",");
            
            // Cédula del afiliado, Id del Resultado y Creación de Consulta.
            int afiCI = Integer.parseInt(c[0]);
            int resultadoId = Integer.parseInt(c[4]);
            IConsulta conAux = new Consulta(c[1], c[2], Integer.parseInt(c[3]), resultadoId);
            INodo<IConsulta> nodoConsulta = new Nodo(idCon1, conAux);
            idCon1 += 1;

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
        int idCon2 = 0;
        for (String linea : lineasHisto) {
            String[] c = linea.split(",");

            // Cédula del afiliado, Id del Resultado y Creación de Consulta.
            int afiCI = Integer.parseInt(c[0]);
            int resultadoId = Integer.parseInt(c[4]);
            IConsulta conAux = new Consulta(c[1], c[2], Integer.parseInt(c[3]), resultadoId);

            INodo<IConsulta> nodoConsulta = new Nodo(idCon2, conAux);
            idCon2 += 1;

            // Buscar afiliado en el padron cargado.
            INodo<IAfiliado> nodoAfi = padronAfiliados.padronAfiliados.buscar(afiCI);
            
            // Si existe el afiliado, ingresar la consulta en la lista de consultas.
            if (nodoAfi != null) {
                ILista<IConsulta> afiliadoConsultasHistoricas = nodoAfi.getDato().getConsultasHistoricas();
                afiliadoConsultasHistoricas.insertar(nodoConsulta);
            }
        }
        
        /**
         * Imprimir estadísticas iniciales.
         */
        System.out.println();
        padronAfiliados.imprimirEstadisticas();
        
        /**
         * EJECUTANDO LA ACTUALIZACIÓN DE CONSULTAS.
         */
        System.out.println("ACTUALIZACIÓN DE CONSULTAS !!!");
        System.out.println();
        ILista <IAfiliado> padronDeudores = padronAfiliados.actualizarConsultas();
        
        /**
         * Imprimir estadisticas finales.
         */
        padronAfiliados.imprimirEstadisticas();

        /**
         * Imprimir deudores.
         */
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

        /**
         * AFILIADOS POR ESPECIALIDAD.
         */
        String especialidad = "Dermatologia";
        
        System.out.println("AFILIADOS POR ESPECIALIDAD: " + especialidad);
        System.out.println();
        
        ILista<IAfiliado> afiliadosPorEspecialidad = padronAfiliados.afiliadosPorEspecialidad(especialidad);
        
        if (!afiliadosPorEspecialidad.esVacia()) {
            
            INodo<IAfiliado> nodoAfiliadoEspecialidad = afiliadosPorEspecialidad.getPrimero();

            while (nodoAfiliadoEspecialidad != null) {
                // Afiliado.
                IAfiliado afiEsp = nodoAfiliadoEspecialidad.getDato();
                System.out.println("CI: " + afiEsp.getCedula() + 
                        "   Nombre: " + afiEsp.getNombre() + 
                        " " + afiEsp.getApellido() + 
                        "   Esp: " + especialidad);
                nodoAfiliadoEspecialidad = nodoAfiliadoEspecialidad.getSiguiente();
            }
        }
        else {
            System.out.println("No hay registros.");
        }
        System.out.println();
    }
    
    
    
}
