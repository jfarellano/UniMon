package pokemonj.Tile;

import gfx.Assets;

public class BBTile
  extends Tile
{
  public BBTile(int id)
  {
    super(Assets.BB, id);
  }
  
  public boolean caminable()
  {
    return false;
  }
}
