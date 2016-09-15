package Entidades;

import Entidades.Individuos.Jugador;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import pokemonj.Manejador;

public final class ManejadorEntidades {
    private Manejador handler;
    private Jugador player;
    private ArrayList<Entidad> entidades;
    private int contador = 0;
    private final Comparator<Entidad> ordenRender = (a, b) -> {
        if (a.getY() + (float)a.getHeight() < b.getY() + (float)b.getHeight()) {
            return -1;
        }
        return 1;
    };

    public ManejadorEntidades(Manejador handler, Jugador player) {
        this.handler = handler;
        this.player = player;
        this.entidades = new ArrayList();
        this.addEntidad((Entidad)player);
    }

    public void tick() {
        contador++;
        if(contador == 30*60)handler.getMundo().RandomSpawn();
        for (int i = 0; i < this.entidades.size(); ++i) {
            Entidad e = this.entidades.get(i);
            e.tick();
        }
        this.entidades.sort(this.ordenRender);
    }

    public void render(Graphics g) {
        for (Entidad e : this.entidades) {
            e.render(g);
        }
    }

    public void addEntidad(Entidad e) {
        this.entidades.add(e);
    }

    public Manejador getHandler() {
        return this.handler;
    }

    public void setHandler(Manejador handler) {
        this.handler = handler;
    }

    public Jugador getPlayer() {
        return this.player;
    }

    public void setPlayer(Jugador player) {
        this.player = player;
    }

    public ArrayList<Entidad> getEntidades() {
        return this.entidades;
    }

    public void setEntidades(ArrayList<Entidad> entidades) {
        this.entidades = entidades;
    }
}