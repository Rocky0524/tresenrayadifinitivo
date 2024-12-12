package tresenrayadifinitivo;

import java.util.Scanner;
import java.util.Random;

public class tresebrayadifinitivo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		Random random = new Random();

		// pregunta los nombres de los dos jugadores

		String[] nomjugadores = new String[2];
		for (int i = 0; i < 2; i++) {
			System.out.println("\njugador " + (i + 1) + " cual es tu nombre?");
			nomjugadores[i] = s.next();
			System.out.println("Nombre del jugador " + (i + 1) + ": " + nomjugadores[i]);
		}

		// Aqui se decide si la moneda sale cara o cruz

		int moneda = random.nextInt(2);
		System.out.println("\nEmpieza " + nomjugadores[moneda]);

		// matriz declarada para el juego
		String matriz[][] = { { ".", ".", "." }, { ".", ".", "." }, { ".", ".", "." } };

		String simbolo1 = "X"; // Jugador 1
		String simbolo2 = "O"; // Jugador 2

		int turno = moneda;

		String revancha = "s";
		while (revancha.equalsIgnoreCase("s")) {

			while (true) {

				int fila;
				int columna;
				boolean jugadaValida;

				System.out.println("\nTurno de " + nomjugadores[turno]);

				for (int i = 0; i < matriz.length; i++) { // primero recore las filas
					for (int j = 0; j < matriz[i].length; j++) { // segundo recorre las columnas
						System.out.print("|" + matriz[i][j] + "|");
					}
					System.out.println("");
				}

				// El jugador elige una posición
				jugadaValida = true;
				while (jugadaValida) {
					System.out.println("Elige una fila (0, 1, 2): ");
					fila = s.nextInt();
					System.out.println("Elige una columna (0, 1, 2): ");
					columna = s.nextInt();

					// Verifica si la celda está vacía
					if (matriz[fila][columna].equals(".")) {
						if (turno == 0) {
							matriz[fila][columna] = simbolo1; // Jugador 1 usa "X"
						} else if (turno == 1) {
							matriz[fila][columna] = simbolo2; // Jugador 2 usa "O"
						}
						jugadaValida = false; // La jugada esta bin hecha
					} else {
						System.out.println("Esa posición ya está ocupada. Intenta de nuevo.");
					}
				}

				// Verificar si alguien ha ganado

				// Comprobar filas, columnas y diagonales
				boolean ganador = false;

				for (int i = 0; i < 3; i++) {
					// Verificar fila
					if (matriz[i][0].equals(matriz[i][1]) && matriz[i][1].equals(matriz[i][2])
							&& !matriz[i][0].equals(".")) {
						ganador = true;
					}
					// Verificar columna
					if (matriz[0][i].equals(matriz[1][i]) && matriz[1][i].equals(matriz[2][i])
							&& !matriz[0][i].equals(".")) {
						ganador = true;
					}
				}

				// Verificar diagonales
				if (matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2])
						&& !matriz[0][0].equals(".")) {
					ganador = true;
				}
				if (matriz[0][2].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][0])
						&& !matriz[0][2].equals(".")) {
					ganador = true;
				}

				// Si hay ganador
				if (ganador) {
					System.out.println("\nEl jugador " + nomjugadores[turno] + " ha ganado");
					break;
				}

				// Verificar si hay empate
				boolean empate = true;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (matriz[i][j].equals(".")) {
							empate = false;
							break;
						}
					}
				}

				if (empate) {
					System.out.println("Empate");
					break;
				}

				// Alternar turno entre los jugadores
				turno = (turno + 1) % 2; // Cambiar entre 0 y 1 (alternando turnos)

			}

			for (int i = 0; i < matriz.length; i++) { // primero recore las filas
				for (int j = 0; j < matriz[i].length; j++) { // segundo recorre las columnas
					System.out.print("|" + matriz[i][j] + "|");
				}
				System.out.println("");
			}

			System.out.println(nomjugadores[turno] + " Si quieres jugar de nuevo pon S si no pon N");
			revancha = s.next().toLowerCase();
			System.out.println(nomjugadores[turno + 1] + " Si quieres jugar de nuevo pon S si no pon N");
			revancha = s.next().toLowerCase();
		}
		System.out.println("El juego se ha cerrado");

	}

}
