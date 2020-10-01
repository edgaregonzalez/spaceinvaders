package vista;

public class TablaDePosicionesVista {
	private String[] posicionesTabla;
	
	public TablaDePosicionesVista(String[] posiciones) 
	{
		posicionesTabla = posiciones;
	}
	
	public String[] posiciones() { return posicionesTabla; }
}
