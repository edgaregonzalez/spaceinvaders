package modelo;


/**
 * 
 */
public class Puntuacion {

    private String jugador;
    private int puntuacion;

    /**
     * Default constructor
     * @param jugador 
     * @param puntuacion
     */
    public Puntuacion(String jugador, int puntuacion) {
        this.jugador = jugador;
        this.puntuacion = puntuacion;
    }

    /**
     * @return
     */
    public String conseguirJugador() { return jugador; }

    /**
     * @return
     */
    public int conseguirPuntuacion() { return puntuacion; }

}