package Entidades.EntidadEstatica;

import Estados.State;
import gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemonj.Manejador;

public class Mon extends Estatica {
    
    public int vida, atack, id;
    public String nombre;
    public BufferedImage text, image;

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
        this.image = Assets.Blank;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if(State.getState() != handler.getGame().getGameState()){
            g.drawImage(image, 12 * 32, 3 * 32, 32 * 5, 32* 5, null);
        }else g.drawImage(image, (int)(this.x - this.handler.getCamaraJuego().getxDesfase()), (int)(this.y - this.handler.getCamaraJuego().getyDesfase()), this.width, this.height, null);
    }

    public Manejador getHandler() {
        return handler;
    }

    public BufferedImage getText() {
        return text;
    }
    
    
}