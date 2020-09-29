package modelo;
/**
 * 
 */
public class Area {
	
    private float ancho;
    private float alto;

     /**
     * Default constructor
     * @param ancho 
     * @param alto
     */
    public Area(float ancho, float alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * @return
     */
    public float devolverAncho() { return ancho; }

    /**
     * @return
     */
    public float devolverAlto() { return alto; }

    /**
     * @param ancho
     */
    public void cambiarAncho(float ancho) { this.ancho = ancho; }

    /**
     * @param alto
     */
    public void cambiarAlto(float alto) { this.alto = alto; }

    /**
     * @param ancho 
     * @param alto
     */
    public void cambiarTamaño(float ancho, float alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
}