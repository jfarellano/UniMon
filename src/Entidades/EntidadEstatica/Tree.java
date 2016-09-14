package Entidades.EntidadEstatica;

import Entidades.EntidadEstatica.Estatica;
import gfx.Assets;
import gfx.CamaraJuego;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import pokemonj.Manejador;

public class Tree extends Estatica {
    public Tree(Manejador handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        this.limites.x = 10;
        this.limites.y = 15;
        this.limites.width = 8;
        this.limites.height = 15;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        g.drawImage(Assets.Tree, (int)(this.x - this.handler.getCamaraJuego().getxDesfase()), (int)(this.y - this.handler.getCamaraJuego().getyDesfase()), this.width, this.height, null);
        g.drawRect((int)(this.x - this.handler.getCamaraJuego().getxDesfase()) + this.limites.x, (int)(this.y - this.handler.getCamaraJuego().getyDesfase()) + this.limites.y, this.limites.width, this.limites.height);
    }
}