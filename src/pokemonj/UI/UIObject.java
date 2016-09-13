package pokemonj.UI;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected Rectangle limites;
    protected boolean hover = false;

    public UIObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.limites = new Rectangle((int) x, (int) y, width, height);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract void onClick();

    public void onMouseMove(MouseEvent e) {
        if (this.limites.contains(e.getX(), e.getY())) {
            this.hover = true;
        } else {
            this.hover = false;
        }
    }

    public void OnMouseRelease(MouseEvent e) {
        if (this.hover) {
            onClick();
        }
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

    public boolean isHover() {
        return this.hover;
    }

    public void setHover(boolean Hover) {
        this.hover = Hover;
    }
}
