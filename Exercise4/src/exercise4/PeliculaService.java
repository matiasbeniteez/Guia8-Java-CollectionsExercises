/*
En el main deberemos tener un bucle que crea un objeto Pelicula pidiéndole al
usuario todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si
quiere crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo
en pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo
en pantalla.
• Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package exercise4;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class PeliculaService {

    private ArrayList<Pelicula> peliculas;
    private Scanner read;

    public PeliculaService() {
        this.peliculas = new ArrayList();
        this.read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }

    public void crearPelicula(String titulo, String director, LocalTime duracionPelicula) {
        Pelicula peliculas = new Pelicula();

        peliculas.setTitulo(titulo);
        peliculas.setDirector(director);
        peliculas.setDuracionPelicula(duracionPelicula);

        agregarPelicula(peliculas);
    }

    public void agregarPelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }

    public void datosPelicula() {
        int horas, minutos;
        LocalTime duracionPelicula;

        System.out.println("INGRESE NOMBRE DE LA PELICULA: ");
        String name = read.next();

        System.out.println("INGRESE DIRECTOR DE LA PELICULA: ");
        String director = read.next();

        System.out.println("INGRESE DURACION DE LA PELICULA EN FORMATO (HORAS : MINUTOS)");
        System.out.println("INGRESE HORAS: ");
        horas = read.nextInt();
        while (horas < 0 || horas > 23) {
            System.out.println("ERROR! INGRESE LA DURACION CORRECTA: ");
            horas = read.nextInt();
        }
        System.out.println("INGRESE MINUTOS: ");
        minutos = read.nextInt();
        while (minutos < 0 || minutos > 60) {
            System.out.println("ERROR! INGRESE LA DURACION CORRECTA: ");
            minutos = read.nextInt();
        }

        duracionPelicula = LocalTime.of(horas, minutos);
        crearPelicula(name, director, duracionPelicula);
    }

    public void mostrarPeliculas() {

        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.toString());
        }
    }

    public void peliculasMayor1Hora() {

        for (Pelicula i : peliculas) {
            if (i.getDuracionPelicula().getHour() < 1) {
                System.out.println(i);
            }
        }

    }

    public void procesamientoPrincipal() {
        String opcion = "";

        do {
            if (this.peliculas.isEmpty()) {
                datosPelicula();
            } else {
                System.out.println("DESEA INGRESAR OTRA PELICULA? ");
                opcion = this.read.next().toUpperCase();

                switch (opcion) {
                    case "S":
                        datosPelicula();
                        break;
                    case "N":
                        System.out.println("OPERACION FINALIZADA!");
                        mostrarOrdenamientos();
                        break;
                    default:
                        System.out.println("LA OPCION INGRESADA NO ES VALIDA");
                        break;
                }
            }
        } while (!opcion.equals("N"));
    }

    public void mostrarOrdenamientos() {
        System.out.println("   -- PELICULAS INGRESDAS --  ");

        for (Pelicula i : peliculas) {
            System.out.println(i);
        }

        Collections.sort(peliculas, new ComparatorDuracionAsc());
        System.out.println("Pelicula por duracion Ascendente: " + peliculas);

        Collections.sort(peliculas, new ComparatorDuracionDesc());
        System.out.println("Pelicula por duracion descendente: " + peliculas);

        Collections.sort(peliculas, new ComparatorTitulo());
        System.out.println("Pelicula ordenada por Titulo: " + peliculas);

        Collections.sort(peliculas, new ComparatorDirector());
        System.out.println("Pelicula ordenada por director: " + peliculas);
        

    }

}
