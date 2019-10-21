/*
 * ANALIZADOR DE EXPRESIONES.
 */
package utarbolbinarioexpresiones;

/**
 * @author mstabile
 */
public class AnalizadorExpresiones {

    // Crear árbol.
    protected IArbolBE<String> arbolBExpr = new TArbolBE<>();

    // Crear pila de paréntesis.
    protected IPila<String> pilaParentesis = new Pila();
    
    /**
     * Analizar la expresión.
     * 
     * @param expresionParaAnalizar - Expresión para analizar.
     * @return un árbol con la expresión.
     */
     public IArbolBE<String> analizarExpresion(String expresionParaAnalizar) { 
        
        String expr = expresionParaAnalizar;
        
        // Recorro el string, insertando los elementos en el árbol.
        for (int i = 0; i < expr.length(); i++) { 
            
            char c = expr.charAt(i);
            
            /** 
             * Caso 1: es paréntesis izquierdo.
             * 
             * Crear nodo, apilarlo en la pila, hacerlo nodoActual.
             */
            if (c == '(') {
                
                TElementoAB<String> unElemento = new TElementoAB(i, null);
                
                arbolBExpr.insertar(unElemento);
                
                INodo<String> unNodo = new Nodo(i, null);
                
                pilaParentesis.apilar(unNodo);
                
                
                
            }
            
            
            
            
            
            
            
        }
                 
         else {
             // La expresión no fue cargada o está vacía.
             System.out.println("La expresión tiene valor nulo!");
         }
     }
    
    /**
     * Retornar el árbol generado.
     * 
     * @return árbol generado.
     */
    public IArbolBB retornarArbolGenerado() { 
        return this.arbolBB; 
    }
    
    /**
     * Retornar resultado de las operaciones.
     * 
     * @return resultado de las operaciones sobre la expresión aritmética.
     */
    
    
      

    
}
