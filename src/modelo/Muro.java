package modelo;

import java.util.*;

/**
 * 
 */
public class Muro extends ObjetoDelMapa {

    private int vida = 100;

    /**
     * @param x 
     * @param y 
     * @param mapa
     */
    public void Muro(float x, float y, Mapa mapa) {
        // TODO implement here
    }

    /**
     * @return vida
     */
    public int vida() {
    	
        return this.vida;
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