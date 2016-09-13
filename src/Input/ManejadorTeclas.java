package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintStream;

public class ManejadorTeclas
  implements KeyListener
{
  private boolean[] keys;
  public boolean up;
  public boolean down;
  public boolean left;
  public boolean rigth;
  public boolean space;
  
  public ManejadorTeclas()
  {
    this.keys = new boolean['?'];
  }
  
  public void tick()
  {
    this.up = this.keys[38];
    this.down = this.keys[40];
    this.left = this.keys[37];
    this.rigth = this.keys[39];
    this.space = this.keys[32];
  }
  
  public void keyTyped(KeyEvent e) {}
  
  public void keyPressed(KeyEvent e)
  {
    this.keys[e.getExtendedKeyCode()] = true;
    System.out.println("Oprimido");
  }
  
  public void keyReleased(KeyEvent e)
  {
    this.keys[e.getExtendedKeyCode()] = false;
  }
}