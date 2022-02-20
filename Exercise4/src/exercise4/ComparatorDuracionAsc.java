package exercise4;

import java.util.Comparator;

public class ComparatorDuracionAsc implements Comparator<Pelicula> {

    @Override
    public int compare(Pelicula t, Pelicula t1) {
        return t1.getDuracionPelicula().compareTo(t.getDuracionPelicula());
        
    }
}
