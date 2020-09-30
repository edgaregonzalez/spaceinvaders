package controlador;

import modelo.*;
import java.util.*;
/**
 * 
 */
public class Aplicacion {
	
    private TablaDePosiciones tablaDePosiciones;
    private Jugador jugador = null;
    private Partida partida = null;
    
    /**
     * Default constructor
     */
    public Aplicacion() {
    	tablaDePosiciones = new TablaDePosiciones();
    }

    /**
     * @param jugador
     */
    public void nuevaPartida(String nombreJugador) {
        if(jugador == null) { jugador = new Jugador(nombreJugador); }
        if(partida == null) 
        {
        	partida = new Partida(jugador);
        	
        	Timer timer = new Timer();
        	TimerTask task = new TimerTask() {
				@Override
				public void run() {
					if(!partida.actualizar()) 
		        	{
						timer.cancel();
		        		partida = null;
		        		if(jugador.conseguirVidas() > 0) { nuevaPartida(nombreJugador); }
		        		else { tablaDePosiciones.nuevaPuntuacion(jugador); }
		        	}
				}
			};
			timer.scheduleAtFixedRate(task, 0, 30);
        }
    }
    public void moverDerecha() { if(partida != null) { partida.intentarDesplazarNave(true); } }
    public void moverIzquierda() { if(partida != null) { partida.intentarDesplazarNave(false); } }
    public void disparar() { if(partida != null) { partida.intentarDisparar();; } }
}