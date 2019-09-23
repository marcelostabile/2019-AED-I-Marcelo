/*
 * ANALIZADOR DE EXPRESIONES ARITMÉTICAS.
 */
package ut04arbolbexpresiones;

/**
 * @author mstabile.
 */
public class AnalizadorExpresiones {
    
    // Atributos.
    protected String expresion;

    // Crear el árbol para análisis.
    protected IArbolBinario<T> arbolBinario = new ArbolBinario<>();

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
    
    public void setExpresion(String expresionParaAnalizar) {
        this.expresion = expresionParaAnalizar;
    }

    /**
     * Procesar la expresión ingresándola en el árbol.
     */
     public void cargarExpresionEnArbol () {

         // Asigno a expr la expresión existente en el objeto. Se debió cargar previamente.
         String expr = this.expresion;

         // Se procesa solo si la expresión existe.
         if (this.expresion != null) { 

             // Recorro el string, insertando los elementos en el árbol.
             for (int i = 0; i < expresion.length(); i++) { 
                 
                 
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
