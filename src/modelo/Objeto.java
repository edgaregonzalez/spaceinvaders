package modelo;

import java.util.*;

/**
 * 
 */
public abstract class Objeto {

    /**
     * Default constructor
     */
    public Objeto() {
    }

    /**
     * 
     */
    private Posicion posicion;

    /**
     * 
     */
    private Area area;

    /**
     * 
     */
    private boolean activo = true;






    /**
     * @param x 
     * @param y 
     * @param ancho 
     * @param alto
     */
    public void Objeto(float x, float y, float ancho, float alto) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Posicion devolverPosicion() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Area devolverArea() {
        // TODO implement here
        return null;
    }

    /**
     * @param colisionante 
     * @return
     */
    public boolean verificarColision(Objeto colisionante) {
        // TODO implement here
        return false;
    }

    /**
     * @param x 
     * @return
     */
    public float xRelativo(float x) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param y 
     * @return
     */
    public float yRelativo(float y) {
        // TODO implement here
        return 0.0f;
    }

    /**
     * 
     */
    public void conseguirEstado() {
        // TODO implement here
    }

    /**
     * @param estado
     */
    public void cambiarEstado(boolean estado) {
        // TODO implement here
    }

}