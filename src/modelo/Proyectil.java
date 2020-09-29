package modelo;


/**
 * 
 */
public class Proyectil extends ObjetoDelMapa {
	

    private float velocidad = 1.0f;
    private boolean direccionHaciaArriba;

    /**
     * Default constructor
     * @param x 
     * @param y 
     * @param desplazamientoHaciaArriba 
     * @param mapa
     */
    public Proyectil(float x, float y, boolean desplazamientoHaciaArriba, Mapa mapa) {
        super(mapa);
        this.posicionRelativa(x, y);
        direccionHaciaArriba = desplazamientoHaciaArriba;
    }

    /**
     * 
     */
    public void mover() {
        if(direccionHaciaArriba) { this.posicionRelativa(this.xRelativo(), this.yRelativo() + velocidad); }
        else { this.posicionRelativa(this.xRelativo(), this.yRelativo() - velocidad); }
    }

    /**
     * 
     */
    public void eliminarProyectil() { this.cambiarEstado(false); }

}