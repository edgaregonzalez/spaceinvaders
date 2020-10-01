package vista;

public class ObjetoVista {
	private float posicionX;
	private float posicionY;
	private float areaAncho;
	private float areaAlto;
	private Boolean estadoActivo;
	
	public ObjetoVista(float x, float y, float ancho, float alto, Boolean activo) 
	{
		this.posicionX = x;
		this.posicionY = y;
		this.areaAncho = ancho;
		this.areaAlto = alto;
		this.estadoActivo = activo;
	}
	
	public float x() { return posicionX; }
	public float y() { return posicionY; }
	public float ancho() { return areaAncho; }
	public float alto() { return areaAlto; }
	public Boolean activo() { return estadoActivo; }	
}
