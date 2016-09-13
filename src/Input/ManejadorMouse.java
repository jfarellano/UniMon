package Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ManejadorMouse
  implements MouseListener, MouseMotionListener
{
  private boolean leftPress;
  private boolean rigthPress;
  private int mouseX;
  private int mouseY;
  
  public boolean isLeftPress()
  {
    return this.leftPress;
  }
  
  public boolean isRigthPress()
  {
    return this.rigthPress;
  }
  
  public int getMouseX()
  {
    return this.mouseX;
  }
  
  public int getMouseY()
  {
    return this.mouseY;
  }
  
  public void mouseClicked(MouseEvent e)
  {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  public void mousePressed(MouseEvent e)
  {
    if (e.getButton() == 1) {
      this.leftPress = true;
    }
    if (e.getButton() == 2) {
      this.rigthPress = true;
    }
  }
  
  public void mouseReleased(MouseEvent e)
  {
    if (e.getButton() == 1) {
      this.leftPress = false;
    }
    if (e.getButton() == 2) {
      this.rigthPress = false;
    }
  }
  
  public void mouseEntered(MouseEvent e) {}
  
  public void mouseExited(MouseEvent e) {}
  
  public void mouseDragged(MouseEvent e) {}
  
  public void mouseMoved(MouseEvent e)
  {
    this.mouseX = e.getX();
    this.mouseY = e.getY();
  }
}
