import structure5.Association;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner class to read text files

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
    }

    public BinarySearchTree<String, String[]> _readEnglish() throws FileNotFoundException {
        myReader = new Scanner(toRead);
        BinarySearchTree<String, String[]> total = new BinarySearchTree<>(new WordComparator());

        while (myReader.hasNextLine()) {
            String[] temp = myReader.nextLine().split(",");
            if (!temp[0].isBlank()) {

                String key = temp[0].trim().toLowerCase();
                String[] values = { "", "" };
                values[0] = temp[1].trim().toLowerCase();
                values[1] = temp[2].trim().toLowerCase();

                total.add(new Association<String, String[]>(key, values));
            }
        }
        myReader.close();

        return total;
    }

    public BinarySearchTree<String, String[]> _readSpanish() throws FileNotFoundException {
        myReader = new Scanner(toRead);
        BinarySearchTree<String, String[]> total = new BinarySearchTree<>(new WordComparator());

        while (myReader.hasNextLine()) {
            String[] temp = myReader.nextLine().split(",");
            if (!temp[0].isBlank()) {
                String key = temp[1].trim().toLowerCase();
                String[] values = { "", "" };
                values[0] = temp[0].trim().toLowerCase();
                values[1] = temp[2].trim().toLowerCase();
                total.add(new Association<String, String[]>(key, values));
            }
        }
        myReader.close();

        return total;
    }

    public BinarySearchTree<String, String[]> _readFrench() throws FileNotFoundException {
        myReader = new Scanner(toRead);
        BinarySearchTree<String, String[]> total = new BinarySearchTree<>(new WordComparator());

        while (myReader.hasNextLine()) {
            String[] temp = myReader.nextLine().split(",");
            if (!temp[0].isBlank()) {
                String key = temp[2].trim().toLowerCase();
                String[] values = { "", "" };
                values[0] = temp[0].trim().toLowerCase();
                values[1] = temp[1].trim().toLowerCase();
                total.add(new Association<String, String[]>(key, values));
            }
        }

        return total;
    }

    public ArrayList<String[]> Traduce() throws FileNotFoundException {
        myReader = new Scanner(toRead);
        ArrayList<String[]> frases = new ArrayList<>();
        String[] words = { "" };

        while (myReader.hasNextLine()) {
            words = myReader.nextLine().split(" ");
            if (!words[0].isBlank()) {
                frases.add(words);
            }

        }

        return frases;
    }
}
