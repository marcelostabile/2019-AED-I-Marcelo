/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import TDALista.*;
import java.util.LinkedList;
import tdaarbolbb.*;
import manejadorarchivos.*;
import pruebas.medicosas.*;
import pruebas.piezacosas.*;

/**
 *
 * @author Diego
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // <editor-fold defaultstate="collapsed" desc=" ** Pruebas árbol 1: Insertando e imprimiendo elementos ">
        TArbolBB arbol1;
        TElementoAB elem1;
        TElementoAB elem2;
        TElementoAB elem3;
        TElementoAB elem4;
        TElementoAB elem5;
        TElementoAB elem6;

        //*****************************************
        //
        // Arbol 3-4-5-8-9-11 me tiene que dar dos hojas (4 y 11)    
        //
        //        5
        //       / \
        //      3   8
        //       \   \
        //        4   9
        //             \
        //              11   
        //
        //*****************************************
        arbol1 = new TArbolBB();

        elem1 = new TElementoAB(5, "5");
        elem2 = new TElementoAB(3, "3");
        elem3 = new TElementoAB(8, "8");
        elem4 = new TElementoAB(4, "4");
        elem5 = new TElementoAB(9, "9");
        elem6 = new TElementoAB(11, "11");

        arbol1.insertar(elem1);
        arbol1.insertar(elem2);
        arbol1.insertar(elem3);
        arbol1.insertar(elem4);
        arbol1.insertar(elem5);
        arbol1.insertar(elem6);

        System.out.println(arbol1.obtenerNodosNivel(1).imprimir());
        System.out.println(arbol1.obtenerNodosNivel(2).imprimir());
        System.out.println(arbol1.obtenerNodosNivel(3).imprimir());
        System.out.println(arbol1.obtenerNodosNivel(4).imprimir());
        // </editor-fold> 

        // <editor-fold defaultstate="collapsed" desc=" ** Pruebas árbol 2: Operaciones con hojas y niveles ** ">
        TArbolBB arbol2 = new TArbolBB();

        //*****************************************
        // Arbol 1-2-3-4-7-8-10-12-15-19, 5 hojas   
        //
        //          7
        //       /     \
        //      2       15
        //     / \      / \
        //    1   4   10   19
        //       /   /  \     
        //      3   8    12    
        //
        //*****************************************
        arbol2.insertar(new TElementoAB<>(7, new Producto(4, 4)));
        arbol2.insertar(new TElementoAB<>(2, new Producto(5, 5)));
        arbol2.insertar(new TElementoAB<>(1, new Producto(4, 4)));
        arbol2.insertar(new TElementoAB<>(3, new Producto(1, 1)));
        arbol2.insertar(new TElementoAB<>(4, new Producto(3, 3)));
        arbol2.insertar(new TElementoAB<>(8, new Producto(24, 24)));
        arbol2.insertar(new TElementoAB<>(12, new Producto(9, 9)));
        arbol2.insertar(new TElementoAB<>(10, new Producto(3, 3)));
        arbol2.insertar(new TElementoAB<>(19, new Producto(0, 0)));
        arbol2.insertar(new TElementoAB<>(15, new Producto(0, 0)));

        System.out.println(arbol2.mayorValor(3, 8));
        System.out.println(arbol2.mayorValor(1, 3));
        System.out.println(arbol2.mayorValor(19, 55));

        System.out.println(arbol2.obtenerClaveInmediataAnterior(12));
        System.out.println(arbol2.esABB());

        System.out.println(arbol1.obtenerHojasConNivel());
        System.out.println(arbol1.obtenerCantidadHojas());
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" ** Pruebas árbol 3: Pruebas con productos ** ">
        String nombreCompletoArchivo = "src/pruebas/claves1.txt";
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        String[] lineasClaves = manejadorArchivos.leerArchivo(nombreCompletoArchivo);

        IArbolBB arbol3 = new TArbolBB();

        for (String linea : lineasClaves) {
            String[] datos = linea.split(",");
            Producto auxProducto = new Producto(linea, 0);
            auxProducto.setNombre("Producto de prueba");
            IElementoAB<Producto> elementoProducto = new TElementoAB(datos[0], auxProducto);
            arbol3.insertar(elementoProducto);
        }

        ILista<Producto> listadoProductos = new Lista<>();
        arbol3.inOrden(listadoProductos);

        INodo<Producto> elementoAuxiliar = listadoProductos.getPrimero();
        while (elementoAuxiliar != null) {
            if (elementoAuxiliar.getDato() != null) {
                String[] linea = new String[1];
                linea[0] = elementoAuxiliar.getDato().toString();
                manejadorArchivos.escribirArchivo("src/pruebas/output/salidaProductos.txt", linea);
            }
            elementoAuxiliar = elementoAuxiliar.getSiguiente();
        }

        String hojasConNivel = arbol3.obtenerHojasConNivel();
        String[] lineaHojasConNivel = new String[1];
        lineaHojasConNivel[0] = hojasConNivel;

        manejadorArchivos.escribirArchivo("src/pruebas/output/salidaHojasConNivel.txt", lineaHojasConNivel);
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" ** Pruebas árbol 4: Pruebas con alumnos ** ">
        IArbolBB arbolUniversidad = new TArbolBB();

        String nombreArchivoAlumnos = "src/pruebas/datos_alumnos.csv";
        String[] lineasAlumnos = manejadorArchivos.leerArchivo(nombreArchivoAlumnos);
        // constructor de la clase: public Alumno(int Codigo, String Apellido, String Carrera)
        // formato del archivo: 123,Abadie,Psicología
        for (String linea : lineasAlumnos) {
            String[] datos = linea.split(",");
            Alumno auxAlumno = new Alumno(Integer.valueOf(datos[0]), datos[1], datos[2]);
            IElementoAB<Alumno> elementoAlumno = new TElementoAB(datos[0], auxAlumno);
            arbolUniversidad.insertar(elementoAlumno);
        }

        IArbolBB arbolMedicina = arbolUniversidad.armarIndiceCarrera("Medicina");
        ILista<Alumno> listaEstudiantesMedicina = new Lista<>();
        arbolMedicina.inOrden(listaEstudiantesMedicina);

        INodo<Alumno> auxAlumnoMedicina = listaEstudiantesMedicina.getPrimero();
        while (auxAlumnoMedicina != null) {
            if (auxAlumnoMedicina.getDato() != null) {
                String[] lineaEstudianteMedicina = new String[1];
                lineaEstudianteMedicina[0] = auxAlumnoMedicina.getDato().toString();
                manejadorArchivos.escribirArchivo("src/pruebas/output/estudiantesMedicina.txt", lineaEstudianteMedicina);
            }
            auxAlumnoMedicina = auxAlumnoMedicina.getSiguiente();
        }
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc=" ** Pruebas árbol 5: Pruebas con directorios medicos ** ">
        PlantillaMedicos directorioMedicos = new PlantillaMedicos();

        String nombreArchivoMedicos = "src/pruebas/medicosas/medicos.txt";
        String[] lineasMedicos = manejadorArchivos.leerArchivo(nombreArchivoMedicos);
        // constructor de la clase:     public Medico(int cedula, String nombre, String especialidad, int ingreso)
        // formato del archivo: 6762,Gravida Gallardo,Neurologia,2004
        for (String linea : lineasMedicos) {
            String[] datos = linea.split(",");
            Medico auxMedico = new Medico(Integer.valueOf(datos[0]), datos[1], datos[2], Integer.valueOf(datos[3]));
            IElementoAB<Medico> elementoMedico = new TElementoAB(datos[0], auxMedico);
            directorioMedicos.insertar(elementoMedico);
        }

        // Escribo a un archivo el directorio de medicos de Neurologia
        DirectorioEspecialidad directorioMedicosNeurologia = directorioMedicos.obtenerDirectorio("Neurologia");
        ILista listaNeurologos = new Lista<>();
        directorioMedicosNeurologia.inOrden(listaNeurologos);
        INodo<Medico> auxNeurologo = listaNeurologos.getPrimero();
        while (auxNeurologo != null) {
            if (auxNeurologo.getDato() != null) {
                String[] lineaNeurologo = new String[1];
                lineaNeurologo[0] = auxNeurologo.getDato().imprimirDatos();
                manejadorArchivos.escribirArchivo("src/pruebas/output/plantillaNeurologia.txt", lineaNeurologo);
            }
            auxNeurologo = auxNeurologo.getSiguiente();
        }

        LinkedList<Medico> listaNeurologos2016 = directorioMedicosNeurologia.listadoIngresos(2016);
        for (Medico neurologo : listaNeurologos2016) {
            String[] lineaNeurologo = new String[1];
            lineaNeurologo[0] = neurologo.imprimirDatos();
            manejadorArchivos.escribirArchivo("src/pruebas/output/plantillaNeurologia2016.txt", lineaNeurologo);
        }

        // </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc=" ** Pruebas árbol 6: Pruebas con piezas y rubros ** ">
        // Creo arbol de piezas a partir del archivo de piezas
        TArbolPiezas arbolPiezas = new TArbolPiezas();
        String nombreArchivoPiezas = "src/pruebas/piezacosas/piezas.txt";
        String[] lineasPiezas = manejadorArchivos.leerArchivo(nombreArchivoPiezas);
        for (String lineaPieza : lineasPiezas) {
            String[] datoPieza = lineaPieza.split(",");
            // constructor: Pieza(String codigo, String codCat, String descripcion, int cantidad, int precioUnitario)
            // archivo: 1237330035,3.4.1 ,Ignition Condensers,5,15
            Pieza auxPieza = new Pieza(datoPieza[0], datoPieza[1], datoPieza[2], Integer.valueOf(datoPieza[3]), Integer.valueOf(datoPieza[4]));
            arbolPiezas.insertar(new TElementoAB<>(datoPieza[0], auxPieza));
        }

        // Obtengo cantidad y valor total de stock
        int cantValor[] = arbolPiezas.cantYvalorStock();
        System.out.println("Cantidad total: " + cantValor[0]);
        System.out.println("Valor total: " + cantValor[1]);

        // Listo todas las piezas en un archivo de deposito y lo guardo
        Lista<Pieza> listaDeposito = new Lista();
        arbolPiezas.inOrden(listaDeposito);
        Nodo<Pieza> nodoActual = listaDeposito.getPrimero();
        while (nodoActual != null) {
            Pieza piezaActual = nodoActual.getDato();
            if (piezaActual != null) {
                String[] lineaDeposito = new String[1];
                lineaDeposito[0] = "Cod pieza: " + piezaActual.getCodigoPieza() + ", Nombre: " + piezaActual.getDescripcion() + ", Valor en stock: " + piezaActual.getValorEnStock();
                manejadorArchivos.escribirArchivo("src/pruebas/output/deposito.txt", lineaDeposito);
            }
            nodoActual = nodoActual.getSiguiente();
        }

        // Creo nuevo árbol que tiene como etiqueta el código de pieza
        // pero sólo contiene piezas del rubro 10
        TArbolPiezas arbolRubro10 = arbolPiezas.piezasPorRubro("10");
        Lista<Pieza> listaRubro10 = arbolRubro10.inorden();
        TArbolPiezas arbolRubro10Ordenado = new TArbolPiezas();
        nodoActual = listaRubro10.getPrimero();
        while (nodoActual != null) {
            Pieza piezaActual = nodoActual.getDato();
            if (piezaActual != null) {
                arbolRubro10Ordenado.insertar(new TElementoAB<>(piezaActual.getCodigoPieza(), piezaActual));
            }
            // Inserto en nuevo árbol
            nodoActual = nodoActual.getSiguiente();
        }

        // Listo todas las piezas en un archivo de deposito y lo guardo
        Nodo<Pieza> nodoActualRubro10 = listaRubro10.getPrimero();
        while (nodoActualRubro10 != null) {
            Pieza piezaActualRubro10 = nodoActualRubro10.getDato();
            if (piezaActualRubro10 != null) {
                String[] lineaDepositoRubro10 = new String[1];
                lineaDepositoRubro10[0] = "Cod pieza: " + piezaActualRubro10.getCodigoPieza() + ", Nombre: " + piezaActualRubro10.getDescripcion() + ", Valor en stock: " + piezaActualRubro10.getValorEnStock();
                manejadorArchivos.escribirArchivo("src/pruebas/output/depositoRubro10.txt", lineaDepositoRubro10);
            }
            nodoActualRubro10 = nodoActualRubro10.getSiguiente();
        }
        
        /* por último, imprimir por consola la cantidad de piezas y el valor de stock
        de las piezas del rubro indicado
         */
        cantValor = arbolRubro10.cantYvalorStock();
        System.out.printf("Cantidad total de rubro 10: %s\n", cantValor[0]);
        System.out.printf("Valor total de rubro 10: %s\n", cantValor[1]);
        // </editor-fold>
    }

}
