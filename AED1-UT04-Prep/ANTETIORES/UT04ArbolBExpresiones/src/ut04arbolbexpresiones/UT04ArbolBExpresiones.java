/*
 * ANALIZAR EXPRESIONES ARITMÉTICAS.
 */
package ut04arbolbexpresiones;

/**
 * @author mstabile
 */
public class UT04ArbolBExpresiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Expresiones.
        String expresionAritmetica1 = "((2+3)*2)+(2*(2+3))";    // 10+10 = 20
        String expresionAritmetica2 = "(2+3*2)+(2*2+3)";        // 8+7 = 15
        String expresionAritmetica3 = "(2+3*2+2*2+3)+1";          // 2+6+4+3 = 15+1 = 16
        
        // Analizadores.
        IAnalizadorExpresiones analizaExpr1 = new AnalizadorExpresiones();
        IAnalizadorExpresiones analizaExpr2 = new AnalizadorExpresiones();
        IAnalizadorExpresiones analizaExpr3 = new AnalizadorExpresiones();
        
        // Cargar las expresiones.
        analizaExpr1.setExpresion(expresionAritmetica1);
        analizaExpr2.setExpresion(expresionAritmetica2);
        analizaExpr3.setExpresion(expresionAritmetica3);
        
        // Imprimir las expresiones y los resultados por consola.
        analizaExpr1.imprimirExpresion();
        analizaExpr1.imprimirResultado();
        System.out.println("");
        
        analizaExpr2.imprimirExpresion();
        analizaExpr2.imprimirResultado();
        System.out.println("");
        
        analizaExpr3.imprimirExpresion();
        analizaExpr3.imprimirResultado();
        System.out.println("");
    }
}
