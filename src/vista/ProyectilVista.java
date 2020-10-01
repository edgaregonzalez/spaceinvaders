package vista;

import modelo.Mapa;
import modelo.Proyectil;

import javax.swing.*;
import java.awt.*;

public class ProyectilVista extends Proyectil {

    protected Image image;
    protected float ancho;
    protected float alto;
    protected boolean visible;
    protected  boolean moviendo;

    public ProyectilVista(float x, float y, boolean desplazamientoHaciaArriba, Mapa mapa, String nombreImagen) {
        super(x, y, desplazamientoHaciaArriba, mapa);
        cargarImagen(nombreImagen);
    }

    void cargarImagen(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public void disponerImagen(Graphics g, JuegoVista juegoVista) {
        g.drawImage(image, Math.round(this.xRelativo()) , Math.round(this.yRelativo()), Math.round(ancho),Math.round(alto) , juegoVista);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isMoviendo() {
        return moviendo;
    }

    public void setMoviendo(boolean moviendo) {
        this.moviendo = moviendo;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }
}
