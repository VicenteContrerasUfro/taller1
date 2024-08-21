import java.util.Scanner;
import java.util.Random;

class taller1 {

    public static void main(String[] args) {
        String cartas[][] = new String[12][2];
        inicializarCartasJuego(cartas);
        ejecutarMenu(cartas);
    }

    public static void ejecutarMenu(String cartas[][]){
        String jugador1 = null;
        String jugador2 = null;
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            switch (opcion) {
                case 1:
                    String[] jugadores = definirJugadores();
                    jugador1 = jugadores[0];
                    jugador2 = jugadores[1];
                    break;
                case 2:
                    if (jugador1 != null && jugador2 != null) {
                        jugar(cartas, jugador1, jugador2);
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del juego");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 3);
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú juego de cartas:");
        System.out.println("1. Definir jugadores");
        System.out.println("2. Iniciar juego");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        System.out.println(" ");
    }

    public static int leerOpcion() {
        int opcion = 0;
        while (true) {
            Scanner scanner = crearScanner();
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 3) {
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

    public static String[] definirJugadores() {
        Scanner scanner = crearScanner();
        System.out.print("Ingrese el nombre del Jugador 1: ");
        String jugador1 = scanner.nextLine();
        System.out.print("Ingrese el nombre del Jugador 2: ");
        String jugador2 = scanner.nextLine();
        return new String[]{jugador1, jugador2};
    }

    public static void inicializarCartasJuego(String[][] cartas){
        cartas[0][0] = "As"; cartas[0][1] = "11";
        cartas[1][0] = "Dos"; cartas[1][1] = "2";
        cartas[2][0] = "Tres"; cartas[2][1] = "3";
        cartas[3][0] = "Cuatro"; cartas[3][1] = "4";
        cartas[4][0] = "Cinco"; cartas[4][1] = "5";
        cartas[5][0] = "Seis"; cartas[5][1] = "6";
        cartas[6][0] = "Siete"; cartas[6][1] = "7";
        cartas[7][0] = "Ocho"; cartas[7][1] = "8";
        cartas[8][0] = "Nueve"; cartas[8][1] = "9";
        cartas[9][0] = "Jota"; cartas[9][1] = "10";
        cartas[10][0] = "Queen"; cartas[10][1] = "10";
        cartas[11][0] = "Reina"; cartas[11][1] = "10";
    }

    public static String[] obtenerCarta(String[][] cartas){
        Random random = new Random();
        int indice = random.nextInt(12);
        return cartas[indice];
    }

    public static void jugar(String[][] cartas, String jugador1, String jugador2){
        int puntajeJugador1 = 0, puntajeJugador2 = 0;
        String[] carta;

        //jugador1
        for (int i = 0; i < 3; i++) {
            carta = obtenerCarta(cartas);
            puntajeJugador1 += Integer.parseInt(carta[1]);
            System.out.println("Carta obtenida: " + carta[0] + " con puntaje: " + carta[1]);
        }
        System.out.println("Puntaje total " + jugador1 + ": " + puntajeJugador1);
        System.out.println(" ");

        // Jugador 2
        for (int i = 0; i < 3; i++) {
            carta = obtenerCarta(cartas);
            puntajeJugador2 += Integer.parseInt(carta[1]);
            System.out.println("Carta obtenida: " + carta[0] + " con puntaje: " + carta[1]);
        }
        System.out.println("Puntaje total " + jugador2 + ": " + puntajeJugador2);
        System.out.println(" ");

        if (puntajeJugador1 == 20) {
            System.out.println(jugador1 + " es el ganador con un puntaje exacto de 20 puntos.");
        } else if (puntajeJugador2 == 20) {
            System.out.println(jugador2 + " es el ganador con un puntaje exacto de 20 puntos.");
        } else if (puntajeJugador1 > puntajeJugador2) {
            System.out.println(jugador1 + " es el ganador con un puntaje de " + puntajeJugador1 + " puntos.");
        } else if (puntajeJugador2 > puntajeJugador1) {
            System.out.println(jugador2 + " es el ganador con un puntaje de " + puntajeJugador2 + " puntos.");
        } else {
            System.out.println("Es un empate con ambos jugadores obteniendo " + puntajeJugador1 + " puntos.");
        }
    }
}
