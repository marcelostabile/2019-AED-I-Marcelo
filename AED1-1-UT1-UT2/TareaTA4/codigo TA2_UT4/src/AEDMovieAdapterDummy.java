/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aed1.obligatorio2016.alumnos;

/**
 *
 * @author Josse
 */
public class AEDMovieAdapterDummy implements IAEDMovieAdapter{
    private String [][] peliculas;
    private String [][] actores;
    private String [][] peliculasActores;
        
    @Override
    public void cargarDatos() {
        //Carga datos
        peliculas = new String[3][3];
        peliculas[0][0] = "1001";
        peliculas[0][1] = "DeadPool";
        peliculas[0][2] = "2016";
        peliculas[1][0] = "998";
        peliculas[1][1] = "50 shades of grey";
        peliculas[1][2] = "2015";
        peliculas[2][0] = "25";
        peliculas[2][1] = "Top Gun";
        peliculas[2][2] = "1986";

        actores = new String[4][2];
        actores[0][0] = "253";
        actores[0][1] = "Ryan Reynolds";
        actores[1][0] = "200";
        actores[1][1] = "Tom Cruise";
        actores[2][0] = "300";
        actores[2][1] = "Kelly McGillis";
        actores[3][0] = "450";
        actores[3][1] = "Dakota Johnson";

        peliculasActores = new String[4][2];
        peliculasActores[0][0] = "1001";
        peliculasActores[0][1] = "253";
        peliculasActores[1][0] = "998";
        peliculasActores[1][1] = "450";
        peliculasActores[2][0] = "25";
        peliculasActores[2][1] = "200";
        peliculasActores[3][0] = "25";
        peliculasActores[3][1] = "300";
    }

    @Override
    public String[][] obtenerPeliculas() {
        return peliculas;
    }

    @Override
    public String[][] obtenerActores() {
           return actores;
    }

    @Override
    public String[][] obtenerPeliculasActores() {
        return peliculasActores;
    }
    
    public String obtenerInfoPelicula(String nombrePelicula){
        //todo:
    }
    
    private String getNombreActor(String idActor) {
        //todo:
    }
}
