import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Traduccion {
    static ArrayList<String[]> toTraduce;

    /**
     * Permite la traducción de frases a través de la lectura de un archivo y la
     * revisión de los diccionarios encontrados, por idioma
     * 
     * @param reader
     * @throws FileNotFoundException
     */
    public static void traduce(readFile reader) throws FileNotFoundException {
        if (RegistroL.inglesK != null) { // Si hay datos registrados
            toTraduce = reader.Traduce(); // Lectura de archivo y registro de datos
            for (String[] frase : toTraduce) { // Por cada frase a traducir
                String traduccion1 = "";
                String traduccion2 = "";
                String language = "";
                String original = "";
                for (String palabra : frase) { // Por cada palabra encontrada
                    palabra = palabra.toLowerCase();
                    String temp1 = "";
                    String temp2 = "";
                    if (RegistroL.inglesK.search(palabra) != null) { // Si existe en el diccionario de ingles
                        language += "i";
                        temp1 = RegistroL.inglesK.search(palabra)[0] + " ";
                        temp2 = RegistroL.inglesK.search(palabra)[1] + " ";
                    } else if (RegistroL.espanolK.search(palabra) != null) { // Si existe en el diccionario de español
                        language += "e";
                        temp1 = RegistroL.espanolK.search(palabra)[0] + " ";
                        temp2 = RegistroL.espanolK.search(palabra)[1] + " ";
                    } else if (RegistroL.francesK.search(palabra) != null) { // Si existe en el diccionario de frances
                        temp1 = RegistroL.francesK.search(palabra)[0] + " ";
                        temp2 = RegistroL.francesK.search(palabra)[1] + " ";
                    } else { // Si no está registrada
                        temp1 = temp2 = "*" + palabra + "* ";
                    }

                    // Agregar las palabras a una cadena, relacionando la frase completa
                    original += palabra + " ";
                    traduccion1 += temp1;
                    traduccion2 += temp2;
                }

                System.out.println("\n-->" + original); // Frase inicial
                if (language.contains("i")) { // Traducido desde ingles
                    System.out.println("\tEn español:" + traduccion1);
                    System.out.println("\tEn frances:" + traduccion2);
                } else if (language.contains("e")) { // Traducido desde español
                    System.out.println("\tEn ingles:" + traduccion1);
                    System.out.println("\tEn frances:" + traduccion2);
                } else { // Traducido desde frances
                    System.out.println("\tEn ingles: " + traduccion1);
                    System.out.println("\tEn español: " + traduccion2);
                }
            }
        } else {
            System.out.println("Cuidado, aún no se han ingresado datos al diccionario");
        }

    }
}