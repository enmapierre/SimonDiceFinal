package files;

import java.io.IOException;

public interface ICustomWriteFiles {
	/**
	 * metodo que cierra
	 * 
	 * @throws IOException
	 */
	public void CloseWriteFile() throws IOException;

	/**
	 * metodo pra escribir en fichero
	 * 
	 * @param chain
	 * @throws IOException
	 */
	public void WritePlayers(String chain) throws IOException;
}

