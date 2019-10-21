/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;


public class TAlumno {
    private final int cedula;
    private final String apellido;
    private final String carrera;
    private final boolean matriculado;

    
    TAlumno(int unaCedula, String unApellido, String unaCarrera, boolean matriculado){
        this.cedula = unaCedula;
        this.apellido = unApellido;
        this.carrera = unaCarrera;
        this.matriculado=matriculado;
    }
    public int getCedula(){
        return cedula;
    }
     public String getApellido(){
        return apellido;
    }
    public String getCarrera(){
        return carrera;
    }
    public boolean getMatriculado(){
        return matriculado;
    }
     
    public String imprimir() {
        return ("Apellido: "+ apellido + ", Carrera: "+ carrera + ", Matriculado: " + matriculado) ;
    }
    
}
