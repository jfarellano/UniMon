package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import pokemonj.UI.UIMananger;

public class ManejadorMouse implements MouseListener, MouseMotionListener {

    private boolean leftPress;
    private boolean rigthPress;
    private int mouseX;
    private int mouseY;
    private UIMananger uiMananger;
    
    
    public void setUIMananger(UIMananger uiMananger){
        this.uiMananger = uiMananger;
    }

    public boolean isLeftPress() {
        return this.leftPress;
    }

    public boolean isRigthPress() {
        return this.rigthPress;
    }

    public int getMouseX() {
        return this.mouseX;
    }

    public int getMouseY() {
        return this.mouseY;
    }

    public void mouseClicked(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            this.leftPress = true;
        }
        if (e.getButton() == 2) {
            this.rigthPress = true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == 1) {
            this.leftPress = false;
        }
        if (e.getButton() == 2) {
            this.rigthPress = false;
        }
        if(uiMananger != null) uiMananger.onMouseRelease(e);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
        if(uiMananger != null) uiMananger.onMouseMove(e);
    }
    
    
}
