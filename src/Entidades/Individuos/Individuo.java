package Entidades.Individuos;

import Entidades.Entidad;
import Mundos.Mundo;
import java.awt.Rectangle;
import pokemonj.Manejador;
import pokemonj.Tile.Tile;

public abstract class Individuo
extends Entidad {
    public static final int VIDA_BASE = 10;
    public static final float VELOCIDAD_BASE = 3.0f;
    public static final int TAMANO_BASE_WIDTH = 32;
    public static final int TAMANO_BASE_HEIGHT = 32;
    protected float vida = 10.0f;
    protected float velocidad = 3.0f;
    protected float xMov = 0.0f;
    protected float yMov = 0.0f;

    public Individuo(Manejador handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    public void move() {
        if (!this.checkColision(this.xMov, 0.0f)) {
            this.moveX();
        }
        if (!this.checkColision(0.0f, this.yMov)) {
            this.moveY();
        }
    }

    public void moveX() {
        if (this.xMov > 0.0f) {
            int tx = (int)(this.x + this.xMov + (float)this.limites.x + (float)this.limites.width) / 32;
            this.x = this.pegoTile(tx, (int)(this.y + (float)this.limites.y) / 32) && this.pegoTile(tx, (int)(this.y + (float)this.limites.y + (float)this.limites.height) / 32) ? (this.x += this.xMov) : (float)(tx * 32 - this.limites.x - this.limites.width - 1);
        } else if (this.xMov < 0.0f) {
            int tx = (int)(this.x + this.xMov + (float)this.limites.x) / 32;
            this.x = this.pegoTile(tx, (int)(this.y + (float)this.limites.y) / 32) && this.pegoTile(tx, (int)(this.y + (float)this.limites.y + (float)this.limites.height) / 32) ? (this.x += this.xMov) : (float)(tx * 32 + 32 - this.limites.x);
        }
    }

    public void moveY() {
        if (this.yMov < 0.0f) {
            int ty = (int)(this.y + this.yMov + (float)this.limites.y) / 32;
            this.y = this.pegoTile((int)(this.x + (float)this.limites.x) / 32, ty) && this.pegoTile((int)(this.x + (float)this.limites.x + (float)this.limites.width) / 32, ty) ? (this.y += this.yMov) : (float)(ty * 32 + 32 - this.limites.y);
        } else if (this.yMov > 0.0f) {
            int ty = (int)(this.y + this.yMov + (float)this.limites.y + (float)this.limites.height) / 32;
            this.y = this.pegoTile((int)(this.x + (float)this.limites.x) / 32, ty) && this.pegoTile((int)(this.x + (float)this.limites.x + (float)this.limites.width) / 32, ty) ? (this.y += this.yMov) : (float)(ty * 32 - this.limites.y - this.limites.height - 1);
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