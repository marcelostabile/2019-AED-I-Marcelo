
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gianluca Positano
 */

/*

*/
public class PlantillaMedicos extends TArbolBB<Medico> implements IPlantillaMedicos {
    /*
    
    */
    @Override
    /*
    Este metodo devuelve el directorio de esa especialidad
    */
    public TArbolBB obtenerDirectorio(String laEspecialidad) {
        if (esVacio()) {
            return null;
        } else {
            TArbolBB res  = new TArbolBB();
            this.getRaiz().obtenerDirectorio(res, laEspecialidad);
            return res;
        }
    }

  
  
}
