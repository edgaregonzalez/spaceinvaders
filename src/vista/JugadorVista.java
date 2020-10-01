package vista;

public class JugadorVista {
	
	private String jugadorNombre;
	private int jugadorPuntuacion;
	private int jugadorVidas;
	private int jugadorNivel;
	
	public JugadorVista(String nombre, int puntuacion, int vidas, int nivel) 
	{
		this.jugadorNombre = nombre;
		this.jugadorPuntuacion = puntuacion;
		this.jugadorVidas = vidas;
		this.jugadorNivel = nivel;
	}
	
	public String nombre() { return jugadorNombre; }
	public int puntuacion() { return jugadorPuntuacion; }
	public int vidas() { return jugadorVidas; }
	public int nivel() { return jugadorNivel; }
}