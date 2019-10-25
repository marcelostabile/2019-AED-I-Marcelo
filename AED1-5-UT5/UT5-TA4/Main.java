
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/palabras2.txt");
        int cantElementos = lineas.length;

        CalculadorMatricesOptimo calculador = new CalculadorMatricesOptimo(cantElementos);
        String[] claves = new String[cantElementos + 1];
        int[] frecExito = new int[cantElementos + 1];
        int[] frecNoExito = new int[cantElementos + 1];

        for (int i = 0; i < cantElementos; i++) {
            String[] datos = lineas[i].split(" ");
            claves[i + 1] = datos[0].trim();
            frecExito[i + 1] = Integer.parseInt(datos[1]);
        }
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/nopalabras2.txt");
        for (int i = 0; i <= cantElementos; i++) {
            frecNoExito[i] = Integer.parseInt(lineas2[i]);
        }

        calculador.calcularMatrices(cantElementos, frecExito, frecNoExito);

        System.out.println("Raiz: " + calculador.R[0][cantElementos]);
        System.out.println("Matriz R: ");
        Util.imprimirMatriz(calculador.R);
        System.out.println("Matriz P: ");
        Util.imprimirMatriz(calculador.P);
        System.out.println("Matriz W: ");
        Util.imprimirMatriz(calculador.W);

        System.out.println("costo del arbol optimo : " + calculador.P[0][cantElementos]);
        TArbolBB elArbol = new TArbolBB();

        calculador.armarArbolBinario(0, cantElementos, claves, elArbol);

        // listar por consola el inorden y el posorden del árbol

       
    }
}
