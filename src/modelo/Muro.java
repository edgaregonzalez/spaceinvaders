package modelo;

import java.util.*;

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
    public Muro(float x, float y, Mapa mapa) {
        // TODO implement here
    }

    /**
     * @return vida
     */
    public int vida() {
    	
        return vida;
    }

    /**
     * @param dano
     */
    public void recibirDaño(int dano) {
        this.vida = this.vida - dano;
    }

    public void reiniciar() {
        this.vida = 100;
    }

}