package Estados;

import gfx.Assets;
import java.awt.Graphics;
import pokemonj.Manejador;

public class Battle extends State{

    public Battle(Manejador handler) {
        super(handler);
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.BB, 0, 0, null);
    }

}