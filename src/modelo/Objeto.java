package modelo;


/**
 * 
 */
public abstract class Objeto {
	
    private Posicion posicion;
    private Area area;
    private boolean activo = true;

    /**
     * Default constructor
     * @param x 
     * @param y 
     * @param ancho 
     * @param alto
     */
    public Objeto(float x, float y, float ancho, float alto) {
        posicion = new Posicion(x, y);
        area = new Area(ancho, alto);
    }

    /**
     * @return
     */
    public Posicion devolverPosicion() { return posicion; }

    /**
     * @return
     */
    public Area devolverArea() { return area; }

    /**
     * @param colisionante 
     * @return
     */
    public boolean verificarColision(Objeto colisionante) {
        if(
        		activo && 
        		colisionante.conseguirEstado() &&
        		colisionante.devolverPosicion().x() >= (posicion.x() - colisionante.devolverArea().devolverAncho()) &&
        		colisionante.devolverPosicion().x() <= (posicion.x() + area.devolverAncho()) &&
        		colisionante.devolverPosicion().y() >= (posicion.y() - colisionante.devolverArea().devolverAlto()) &&
        		colisionante.devolverPosicion().y() <= (posicion.y() + area.devolverAlto())
        ) { return true; }
        else { return false; }
    }

    /**
     * 
     */
    public Boolean conseguirEstado() { return activo; }

    /**
     * @param estado
     */
    public void cambiarEstado(boolean estado) { activo = estado; }

}