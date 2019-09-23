/*
 * ANALIZADOR DE EXPRESIONES ARITMÉTICAS.
 */
package ut04arbolbinario;

/**
 * @author mstabile.
 */
public class AnalizadorExpresiones {
    
    // Atributos.
    protected String expresion;

    // Crear el árbol para análisis.
    protected IArbolBB arbolExpr = new TArbolBB();

    // Crear la pila para análisis.
    protected ILista pilaParentesis = new Lista();
    
    // Constructor.
    public AnalizadorExpresiones () {
        this.expresion = null;
    }

    // Expresión Recibida.
    public String getExpresion() {
        return this.expresion;
    }
    
    public void setExpresion(String unaExpresion) {
        this.expresion = unaExpresion;
    }

    /**
     * Procesar la expresión ingresándola en el árbol.
     */
     public void analizarExpresion (String expresionParaAnalizar) {

        // Se procesa solo si la expresión existe.
        if (this.expresion != null) { 

            // Asigno la expresión existente al objeto que se debió cargar previamente.
            char[] exprAux = this.expresion.toCharArray();
            
            // Recorrrer el array de carácteres.
            for (int i = 0; i < exprAux.length; i++) {
                
                // Tomo el caracter.
                String charAux = Character.toString(exprAux[i]);
                
                // Caso: Descartamos los blancos.
                if (charAux != " ") {
                    
                    if (arbolExpr) {
                        
                    }
                    // Caso: es un "(".
                    if (charAux == "(") {
                        
                        TElementoAB unElemento = new TElementoAB(exprAux[i], null);
                        
                        arbolExpr.insertar(unElemento);
                        
                    }
                    
                    
                    
                    
                    
                }
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
