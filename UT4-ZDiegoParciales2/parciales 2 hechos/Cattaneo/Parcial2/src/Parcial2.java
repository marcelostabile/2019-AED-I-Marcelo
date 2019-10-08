import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Parcial2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br;
        BufferedWriter bw;

        /**
         *
         * LEER ATENTAMENTE LAS INDICACIONES.
         *
         * Paso 1:
         *
         * 1.1 - instanciar un árbol de piezas (desciende de árbol binario de
         * búsqueda)
         *
         * 1.2 - cargar las piezas del archivo "piezas.txt" e insertarlas en el
         * árbol
         *
         */
        String campos[];
        TArbolPiezas arbol = new TArbolPiezas();
        br = new BufferedReader(new FileReader("src/piezas.txt"));
        for (String linea = ""; (linea = br.readLine()) != null; /**/) {
            campos = linea.split(",");
            arbol.insertar(new TElementoAB<>(campos[0], new Pieza(campos[0], campos[1], campos[2], Integer.parseInt(campos[3]), Integer.parseInt(campos[4]))));
        }
        br.close();
        
        
        /**
         * Paso 2:
         *
         * 2.1 - Invocar al método “cantYvalorStock” del árbol y mostrar por
         * pantalla los valores de cantidad total de piezas existentes y valor
         * total del stock.
         *
         */
        int cantValor[] = arbol.cantYvalorStock();
        System.out.printf("Cantidad total: %s\n", cantValor[0]);
        System.out.printf("Valor total: %s\n", cantValor[1]);
        
        /**
         * Paso 3:
         *
         * guardar un archivo "deposito.txt" conteniendo el listado - ordenado
         * ascendentemente por código de pieza - de todas las piezas del stock.
         * en cada línea debe aparecer: CODIGO, VALOR MONETARIO de la pieza en
         * stock - cantidad * precio
         *
         */
        Lista<Pieza> lista = arbol.inorden();
        Nodo<Pieza> nodoActual = lista.getPrimero();
        Pieza piezaActual;
        bw = new BufferedWriter(new FileWriter("src/deposito.txt"));
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            // Escribo línea
            bw.write(piezaActual.getCodigoPieza() + ", " + piezaActual.getValorEnStock() + "\n");
            nodoActual = nodoActual.getSiguiente();
        }
        bw.close();
        
        
        /**
         * Paso 4:
         *
         * crear un nuevo arbol de piezas que contenga solamente las piezas del
         * rubro indicado en el pizarron, y luego emitir un archivo
         * "porRubro.txt" conteniendo el listado - ordenado ascendentemente por
         * código de pieza - de todas las piezas contenidas en este árbol, con
         * el mismo formato que el archivo "deposito.txt"
         *
         */
        TArbolPiezas arbolRubro10 = arbol.piezasPorRubro("10");
        lista = arbolRubro10.inorden();
        // Creo nuevo árbol que tiene como etiqueta el código de pieza
        // pero sólo contiene piezas del rubro 10
        TArbolPiezas arbolRubro10Ordenado = new TArbolPiezas();
        nodoActual = lista.getPrimero();
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            // Inserto en nuevo árbol
            arbolRubro10Ordenado.insertar(new TElementoAB<>(piezaActual.getCodigoPieza(), piezaActual));
            nodoActual = nodoActual.getSiguiente();
        }
        // Recorro nuevo árbol de rubro 10 (ordenado por código de pieza) y genero archivo
        lista = arbolRubro10Ordenado.inorden();
        nodoActual = lista.getPrimero();
        bw = new BufferedWriter(new FileWriter("src/porRubro.txt"));
        while (nodoActual != null) {
            piezaActual = nodoActual.getDato();
            // Escribo línea
            bw.write(piezaActual.getCodigoPieza() + ", " + piezaActual.getValorEnStock() + "\n");
            nodoActual = nodoActual.getSiguiente();
        }
        bw.close();
        
        /* por último, imprimir por consola la cantidad de piezas y el valor de stock
        de las piezas del rubro indicado
         */
        cantValor = arbolRubro10.cantYvalorStock();
        System.out.printf("Cantidad total de rubro 10: %s\n", cantValor[0]);
        System.out.printf("Valor total de rubro 10: %s\n", cantValor[1]);
    }
}
