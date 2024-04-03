package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import clases.Jugador;

public class CustomReadFile extends FileReader implements ICustomReadFiles {
	Scanner sc;

	/**
	 * Constructora que inicializa el scanner y cargar el fichero
	 * 
	 * @param file
	 * @throws FileNotFoundException
	 */
	public CustomReadFile(String file) throws FileNotFoundException {
		super(file);
		this.sc = new Scanner(this);
	}

	/**
	 * reescribe el metodo de la interfaz
	 */
	@Override
	public void CloseReadFile() throws IOException {
		this.close();

	}

	/**
	 * reescribe el metodo de la interfaz
	 */
	
	public ArrayList <Jugador> jugadores() throws FileNotFoundException {
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		while (this.sc.hasNextLine()) {
			try {
				int puntos = this.sc.nextInt();
				String nombre = this.sc.next();
				Jugador jugador = new Jugador(nombre, puntos);
				jugadores.add(jugador);
				this.sc.nextLine();
			} catch (NoSuchElementException e) {
				System.err.println(e);
			}
		}
		return jugadores;
	}

}
