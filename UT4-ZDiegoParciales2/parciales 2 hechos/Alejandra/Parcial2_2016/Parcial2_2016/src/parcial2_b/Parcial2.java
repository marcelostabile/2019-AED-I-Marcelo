package parcial2_b;

import parcial2.*;



public class Parcial2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();
        arbol.insertar(new TElementoAB(1, new Producto(1,25)));
        arbol.insertar(new TElementoAB(2, new Producto(2,27)));
        arbol.insertar(new TElementoAB(3, new Producto(3,14)));
        System.out.println(arbol.mayorValor(0, 1));
        // leer las claves del archivo "claves.txt" e insertar en el árbol nodos con estas claves
		// ATENCIÓN: LAS CLAVES SON NUMEROS ENTEROS, Y DEBEN SER TRATADOS COMO TALES 
		
		// invocar al método cantNodosInternosCompletos() y emitir por consola el resultado
    }

}
