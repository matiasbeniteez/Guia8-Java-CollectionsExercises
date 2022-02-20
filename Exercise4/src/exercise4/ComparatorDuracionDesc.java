
package exercise4;

import java.util.Comparator;

public class ComparatorDuracionDesc implements Comparator<Pelicula>{

    @Override
    public int compare(Pelicula t, Pelicula t1) {
        return t.getDuracionPelicula().compareTo(t1.getDuracionPelicula());
    }
    
}
