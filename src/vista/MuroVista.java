package vista;

import modelo.Mapa;
import modelo.Muro;

import java.awt.*;

import static modelo.Common.SQUARE_SIZE;

public class MuroVista extends Muro {
    int anchoMuro;
    int altoMuro;
    boolean visible;


    MuroVista(int x, int y,Mapa mapa) {
        super(x, y,mapa);
        anchoMuro=SQUARE_SIZE;
        altoMuro=SQUARE_SIZE;
        setVisible(true);
    }

    void setVisible(boolean visible) {
        this.visible = visible;
    }

    void mostrarMuro(Graphics g) {
        g.setColor(new Color(241, 59, 53));
        g.fillRect(Math.round(this.xRelativo()), Math.round(this.yRelativo()), anchoMuro, altoMuro);
    }
}
