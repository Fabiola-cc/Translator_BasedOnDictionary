import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import lib.BinarySearchTree;

/**
 * @author
 *         Fabiola Contreras
 * @category Hoja de trabajo #7
 *           Propósito: Leer el arhivo txt para obtener los datos de traducción
 * @date 24/03/2023
 */

public class readFile {
    private File toRead;
    private Scanner myReader;

    readFile(String fpath) throws FileNotFoundException {
        toRead = new File(fpath);
        myReader = new Scanner(toRead);
    }

    public BinarySearchTree<String, String[]> _readEnglish() {
        String key = "";
        String[] values = {};
        BinarySearchTree<String, String[]> total = new BinarySearchTree<>(new WordComparator());

        while (myReader.hasNextLine()) {
            if (!myReader.nextLine().isBlank()) {
                String[] temp = myReader.nextLine().split(",");
                key = temp[0];
                values[0] = temp[1];
                values[1] = temp[2];
            }

            total.add(key, values);
        }
        myReader.close();

        return total;
    }

    public BinarySearchTree<String, String[]> _readSpanish() {
        String key = "";
        String[] values = {};
        BinarySearchTree<String, String[]> total = new BinarySearchTree<>(new WordComparator());

        while (myReader.hasNextLine()) {
            if (!myReader.nextLine().isBlank()) {
                String[] temp = myReader.nextLine().split(",");
                key = temp[1];
                values[0] = temp[0];
                values[1] = temp[2];
            }

            total.add(key, values);
        }
        myReader.close();

        return total;
    }

    public BinarySearchTree<String, String[]> _readFrench() {
        String key = "";
        String[] values = {};
        BinarySearchTree<String, String[]> total = new BinarySearchTree<>(new WordComparator());

        while (myReader.hasNextLine()) {
            if (!myReader.nextLine().isBlank()) {
                String[] temp = myReader.nextLine().split(",");
                key = temp[2];
                values[0] = temp[0];
                values[1] = temp[1];
            }

            total.add(key, values);
        }

        return total;
    }
}
