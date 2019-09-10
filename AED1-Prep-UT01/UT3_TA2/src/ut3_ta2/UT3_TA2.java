/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut3_ta2;

import static ut3_ta2.EmpresaReclutadora.listaOrdenadaCedula;
import static ut3_ta2.EmpresaReclutadora.listaOrdenadaNombre;

/**
 *
 * @author Equipo 1
 */
public class UT3_TA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Crear empresa, inicializar valores.
        EmpresaReclutadora empresa = new EmpresaReclutadora("Personas y Trabajos");
        Double valorContratosTotal = 0.0;
        Double valorSalariosDesempleados = 0.0;

        // Altas y listar el pool ordenado por ciertos criterios
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta2/altas.txt");

        for (String linea : lineas) {
            String[] c = linea.split(",");
            Persona personaAuxiliar = new Persona(c[0], c[1], c[2], c[3], c[4], Double.parseDouble(c[5]), Boolean.parseBoolean(c[6]));
            if ("1".equals(c[6])) {
                System.out.println("Acumulado de sueldos: " + valorContratosTotal);
                valorContratosTotal += personaAuxiliar.getSueldoMinimo();
            } else {
                valorSalariosDesempleados += personaAuxiliar.getSueldoMinimo();
            }
            empresa.insertarPersona(personaAuxiliar);
            INodo<Persona> auxDocumento = new Nodo(personaAuxiliar.getDocumento(), personaAuxiliar);
            listaOrdenadaCedula.insertarOrdenado(auxDocumento);
            INodo<Persona> auxNombre = new Nodo(personaAuxiliar.getPrimerNombre(), personaAuxiliar);
            listaOrdenadaNombre.insertarOrdenado(auxNombre);
            INodo<Persona> auxApellido = new Nodo(personaAuxiliar.getPrimerApellido(), personaAuxiliar);
            listaOrdenadaCedula.insertarOrdenado(auxApellido);
        }

        System.out.println("Costo total recursos humanos: " + empresa.calcularCostoTotalDeRRHH());

        // Contratos.
        String[] contratos = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta2/contratos.txt");

        Double valorContratos = 0.0;
        for (String contrato : contratos) {
            String[] c = contrato.split(",");
            INodo<Persona> auxPersona = empresa.getListaPersonas().buscar(contrato);
            auxPersona.getDato().setContratado(Boolean.TRUE);
            valorContratos += auxPersona.getDato().getSueldoMinimo();
        }
        System.out.println("Valor contratos en archivo de contratos: " + valorContratos);

        // Contratos, calcular valores.
        valorContratosTotal += valorContratos;
        System.out.println("Valor total de personas contratadas: " + valorContratosTotal);
        System.out.println("Valor de los desempleados: " + valorSalariosDesempleados);

        // Bajas.
        String[] bajas = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta2/bajas.txt");

        Double valorContratosBajas = 0.0;
        for (String baja : bajas) {
            String[] c = baja.split(",");
            INodo<Persona> personaAuxiliar = empresa.getListaPersonas().buscar(c[0]);
            valorContratosBajas += personaAuxiliar.getDato().getSueldoMinimo();
            empresa.getListaPersonas().eliminar(c[0]);
        }
        
        // empresa.getListaPersonas().imprimir();
        empresa.getListaOrdenadaCedula().imprimir();
        empresa.getListaOrdenadaNombre() .imprimir();     
        empresa.getListaOrdenadaApellido().imprimir();
        valorContratosTotal = valorContratosTotal - valorContratosBajas;

        System.out.println("Valor de personas eliminadas: " + valorContratosBajas);
        System.out.println("Nuevo Total: " + (valorContratosTotal));
    }
}
