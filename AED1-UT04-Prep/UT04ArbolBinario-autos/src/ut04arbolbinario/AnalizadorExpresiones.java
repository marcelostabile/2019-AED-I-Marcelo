/*
 * ANALIZADOR DE EXPRESIONES ARITMÉTICAS.
 */
package ut04arbolbinario;

/**
 * @author mstabile.
 */
public class AnalizadorExpresiones {
    
    // Atributos.
    protected String expresionRecibida;

    // Crear el árbol para análisis.
    protected IArbolBB arbolBB = new TArbolBB();
    
    // Crear la pila para análisis.
    protected ILista pilaDeParentesis = new Lista();
    
    // Constructor.
    public AnalizadorExpresiones () {
        this.expresionRecibida = null;
    }

    // Expresión Recibida.
    public String getExpresion() {
        return this.expresionRecibida;
    }
    
    public void setExpresion(String expresionParaAnalizar) {
        this.expresionRecibida = expresionParaAnalizar;
    }
    
    /**
     * Procesar la expresión ingresándola en el àrbol.
     */
     public void cargarExpresionEnArbol (String expresion) {
         
         // Se procesa si la expresión existe.
         if (this.expresionRecibida != null) {
             
             
             
             
             
             
             
             
             
             
             
             
             
             
         }
         else {
             // La expresión no fue cargada o está vacía.
             System.out.println("La expresión no fue cargada o está vacía !");
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
