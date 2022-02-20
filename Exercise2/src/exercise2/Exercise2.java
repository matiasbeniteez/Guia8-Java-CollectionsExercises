/*
2. Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y
se mostrará la lista ordenada.
 */
package exercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        ArrayList<String> raza = new ArrayList();
        char respuesta;
        boolean bandera = false;

        do {
            System.out.println("Ingrese una raza de perro: ");
            String razas = read.next();
            raza.add(razas);
            System.out.println("Desea ingresar otra raza?\n Si / No");
            respuesta = read.next().charAt(0);

        } while (respuesta != 'n');

       /* System.out.println("------------------");
        for (String element : raza) {
            System.out.println(element);
        }
        System.out.println("------------------"); */

        System.out.println("Ingrese raza a eliminar: ");
        String eliminar = read.next();

        Iterator<String> it = raza.iterator();
        while (it.hasNext()) {
            if (it.next().equals(eliminar)) {
                it.remove();
                bandera=true;
            }

        }
        if(!bandera){
            System.out.println("La raza " + eliminar + " no se encuentra en la lista");
        }

        System.out.println("-- LISTA ORDENADA --");
        for (String element : raza) {
            System.out.println(element);
        }

    }

}
