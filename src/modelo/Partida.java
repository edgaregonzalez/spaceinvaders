package modelo;

import java.util.*;
import vista.*;

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
        mapa = new Mapa(0,0,300,500);
        bateria = new Bateria(150, mapa);
        muros = new Muro[4];
        for(int i = 0; i < 4; i++) { muros[i] = new Muro( 50 *  (i+1) , 350, mapa); }
        switch(jugador.conseguirNivel()) 
        {
        	case 0: dificultad = Dificultades.Cadete; break;
        	case 1: dificultad = Dificultades.Guerrero; break;
        	case 2: dificultad = Dificultades.Master; break;
        	default: dificultad = Dificultades.Master;
        }
        batallon = new Batallon(mapa, 10f);
        proyectiles = new ArrayList<Proyectil>();
        estado = Estados.Juego;
    }

    public Boolean actualizar() 
    {	
    	moverProyectiles();
    	manejarColisiones();
    	if(estado == Estados.Fin) { return false; }
    	else { return true; }
    }
    
    public void intentarDesplazarNave(Boolean aLaDerecha) { bateria.desplazarHorizontalmente(aLaDerecha); }

    public void intentarDisparar() 
    { 
    	proyectiles.add(new Proyectil(bateria.xRelativo(), bateria.yRelativo(), true, mapa));
    	System.out.println("Disparo efectuado");
    }
    
    public PartidaVista devolverPartida() { return new PartidaVista(estado.toString(), dificultad.toString()); }
    public ObjetoVista devolverMapa(){ return mapa.aVista(); }
    public ObjetoVista devolverBateria(){ return bateria.aVista(); }
    public List<ObjetoVista> devolverMuros()
    {
    	List<ObjetoVista> vistas = new ArrayList<ObjetoVista>();
    	for(Muro m:muros) { vistas.add(m.aVista()); }
    	return vistas;
    }
    public List<ObjetoVista> devolverNaves()
    {
    	List<ObjetoVista> vistas = new ArrayList<ObjetoVista>();
    	for(Nave n:batallon.devolverNaves()) { vistas.add(n.aVista()); }
    	return vistas;
    }
    public List<ObjetoVista> devolverProyectiles()
    {
    	List<ObjetoVista> vistas = new ArrayList<ObjetoVista>();
    	for(Proyectil p:proyectiles) { vistas.add(p.aVista()); }
    	return vistas;
    }
    
    private void manejarDisparosBatallon() 
    {
    	if(Math.random() < 0.5)
    	{
    		Nave[] naves = batallon.devolverNaves();
    		List<Nave> navesActivas = new ArrayList<Nave>();
    		Nave elegida;
    		for(int i = 0; i < naves.length; i++) { if(naves[i].conseguirEstado()) { navesActivas.add(naves[i]); } }
    		elegida = navesActivas.get((int)((Math.random() * (navesActivas.size()-1))));
    		proyectiles.add(new Proyectil(elegida.xRelativo(), elegida.yRelativo(), false, mapa));
    		System.out.println("Disparo Batallon");
    	}
    }

    public void moverBatallon() 
    {
    	System.out.println("Batallon en Movimiento");
    	batallon.moverBatallon(); 
    	manejarDisparosBatallon();	
    }

    private void moverProyectiles() { for(Proyectil p:proyectiles) { p.mover(); } }

    private void manejarColisiones() {
    	for(Proyectil p:proyectiles) 
    	{
    		if(p.conseguirEstado()) {
    			if(p.devolverDireccion()) 
    			{
    				for(Muro m:muros) 
    				{
        				if(p.verificarColision(m)) 
        				{
        					System.out.println("Fuego Amigo");
        					m.recibirDaño(10);
        					p.eliminarProyectil();
        				}    				
    				} 			
    				for(Nave n:batallon.devolverNaves()) 
    				{
        				if(p.verificarColision(n)) 
        				{
        					System.out.println("Colision con Nave");
        					p.eliminarProyectil();
        					n.eliminarNave();
        					jugador.incrementarPuntuacion(10);
        					if(batallon.enemigosRestantes() == 0) 
        					{
            					System.out.println("Victoria!");
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
        					System.out.println("Colision con Muro");
        					m.recibirDaño(5); 
        					p.eliminarProyectil();
        				}
    				}

    				if(p.verificarColision(bateria)) 
    				{
    					System.out.println("Recibiste Daño");
    					p.eliminarProyectil();
    					if( !jugador.disminuirVidas() ) 
    					{
        					System.out.println("Fin del Juego");
    						fin(); 
    					}
    					else { for(Muro m:muros) { m.reiniciar(); } }
    				}   
    			}
    		    		
    			if(!p.estaDentroDelMapa(p.xRelativo(), p.yRelativo(), p.devolverArea().devolverAncho(), p.devolverArea().devolverAlto())) 
    			{ 
					System.out.println("Proyectil fuera de mapa");
					p.eliminarProyectil();
    			}
    		}
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