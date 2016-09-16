package Entidades.EntidadEstatica;

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
        this.limites.x = 0;
        this.limites.y = 0;
        this.limites.width = 32;
        this.limites.height = 32;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(text, (int)(this.x - this.handler.getCamaraJuego().getxDesfase()), (int)(this.y - this.handler.getCamaraJuego().getyDesfase()), this.width, this.height, null);
    }

    public Manejador getHandler() {
        return handler;
    }

    public BufferedImage getText() {
        return text;
    }
    
    
}