package clases;

public class Jugador {
	/**
	 * atributos
	 */
	private String nombre;
	private int puntuacion;
	
	
	/**
	 * constructora
	 * @param nombre
	 * @param puntuacion
	 */
	public Jugador (String nombre, int puntuacion){
		this.nombre= nombre;
		this.puntuacion = puntuacion;	
	}

	
	/**
	 * metodos
	 * @return
	 */
	public String getNombre() {
	    return this.nombre;
	}
	
	
	/**
	 * recive puntuación
	 * @param puntuacion
	 */
	public void setPuntuacion(int puntuacion) {
	    this.puntuacion = puntuacion;
	}
	
	
	
	/**
	 * devuelve puntuacion
	 * @return
	 */
	public int getPuntuacion() {
	    return this.puntuacion;
	}
}
