package Estados;

import Estados.State;
import Input.ManejadorTeclas;
import gfx.CargarImgs;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import pokemonj.Juego;
import pokemonj.Manejador;

public class MainMenu
extends State {
    private final BufferedImage fondo;
    private String ruta;

    public MainMenu(Manejador handler, String ruta) {
        super(handler);
        this.fondo = CargarImgs.cargarImagen((String)ruta);
    }

    @Override
    public void tick() {
        if (this.handler.getManejadorTeclas().space) {
            State.setState(this.handler.getGame().getGameState());
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.fondo, 0, 0, null);
    }
}