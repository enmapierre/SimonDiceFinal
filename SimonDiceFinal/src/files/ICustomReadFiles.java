package files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import clases.Jugador;

public interface ICustomReadFiles {
	/**
	 * metodo para cerrar
	 * 
	 * @throws IOException
	 */
	public void CloseReadFile() throws IOException;

	/**
	 * crear array tipo jugador
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	ArrayList <Jugador> jugadores() throws FileNotFoundException;
}


