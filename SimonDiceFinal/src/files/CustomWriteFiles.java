package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import clases.Jugador;

public class CustomWriteFiles extends FileWriter implements ICustomWriteFiles {

	/**
	 * constructora
	 * 
	 * @param file
	 * @throws IOException
	 */
	public CustomWriteFiles(String file) throws IOException {
		super(file);

	}

	/**
	 * metodo que cierra el fichero
	 */
	public void CloseWriteFile() throws IOException {
		this.close();

	}

	/**
	 * metodo que escribe en el fichero
	 */
	public void WritePlayers(String chain) throws IOException {
		this.write(chain);

	}

}
