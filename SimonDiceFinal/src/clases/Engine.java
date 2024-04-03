package clases;

import java.util.Random;

import java.util.Scanner;
import java.io.IOException;
import java.util.Arrays;

public class Engine {
	Scanner sc = new Scanner(System.in);

	/**
	 * de tipo tColores
	 */
	public enum tColores{
		ROJO , VERDE , AZUL , DORADO , BLANCO , MARRON , NARANJA
	}

	/**
	 * enum tModo para usar el modo facil o dificil
	 */
	public enum tModo{
		FACIL , DIFICIL
	}

	public int puntuacion = 0;
	public int ayuda;
	public final int MAX_COLORES_FACIL = 4;
	public final int MAX_COLORES_DIFICIL = 7;

	/**
	 * variable constante. private: la variable solo se puede acceder dentro de la
	 * clase en la que se define. final: constante la variable no se puede cambiar
	 * una vez que se inicializa. entero constante con valor de 12.
	 */
	private final int MAX_COLORES_SEQ = 15;

	/**
	 * una array de tipo tColores con una longitud de MAX_COLORES_SEQ (12).
	 */
	private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * metodo que recive un char y retorna un enum (color) de tipo tColores.
	 * 
	 * @param _color este es el color que se retorna
	 * @return un color
	 */
	public tColores charToColor(char _color) {

		char letraColor = Character.toLowerCase(_color); // mayusculas y minusculas

		switch (letraColor) {
		case 'r':
			return tColores.ROJO;
		case 'v':
			return tColores.VERDE;
		case 'a':
			return tColores.AZUL;
		case 'd':
			return tColores.DORADO;
		case 'b':
			return tColores.BLANCO;
		case 'm':
			return tColores.MARRON;
		case 'n':
			return tColores.NARANJA;
		default:
			return null;

		}

	}

	/**
	 * metodo que recive un numero y retorna un color (enum) de tipo tColores.
	 * 
	 * @param _numero recive un numero por parametro
	 * @return un color 
	 */
	public tColores intToColor(int _numero) {
		switch (_numero) {
		case 1:
			return tColores.ROJO;
		case 2:
			return tColores.VERDE;
		case 3:
			return tColores.AZUL;
		case 4:
			return tColores.DORADO;
		case 5:
			return tColores.BLANCO;
		case 6:
			return tColores.MARRON;
		case 7:
			return tColores.NARANJA;

		default:
			System.out.println("Numero no encontrado.");
			return null;

		}

	}

	/**
	 * este metodo genera una secuencia de colores aleatoriamente y se guarda en el
	 * array secuenciaColores .
	 * 
	 * @param _numColores numero array
	 */
	public void generarSecuencia(int _numColores) {
		for (int i = 0; i < secuenciaColores.length; i++) {
			secuenciaColores[i] = intToColor((int) (Math.random() * _numColores + 1));
		}
	}

	/**
	 * metodo que comprueba el color introducido por el usuario, retorna un true o
	 * false.
	 * 
	 * @param _index posicion del array
	 * @param _color color 
	 * @return array
	 */
	public boolean comprobarColor(int _index, tColores _color) {
		return (secuenciaColores[_index] == _color);
	}

