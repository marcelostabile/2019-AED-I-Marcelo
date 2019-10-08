
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
        /*
        si la especialidad no es nula entonces busco la especialidad
        */
        LinkedList<Medico> lista = new LinkedList<Medico>();
        TArbolBB arbolEspecialidad = null;
        boolean inserteAlgo=false;
        if (añoDeIngreso!=0){
              /*
              Creo la lisata donde me devolveran los nodos del arbol ordenados en orden
              */
              LinkedList <Medico>listaInorden = null;
              listaInorden = new LinkedList<>();
              if (!this.esVacio()){
                  /* 
                  si el arbol de plantilla de medicos no esta vacio 
                  entonces me traigo la lista ordenada
                  */
                listaInorden = this.inOrden();
                /*3
                recorro la lista buscando la especialidad para armar el nuev arbol
                */
                for (int i = 0; i < listaInorden.size(); i++) {
                    if (listaInorden.get(i).getIngreso()==(añoDeIngreso)){
                        /*
                        si son iguales lo inserto en el nuevo arbol
                        */
                        //IElementoAB e = new TElementoAB(listaInorden.get(i).getNombre(), listaInorden.get(i));
                        boolean insertar;
                        //insertar = arbolEspecialidad.insertar(e);
                        lista.add(listaInorden.get(i));
                        insertar=true;
                        if (insertar==true){
                           inserteAlgo=true; 
                        }     
                    }
                        
                }
              
           }   
          }
        if (inserteAlgo==true){
            return lista;
        }else{
          return null;
        }
    }

   
}
