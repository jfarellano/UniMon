package Entidades.EntidadEstatica;

import gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemonj.Manejador;

public class Mon extends Estatica {
    
    int vida, atack, id;
    String nombre;
    BufferedImage text;

    public Mon(int id, int vida, int atack, String nombre, BufferedImage text, Manejador handler, float x, float y) {
        super(handler, x, y, 32, 32);
        this.vida = vida;
        this.atack = atack;
        this.id = id;
        this.nombre = nombre;
        this.text = text;
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.mones[id], (int)(this.x - this.handler.getCamaraJuego().getxDesfase()), (int)(this.y - this.handler.getCamaraJuego().getyDesfase()), this.width, this.height, null);
    }

    public Manejador getHandler() {
        return handler;
    }
    
    
}