package modelo;

/**
 * 
 */
public class Muro extends ObjetoDelMapa {

    private int vida = 100;

    /**
     * Default Constructor
     * @param x 
     * @param y 
     * @param mapa
     */
    public Muro(float x, float y, Mapa mapa){
        super(mapa);
        this.posicionRelativa(x, y);
    }

    /**
     * @return vida
     */
    public int vida() { return vida; }

    /**
     * @param dano
     */
    public void recibirDa�o(int da�o) {
        if( (vida - da�o) > 0 ) { vida -= da�o; }
        else 
        {
        	vida = 0;
        	this.cambiarEstado(false);
        }
    }

    public void reiniciar() {
    	vida = 100;
    	this.cambiarEstado(true);
    }

}