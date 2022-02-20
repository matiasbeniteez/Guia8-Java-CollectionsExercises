package exercise3;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AlumnoService {

    private ArrayList<Alumno> alumnos;
    private Scanner read;

    public AlumnoService() {
        this.alumnos = new ArrayList<>();
        this.read = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
    }

    public void crearAlumnos(String name, ArrayList<Integer> notas) {

        Alumno alumno = new Alumno();

        alumno.setName(name);
        alumno.setNotas(notas);

        agregarAlumno(alumno);
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public Alumno buscarAlumno(String name) {
        Alumno alumnoRetorno = null;

        for (Alumno alumno : alumnos) {
            if (alumno.getName().equalsIgnoreCase(name)) {
                return alumno;
            }
        }
        return alumnoRetorno;
    }

    public double obtenerNotaFinal(Alumno alumno) {

        int acumulador = 0;

        for (Integer nota : alumno.getNotas()) {
            acumulador += nota;
        }
        return (double) acumulador / alumno.getNotas().size();

    }

    public void ingresarNombreYNotas() {
        ArrayList<Integer> listaNotas = new ArrayList();

        System.out.println("INGRESE NOMBRE DEL ALUMNO: ");
        String nombre = read.next();

        for (int i = 0; i < 3; i++) {
            System.out.println("INGRESE NOTA " + (i + 1) + " DEL ALUMNO");
            int nota = read.nextInt();
            listaNotas.add(nota);
        }

        crearAlumnos(nombre, listaNotas);
    }

    public void procesamientoPrincipal() {
        String opcion = "";

        do {
            if (this.alumnos.isEmpty()) {
                ingresarNombreYNotas();
            } else {
                System.out.println("DESEA INGRESAR OTRO ALUMNO? (SI/NO)");
                opcion = this.read.next().toUpperCase();

                switch (opcion) {
                    case "S":
                        ingresarNombreYNotas();
                        break;
                    case "N":
                        System.out.println("OPERACION FINALIZADA");
                        break;
                    default:
                        System.out.println("LA OPCION INGRESADA NO ES VALIDA");
                        break;
                }
            }
        } while (!opcion.equals("N"));
    }

    public void operacionSecundario() {
        
        System.out.println("INGRESE NOMBRE DEL ALUMNO QUE DESEA CALCULAR NOTA: ");
        String nombre = this.read.next();
        Alumno alumno = buscarAlumno(nombre);

        if (alumno != null) {
            System.out.printf(" Promedio: %.2f\n ", obtenerNotaFinal(alumno));
        } else {
            System.out.println("NO EXISTE UN ALUMNO CON EL NOMBRE INGRESADO");
        }
    }

}
