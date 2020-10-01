package vista;

import modelo.Batallon;
import modelo.Nave;

import java.awt.*;
import java.util.ArrayList;

public class BatallonVista {
    private Batallon batallon;
    private ArrayList<NaveVista> enemigos;

    public BatallonVista(Batallon batallon) {
        this.batallon = batallon;
        this.setNaveEnemigas();
    }

    public void setNaveEnemigas() {
        enemigos = new ArrayList<NaveVista>();
        for (Nave nave : batallon.devolverNaves()) {
            enemigos.add(new NaveVista(nave.xRelativo(), nave.yRelativo(), true, nave.mapa, "enemy.png"));
        }
    }

    public void disponerBatallon(Graphics g, JuegoVista juegoVista) {
        for (NaveVista nave : enemigos) {
            if (nave.conseguirEstado())
                nave.disponerImagen(g, juegoVista);
        }
    }
}
