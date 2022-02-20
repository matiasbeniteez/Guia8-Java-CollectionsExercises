/*
6. Se necesita una aplicación para una tienda en la cual queremos almacenar los
distintos productos que venderemos y el precio que tendrán. Además, se necesita
que la aplicación cuente con las funciones básicas.
Estas las realizaremos en el main. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package exercise6;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        
        TiendaService tienda = new TiendaService();
        
        String producto, opcion;
        int precio;
        
        do {
            
            System.out.println("      --- MENU --- ");
            System.out.println("1. INTRODUCIR PRODUCTO ");
            System.out.println("2. MODIFICAR PRECIO ");
            System.out.println("3. ELIMINAR PRODUCTO ");
            System.out.println("4. MOSTRAR PRODUCTOS ");
            System.out.println("5. SALIR");
            opcion = read.next();
            
            switch (opcion) {
                case "1":
                    tienda.introducirProductos();
                    break;
                case "2":
                    tienda.modificarPrecio();
                    break;
                case "3":
                    tienda.eliminarProducto();
                    break;
                case "4":
                    tienda.mostrarProductos();
                    break;
                case "5":
                    System.out.println("OPERACION FINALIZADA!");
                    break;
                default:
                    System.out.println("INGRESE OPCION VALIDA ");
                
            }
            
        } while (!opcion.equals("5"));
        
    }
    
}
