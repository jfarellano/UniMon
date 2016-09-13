package pokemonj.Tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile
{
  public static Tile[] tiles = new Tile[4];
  public static Tile grassTile = new GrassTile(0);
  public static Tile brickTile = new BrickTile(1);
  public static Tile bbTile = new BBTile(2);
  public static Tile esclaeraTile = new EscaleraTile(3);
  protected BufferedImage texture;
  protected final int id;
  public static final int TILEWIDTH = 32;
  public static final int TILEHEIGHT = 32;
  
  public Tile(BufferedImage texture, int id)
  {
    this.texture = texture;
    this.id = id;
    tiles[id] = this;
  }
  
  public boolean caminable()
  {
    return true;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void tick() {}
  
  public void render(Graphics g, int x, int y)
  {
    g.drawImage(this.texture, x, y, 32, 32, null);
  }
}
