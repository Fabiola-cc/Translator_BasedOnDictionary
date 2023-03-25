package src;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Traduccion {
    static ArrayList<String[]> toTraduce;

    public static void traduce(readFile reader) throws FileNotFoundException {
        toTraduce = reader.Traduce();

        for (String[] frase : toTraduce) {
            String traduccion1 = "";
            String traduccion2 = "";
            String language = "";
            for (String palabra : frase) {
                palabra = palabra.toLowerCase();
                String temp1 = "";
                String temp2 = "";
                if (RegistroL.inglesK.search(palabra) != null) {
                    language += "i";
                    temp1 = RegistroL.inglesK.search(palabra)[0] + " ";
                    temp2 = RegistroL.inglesK.search(palabra)[1] + " ";
                } else if (RegistroL.espanolK.search(palabra) != null) {
                    language += "e";
                    temp1 = RegistroL.espanolK.search(palabra)[0] + " ";
                    temp2 = RegistroL.espanolK.search(palabra)[1] + " ";
                } else if (RegistroL.francesK.search(palabra) != null) {
                    temp1 = RegistroL.francesK.search(palabra)[0] + " ";
                    temp2 = RegistroL.francesK.search(palabra)[1] + " ";
                } else {
                    temp1 = temp2 = "*" + palabra + "* ";
                }

                traduccion1 += temp1;
                traduccion2 += temp2;
            }

            if (language.contains("i")) {
                System.out.println();
                System.out.println("En español:" + traduccion1);
                System.out.println("En frances:" + traduccion2);
            } else if (language.contains("e")) {
                System.out.println();
                System.out.println("En ingles:" + traduccion1);
                System.out.println("En frances:" + traduccion2);
            } else {
                System.out.println();
                System.out.println("En ingles: " + traduccion1);
                System.out.println("En español: " + traduccion2);
            }
        }

    }
}