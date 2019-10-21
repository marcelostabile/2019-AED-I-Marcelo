/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2_b;

/**
 *
 * @author usuario
 */
public class Producto {
    private final int codigo;

    public int getCodigo() {
        return codigo;
    }

    public int getValor() {
        return valor;
    }
    private final int valor;

    public Producto(int Codigo, int Valor) {

        this.codigo = Codigo;
        this.valor = Valor;
    }
}
