/*
1. Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String.
El programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si
decide salir, se mostrará todos los perros guardados en el ArrayList.
 */
package exercise1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);

        ArrayList<String> raza = new ArrayList<>();

        char respuesta;

        do {
            System.out.println("Ingrese una raza de perro: ");
            String razas = read.next();
            raza.add(razas);
            System.out.println("Desea ingresar otra raza?\n si/no");
            respuesta = read.next().charAt(0);
        } while (respuesta != 'n' );

        for ( String element : raza){
            System.out.println(element);
        }

    }

}
