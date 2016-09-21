package Entidades;

import Entidades.EntidadEstatica.Dispensador;
import Entidades.EntidadEstatica.Mon;
import Entidades.Individuos.Jugador;
import Utilidad.Utilidad;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import pokemonj.Manejador;

public final class ManejadorEntidades {
    private Manejador handler;
    private Jugador player;
    private ArrayList<Entidad> entidades;
    private ArrayList<Mon> mones;
     private ArrayList<Dispensador> dispensadores;
    private String[][] archivoMones;
    private int cantMon;
    private ManejadorAtaques manejadorAtaques;
    private final Comparator<Entidad> ordenRender = (a, b) -> {
        if (a.getY() + (float)a.getHeight() < b.getY() + (float)b.getHeight()) {
            return -1;
        }
        return 1;
    };

    public ManejadorEntidades(Manejador handler, Jugador player) {
        this.handler = handler;
        this.player = player;
        this.manejadorAtaques = new ManejadorAtaques();
        this.mones = new ArrayList<>();
        this.dispensadores = new ArrayList<>();
        this.entidades = new ArrayList();
        this.addEntidad((Entidad)player);
        cargarArchivoMones();
    }
    
     public void addMones(Mon m){
        mones.add(m);
    }
     
    public void delMones(Mon m){
        mones.remove(m);
    }
    
    public void addDisp(Dispensador d){
        dispensadores.add(d);
    }
    
    public void cargarArchivoMones(){
        String file = Utilidad.loadFileAsString("res/Mon/monBase.txt");
        String[] separados = file.split("\\s+");
        cantMon = Utilidad.parseInt(separados[0]);
        archivoMones = new String[cantMon][7];
        int pos = 1;
        for(int i = 0; i < cantMon; i++){
            for(int j = 0; j < 7; j++){
                archivoMones[i][j] = separados[pos];
                pos++;
            }
        }
    }

    public String[][] getArchivoMones() {
        return archivoMones;
    }

    public int getCantMon() {
        return cantMon;
    }

    public ArrayList<Mon> getMones() {
        return mones;
    }

    public ArrayList<Dispensador> getDispensadores() {
        return dispensadores;
    }
    
    public void tick() {
        for (int i = 0; i < this.entidades.size(); ++i) {
            Entidad e = this.entidades.get(i);
            e.tick();
        }
        this.entidades.sort(this.ordenRender);
        for (int i = 0; i < this.dispensadores.size(); ++i) {
            Dispensador d = this.dispensadores.get(i);
            d.tick();
        }
        this.dispensadores.sort(this.ordenRender);
    }

    public void render(Graphics g) {
         for (Dispensador d : dispensadores){
            d.render(g);
        }
        for (Entidad e : this.entidades) {
            e.render(g);
        }
        for (Mon m : mones) {
            m.render(g);
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

    public ManejadorAtaques getManejadorAtaques() {
        return manejadorAtaques;
    }
}