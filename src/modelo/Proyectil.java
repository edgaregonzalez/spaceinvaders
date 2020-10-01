package modelo;


/**
 * 
 */
public class Proyectil extends ObjetoDelMapa {
	

    private float velocidad = 1f;
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
        if(!direccionHaciaArriba) { velocidad = -velocidad; }
        this.devolverArea().cambiarTama�o(10f, 10f);
    }

    public Boolean devolverDireccion() { return direccionHaciaArriba; }
    /**
     * 
     */
    public void mover() { this.posicionRelativa(this.xRelativo(), this.yRelativo() - velocidad); }
    
    /**
     * 
     */
    public void eliminarProyectil() { this.cambiarEstado(false); }

}