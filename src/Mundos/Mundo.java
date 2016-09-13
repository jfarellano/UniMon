package Mundos;

import Entidades.EntidadEstatica.Tree;
import Entidades.Individuos.Jugador;
import Entidades.ManejadorEntidades;
import Utilidad.Utilidad;
import gfx.CamaraJuego;
import java.awt.Graphics;
import java.io.PrintStream;
import pokemonj.Juego;
import pokemonj.Manejador;
import pokemonj.Tile.Tile;

public class Mundo
{
  private int width;
  private int height;
  private int spwX;
  private int spwY;
  private int[][] tiles;
  private final Manejador handler;
  private ManejadorEntidades manejadorEntidades;
  
  public Mundo(Manejador handler, String ruta)
  {
    this.handler = handler;
    
    this.manejadorEntidades = new ManejadorEntidades(handler, new Jugador(handler, this.spwX, this.spwY));
    this.manejadorEntidades.addEntidad(new Tree(handler, 950.0F, 900.0F, 32, 32));
    
    cargarMundo(ruta);
    this.manejadorEntidades.getPlayer().setX(this.spwX);
    this.manejadorEntidades.getPlayer().setY(this.spwY);
  }
  
  public void tick()
  {
    this.manejadorEntidades.tick();
  }
  
  public void render(Graphics g)
  {
    int xStart = (int)Math.max(0.0F, this.handler.getCamaraJuego().getxDesfase() / 32.0F);
    int xEnd = (int)Math.min(this.width, this.handler.getCamaraJuego().getxDesfase() / 32.0F + this.handler.getGame().width);
    int yStart = (int)Math.max(0.0F, this.handler.getCamaraJuego().getyDesfase() / 32.0F);
    int yEnd = (int)Math.min(this.height, this.handler.getCamaraJuego().getyDesfase() / 32.0F + this.handler.getGame().height);
    for (int y = yStart; y < yEnd; y++) {
      for (int x = xStart; x < xEnd; x++) {
        getTile(x, y).render(g, (int)(x * 32 - this.handler.getCamaraJuego().getxDesfase()), (int)(y * 32 - this.handler.getCamaraJuego().getyDesfase()));
      }
    }
    this.manejadorEntidades.render(g);
  }
  
  public Tile getTile(int x, int y)
  {
    if ((x < 0) || (y < 0) || (x >= this.width) || (y >= this.height)) {
      return Tile.brickTile;
    }
    Tile t = Tile.tiles[this.tiles[x][y]];
    if (t == null) {
      return Tile.grassTile;
    }
    return t;
  }
  
  private void cargarMundo(String ruta)
  {
    String file = Utilidad.loadFileAsString(ruta);
    String[] separados = file.split("\\s+");
    this.width = Utilidad.parseInt(separados[0]);
    System.out.println(this.width);
    this.height = Utilidad.parseInt(separados[1]);
    this.spwX = Utilidad.parseInt(separados[2]);
    this.spwY = Utilidad.parseInt(separados[3]);
    
    this.tiles = new int[this.width][this.height];
    for (int y = 0; y < this.height; y++) {
      for (int x = 0; x < this.width; x++) {
        this.tiles[x][y] = Utilidad.parseInt(separados[(x + y * this.width + 4)]);
      }
    }
  }
  
  public int getSpwX()
  {
    return this.spwX;
  }
  
  public int getSpwY()
  {
    return this.spwY;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public ManejadorEntidades getManejadorEntidades()
  {
    return this.manejadorEntidades;
  }
  
  public void setManejadorEntidades(ManejadorEntidades manejadorEntidades)
  {
    this.manejadorEntidades = manejadorEntidades;
  }
}