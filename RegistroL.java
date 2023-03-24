
import java.io.FileNotFoundException;

import lib.BinarySearchTree;

public class RegistroL {
    static BinarySearchTree<String, String[]> inglesK;
    static BinarySearchTree<String, String[]> espanolK;
    static BinarySearchTree<String, String[]> francesK;

    static readFile reader;

    public static void saveInfo(String file_path) throws FileNotFoundException {
        reader = new readFile(file_path);
        inglesK = reader._readEnglish();
        espanolK = reader._readSpanish();
        francesK = reader._readFrench();
    }

}