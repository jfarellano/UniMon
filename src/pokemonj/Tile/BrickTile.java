package pokemonj.Tile;

import gfx.Assets;

public class BrickTile
  extends Tile
{
  public BrickTile(int id)
  {
    super(Assets.Brick, id);
  }
  
  public boolean caminable()
  {
    return true;
  }
}
