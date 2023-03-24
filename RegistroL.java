
import java.io.FileNotFoundException;

import lib.BinarySearchTree;

public class RegistroL {
    static BinarySearchTree<String, String[]> inglesK;
    static BinarySearchTree<String, String[]> espanolK;
    static BinarySearchTree<String, String[]> francesK;

    public static void saveInfo(readFile reader) throws FileNotFoundException {
        inglesK = reader._readEnglish();
        espanolK = reader._readSpanish();
        francesK = reader._readFrench();
    }

}