package pokemonj;

import Input.ManejadorMouse;
import Input.ManejadorTeclas;
import Mundos.Mundo;
import gfx.CamaraJuego;

public class Manejador {

    private Juego game;
    private Mundo mundo;

    public Manejador(Juego game) {
        this.game = game;
    }

    public CamaraJuego getCamaraJuego() {
        return this.game.getCamaraJuego();
    }

    public ManejadorTeclas getManejadorTeclas() {
        return this.game.getManejador();
    }

    public ManejadorMouse getManejadorMouse() {
        return this.game.getManejadorMouse();
    }

    public int getWidth() {
        return this.game.width;
    }

    public int getHeight() {
        return this.game.height;
    }

    public Juego getGame() {
        return this.game;
    }

    public void setGame(Juego game) {
        this.game = game;
    }

    public Mundo getMundo() {
        return this.mundo;
    }

    public void setMundo(Mundo mundo) {
        this.mundo = mundo;
    }

}
