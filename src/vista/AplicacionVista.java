package vista;
import java.util.*;
import java.util.List;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import javax.swing.*;
import controlador.*;

public class AplicacionVista extends JFrame{
	
	private JFrame ventana;
	private JLabel rotulo;
	private JTextField nombre;
	private JButton boton;
	private Container c;
	
	private JLabel vidas;
	private JLabel nivel;
	private JLabel puntuacion;
	private JLabel nombreJugador;
	
	private List<JLabel> tabla;
	private JButton botonTabla;
	
	private JLabel bateria;
	private List<JLabel> muros;
	private List<JLabel> naves;
	private List<JLabel> proyectiles;
	
	public AplicacionVista() 
	{
		configuracion();
		eventos();
	}
	private void configuracion() 
	{
		ventana = this;
		c = this.getContentPane();
		c.setLayout(null);
		rotulo = new JLabel("Ingrese un nombre");
		nombre = new JTextField();
		boton = new JButton("Iniciar Partida");
		
		rotulo.setBounds(50,  0, 200, 30);
		nombre.setBounds(50, 50, 200, 30);
		boton.setBounds(50, 100, 200, 30);
		
		rotulo.setVisible(true);
		nombre.setVisible(true);
		boton.setVisible(true);
		
		this.setFocusable(true);
		this.setSize(400,300);
		this.setVisible(true);
		
		tabla = new ArrayList<JLabel>();
		for(int i = 0; i<10 ; i++) {
			tabla.add(new JLabel(""));			
			tabla.get(i).setBounds(50, 30 * (i+1), 100, 20);
			tabla.get(i).setVisible(false);
			c.add(tabla.get(i));
		}
		
		botonTabla = new JButton("Ok");
		botonTabla.setBounds(50, 400, 200, 30);
		botonTabla.setVisible(false);
		botonTabla.addActionListener(new ActionListener() 
		{
			@Override 
			public void actionPerformed(ActionEvent e) 
			{
				for(int i = 0; i<10 ; i++) { tabla.get(i).setVisible(false); }
				botonTabla.setVisible(false);
				configuracion();
			}
		});
		
			
		
		
		boton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				Aplicacion.devolverInstancia().nuevaPartida(nombre.getText()); 
				rotulo.setVisible(false);
				nombre.setVisible(false);
				boton.setVisible(false);
				iniciarPartida();
			}
		});
		
		c.add(botonTabla);
		c.add(rotulo);
		c.add(nombre);
		c.add(boton);	
	}
	private void eventos() 
	{
		ventana.addKeyListener(new KeyListener() 
		{
			@Override public void keyTyped(KeyEvent e) { }
			@Override public void keyPressed(KeyEvent e) 
			{ 
				if(e.getKeyCode() == 39) { Aplicacion.devolverInstancia().moverDerecha(); }
				if(e.getKeyCode() == 37) { Aplicacion.devolverInstancia().moverIzquierda(); }
			}
			@Override public void keyReleased(KeyEvent e) { if(e.getKeyCode() == 32) { Aplicacion.devolverInstancia().disparar(); } }	
		});

	}
	private void iniciarPartida() 
	{
		this.setSize((int)Aplicacion.devolverInstancia().devolverMapa().ancho() + 20, (int)Aplicacion.devolverInstancia().devolverMapa().alto() + 20);
		
		JugadorVista jugador = Aplicacion.devolverInstancia().devolverJugador();
		nivel = new JLabel(Aplicacion.devolverInstancia().devolverPartida().dificultad());
		nivel.setBounds( 230, 50, 100, 20);
		nivel.setVisible(true);
		c.add(nivel);
		puntuacion = new JLabel(""+jugador.puntuacion());
		puntuacion.setBounds( 140, 50, 50, 20);
		puntuacion.setVisible(true);
		c.add(puntuacion);
		nombreJugador = new JLabel(jugador.nombre());
		nombreJugador.setBounds( 10, 50, 50, 20);
		nombreJugador.setVisible(true);
		c.add(nombreJugador);
		
		vidas = new JLabel("Vidas: "+jugador.vidas());
		vidas.setBounds( 125, 25, 50, 20);
		vidas.setVisible(true);
		c.add(vidas);
		
		
		bateria = new JLabel("oio");
		bateria.setVisible(true);
		bateria.setBackground(Color.lightGray);
		bateria.setOpaque(true);
		c.add(bateria);
		
		muros = new ArrayList<JLabel>();
		for(int i = 0; i<4; i++) 
		{
			muros.add(new JLabel("-M-"));
			muros.get(i).setVisible(true);
			muros.get(i).setBackground(Color.lightGray);
			muros.get(i).setOpaque(true);
			c.add(muros.get(i));	
		}
		
		naves = new ArrayList<JLabel>();
		for(int i = 0; i<15; i++) 
		{
			naves.add(new JLabel("V"));
			naves.get(i).setVisible(true);
			naves.get(i).setBackground(Color.lightGray);
			naves.get(i).setOpaque(true);
			c.add(naves.get(i));	
		}
		
		proyectiles = new ArrayList<JLabel>();
		timers();
	}
	private void actualizarPantalla() 
	{
		ObjetoVista obj = Aplicacion.devolverInstancia().devolverBateria();
		if(obj != null) {
			nivel.setText(Aplicacion.devolverInstancia().devolverPartida().dificultad());
			nombreJugador.setText(Aplicacion.devolverInstancia().devolverJugador().nombre());
			vidas.setText("Vidas: "+Aplicacion.devolverInstancia().devolverJugador().vidas());
			puntuacion.setText("" + Aplicacion.devolverInstancia().devolverJugador().puntuacion());
			List<ObjetoVista> objs;
		
			if(obj.activo()) { bateria.setBounds((int)obj.x(),  (int)obj.y(), (int)obj.ancho(), (int)obj.alto()); }
			else { bateria.setVisible(false); }
			
			objs = Aplicacion.devolverInstancia().devolverMuros();
			for(int i = 0; i < objs.size(); i++) 
			{
				ObjetoVista o = objs.get(i);
				if(o.activo()) 
				{
					muros.get(i).setBounds((int)o.x(),  (int)o.y(), (int)o.ancho(), (int)o.alto()); 
					muros.get(i).setVisible(true);
				}
				else { muros.get(i).setVisible(false); }
			}
			
			objs = Aplicacion.devolverInstancia().devolverNaves();
			for(int i = 0; i < objs.size(); i++) 
			{
				ObjetoVista o = objs.get(i);
				if(o.activo()) { naves.get(i).setBounds((int)o.x(),  (int)o.y(), (int)o.ancho(), (int)o.alto()); }
				else { naves.get(i).setVisible(false); }
			}
			
			objs = Aplicacion.devolverInstancia().devolverProyectiles();
			int diferencia = objs.size() - proyectiles.size();
			if(diferencia > 0)  { for(int i = 0; i < diferencia; i++)  { proyectiles.add(new JLabel("o")); } }
			
			for(int i = 0; i < objs.size(); i++) 
			{
				ObjetoVista o = objs.get(i);
				JLabel rotulo = proyectiles.get(i);
				if(o.activo()) 
				{
					rotulo.setBounds((int)o.x(),  (int)o.y(), (int)o.ancho(), (int)o.alto()); 
					rotulo.setVisible(true);	
					rotulo.setBackground(Color.lightGray);
					rotulo.setOpaque(true);
					c.add(rotulo);
				}
				else { rotulo.setVisible(false); }
			}
		}
	}
	private void borrarPantalla() 
	{
		nombreJugador.setVisible(false);
		c.remove(nombreJugador);
		puntuacion.setVisible(false);
		c.remove(puntuacion);
		nivel.setVisible(false);
		c.remove(nivel);
		vidas.setVisible(false);
		c.remove(vidas);
		
		bateria.setVisible(false);
		c.remove(bateria);
		for(JLabel muro:muros) 
		{
			muro.setVisible(false);
			c.remove(muro);
		}
		muros.clear();
		for(JLabel nave:naves) 
		{
			nave.setVisible(false);
			c.remove(nave);
		}
		naves.clear();
		for(JLabel proyectil:proyectiles) 
		{
			proyectil.setVisible(false);
			c.remove(proyectil);
		}
		proyectiles.clear();
	}
	private void timers() 
	{
		Timer fps = new Timer();
		Timer turno = new Timer();
    	TimerTask tareaFps = new TimerTask() {
			@Override
			public void run() {				
				if(Aplicacion.devolverInstancia().devolverPartida() != null) 
				{
					Aplicacion.devolverInstancia().actualizar();
					actualizarPantalla();	
				}
				else 
				{
					borrarPantalla();
					JugadorVista jugador = Aplicacion.devolverInstancia().devolverJugador();
					if(jugador.vidas()>0) 
					{
						Aplicacion.devolverInstancia().nuevaPartida(jugador.nombre());
						iniciarPartida();
					}
					else 
					{
						tablaDePosiciones(); 
					}
					
					fps.cancel(); 
					turno.cancel();
				}
			}
		};
		TimerTask tareaTurno = new TimerTask() { @Override public void run() { Aplicacion.devolverInstancia().moverBatallon(); } };
		
		turno.scheduleAtFixedRate(tareaTurno, 0, 2000 / (Aplicacion.devolverInstancia().devolverJugador().nivel()+1));
		fps.scheduleAtFixedRate(tareaFps, 0, 10);	
	}
	private void tablaDePosiciones() 
	{
		String[] puntuaciones = Aplicacion.devolverInstancia().devolverTabla().posiciones();
		
		for(int i = 0; i<10 ; i++) {
			tabla.get(i).setText(puntuaciones[i]);
			tabla.get(i).setVisible(true);
		}
		botonTabla.setVisible(true);
	}
}
