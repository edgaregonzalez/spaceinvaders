package modelo;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Partida {
	
    private Jugador jugador;
    public Mapa mapa;
    private Bateria bateria;
    private Muro[] muros;
    private Batallon batallon;
    private List<Proyectil> proyectiles;
    private Dificultades dificultad;
    private Estados estado;
    
    /**
     * @param jugador
     */
    public Partida(Jugador jugador) 
    {
        this.jugador = jugador;
        mapa = new Mapa(100,100,10,50);
        bateria = new Bateria(50, mapa);
        muros = new Muro[4];
        for(int i = 0; i < 4; i++) { muros[i] = new Muro( 2 * ( i + 1 ), 20, mapa); }
        switch(jugador.conseguirNivel()) 
        {
        	case 0: dificultad = Dificultades.Cadete; break;
        	case 1: dificultad = Dificultades.Guerrero; break;
        	case 2: dificultad = Dificultades.Master; break;
        	default: dificultad = Dificultades.Master;
        }
        batallon = new Batallon(mapa, 0.1f * jugador.conseguirNivel());
        proyectiles = new ArrayList<Proyectil>();
        estado = Estados.Juego;
    }

    public Boolean actualizar() 
    {
    	manejarDisparosBatallon();
    	moverBatallon();
    	moverProyectiles();
    	manejarColisiones();
    	if(estado == Estados.Fin) { return false; }
    	else { return true; }
    }
    
    public void intentarDesplazarNave(Boolean aLaDerecha) { bateria.desplazarHorizontalmente(aLaDerecha); }

    public void intentarDisparar() { proyectiles.add(new Proyectil(bateria.xRelativo(), 5, true, mapa)); }
    
    public String devolverDificultad() { return dificultad.toString(); }

    private void manejarDisparosBatallon() 
    {
    	if(Math.random() <= 0.1) 
    	{
    		int aleatorio = ThreadLocalRandom.current().nextInt(0, 14 + 1);
    		proyectiles.add(new Proyectil(batallon.devolverNaves()[aleatorio].xRelativo(), batallon.devolverNaves()[aleatorio].yRelativo(), false, mapa));
    	}
    }

    private void moverBatallon() { batallon.moverBatallon(); }

    private void moverProyectiles() { for(Proyectil p:proyectiles) { p.mover(); } }

    private void manejarColisiones() {
    	for(Proyectil p:proyectiles) 
    	{
    		if(p.devolverDireccion()) 
    		{
    			for(Muro m:muros) 
    			{
        			if(p.verificarColision(m)) 
        			{
        				m.recibirDano(10);
        				p.eliminarProyectil();
        			}    				
    			} 			
    			for(Nave n:batallon.devolverNaves()) 
    			{
        			if(p.verificarColision(n)) 
        			{
        				p.eliminarProyectil();
        				n.eliminarNave();
        				jugador.incrementarPuntuacion(10);
        				if(batallon.enemigosRestantes() == 0) 
        				{
        					jugador.incrementarNivel();
        					fin();
        				}
        			}
    			}
    		}
    		else
    		{
    			for(Muro m:muros) 
    			{
        			if(p.verificarColision(m)) 
        			{
        				m.recibirDano(5); 
        				p.eliminarProyectil();
        			}
    			}

    			if(p.verificarColision(bateria)) 
    			{
    				p.eliminarProyectil();
    				if( !jugador.disminuirVidas() ) { fin(); }
    			}   
    		}
    		    		
    		if(!p.estaDentroDelMapa(p.xRelativo(), p.yRelativo(), p.devolverArea().devolverAncho(), p.devolverArea().devolverAlto())) { p.eliminarProyectil(); }
    	}
    	
    	for(Nave n:batallon.devolverNaves()) 
		{
			if(n.verificarColision(bateria)) 
			{
				n.eliminarNave();
				if( !jugador.disminuirVidas() ) { fin(); }
				else if(batallon.enemigosRestantes() == 0) 
				{
					jugador.incrementarNivel();
					fin();
				}
			}
		}
    }
    
    private void fin() { estado = Estados.Fin; }

}