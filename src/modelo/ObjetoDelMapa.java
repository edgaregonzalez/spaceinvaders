package modelo;

import java.util.*;

/**
 * 
 */
public abstract class ObjetoDelMapa extends Objeto {

    /**
     * Default constructor
     */
    public ObjetoDelMapa() {
    }

    /**
     * 
     */
    public Mapa mapa;


    /**
     * @param mapa
     */
    public ObjetoDelMapa(Mapa mapa) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y
     */
    public void posicionRelativa(float x, float y) {
        // TODO implement here
    }

    /**
     * @param x 
     * @param y 
     * @return
     */
    public boolean estaDentroDelMapa(float x, float y) {
        // TODO implement here
        return false;
    }

}