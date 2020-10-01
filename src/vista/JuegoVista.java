package vista;

import controlador.Aplicacion;
import modelo.Mapa;
import modelo.Muro;
import modelo.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static modelo.Common.*;

public class JuegoVista extends JPanel {
    JugadorVista jugadorVista;
    BatallonVista batallonVista;
    MuroVista[] muroVistas;
    Partida partida;
    public Mapa mapa;

    private boolean inGame;
    private Integer lives;
    private String message;

    JuegoVista(Aplicacion aplicacion) {
        partida = aplicacion.getPartida();
        jugadorVista = new JugadorVista(START_X, START_Y, partida.mapa);
        addKeyListener(new KAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        muroVistas = new MuroVista[4];

        for(int i=0; i<partida.getMuros().length; i++) {
            Muro muro=partida.getMuros()[i];
            if(muro.conseguirEstado()) muroVistas[i]= new MuroVista(Math.round(muro.xRelativo()),Math.round(muro.yRelativo()),muro.mapa);
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Font font = new Font("Helvetica", Font.PLAIN, 15);
        g.setColor(Color.WHITE);
        g.setFont(font);

        g.drawString("Vidas : " + 3, BOARD_WIDTH - 90, 20);
        g.drawString("Enemigos Restantes : " + 10, 28, 20);

        g.setColor(Color.GREEN);
        g.drawLine(0, GROUND, BOARD_WIDTH, GROUND);

        jugadorVista.disponerImagen(g, this);
        if (jugadorVista.getMisil().isVisible())
            jugadorVista.getMisil().disponerImagen(g, this);

        for(MuroVista muroVista : muroVistas) {
            if(muroVista.conseguirEstado())muroVista.mostrarMuro(g);
        }
        batallonVista = new BatallonVista(partida.getBatallon());
        batallonVista.disponerBatallon(g, this);
    }

    private class KAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            jugadorVista.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            jugadorVista.keyReleased(e);
        }
    }
}
