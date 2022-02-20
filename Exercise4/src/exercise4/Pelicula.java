
package exercise4;

import java.time.LocalTime;

public class Pelicula {
    
    private String titulo;
    private String director;
    private LocalTime duracionPelicula;
    
    public Pelicula(){
        
    }
    
    public Pelicula(String titulo, String director, LocalTime duracionPelicula){
        this.titulo = titulo;
        this.director = director;
        this.duracionPelicula = duracionPelicula ;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalTime getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(LocalTime duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "titulo= " + titulo + ", director= " + director + ", duracionPelicula= " + duracionPelicula + '}';
    }

    
 
    
    }
    
