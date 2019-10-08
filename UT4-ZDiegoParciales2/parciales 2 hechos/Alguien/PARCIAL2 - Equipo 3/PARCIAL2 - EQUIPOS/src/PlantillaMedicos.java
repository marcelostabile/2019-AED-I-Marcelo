
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
public class PlantillaMedicos extends TArbolBB<Medico> implements IPlantillaMedicos {

    @Override
    public DirectorioEspecialidad obtenerDirectorio(String laEspecialidad) {
        DirectorioEspecialidad miPlantilla = new DirectorioEspecialidad();
        LinkedList<Medico> misMedicos = inOrden();
        if (getRaiz()!= null){
            for (Medico medic : misMedicos){
                if (medic.getEspecialidad().equals(laEspecialidad)){
                    TElementoAB m = new TElementoAB(medic.getNombre(),medic);
                    miPlantilla.insertar(m);
                }
            }
        }
        return miPlantilla;
    }

  
  
}
