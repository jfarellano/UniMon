package Estados;

import Estados.State;
import Mundos.Mundo;
import java.awt.Graphics;
import pokemonj.Manejador;

public class GameState
extends State {
    private Mundo world;

    public GameState(Manejador handler) {
        super(handler);
        this.world = new Mundo(handler, "res/Mundos/mundoBase.txt");
        handler.setMundo(this.world);
    }

    public void tick() {
        this.world.tick();
    }

    public void render(Graphics g) {
        this.world.render(g);
    }
}