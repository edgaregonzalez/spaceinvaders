package vista;

import modelo.Mapa;

import java.awt.event.KeyEvent;

import static modelo.Common.*;

public class JugadorVista extends ProyectilVista {
    private static final long serialVersionUID = 1L;

    private ProyectilVista misil;

    public JugadorVista(float x, float y, Mapa mapa) {
        super(x, y, false, mapa, "jugador.png");
        misil = new ProyectilVista(0, 0, true, mapa, "missile.png");
        misil.setAncho(MISSILE_WIDTH);
        misil.setAlto(MISSILE_HEIGHT);
        ancho = PLAYER_WIDTH;
        alto = PLAYER_HEIGHT;
        visible = true;
    }

    public ProyectilVista getMisil() {
        return misil;
    }

    public void moverMisil() {
        if (misil.isVisible()) {
            misil.mover();
        }
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.posicionRelativa(-PLAYER_SPEED, this.yRelativo());
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.posicionRelativa(PLAYER_SPEED, this.yRelativo());
        }
        if (key == KeyEvent.VK_SPACE) {
            if (!misil.visible) {
                misil.visible = true;
                misil.posicionRelativa(this.misil.xRelativo() + PLAYER_WIDTH / 2, this.misil.yRelativo());
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            this.posicionRelativa(0, this.yRelativo());
        }
        if (key == KeyEvent.VK_RIGHT) {
            this.posicionRelativa(0, this.yRelativo());
        }
    }

}
