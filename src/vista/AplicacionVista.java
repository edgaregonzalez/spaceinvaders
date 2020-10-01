package vista;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controlador.*;

import static modelo.Common.BOARD_HEIGHT;
import static modelo.Common.BOARD_WIDTH;

public class AplicacionVista extends JFrame {

    private static AplicacionVista ourInstance;
    private JLabel rotulo;
    private JTextField nombre;
    private JButton boton;
    private Aplicacion app;
    private JPanel juegoVista;


    public AplicacionVista() {
        setTitle("Space invaders");
        setSize(BOARD_WIDTH, BOARD_HEIGHT);

        app = new Aplicacion();
        app.nuevaPartida("Pedro");
//        Container c = this.getContentPane();
//        c.setLayout(null);
//        rotulo = new JLabel("Ingrese tu nombre");
//        nombre = new JTextField();
//        boton = new JButton("Iniciar Partida");
//
//        rotulo.setBounds(50, 0, 200, 30);
//        nombre.setBounds(50, 50, 200, 30);
//        boton.setBounds(50, 100, 200, 30);

//        boton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                app.nuevaPartida(nombre.getText());
//                rotulo.setVisible(false);
//                nombre.setVisible(false);
//                boton.setVisible(false);
//                juegoVista = new JuegoVista(app);
//                add(juegoVista);
//            }
//        });

//        c.add(rotulo);
//        c.add(nombre);
//        c.add(boton);
        juegoVista = new JuegoVista(app);

        this.add(juegoVista);
        this.setFocusable(true);
        this.setLocationRelativeTo(null);
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void eventos() {
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                if (e.getKeyCode() == 39) {
                    app.moverDerecha();
                }
                if (e.getKeyCode() == 37) {
                    app.moverIzquierda();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32) {
                    app.disparar();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub

            }

        });
    }

    public static AplicacionVista getInstance() {
        if (ourInstance == null) {
            ourInstance = new AplicacionVista();
        }
        return ourInstance;
    }

    public static AplicacionVista getOurInstance() {
        return ourInstance;
    }
}
