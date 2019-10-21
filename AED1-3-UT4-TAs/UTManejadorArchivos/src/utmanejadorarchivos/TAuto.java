/*
 * INTERFASE
 */
package utmanejadorarchivos;

/**
 *
 * @author EQUIPO
 */
public class TAuto implements IAuto {
    
    // Atributos.
    private String marca = null;
    private String modelo = null;
    private String matricula = null;
    
    // Constructor.
    public TAuto (String marca, String modelo, String matricula) { 
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }
    
    // Matrícula.
    public String getMatricula() {
        return this.matricula;
    }
    
    // Imprimir datos del vehículo.
    @Override
    public void imprimirDatos() {
        System.out.println("Marca: " + this.marca + " - Modelo: " + this.modelo + " - Matrícula: " + this.matricula);
    }
    
}
