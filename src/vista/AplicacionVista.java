package vista;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import controlador.*;

public class AplicacionVista extends JFrame{
	
	private JLabel rotulo;
	private JTextField nombre;
	private JButton boton;
	private Aplicacion app;
	
	
	public AplicacionVista() 
	{
		app = new Aplicacion();
		Container c = this.getContentPane();
		c.setLayout(null);
		rotulo = new JLabel("Ingrese un nombre");
		nombre = new JTextField();
		boton = new JButton("Iniciar Partida");
		
		rotulo.setBounds(50,  0, 200, 30);
		nombre.setBounds(50, 50, 200, 30);
		boton.setBounds(50, 100, 200, 30);
		
		boton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				app.nuevaPartida(nombre.getText()); 
				rotulo.setVisible(false);
				nombre.setVisible(false);
				boton.setVisible(false);
			}
		});
		
		c.add(rotulo);
		c.add(nombre);
		c.add(boton);
	
		this.setSize(400,300);
		this.setVisible(true);
	}
	
	public void eventos() 
	{
		this.addKeyListener(new KeyListener() 
		{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == 39) { app.moverDerecha();  }
				if(e.getKeyCode() == 37) { app.moverIzquierda(); }
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 32) { app.disparar(); }
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
