package pokemonj.UI;

import java.awt.Font;
import java.awt.Graphics;

public class TextLable extends UIObject {

    private String texto;
    private final int size;

    public TextLable(float x, float y, String t, int size) {
        super(x * 32, y * 32, 0, 0);
        this.texto = t;
        this.size = size;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.setFont(new Font("Impact", Font.PLAIN, size));
        g.drawString(texto, (int) x + 20, (int) y + 20);
    }

    @Override
    public void onClick() {
        
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}