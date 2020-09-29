package modelo;

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
        for(int i = 0; i < 10; i++) 
        {
        	if(!insertado && puntuaciones[i].conseguirPuntuacion() < jugador.conseguirPuntuacion()) { insertado = true; }
        	if(insertado) 
        	{
        		Puntuacion puntuacion = new Puntuacion(jugador.conseguirNombre(), jugador.conseguirPuntuacion());
        		Puntuacion auxiliar;
        		auxiliar = puntuaciones[i];
        		puntuaciones[i] = puntuacion;			
        		puntuacion = auxiliar;
        	}
        }
    }
}