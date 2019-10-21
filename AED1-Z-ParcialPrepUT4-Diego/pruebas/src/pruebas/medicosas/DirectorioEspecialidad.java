package pruebas.medicosas;

import TDALista.*;
import tdaarbolbb.*;
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
public class DirectorioEspecialidad extends TArbolBB<Medico> implements IDirectorioEspecialidad {

    public LinkedList<Medico> listadoIngresos(int añoDeIngreso) {
        LinkedList<Medico> misMedicos = this.inOrdenLinkedList();
        LinkedList<Medico> listadoMedicosAñoIngreso = new LinkedList<>();
        for (Medico med : misMedicos) {
            if (med.getIngreso() >= añoDeIngreso) {
                listadoMedicosAñoIngreso.add(med);
            }
        }
        return listadoMedicosAñoIngreso;
    }

    // Mismo metodo pero sin linked lists
    public Lista<Medico> listadoIngresosEnListaComun(int añoDeIngreso) {
        Lista<Medico> misMedicos = this.inorden();
        Lista<Medico> listadoMedicosAñoIngreso = new Lista<>();
        Nodo<Medico> auxNodo = misMedicos.getPrimero();
        while (auxNodo != null) {
            Medico auxMedico = auxNodo.getDato();
            if (auxMedico != null) {
                if (auxMedico.getIngreso() >= añoDeIngreso) {
                    listadoMedicosAñoIngreso.insertar(auxNodo);
                }
            }
            auxNodo = auxNodo.getSiguiente();
        }
        return listadoMedicosAñoIngreso;
    }
}
