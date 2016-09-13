package pokemonj;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Pantalla
{
  private JFrame ventana;
  private Canvas lienzo;
  private final String title;
  private final int width;
  private final int height;
  
  public Pantalla(String title, int width, int height)
  {
    this.title = title;
    this.width = width;
    this.height = height;
    
    crearVentana();
  }
  
  public Canvas getLienzo()
  {
    return this.lienzo;
  }
  
  public JFrame getVentana()
  {
    return this.ventana;
  }
  
  private void crearVentana()
  {
    this.ventana = new JFrame(this.title);
    this.ventana.setSize(this.width, this.height);
    this.ventana.setDefaultCloseOperation(3);
    this.ventana.setResizable(false);
    this.ventana.setLocationRelativeTo(null);
    this.ventana.setVisible(true);
    
    this.lienzo = new Canvas();
    this.lienzo.setPreferredSize(new Dimension(this.width, this.height));
    this.lienzo.setMaximumSize(new Dimension(this.width, this.height));
    this.lienzo.setMinimumSize(new Dimension(this.width, this.height));
    this.lienzo.setFocusable(false);
    
    this.ventana.add(this.lienzo);
    
    this.ventana.pack();
  }
}
