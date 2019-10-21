/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed1.obligatorio2016.alumnos;

import aed1.obligatorio2016.catedra.*;

/**
 *
 * @author Josse
 */
public interface IAEDMovieAdapter {
    void cargarDatos();
    String [][] obtenerPeliculas();
    String [][] obtenerActores();
    String [][] obtenerPeliculasActores();
}
