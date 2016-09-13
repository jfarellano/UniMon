package gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CargarImgs
{
  public static BufferedImage cargarImagen(String ruta)
  {
    try
    {
      return ImageIO.read(CargarImgs.class.getResource(ruta));
    }
    catch (IOException ex)
    {
      System.exit(1);
    }
    return null;
  }
}
