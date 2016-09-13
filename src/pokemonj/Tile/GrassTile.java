package pokemonj.Tile;

import gfx.Assets;

public class GrassTile
  extends Tile
{
  public GrassTile(int id)
  {
    super(Assets.Grass, id);
  }
  
  public boolean caminable()
  {
    return false;
  }
}
