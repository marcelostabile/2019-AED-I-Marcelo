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
public class UT2TD1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // instanciar animales.
        IPerro bobby = new Perro("Bobby");
        IGato misifu = new Gato("Misifu");
        
        // imprimir nombres.
        System.out.println(bobby.getNombre());
        System.out.println(misifu.getNombre());
        
        // ladrar y maullar.
        bobby.ladrar();
        misifu.maullar();
        
        // preguntar nombre.
        System.out.println(bobby.respondeA("Bobby"));
        System.out.println(misifu.respondeA("Misifu"));
        
    }

}
