import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Clase Main
 * @author: Fabiola Contreras
 * 
 * A través de esta clase se interactúa con el usuario y se llama a otras clases para permitir el funcionamiento adecuado del programa
 */
public class Main {
    static readFile reader;
    static Scanner sc = new Scanner(System.in);

    /**
     * Permite iniciar el programa
     * 
     * @param args
     * @throws FileNotFoundException - archivo no encontrado
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Bienvenid@");
        menu();
    }

    /**
     * Mantiene el programa funcionando hasta que el usuario desee lo contrario,
     * permite elegir entre leer, revisar o traducir datos
     * 
     * @throws FileNotFoundException - archivo no encontrado
     */
    public static void menu() throws FileNotFoundException {
        int finish = 0;
        while (finish != 4) {
            System.out.println(
                    "\n¿Qué deseas hacer?\n1. Registrar palabras  2. Ver diccionario en orden  3. Traducir oraciones  4. Salir");
            switch (solicitarI("")) {
                case 1: // Registro de palabras
                    reader = new readFile("src/diccionario.txt");
                    RegistroL.saveInfo(reader);
                    System.out.println("Se ha registrado la información en el archivo 'diccionario.txt'\n");
                    break;
                case 2: // Impresión 'inOrder'
                    RegistroL.inglesK.InOrderPrint();
                    System.out.println();
                    RegistroL.espanolK.InOrderPrint();
                    System.out.println();
                    RegistroL.francesK.InOrderPrint();
                    break;
                case 3: // Traducción de texto
                    System.out.println(
                            "Se leera la información en el archivo 'texto.txt' asegurate de que no tenga elementos extra como puntos para no interferir con el proceso de traducción.");
                    reader = new readFile("src/texto.txt");
                    Traduccion.traduce(reader);
                    System.out.println("\nSe ha traducido toda la información en el archivo 'texto.txt'\n");
                    break;
                case 4: // Fin de programa
                    finish = 4;
            }
        }

    }

    /**
     * Imprime una solicitud y recibe un dato tipo int
     * Evita una excepción -InputMismatchException- volviendo a solicitar el dato en
     * caso de que ocurra. (Utilizada continuamente en distintos programas)
     *
     * @Author Fabiola Contreras
     * @param solicitud texto que describe lo solicitado
     * @return entero ingresado por el usuario
     */
    public static int solicitarI(String solicitud) {
        System.out.println(solicitud);
        int solicitar = 0;
        Boolean correcto = false;
        do {
            try {
                solicitar = sc.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("¡Cuidado! Ingresa un número entero.");
            }
        } while (correcto == false);
        sc.nextLine(); // Elimina la posibilidad de saltarse una linea de solicitud después
        return solicitar;
    }
}
