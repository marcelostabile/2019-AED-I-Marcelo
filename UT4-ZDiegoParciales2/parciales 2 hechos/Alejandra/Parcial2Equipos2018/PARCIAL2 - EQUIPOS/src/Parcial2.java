
import parcial2.ManejadorArchivosGenerico;
import static parcial2.ManejadorArchivosGenerico.escribirArchivo;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlantillaMedicos hospital = new PlantillaMedicos();
        /* LAS SIGUIENTES LINEAS PUEDEN SERVIR PARA HACER PRUEBAS
       Nodo<Medico> nodo1 = new Nodo<>(8, new Medico(8, "Maria", "Cardiologia", 2013));
        Nodo<Medico> nodo2 = new Nodo<>(5, new Medico(5, "Valentina", "Cirugia", 2014));
        Nodo<Medico> nodo3 = new Nodo<>(3, new Medico(3, "Jose", "Pediatria", 2013));
        Nodo<Medico> nodo4 = new Nodo<>(6, new Medico(6, "Ana", "Cirugia", 2013));
        Nodo<Medico> nodo5 = new Nodo<>(4, new Medico(4, "Florencia", "Pediatria", 2013));
        Nodo<Medico> nodo6 = new Nodo<>(2, new Medico(2, "Juan", "Cardiologia", 2001));
        Nodo<Medico> nodo7 = new Nodo<>(1, new Medico(1, "Pedro", "Cirugia", 2017));
        Nodo<Medico> nodo8 = new Nodo<>(7, new Medico(7, "Martin", "Pediatria", 2015));

        
        hospital.insertar(nodo1);
        hospital.insertar(nodo2);
        hospital.insertar(nodo3);
        hospital.insertar(nodo4);
        hospital.insertar(nodo5);
        hospital.insertar(nodo6);
        hospital.insertar(nodo7);
        hospital.insertar(nodo8);
         */
        /**
         * 1. Crear los médicos y cargarlos en la planilla del hospital a partir
         * del archivo "medicos.txt” Cada línea tiene cédula, nombre,
         * especialidad y año de ingreso del médico
         */
        String[] lineasMedicos = ManejadorArchivosGenerico.leerArchivo("src/medicos.txt");
      
        Medico medico;
        for (String l : lineasMedicos) {
            String[] datos = l.split(",");
            medico = new Medico(Integer.valueOf(datos[0]), datos[1], datos[2], Integer.valueOf(datos[3]));
            TElementoAB<Medico> nuevoNodo = new TElementoAB<>(medico.getCedula(), medico);
            hospital.insertar(nuevoNodo);
        }
        /*
        Parte 2
        */
        LinkedList listado = new LinkedList();
        listado=hospital.inOrden();
        for(Object m: listado){
            Medico med = (Medico)m;
            System.out.println(med.getCedula()+","+med.getNombre()+","+med.getIngreso()+","+med.getEspecialidad());
        }
        System.out.println("Tamaño: "+hospital.obtenerTamanio());
        /*
        Parte 3
        */
        hospital.eliminar(4141);
        hospital.eliminar(1732);
        hospital.eliminar(2);
        hospital.eliminar(9988);
        hospital.eliminar(5555);
        /*
        Parte 4
        */
        
        System.out.println("Tamaño: "+hospital.obtenerTamanio());
        
        /*
        Parte 5
        */
        TElementoAB nodo1 = (TElementoAB) hospital.buscar(7777);
        TElementoAB nodo2 = (TElementoAB) hospital.buscar(2222);
        TElementoAB nodo3 = (TElementoAB) hospital.buscar(333);
        
         Medico med = (Medico)nodo1.getDatos();
         System.out.println(med.getCedula()+","+med.getNombre()+","+med.getIngreso()+","+med.getEspecialidad());
         Medico med2 = (Medico)nodo2.getDatos();
         System.out.println(med2.getCedula()+","+med2.getNombre()+","+med2.getIngreso()+","+med2.getEspecialidad());
        Medico med3 = (Medico)nodo3.getDatos();
         System.out.println(med3.getCedula()+","+med3.getNombre()+","+med3.getIngreso()+","+med3.getEspecialidad());
        /*
        Parte 6
        */
        IDirectorioEspecialidad directorioEspecialidad = new DirectorioEspecialidad();
        directorioEspecialidad=hospital.obtenerDirectorio("Gastroenterologia");
        /*
        Parte 7
        */
        /* nuevo = new LinkedList();
        nuevo=directorioEspecialidad.inOrden();
        for(Object m: nuevo){
            String[] ingr = new String[1];
            Medico med0 = (Medico)m;
            ingr[0] = med0.getCedula()+","+med0.getNombre()+","+med0.getEspecialidad()+","+med0.getIngreso();
            escribirArchivo("src/medicos_policlinica.txt", ingr);
        }*/
        /*
        Parte 8
        */
        LinkedList listadoDirectorio = new LinkedList();
        listadoDirectorio=directorioEspecialidad.listadoIngresos(2014);
        /*
        Parte 7
        */
       /*
        
2.      Emitir por consola el listado de médicos de la plantilla del hospital 
        ordenado en forma ascendente por número de Cédula y la Cantidad total de
        medicos en la plantilla.

3.	Eliminar de la plantilla los médicos con las siguientes Cédulas: 
        7669, 
        1632, 
        5328, 
        1081,
        9069
        
4.      Emitir por consola la nueva cantidad de medicos en la plantilla (invocando
        al metodo correspondiente del arbol de plantilla)
        
5.	Dados los siguientes números de cédula, recuperar los médicos 
        correspondientes de la plantilla e imprimir por consola sus datos completos: 
        8948, 
        5683 y 
        822

6.	Ejecutar el método “obtenerDirectorio” de la plantilla del hospital, 
        para la especialidad que se indicará en el pizarrón. 
*/
//  String especialidad = // se comunica en el pizarron;
//        DirectorioEspecialidad arbolEspecialidad = hospital.obtenerDirectorio(especialidad);
/*

7.	Escribir un archivo “medicos_policlinica.txt” que contenga todos los 
datos de los médicos incluidos en la instancia de DirectorioEspecialidad obtenida, 
uno por cada línea, ordenados alfabéticamente por nombre.

8.	Ejecutar el método “listadoIngresos” del directorio de la especialidad, 
pasando por parámetro el año indicado en el pizarrón.

9.	Escribir un archivo “médicos_poli_anio.txt” con los datos resultantes del 
punto anterior, un médico por línea (todos los datos), ordenados alfabéticamente 
por nombre.

*/
    }

}