	/**
	 * método que muestrar la secuencia actual por pantalla para que el usuario la
	 * pueda memorizar.
	 * 
	 * @param _numero numero 
	 */
	public void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
		sc.nextLine();
	}

	/**
	 * metodo menu, para guiar al jugador durante el juego, empezar juego o salir.
	 * realmente la ejecucuion del menu se hace en el metodo play
	 */
	public void menu() {
		System.out.println("1......Facil.");
		System.out.println("2......Dificil.");
		System.out.println("3......Mostrar Top3.");
		System.out.println("4......Mostrar Ranking.");
		System.out.println("5......Salir.");

	}

	/**
	 * metodo que usa el atributo ayuda y devuelve verdadero o falso, la ayuda te
	 * devuelve la posicion iesima del array a no ser que no te queden mas
	 * 
	 * @param _index numero 
	 * @return verdadero o falso 
	 */
	public boolean usarAyuda(int _index) {
		if (ayuda > 0) {
			ayuda--;
			System.out.println("Tu color olvidado es " + secuenciaColores[_index] + " y te quedan " + this.ayuda
					+ " oportunidades");
			return true;
		} else {
			System.out.println("No te quedan mas ayudas");
			return false;
		}
	}

	/**
	 * metodo mas importate, es el que ejecutara el juego, emepezamos imprimiendo
	 * por pantalla la bienvenida al jugador, registrando su nombre y mostrando el
	 * menu. utilizamos un switch para dirigir el juego y al usuario, es el meu del
	 * juego, si pulsa 1 comienza a ejecutarse el juego y si pulsa 2 sale. dentro
	 * del do ponemos lo que queremos que se reproduzca, se genera la secuencia de
	 * colores, con los 4 colores, muestra solo los 3 primeros numeros y "borra " la
	 * pantalla. pedimos al usuario que ingrese la primera secuencia, y mientras el
	 * numero de secuencia no sea 10, el jugador seguiá jugando hasta ganar
	 * (problema de esta condicion es que si falla no se saldra del bucle).
	 * @param modo modo 
	 * @throws IOException excepcion
	 */
	public void play(tModo modo) throws IOException {

		int numSecuencia;
		int coloresSecuencia;
		boolean error = true;
		puntuacion = 0;
		numSecuencia = 1;
		coloresSecuencia = 3;
		ayuda = 3;

		if (modo == tModo.FACIL) {
			generarSecuencia(MAX_COLORES_FACIL);
		} else {
			generarSecuencia(MAX_COLORES_DIFICIL);
		}
		sc.nextLine();
		while (coloresSecuencia <= MAX_COLORES_SEQ && error) {
			System.out.println("Secuencia número " + numSecuencia + ":");
			mostrarSecuencia(coloresSecuencia);
			System.out.println("Preparadx? " + "Memoriza la secuencia y pulsa enter para empezar."); 
			sc.nextLine();
			for (int i = 0; i <= 5; i++) {
				System.out.println();
			}
			int j = 0;
			while (j < coloresSecuencia && error) {
				char caracter = sc.next().charAt(0);
				sc.nextLine();
				if ((caracter == 'x' || caracter == 'X') && ayuda >= 1) {
					usarAyuda(j);
					puntuacion -= 8;
					j++;
				} else if ((caracter == 'x' || caracter == 'X') && ayuda < 1) {
					usarAyuda(j);
				} else if (comprobarColor(j, charToColor(caracter))) {
					System.out.println("Correcto!");
					j++;
					puntuacion += 2;
				} else {
					System.out.println("Ha fallado.");
					error = false;
				}
			}
			if (error && coloresSecuencia < MAX_COLORES_SEQ) {
				numSecuencia++;
				coloresSecuencia++;
				puntuacion += 8;
			} else if (error && coloresSecuencia == MAX_COLORES_SEQ) {
				System.out.println("Has ganado");
				puntuacion += 40;
				error = true;
			}
		}

	}


	/**
	 * metodo que convierte la seleccion (numero 1,2,3) en un tModo (facil o
	 * dificil)
	 * 
	 * @param _numero numero
	 * @return modo
	 */
	public tModo intToModo(int _numero) {
		tModo modo = null;
		switch (_numero) {
		case 1:
			modo = tModo.FACIL;
			break;
		case 2:
			modo = tModo.DIFICIL;
			break;
		}
		return modo;
	}

	/**
	 * metodo que estara en la clase main metodo, que llama al metodo anterior play.
	 * 
	 * @throws IOException excepcion
	 */
	public void start() throws IOException {
		Record record = new Record();
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido a Simon Dice.");
		System.out.println("Introduce tu nombre de usuario.");
		String nombre = sc.nextLine();
		Jugador jugador = new Jugador(nombre, 0);
		record.introducirJugador(jugador);
		record.cargarRanking();
		System.out.println("Hola " + nombre + " pulsa enter para mostrar menu.");
		sc.nextLine();

		int seleccion = 0;

		while (seleccion != 5) {
			menu();
			seleccion = sc.nextInt();
			switch (seleccion) {
			case 1:
				play(intToModo(seleccion));
				jugador.setPuntuacion(puntuacion);
				break;
			case 2:
				play(intToModo(seleccion));
				jugador.setPuntuacion(puntuacion);
				break;
			case 3:
				record.ordenarRanking();
				record.imprimirTop3();
				System.out.println();
				break;
			case 4:
				record.ordenarRanking();
				record.showRanking();
				System.out.println();
				break;
			case 5:
				System.out.println("Adios! vuelve pronto:)");
				record.escribirRanking();
			}
		}
	}
}
