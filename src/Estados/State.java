package Estados;

import java.awt.Graphics;
import pokemonj.Manejador;

public abstract class State {
    private static State currentState = null;
    protected Manejador handler;

    public static void setState(State state) {
        currentState = state;
    }

    public static State getState() {
        return currentState;
    }

    public State(Manejador handler) {
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}