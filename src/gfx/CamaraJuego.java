package gfx;

import Entidades.Entidad;
import pokemonj.Manejador;

public class CamaraJuego {

    private float xDesfase;
    private float yDesfase;
    private final Manejador handler;

    public CamaraJuego(Manejador handler, float xDesfase, float yDesfase) {
        this.handler = handler;
        this.xDesfase = xDesfase;
        this.yDesfase = yDesfase;
    }

    public void checkEspacio() {
        if (this.xDesfase < 0.0F) {
            this.xDesfase = 0.0F;
        }
        if (this.yDesfase < 0.0F) {
            this.yDesfase = 0.0F;
        }
        if (this.xDesfase > this.handler.getMundo().getWidth() * 32 - this.handler.getWidth()) {
            this.xDesfase = (this.handler.getMundo().getWidth() * 32 - this.handler.getWidth());
        }
        if (this.yDesfase > this.handler.getMundo().getHeight() * 32 - this.handler.getHeight()) {
            this.yDesfase = (this.handler.getMundo().getHeight() * 32 - this.handler.getHeight());
        }
    }

    public void centrar(Entidad e) {
        this.xDesfase = (e.getX() - this.handler.getWidth() / 2 + e.getWidth() / 2);
        this.yDesfase = (e.getY() - this.handler.getHeight() / 2 + e.getHeight() / 2);
        checkEspacio();
    }

    public void move(float xCant, float yCant) {
        this.xDesfase += xCant;
        this.yDesfase += yCant;
        checkEspacio();
    }

    public float getxDesfase() {
        return this.xDesfase;
    }

    public void setxDesfase(float xDesfase) {
        this.xDesfase = xDesfase;
    }

    public float getyDesfase() {
        return this.yDesfase;
    }

    public void setyDesfase(float yDesfase) {
        this.yDesfase = yDesfase;
    }
}
