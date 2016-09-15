package Entidades.Individuos;

import Entidades.Entidad;
import gfx.Animacion;
import gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemonj.Manejador;

public class Jugador
extends Individuo {
    private BufferedImage[] quieto;
    private Animacion animDw;
    private Animacion animUp;
    private Animacion animIzq;
    private Animacion animDer;
    int last;

    public Jugador(Manejador handler, float x, float y) {
        super(handler, x, y, 32, 32);
        this.limites.x = 10;
        this.limites.y = 0;
        this.limites.width = 13;
        this.limites.height = 30;
        this.quieto = new BufferedImage[4];
        this.quieto[0] = Assets.Turpial_Der[0];
        this.quieto[1] = Assets.Turpial_Izq[0];
        this.quieto[2] = Assets.Turpial_Up[0];
        this.quieto[3] = Assets.Turpial_Dw[0];
        this.animDw = new Animacion(200, Assets.Turpial_Dw);
        this.animDer = new Animacion(200, Assets.Turpial_Der);
        this.animIzq = new Animacion(200, Assets.Turpial_Izq);
        this.animUp = new Animacion(200, Assets.Turpial_Up);
    }

    private void getInput() {
        this.xMov = 0.0f;
        this.yMov = 0.0f;
        if (this.handler.getGame().getManejador().up) {
            this.yMov = - this.velocidad;
        }
        if (this.handler.getGame().getManejador().down) {
            this.yMov = this.velocidad;
        }
        if (this.handler.getGame().getManejador().left) {
            this.xMov = - this.velocidad;
        }
        if (this.handler.getGame().getManejador().rigth) {
            this.xMov = this.velocidad;
        }
    }

    public void tick() {
        this.animDer.tick();
        this.animDw.tick();
        this.animIzq.tick();
        this.animUp.tick();
        this.getInput();
        this.move();
        this.handler.getGame().getCamaraJuego().centrar((Entidad)this);
    }

    public void render(Graphics g) {
        g.drawImage(this.conseguirCuadro(), (int)(this.x - this.handler.getCamaraJuego().getxDesfase()), (int)(this.y - this.handler.getCamaraJuego().getyDesfase()), this.width, this.height, null);
    }

    private BufferedImage conseguirCuadro() {
        if (this.handler.getGame().getManejador().rigth) {
            this.last = 0;
            return this.animDer.getFrame();
        }
        if (this.handler.getGame().getManejador().left) {
            this.last = 1;
            return this.animIzq.getFrame();
        }
        if (this.handler.getGame().getManejador().up) {
            this.last = 2;
            return this.animUp.getFrame();
        }
        if (this.handler.getGame().getManejador().down) {
            this.last = 3;
            return this.animDw.getFrame();
        }
        return this.quieto[this.last];
    }
}