package Estados;

import Mundos.Mundo;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pokemonj.Manejador;

public class GameState extends State {
    private Mundo world;

    public GameState(Manejador handler) {
        super(handler);
        this.world = new Mundo(handler, "res/Mundos/mundoBase.txt");
        handler.setMundo(this.world);
    }

    @Override
    public void tick() {
        try {
            this.world.tick();
        } catch (IOException ex) {
            Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void render(Graphics g) {
        this.world.render(g);
    }
}