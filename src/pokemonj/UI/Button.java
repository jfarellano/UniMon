package pokemonj.UI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Button extends UIObject{
    
    private BufferedImage[] image;
    private ClickListener clicker;

    public Button(float x, float y, int width, int height, BufferedImage[] image, ClickListener clicker) {
        super(x, y, width, height);
        this.clicker = clicker;
        this.image = image;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if(hover){
            g.drawImage(image[1], (int) x, (int) y, width, height, null);
        }else{
            g.drawImage(image[0], (int) x, (int) y, width, height, null);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
    
}