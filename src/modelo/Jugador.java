package modelo;

import vista.*;
/**
 * 
 */
public class Jugador {
	


    private String nombre;
    private int nivel = 0;
    private int vidas = 3;
    private int puntuacion = 0;
    private int puntuacionRestante = 500;

    /**
     * Default constructor
     * @param nombre
     */
    public Jugador(String nombre) {
        this.nombre = nombre;
        vidas = 3;
    }

    /**
     * @return
     */
    public String conseguirNombre() { return nombre; }

    /**
     * @return
     */
    public int conseguirNivel() { return nivel; }

    /**
     * @return
     */
    public int conseguirVidas() { return vidas; }

    /**
     * @return
     */
    public int conseguirPuntuacion() { return puntuacion; }

    /**
     * 
     */
    public void incrementarNivel() {
        nivel++;
        incrementarPuntuacion(200);
    }

    /**
     * 
     */
    public void incrementarPuntuacion(int cantidad) {
        if(cantidad <= 0) { return; }
    	puntuacionRestante -= cantidad;
    	if(puntuacionRestante <= 0) 
    	{
    		puntuacionRestante = 500;
    		incrementarVidas();
    	}
    	puntuacion += cantidad;
    }

    /**
     * @return
     */
    public boolean disminuirVidas() {
    	vidas--;
    	if(vidas > 0) { return true; }
        else { return false; }
    }

    /**
     * 
     */
    private void incrementarVidas() { vidas++; }

    public JugadorVista aVista() { return new JugadorVista(nombre, puntuacion, vidas, nivel); }
}