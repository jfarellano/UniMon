package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ManejadorTeclas implements KeyListener {

    private final boolean[] keys;
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean rigth;
    public boolean space;
    public boolean m;

    public ManejadorTeclas() {
        this.keys = new boolean[225];
    }

    public void tick() {
        this.up = this.keys[38];
        this.down = this.keys[40];
        this.left = this.keys[37];
        this.rigth = this.keys[39];
        this.space = this.keys[32];
        this.m = this.keys[KeyEvent.VK_M];
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length) return;
        this.keys[e.getExtendedKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < 0 || e.getKeyCode() > keys.length) return;
        this.keys[e.getExtendedKeyCode()] = false;
    }
}
