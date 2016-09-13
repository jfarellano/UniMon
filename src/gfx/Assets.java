package gfx;

import java.awt.image.BufferedImage;

public class Assets
{
  private static final int WIDTH = 32;
  private static final int HEIGHT = 32;
  public static BufferedImage Brick;
  public static BufferedImage Tree;
  public static BufferedImage Grass;
  public static BufferedImage Bench;
  public static BufferedImage Escalera;
  public static BufferedImage BB;
  public static BufferedImage[] Turpial_Der;
  public static BufferedImage[] Turpial_Izq;
  public static BufferedImage[] Turpial_Up;
  public static BufferedImage[] Turpial_Dw;
  public static BufferedImage[] Button;
  
  public static void init()
  {
    SpriteSheet sheet = new SpriteSheet(CargarImgs.cargarImagen("/Texturas/SpriteSheet-01.png"));
    Turpial_Der = new BufferedImage[3];
    Turpial_Izq = new BufferedImage[3];
    Turpial_Up = new BufferedImage[3];
    Turpial_Dw = new BufferedImage[3];
    Button = new BufferedImage[2];
    
    Turpial_Der[0] = sheet.crop(0, 0, 32, 32);
    Turpial_Der[1] = sheet.crop(32, 0, 32, 32);
    Turpial_Der[2] = sheet.crop(0, 32, 32, 32);
    Turpial_Izq[0] = sheet.crop(128, 0, 32, 32);
    Turpial_Izq[1] = sheet.crop(160, 0, 32, 32);
    Turpial_Izq[2] = sheet.crop(128, 32, 32, 32);
    Turpial_Dw[0] = sheet.crop(64, 32, 32, 32);
    Turpial_Dw[1] = sheet.crop(64, 0, 32, 32);
    Turpial_Dw[2] = sheet.crop(96, 0, 32, 32);
    Turpial_Up[0] = sheet.crop(192, 0, 32, 32);
    Turpial_Up[1] = sheet.crop(224, 0, 32, 32);
    Turpial_Up[2] = sheet.crop(192, 32, 32, 32);
    
    Button[0] = sheet.crop(32, 64, 32, 16);
    Button[1] = sheet.crop(32, 80, 32, 16);
    
    Brick = sheet.crop(32, 32, 32, 32);
    Grass = sheet.crop(96, 32, 32, 32);
    Tree = sheet.crop(160, 32, 32, 32);
    Bench = sheet.crop(224, 32, 64, 32);
    BB = sheet.crop(256, 0, 32, 32);
    Escalera = sheet.crop(0, 64, 32, 32);
  }
}
