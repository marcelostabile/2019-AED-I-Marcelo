
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class TArbolPiezas extends TArbolBB<Pieza> implements IArbolPiezas {
    
    @Override
    public TArbolPiezas piezasPorRubro(String unRubro) {
        TArbolPiezas arbol;
        Nodo<Pieza> nodoActual;
        Lista<Pieza> lista;
        Pieza piezaActual;
        
        arbol = new TArbolPiezas();
        
        if (this.getRaiz() == null)
            return arbol;
        
        // Genero lista inorden del arbol y recorro
        lista = this.inorden();
        nodoActual = lista.getPrimero();
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            // Inserto pieza si coincide con rubro
            if (piezaActual.obtenerRubro().equals(unRubro))
                arbol.insertar(new TElementoAB<>(piezaActual.getCodigoCatalogo(), piezaActual));
            nodoActual = nodoActual.getSiguiente();
        }
        
        // Retorno nuevo arbol
        return arbol;
    }
   

    @Override
    public int[] cantYvalorStock() {
        int cantValor[];
        Nodo<Pieza> nodoActual;
        Lista<Pieza> lista;
        Pieza piezaActual;
        
        cantValor = new int[2];
        
        if (this.getRaiz() == null)
            return cantValor;
        
        // Genero lista inorden del arbol y recorro
        lista = this.inorden();
        nodoActual = lista.getPrimero();
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            // Actualizo arreglo
            cantValor[0] += piezaActual.getCantidad();
            cantValor[1] += piezaActual.getValorEnStock();
            nodoActual = nodoActual.getSiguiente();
        }
        
        // Retorno arreglo
        return cantValor;
    }

}
