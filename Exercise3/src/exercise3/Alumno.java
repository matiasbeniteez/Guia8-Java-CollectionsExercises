/*
3. Crear una clase llamada Alumno que mantenga información sobre las notas de
distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de
tipo Integer con sus 3 notas.
En el main deberemos tener un bucle que crea un objeto Alumno. Se pide toda la
información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bluce tendremos el siguiente método en la clase Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su
nota final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método.
Dentro del método se usará la lista notas para calcular el promedio final de alumno.
Siendo este promedio final, devuelto por el método y mostrado en el main.
 */
package exercise3;

import java.util.ArrayList;
import java.util.Iterator;


public class Alumno {
    
    private String name;
    private ArrayList<Integer> notas;
    
    public Alumno(){
        
    }
    
    public Alumno(String name, ArrayList<Integer> notas){
        this.name = name;
        this.notas = notas;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() { 
        return String.format("Person (%s, %d)", name, notas);
    }
       
    public double notaFinal(){
      int acum = 0;
      
     Iterator<Integer> iterator = notas.iterator();
     while(iterator.hasNext()){
         Integer nota = iterator.next();
         acum+= nota;
     }
     return acum/3;
  }
}
