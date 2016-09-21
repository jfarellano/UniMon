package Entidades.EntidadEstatica;

import gfx.Assets;
import java.awt.Graphics;
import pokemonj.Manejador;

public class Dispensador extends Estatica{

    int timer = 0;
    public int func = 0;

    public Dispensador(Manejador handler, float x , float y, int width, int height) {
        super(handler, x * 32, y *32, width, height);
        this.limites.x = 10;
        this.limites.y = 0;
        this.limites.width = 10;
        this.limites.height = 10;
    }

    @Override
    public void tick() {
        if(func == 1)timer ++;
        if(timer == 30 * 90){
            func = 0;
            timer = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Dispensadora, (int)(this.x - this.handler.getCamaraJuego().getxDesfase()), (int)(this.y - this.handler.getCamaraJuego().getyDesfase()), this.width, this.height, null);
    }

}