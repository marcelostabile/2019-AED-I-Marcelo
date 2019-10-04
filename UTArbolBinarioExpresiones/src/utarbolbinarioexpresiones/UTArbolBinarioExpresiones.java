/*
 * ÁRBOL BINARIO DE EXPRESIONES.
 */
package utarbolbinarioexpresiones;

/**
 * @author mstabile
 */
public class UTArbolBinarioExpresiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Expresiones.
        String expresion1 = "((2+3)*2)+(2*(2+3))";  // 10+10 = 20
        String expresion2 = "(2+3*2)+(2*2+3)";      // 8+7 = 15
        String expresion3 = "(2+3*2+2*2+3)+1";      // 2+6+4+3 = 15+1 = 16

        // Analizador.
        IAnalizadorExpresiones analizador = new AnalizadorExpresiones();
        
        // Analizar las expresiones.
        analizador.setExpresion(expresion1);
        analizador.imprimirExpresion();
        analizador.imprimirResultado();
        System.out.println("");
        
        // Analizar las expresiones.
        analizador.setExpresion(expresion2);
        analizador.imprimirExpresion();
        analizador.imprimirResultado();
        System.out.println("");

                // Analizar las expresiones.
        analizador.setExpresion(expresion3);
        analizador.imprimirExpresion();
        analizador.imprimirResultado();
        System.out.println("");

    }
}
