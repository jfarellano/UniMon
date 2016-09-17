package pokemonj.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button extends UIObject{
    
    private BufferedImage[] image;
    private ClickListener clicker;
    private String texto;

    public Button(float x, float y, int width, int height, BufferedImage[] image, String t, ClickListener clicker) {
        super(x, y, width, height);
        this.clicker = clicker;
        this.image = image;
        this.texto = t;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if(hover){
            g.drawImage(image[1], (int) x, (int) y, width, height, null);
            g.drawString(texto, (int) x + 32, (int) y + 20);
        }else{
            g.drawImage(image[0], (int) x, (int) y, width, height, null);
            g.drawString(texto, (int) x + 32, (int) y + 20);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
    
}