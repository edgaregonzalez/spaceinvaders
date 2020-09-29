package modelo;

/**
 * 
 */
public class Bateria extends ObjetoDelMapa {
	
    private float velocidad = 1.0f;

    /**
     * Default constructor
     * @param x 
     * @param mapa
     */
    public Bateria(float x, Mapa mapa) {
        super(mapa);
        this.posicionRelativa(x, 10);
    }

    /**
     * @param aLaDerecha
     */
    public void desplazarHorizontalmente(boolean aLaDerecha) {
        if(aLaDerecha) 
        {
        	if(this.estaDentroDelMapa(this.devolverPosicion().x() + velocidad, this.devolverPosicion().y(), this.devolverArea().devolverAncho(), this.devolverArea().devolverAlto())) 
        	{
        		this.posicionRelativa(this.xRelativo() + velocidad, this.yRelativo());
        	}
        }
        else 
        {
        	if(this.estaDentroDelMapa(this.devolverPosicion().x() - velocidad, this.devolverPosicion().y(), this.devolverArea().devolverAncho(), this.devolverArea().devolverAlto())) 
        	{
        		this.posicionRelativa(this.xRelativo() - velocidad, this.yRelativo());
        	}
        }
    }

}