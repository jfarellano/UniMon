package Entidades;

import Entidades.EntidadEstatica.Mon;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import pokemonj.Manejador;

public abstract class Entidad {
    protected Manejador handler;
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle limites;

    public Entidad(Manejador handler, float x, float y, int width, int height) {
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.limites = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public boolean checkColision(float xDesfase, float yDesfase) {
        for (Entidad e : this.handler.getMundo().getManejadorEntidades().getEntidades()) {
            if (e.equals(this) || !e.getCollisionBounds(0.0f, 0.0f).intersects(this.getCollisionBounds(xDesfase, yDesfase))) continue;
            return true;
        }
        return false;
    }
    
    public Mon checkMon(float xDesfase, float yDesfase){
        for (Iterator<Mon> it = this.handler.getMundo().getManejadorEntidades().getMones().iterator(); it.hasNext();) {
            Entidad e = it.next();
            if (e.equals(this) || !e.getCollisionBounds(0.0f, 0.0f).intersects(this.getCollisionBounds(xDesfase, yDesfase))) continue;
            return (Mon) e;
        }
        return null;
    }

    public Rectangle getCollisionBounds(float xDesfase, float yDesfase) {
        return new Rectangle((int)(this.x + (float)this.limites.x + xDesfase), (int)(this.y + (float)this.limites.y + yDesfase), this.limites.width, this.limites.height);
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}