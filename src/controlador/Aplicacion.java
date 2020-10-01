package controlador;

import modelo.*;
import java.util.*;
import vista.*;
/**
 * 
 */
public class Aplicacion {
	
	private static Aplicacion instancia = null;
    private TablaDePosiciones tablaDePosiciones;
    private Jugador jugador = null;
    private Partida partida = null;
    
    /**
     * Default constructor
     */
    private Aplicacion() {
    	tablaDePosiciones = new TablaDePosiciones();
    }

    public static Aplicacion devolverInstancia() 
    {
    	if(instancia == null) { instancia = new Aplicacion(); }
    	return instancia; 
    }
    /**
     * @param jugador
     */
    public void nuevaPartida(String nombreJugador) 
    {
        if(jugador == null) { jugador = new Jugador(nombreJugador); }
        else if(jugador.conseguirVidas() == 0) { jugador = new Jugador(nombreJugador); }
        if(partida == null) { partida = new Partida(jugador); }
    }
    public void actualizar() 
    {
    	if(partida != null) 
    	{ 
    		if(!partida.actualizar())
    		{ 
    			partida = null;
    			if(jugador.conseguirVidas() == 0) { tablaDePosiciones.nuevaPuntuacion(jugador); }
    		}
    	} 
    }
    public void moverBatallon() { if(partida != null) { partida.moverBatallon(); } }
    public void moverDerecha() { if(partida != null) { partida.intentarDesplazarNave(true); } }
    public void moverIzquierda() { if(partida != null) { partida.intentarDesplazarNave(false); } }
    public void disparar() { if(partida != null) { partida.intentarDisparar();; } }
    
    public PartidaVista devolverPartida() { if(partida != null) { return partida.devolverPartida(); } else { return null; } }
    public JugadorVista devolverJugador() { if(jugador != null) { return jugador.aVista(); } else { return null; } }
    public TablaDePosicionesVista devolverTabla() { return tablaDePosiciones.aVista(); }
    public ObjetoVista devolverMapa(){ if(partida != null) { return partida.devolverMapa(); } else { return null; } }
    public ObjetoVista devolverBateria(){ if(partida != null) { return partida.devolverBateria(); } else { return null; } }
    public List<ObjetoVista> devolverMuros(){ if(partida != null) { return partida.devolverMuros(); } else { return null; } }
    public List<ObjetoVista> devolverNaves(){ if(partida != null) { return partida.devolverNaves(); } else { return null; } }
    public List<ObjetoVista> devolverProyectiles(){ if(partida != null) { return partida.devolverProyectiles(); } else { return null; } }
}