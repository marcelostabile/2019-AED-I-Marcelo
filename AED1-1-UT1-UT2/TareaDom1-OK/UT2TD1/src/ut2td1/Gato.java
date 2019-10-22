/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut2td1;

/**
 *
 * @author estudiante.fit
 */
public class Gato implements IGato, IMamifero {
    
    // atributos.
    private String nombre;
    
    // constructor.
    public Gato (String unNombre) {
        this.nombre = unNombre;
    }
    
    // método.
    @Override
    public String getNombre () {
        return this.nombre;
    }
    
    // método.
    @Override
    public void maullar() {
        System.out.println("miaauuu!!!");
    }
    
    // método.
    @Override
    public boolean respondeA(String unNombre) {
        return false; // Los gatos nunca responden !!!
    }

    @Override
    public void caminar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void correr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saltar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
