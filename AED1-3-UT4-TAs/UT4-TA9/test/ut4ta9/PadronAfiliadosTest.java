/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut4ta9;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego
 */
public class PadronAfiliadosTest {

    PadronAfiliados padronAfiliados = new PadronAfiliados();

    public PadronAfiliadosTest() {

        /**
         * Instanciamos el hospital.
         */
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

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testActualizarConsultas() {

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
        System.out.println("\nSe ejecuta método actualizarConsultas.");
        padronAfiliados.actualizarConsultas();

        /**
         * Imprimir estadisticas iniciales.
         */
        System.out.println("\nESTADÍSTICAS ACTUALIZADAS\n");
        System.out.println("Cantidad de afiliados: " + padronAfiliados.cantidadAfiliados());
        System.out.println("Cant. Consultas Agendadas: " + padronAfiliados.cantidadConsultasAgendadas());
        System.out.println("Cant. Consultas Históricas: " + padronAfiliados.cantidadConsultasHistoricas());
        System.out.println("Total de Consultas: " + padronAfiliados.totalConsultas());

        // Tests.
        // Sabemos que las consultas agendadas son 84 y las historicas 88.
        // luego de correr la funcionalidad, agendadas 75 y historicas 116.
        int agendadasResultado = 75;
        int historicasResultado = 116;

        assertEquals(padronAfiliados.cantidadConsultasAgendadas(), agendadasResultado);
        assertEquals(padronAfiliados.cantidadConsultasHistoricas(), historicasResultado);

    }

    @Test
    public void testListadoContaduria() {
        padronAfiliados.actualizarConsultas();
        System.out.println("\nÁRBOL DE AFILIADOS DEUDORES inOrden \n");
        TArbolBB<Afiliado> listadoContaduria = padronAfiliados.listadoContaduria();
        System.out.println(listadoContaduria.inOrden()); //159448-226926-513957
        System.out.println("\nLista deudores\n");
        padronAfiliados.getListaDeudores().imprimir(); // Cantidad de deudores: 3

        // Tenemos 3 afiliados en esta condición.
        int resultadoEsperado = 3;
        assertEquals(resultadoEsperado, padronAfiliados.listadoContaduria().obtenerTamaño());
    }

    @Test
    public void testListadoInactivos() {
        padronAfiliados.actualizarConsultas();
        System.out.println("\nÁRBOL DE AFILIADOS INACTIVOS inOrden \n");
        System.out.println("Cantidad de afiliados inactivos: " + padronAfiliados.getListaInactivos().cantElementos());

        // Tenemos 3 afiliados en esta condición.
        int resultadoEsperado = 60;
        assertEquals(resultadoEsperado, padronAfiliados.getListaInactivos().cantElementos());

    }

    @Test
    public void testLimpiar() {
        padronAfiliados.actualizarConsultas();

        /**
         * Imprimir estadisticas finales. 
         */
        System.out.println(
                "\nESTADISTICAS FINALES");
        System.out.println(
                "\nEjecuto limpiar...");
        padronAfiliados.limpiar();

        System.out.println(
                "Cantidad de afiliados: " + padronAfiliados.cantidadAfiliados());
        System.out.println(
                "Cant. Consultas Agendadas: " + padronAfiliados.cantidadConsultasAgendadas());
        System.out.println(
                "Cant. Consultas Históricas: " + padronAfiliados.cantidadConsultasHistoricas());
        System.out.println(
                "Total de Consultas: " + padronAfiliados.totalConsultas() + "\n");

//        Cantidad de afiliados: 41
//        Cant. Consultas Agendadas: 15
//        Cant. Consultas Históricas: 34
//        Total de Consultas: 49
                
        int cantAfiliadosFinal = 41;
        int cantConsultasAgendadasFinal = 15;
        int cantConsultasHistoricasFinal = 34;

        assertEquals(padronAfiliados.cantidadAfiliados(), cantAfiliadosFinal);
        assertEquals(padronAfiliados.cantidadConsultasAgendadas(), cantConsultasAgendadasFinal);
        assertEquals(padronAfiliados.cantidadConsultasHistoricas(), cantConsultasHistoricasFinal);
    }

}
