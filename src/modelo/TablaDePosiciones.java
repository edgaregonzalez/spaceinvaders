package modelo;

import vista.*;
/**
 * 
 */
public class TablaDePosiciones {
	
	private Puntuacion[] puntuaciones;

    /**
     * Default constructor
     */
    public TablaDePosiciones() {
    	puntuaciones = new Puntuacion[10];
    	for(int i = 0; i < 10; i++) { puntuaciones[i] = new Puntuacion("", 0); }
    }

    public Puntuacion[] devolverTabla() { return puntuaciones; }

    /**
     * @param jugador
     */
    public void nuevaPuntuacion(Jugador jugador) {
        Boolean insertado = false;
        Puntuacion puntuacion = new Puntuacion(jugador.conseguirNombre(), jugador.conseguirPuntuacion());
        for(int i = 0; i < 10; i++) 
        {
        	if(!insertado && puntuaciones[i].conseguirPuntuacion() < jugador.conseguirPuntuacion()) { insertado = true; }
        	if(insertado) 
        	{
        		Puntuacion auxiliar;
        		auxiliar = puntuaciones[i];
        		puntuaciones[i] = puntuacion;			
        		puntuacion = auxiliar;
        	}
        }
    }
    
    public TablaDePosicionesVista aVista() 
    {
    	String[] tabla = new String[10];
    	for(int i = 0; i < 10; i++) 
    	{
    		tabla[i] = (i+1) + " - " + puntuaciones[i].conseguirJugador() + ": " + puntuaciones[i].conseguirPuntuacion();
    	}
    	return new TablaDePosicionesVista(tabla);
    }
}