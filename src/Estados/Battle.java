package Estados;

import Entidades.EntidadEstatica.Mon;
import java.awt.Graphics;
import pokemonj.Manejador;

public class Battle extends State{
    
    private Mon m;

    public Battle(Manejador handler, Mon m) {
        super(handler);
        this.m = m;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        m.render(g);
    }

}