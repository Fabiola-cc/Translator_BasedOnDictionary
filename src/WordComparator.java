import java.util.Comparator;

/*Permite la comparación de datos para el orden correcto del diccionario */
public class WordComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2);

    }

}
