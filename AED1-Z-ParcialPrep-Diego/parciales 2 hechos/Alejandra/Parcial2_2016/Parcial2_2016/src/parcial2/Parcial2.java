package parcial2;



public class Parcial2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBB arbol = new TArbolBB();
        arbol.cargarArchivo("src/parcial2/claves.txt");
        System.out.println(arbol.cantNodosInternosCompletos());
        // leer las claves del archivo "claves.txt" e insertar en el árbol nodos con estas claves
		// ATENCIÓN: LAS CLAVES SON NUMEROS ENTEROS, Y DEBEN SER TRATADOS COMO TALES 
		
		// invocar al método cantNodosInternosCompletos() y emitir por consola el resultado
    }

}
