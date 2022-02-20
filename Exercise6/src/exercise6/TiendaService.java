package exercise6;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class TiendaService {

    private HashMap<String, Integer> tienda;
    private Scanner read;

    public TiendaService() {
        this.tienda = new HashMap();
        this.read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }

    public void introducirProductos() {
        System.out.println("INGRESE PRODUCTO: ");
        String producto = read.next();
        System.out.println("INGRESE SU PRECIO: ");
        int precio = read.nextInt();

        tienda.put(producto, precio);
    }

    public void modificarPrecio() {
        System.out.println("INGRESE PRODUCTO PARA MODIFICAR SU PRECIO: ");
        String modificar = read.next();

        if (tienda.containsKey(modificar)) {
            System.out.println("INGRESE NUEVO PRECIO: ");
            int precioNuevo = read.nextInt();

            tienda.put(modificar, precioNuevo);
        }
    }

    public void eliminarProducto() {

        System.out.println("INGRESE PRODUCTO A ELIMINAR: ");
        String eliminar = read.next();

        if (tienda.containsKey(eliminar)) {
            tienda.remove(eliminar);
        }
    }
    
    public void mostrarProductos(){
        
        for(Map.Entry<String, Integer> entry : tienda.entrySet()){
            System.out.println("PRODUCTO:  " + entry.getKey() + ", PRECIO: " + entry.getValue() );
        }
    }

}
