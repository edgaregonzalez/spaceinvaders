package modelo;

/**
 * 
 */
public abstract class ObjetoDelMapa extends Objeto {
    
	public Mapa mapa;
	
    
    /**
     * Default constructor
     * @param mapa
     */
    public ObjetoDelMapa(Mapa mapa) {
        super(0,0,1,1);
        this.mapa = mapa;
    }

    /**
     * @param x 
     * @param y
     */
    public void posicionRelativa(float x, float y) {
        this.devolverPosicion().cambiarX(x + mapa.devolverPosicion().x());
        this.devolverPosicion().cambiarY(y + mapa.devolverPosicion().y());
    }
    public float xRelativo() { return this.devolverPosicion().x() - mapa.devolverPosicion().x(); }
    public float yRelativo() { return this.devolverPosicion().y() - mapa.devolverPosicion().y(); }
    
    /**
     * @param x 
     * @param y 
     * @return
     */
    public boolean estaDentroDelMapa(float x, float y, float ancho, float alto) {
        if(
        		x >= mapa.devolverPosicion().x() && 
        		y >= mapa.devolverPosicion().y() &&
        		x + ancho <= mapa.devolverPosicion().x() + mapa.devolverArea().devolverAncho() &&
        		y + alto <= mapa.devolverPosicion().y() + mapa.devolverArea().devolverAlto()
        		) { return true; }
        else { return false; }        
    }

}