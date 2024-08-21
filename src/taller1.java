import java.util.Scanner;
import java.util.Random;

class taller1 {

    public static void main(String[] args) {
        String cartas[][] = new String[12][2];
        inicializarCartasJuego(cartas);
        ejecutarMenu(cartas);

    }

    public static void ejecutarMenu(String cartas[][]){
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            ejecutarOpcion(opcion, cartas);
        } while (opcion != 2);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú juego de cartas:");
        System.out.println("1. Iniciar");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");

    }

        public static int leerOpcion() {
            int opcion = 0;
            while (true) {
                Scanner scanner = crearScanner();
                if (scanner.hasNextInt()) {
                    opcion = scanner.nextInt();
                    if (opcion >= 1 && opcion <= 2) {
                        break;
                    } else {
                        System.out.print("Opción inválida. Intente nuevamente: ");
                    }
                } else {
                    System.out.print("Entrada no válida. Ingrese un número: ");
                    scanner.next();
                }
            }

            return opcion;
        }

        public static Scanner crearScanner() {
            return new Scanner(System.in);
        }

    public static void ejecutarOpcion(int opcion, String[][] cartas) {
        switch (opcion) {
            case 1:
                jugar(cartas);
                break;
            case 2:
                System.out.println("Saliendo del juego. ¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
 

    public static String agregarCartas(String[][] cartas){
        cartas[0][0] = "As"; cartas[0][1] = "11";
        cartas[1][0] = "Dos"; cartas[1][1] = "2";
        cartas[2][0] = "Tres"; cartas[2][1] = "3";
        cartas[3][0] = "Cuatro"; cartas[3][1] = "4";
        cartas[4][0] = "Cinco"; cartas[4][1] = "5";
        cartas[5][0] = "Seis"; cartas[5][1] = "6";
        cartas[6][0] = "Siete"; cartas[6][1] = "7";
        cartas[7][0] = "Ocho"; cartas[7][1] = "8";
        cartas[8][0] = "Nueve"; cartas[8][1] = "9";
        cartas[9][0] = "Diez"; cartas[9][1] = "10";
        cartas[10][0] = "Jota"; cartas[10][1] = "10";
        cartas[11][0] = "Queen"; cartas[10][1] = "10";
        cartas[12][0] = "Kaiser"; cartas[11][1] = "10";
    }

    public static String inicializarCartasJuego(String[][] cartas){

    }

    public static String obtenerCartas(String[][] cartas){

    }

    public static String jugar(String[][] cartas){

    }
}