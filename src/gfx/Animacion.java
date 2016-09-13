package gfx;

import java.awt.image.BufferedImage;

public class Animacion
{
  private int speed;
  private int index;
  private long lastTime;
  private long timer;
  private BufferedImage[] frames;
  
  public Animacion(int speed, BufferedImage[] frames)
  {
    this.speed = speed;
    this.frames = frames;
    this.timer = 0L;
    this.index = 0;
    this.lastTime = System.currentTimeMillis();
  }
  
  public BufferedImage getFrame()
  {
    return this.frames[this.index];
  }
  
  public void tick()
  {
    this.timer += System.currentTimeMillis() - this.lastTime;
    this.lastTime = System.currentTimeMillis();
    if (this.timer > this.speed)
    {
      this.index += 1;
      this.timer = 0L;
      if (this.index >= this.frames.length) {
        this.index = 0;
      }
    }
  }
}
