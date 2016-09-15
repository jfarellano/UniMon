package Entidades.EntidadEstatica;

import gfx.Assets;
import java.awt.Graphics;
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
    }
}