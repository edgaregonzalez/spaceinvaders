package modelo;

/**
 * 
 */
public class Nave extends ObjetoDelMapa {
	
    /**
     * @param x 
     * @param y 
     * @param mapa
     */
    public Nave(float x, float y,Mapa mapa) {
    	super(mapa);
    	this.posicionRelativa(x, y);
        this.devolverArea().cambiarTamaño(10, 20);
    }

    /**
     * 
     */
    public void eliminarNave() { this.cambiarEstado(false); }

    /**
     * 
     */
    public void reiniciar() { this.cambiarEstado(true); }

}