package clases;

import java.io.IOException;
import java.util.ArrayList;

import files.CustomReadFile;
import files.CustomWriteFiles;

public class Record {
	/**
	 * atributos
	 */
	private int contador;
	private int MAX_JUGADORES;
	private Jugador[] arrayJugadores;

	/**
	 * constructora de la clase Record.
	 */
	public Record() {
		this.MAX_JUGADORES = 10;
		this.arrayJugadores = new Jugador[MAX_JUGADORES];
		this.contador = 0;
	}

	/**
	 * metodo que introduce jugador al array
	 * 
	 * @param jugador
	 */
	public void introducirJugador(Jugador jugador) {
		if (this.contador < this.MAX_JUGADORES) {
			arrayJugadores[this.contador] = jugador;
			this.contador++;
		}
	}

	/**
	 * metodo que ordena de mejor a peor jugador
	 */
	public void ordenarRanking() {
		for (int i = 0; i < this.contador; i++) {
			for (int j = 0; j < this.contador - i - 1; j++) {
				if (this.arrayJugadores[j].getPuntuacion() < this.arrayJugadores[j + 1].getPuntuacion()) {
					Jugador temp = this.arrayJugadores[j + 1];
					this.arrayJugadores[j + 1] = this.arrayJugadores[j];
					this.arrayJugadores[j] = temp;
				}
			}
		}
	}

	/**
	 * metodo que imprime los tres mejores jugadores
	 */
	public void imprimirTop3() { // imprimir los que sean "n" hacer variable, modulable
		ordenarRanking();
		System.out.println("Top 3 jugadores por puntuación:");
		for (int i = 0; i < 3 && i < this.contador; i++) {// quitar "3" por lo de mostrar n
			System.out.println((i + 1) + ". " + this.arrayJugadores[i].getNombre() + ": "
					+ this.arrayJugadores[i].getPuntuacion());
		}
	}

	/**
	 * metodo que muestra los juegadores del array
	 */
	public void showRanking() {
		ordenarRanking();
		for (int i = 0; i < this.contador; i++) {
			System.out.println((i + 1) + ". " + this.arrayJugadores[i].getNombre() + ": "
					+ this.arrayJugadores[i].getPuntuacion());
		}

	}

	/**
	 * metodo para ensear mejor jugador y puntuaciones
	 */
	public void showBestPlayer() {
		int maxPuntuacion = arrayJugadores[0].getPuntuacion();
		int i = 0;
		while (i < contador && arrayJugadores[i].getPuntuacion() == maxPuntuacion) {
			System.out.println(arrayJugadores[i].getNombre() + " - Puntuación: " + arrayJugadores[i].getPuntuacion());
			i++;
		}
	}

	/**
	 * metodo lee fichero y añade al array
	 * 
	 * @throws IOException
	 */
	public void cargarRanking() throws IOException {
		CustomReadFile read = new CustomReadFile("./src/data/top.txt");
		ArrayList<Jugador> jugadores = read.jugadores();
		int i = 0;
		int size = jugadores.size();
		while (i < size && i < this.MAX_JUGADORES) {
			Jugador j = jugadores.get(i);
			introducirJugador(j);
			i++;
		}
		read.CloseReadFile();
	}

	/**
	 * ecribe los jugadores del array en el fichero
	 * 
	 * @throws IOException
	 */
	public void escribirRanking() throws IOException {
		CustomWriteFiles write = new CustomWriteFiles("./src/data/top.txt");
		String jugadores = "";
		for (int i = 0; i < this.contador; i++) {
			jugadores = jugadores + (arrayJugadores[i].getPuntuacion() + " " + arrayJugadores[i].getNombre() + "\n");
		}
		write.WritePlayers(jugadores);
		write.CloseWriteFile();
	}

}
