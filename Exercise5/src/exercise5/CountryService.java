/*
5. Se requiere un programa que lea y guarde países, y para evitar que se ingresen
repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se
guardará el país en el conjunto y después se le preguntará al usuario si quiere
guardar otro país o si quiere salir, si decide salir, se mostrará todos los países
guardados en el conjunto.
Después deberemos mostrar el conjunto ordenado alfabéticamente para esto
recordar como se ordena un conjunto.
Y por ultimo, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator,
se buscará el país en el conjunto y si está en el conjunto se eliminará el país que
ingresó el usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto
se le informará al usuario.
 */
package exercise5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class CountryService {

    private HashSet<String> setPaises;
    private Scanner read;

    public CountryService() {
        this.setPaises = new HashSet<>();
        this.read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }

    public void ingresarPais() {

        System.out.println("INGRESE UN PAIS: ");
        String pais = read.next();

        setPaises.add(pais);

    }

    public void mostrarPaises() {

        for (String pais : setPaises) {
            System.out.println(pais);
        }
    }

    public void procesamientoPrincipal() {
        ArrayList<String> list;
        String opcion = "";

        do {

            if (this.setPaises.isEmpty()) {
                ingresarPais();
            } else {
                System.out.println("DESEA INGRESAR OTRO PAIS? (S/N) ");
                opcion = read.next().toUpperCase();

                switch (opcion) {
                    case "S":
                        ingresarPais();
                        break;
                    case "N":
                        System.out.println("OPERACION FINALIZADA!");
                        mostrarPaises();
                        System.out.println("CONJUNTO ORDENADO ALFABETICAMENTE: ");
                        list = new ArrayList(setPaises);
                        Collections.sort(list);
                        for (String i : list) {
                            System.out.println(i);
                        }
                        break;
                    default:
                        System.out.println("OPCION INVALIDA ");
                        break;
                }
            }
        } while (!opcion.equals("N"));

    }

    public void procesamientoSecundario() {

        Iterator<String> it = setPaises.iterator();
        boolean bandera = false;

        System.out.println("INGRESE PAIS A ELIMINAR: ");
        String borrar = read.next();

        while (it.hasNext()) {
            if (it.next().equals(borrar)) {
                it.remove();
                bandera = true;
                System.out.println("EL PAIS SE ELIMINO CORRECTAMENTE!");
                break;
            }
            if (!bandera) {
                System.out.println(borrar + " NO SE ENCUENTRA EN EL CONJUNTO");
            }
            break;

        }
    }
}
