package Entidades.Individuos;

import Entidades.Entidad;
import Entidades.EntidadEstatica.Mon;
import Estados.Battle;
import Estados.State;
import java.util.Random;
import pokemonj.Manejador;

public abstract class Individuo
        extends Entidad {

    public float VIDA_BASE = 100;
    public static final float VELOCIDAD_BASE = 3.0f;
    public static final int TAMANO_BASE_WIDTH = 32;
    public static final int TAMANO_BASE_HEIGHT = 32;
    protected float vida = 100.0f;
    protected float velocidad = 3.0f;
    protected float xMov = 0.0f;
    protected float yMov = 0.0f;

    public Individuo(Manejador handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    public void move() {
        if (!this.checkColision(this.xMov, 0.0f) && this.checkDisp(this.xMov, 0.0f) == null) {
            this.moveX();
        }
        if (!this.checkColision(0.0f, this.yMov) && this.checkDisp(0.0f, this.yMov) == null) {
            this.moveY();
        }
        
        if(this.checkDisp(xMov, yMov) != null && this.checkDisp(xMov, yMov).func == 0 && handler.getMundo().getManejadorEntidades().getPlayer().getVida() != handler.getMundo().getManejadorEntidades().getPlayer().VIDA_BASE){
            Random r = new Random();
            float f;
            f = handler.getMundo().getManejadorEntidades().getPlayer().getVida() + r.nextInt((int) ((int) handler.getMundo().getManejadorEntidades().getPlayer().VIDA_BASE - handler.getMundo().getManejadorEntidades().getPlayer().getVida())) + 1;
            handler.getMundo().getManejadorEntidades().getPlayer().setVida(f);
            this.checkDisp(xMov, yMov).func = 1;
        }
        
        if(this.checkMon(xMov, yMov) != null){
            Mon m = this.checkMon(xMov, yMov);
            m.image = m.text;
            State.setState(new Battle(handler, m, handler.getMundo().getManejadorEntidades().getPlayer()));
        }
    }

    public void moveX() {
        if (this.xMov > 0.0f) {
            int tx = (int) (this.x + this.xMov + (float) this.limites.x + (float) this.limites.width) / 32;
            this.x = this.pegoTile(tx, (int) (this.y + (float) this.limites.y) / 32) && this.pegoTile(tx, (int) (this.y + (float) this.limites.y + (float) this.limites.height) / 32) ? (this.x += this.xMov) : (float) (tx * 32 - this.limites.x - this.limites.width - 1);
        } else if (this.xMov < 0.0f) {
            int tx = (int) (this.x + this.xMov + (float) this.limites.x) / 32;
            this.x = this.pegoTile(tx, (int) (this.y + (float) this.limites.y) / 32) && this.pegoTile(tx, (int) (this.y + (float) this.limites.y + (float) this.limites.height) / 32) ? (this.x += this.xMov) : (float) (tx * 32 + 32 - this.limites.x);
        }
    }

    public void moveY() {
        if (this.yMov < 0.0f) {
            int ty = (int) (this.y + this.yMov + (float) this.limites.y) / 32;
            this.y = this.pegoTile((int) (this.x + (float) this.limites.x) / 32, ty) && this.pegoTile((int) (this.x + (float) this.limites.x + (float) this.limites.width) / 32, ty) ? (this.y += this.yMov) : (float) (ty * 32 + 32 - this.limites.y);
        } else if (this.yMov > 0.0f) {
            int ty = (int) (this.y + this.yMov + (float) this.limites.y + (float) this.limites.height) / 32;
            this.y = this.pegoTile((int) (this.x + (float) this.limites.x) / 32, ty) && this.pegoTile((int) (this.x + (float) this.limites.x + (float) this.limites.width) / 32, ty) ? (this.y += this.yMov) : (float) (ty * 32 - this.limites.y - this.limites.height - 1);
        }
    }

    protected boolean pegoTile(int x, int y) {
        return this.handler.getMundo().getTile(x, y).caminable();
    }

    public float getxMov() {
        return this.xMov;
    }

    public void setxMov(float xMov) {
        this.xMov = xMov;
    }

    public float getyMov() {
        return this.yMov;
    }

    public void setyMov(float yMov) {
        this.yMov = yMov;
    }

    public float getVida() {
        return this.vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public float getVelocidad() {
        return this.velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }
}
