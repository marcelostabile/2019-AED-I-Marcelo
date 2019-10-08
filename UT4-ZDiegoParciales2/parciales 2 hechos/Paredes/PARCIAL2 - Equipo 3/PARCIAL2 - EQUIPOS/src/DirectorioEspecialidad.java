
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

    @Override
    public LinkedList<Medico> listadoIngresos(int añoDeIngreso) {
        LinkedList <Medico> misMedicos = this.inOrden();
        LinkedList <Medico> listado = new LinkedList <Medico>();
        for (Medico med : misMedicos){
            if (med.getIngreso()>= añoDeIngreso){
                listado.add(med);
            }
        }
        return listado;
    }

   
}
