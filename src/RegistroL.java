import java.io.FileNotFoundException;

public class RegistroL {
    static BinarySearchTree<String, String[]> inglesK;
    static BinarySearchTree<String, String[]> espanolK;
    static BinarySearchTree<String, String[]> francesK;

    /**
     * Llama a la clase readFile para leer el documento deseado y retornar los datos
     * del archivo en el formato adecuado
     * 
     * @param reader
     * @throws FileNotFoundException
     */
    public static void saveInfo(readFile reader) throws FileNotFoundException {
        inglesK = reader._readEnglish();
        espanolK = reader._readSpanish();
        francesK = reader._readFrench();
    }

}