/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Josse
 */
public class Programa {
    static Lista listaSuero;
    static Lista listaFarmacos;
    static Lista listaBlancaLista;
    static Lista listaNegraLista;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ejercicio1();
        
        //--- PREPARADO 1
        Lista unaListaF1 = new Lista();
        Nodo unNodo = new Nodo("273",null);
        unaListaF1.insertar(unNodo);
        
        System.err.println("Preparado 1 viable "+preparadoViable ("7",unaListaF1));
        //--- PREPARADO 2
        Lista unaListaF2 = new Lista();
        unNodo = new Nodo("223",null);
        unaListaF2.insertar(unNodo);
        
        System.err.println("Preparado 3 viable "+preparadoViable ("7",unaListaF2));
        //--- PREPARADO 3
        Lista unaListaF3 = new Lista();
        unNodo = new Nodo("31",null);
        unaListaF3.insertar(unNodo);
        
        //--- PREPARADO 4
        Lista unaListaF4 = new Lista();
        unNodo = new Nodo("230",null);
        unaListaF4.insertar(unNodo);
        System.err.println("Preparado 4 viable "+preparadoViable ("16",unaListaF4));
    }

    public static void ejercicio1() {
        // Cargo sueros
       String[] suerosArray = ManejadorArchivosGenerico.leerArchivo("src/Sueros.txt");
       listaSuero = new Lista();
        for (String sueros : suerosArray) {
            Suero unSuero = new Suero();
            unSuero.sueroID = sueros.split(",")[0];
            unSuero.sueroNombre = sueros.split(",")[1];
            Nodo unSueroNodo = new Nodo(unSuero.sueroID,unSuero);
          
            listaSuero.insertar(unSueroNodo);
        }
        
        // Cargo farmacos
        String[] farmacosArray = ManejadorArchivosGenerico.leerArchivo("src/farmacos.txt");
        listaFarmacos = new Lista();
        for (String farmacos : farmacosArray) {
            Farmaco unFarmaco = new Farmaco();
            unFarmaco.farmacoID = farmacos.split(",")[0];
            unFarmaco.farmacoNombre = farmacos.split(",")[1];
            Nodo unFarmacoNodo = new Nodo(unFarmaco.farmacoID, unFarmaco);
            
            listaFarmacos.insertar(unFarmacoNodo);
        }
        
        //Cargo listablanca
        String[] listaBlancaArray = ManejadorArchivosGenerico.leerArchivo("src/listablanca.txt");
        listaBlancaLista = new Lista();
        for (String listaBlancaitem : listaBlancaArray) {
            Nodo unNodoListaBlanca = new Nodo(listaBlancaitem,null);
            listaBlancaLista.insertar(unNodoListaBlanca);
        }

        //Cargo listaNegra
        String[] listaNegraArray = ManejadorArchivosGenerico.leerArchivo("src/listanegra.txt");
        listaNegraLista = new Lista();
        for (String listaNegraitem : listaNegraArray) {
            String idSuero = listaNegraitem.split(",")[0];
            String idFarmaco = listaNegraitem.split(",")[1];
            
            Nodo nodoBuscado = listaNegraLista.buscar(idSuero);
            if(nodoBuscado == null){
                Nodo unNodoListaNegra = new Nodo(idSuero,null);
                Lista listaFarmacosListaNegra = new Lista();
                Nodo farmacoListaNegra = new Nodo(idFarmaco,null);
                listaFarmacosListaNegra.insertar(farmacoListaNegra);
                                
                unNodoListaNegra.setDato(listaFarmacosListaNegra);
                listaNegraLista.insertar(unNodoListaNegra);
            }else{
                Nodo nodoElBuscado =(Nodo)nodoBuscado;
                Lista listaFarmacosListaNegra = (Lista)nodoElBuscado.getDato();
                Nodo farmacoListaNegra = new Nodo(idFarmaco, null);
                listaFarmacosListaNegra.insertar(farmacoListaNegra);
            }
        }
    }
    
    public static boolean preparadoViable (String idSuero,Lista listaFarmacos){
        Nodo unFarmaco = listaFarmacos.getPrimero();
        while(unFarmaco!=null){
            INodo nodoBuscado = listaBlancaLista.buscar(unFarmaco.getEtiqueta());
            if(nodoBuscado==null){
                return false;
            }
            unFarmaco = unFarmaco.getSiguiente();
        }
        
        // Validó por lista blanca, entonces chequeo por lista negra
        INodo inodoListaNegra = listaNegraLista.buscar(idSuero);
        if (inodoListaNegra != null) { //tengo que ver si alguno de los farmacos están...
            Nodo nodoListaNegra = (Nodo) inodoListaNegra;
            Lista listaNegraFarmacos = (Lista) nodoListaNegra.getDato();
            
            unFarmaco = listaFarmacos.getPrimero();
            while (unFarmaco != null) {
                INodo nodoBuscado = listaNegraFarmacos.buscar(unFarmaco.getEtiqueta());
                if (nodoBuscado != null) {
                    return false;
                }
                unFarmaco = unFarmaco.getSiguiente();
            }
        }
        
        return true;
    }
}
