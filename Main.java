import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import java.util.Scanner;

public class Main {
    static readFile reader;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Bienvenid@");
        menu();
    }

    public static void menu() throws FileNotFoundException {
        int finish = 0;
        while (finish != 3) {
            System.out.println("¿Qué deseas hacer?\n1. Registrar palabras  2.Traducir oraciones  3. Salir");
            switch (solicitarI("")) {
                case 1:
                    reader = new readFile("diccionario.txt//");
                    RegistroL.saveInfo(reader);
                    System.out.println("Se ha registrado la información en el archivo 'diccionario.txt'\n");
                    break;

                case 2:
                    reader = new readFile("texto.txt//");
                    Traduccion.traduce(reader);
                    System.out.println("Se ha traducido toda la información en el archivo 'texto.txt'\n");
                    break;
                case 3:
                    finish = 3;
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
