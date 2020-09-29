package modelo;

import java.util.*;

/**
 * 
 */
public class Posicion {
	
    private float posicionX = 0;
    private float posicionY = 0;

    /**
     * Default constructor
     * @param x 
     * @param y
     */
    public Posicion(float x, float y) {
        posicionX = x;
        posicionY = y;
    }

    /**
     * @return
     */
    public float x() { return posicionX; }

    /**
     * @return
     */
    public float y() { return posicionY; }

    /**
     * @param x
     */
    public void cambiarX(float x) { posicionX = x; }

    /**
     * @param y
     */
    public void cambiarY(float y) { posicionY = y; }

    /**
     * @param x 
     * @param y
     */
    public void nuevaPosicion(float x, float y) {
        posicionX = x;
        posicionY = y;
    }

}