
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
        /*
        si la especialidad no es nula entonces busco la especialidad
        */
        DirectorioEspecialidad arbolEspecialidad = null;
        boolean inserteAlgo=false;
        if (!laEspecialidad.isEmpty()){
              /*
              Creo la lisata donde me devolveran los nodos del arbol ordenados en orden
              */
              LinkedList <Medico>listaInorden = null;
              listaInorden = new LinkedList<>();
              boolean insertar=false;
              if (!this.esVacio()){
                  /* 
                  si el arbol de plantilla de medicos no esta vacio 
                  entonces me traigo la lista ordenada
                  */
                listaInorden = this.inOrden();
                /*
                recorro la lista buscando la especialidad para armar el nuev arbol
                */
                for (Medico med:listaInorden) {
                    if(med!=null){
                        if (med.getEspecialidad().equals(laEspecialidad)){
                            /*
                            si son iguales lo inserto en el nuevo arbol
                            */
                            //insertar = arbolEspecialidad.insertar(e);
                            insertar = arbolEspecialidad.insertar(new TElementoAB(med.getNombre(), med));

                        }
                        if (insertar==true){
                            inserteAlgo=true; 
                        }
                    }
                        
                }
              
           }   
          }
        if (inserteAlgo==true){
            return arbolEspecialidad;
        }else{
          return null;
        }
    }
    
    

  
  
}
