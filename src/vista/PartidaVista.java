package vista;

public class PartidaVista {
	private String estadoPartida;
	private String dificultadPartida;
	
	public PartidaVista(String estado, String dificultad) 
	{
		estadoPartida = estado;
		dificultadPartida = dificultad;
	}
	
	public String estado() { return estadoPartida; }
	public String dificultad() { return dificultadPartida; }
}
