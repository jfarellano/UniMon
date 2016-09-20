package Mundos;

import Entidades.EntidadEstatica.Dispensador;
import Entidades.EntidadEstatica.Mon;
import Entidades.EntidadEstatica.Tree;
import Entidades.Individuos.Jugador;
import Entidades.ManejadorEntidades;
import Estados.Inventario;
import Estados.State;
import Estados.TresAtaques;
import Utilidad.Utilidad;
import gfx.Assets;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import pokemonj.Manejador;
import pokemonj.Tile.Tile;

public class Mundo {

    private int width;
    private int height;
    private int spwX;
    private int spwY;
    private int veces = 0;
    private int[][] tiles;
    private final Manejador handler;
    private ManejadorEntidades manejadorEntidades;
    private final ArrayList<Mon> mones;

    public Mundo(Manejador handler, String ruta) {
        this.handler = handler;
        this.mones = new ArrayList<>();
        
        this.manejadorEntidades = new ManejadorEntidades(handler, new Jugador(handler, this.spwX, this.spwY));
        this.manejadorEntidades.addEntidad(new Tree(handler, 950.0F, 900.0F, 32, 32));
        this.manejadorEntidades.addDisp(new Dispensador(handler, 14, 13, 32, 32));
        this.manejadorEntidades.addDisp(new Dispensador(handler, 21, 21, 32, 32));
        this.manejadorEntidades.addDisp(new Dispensador(handler, 1, 26, 32, 32));
        this.manejadorEntidades.addDisp(new Dispensador(handler, 46, 23, 32, 32));
        this.manejadorEntidades.addDisp(new Dispensador(handler, 32, 1, 32, 32));
        this.manejadorEntidades.addDisp(new Dispensador(handler, 45, 1, 32, 32));
        this.manejadorEntidades.addDisp(new Dispensador(handler, 22, 34, 32, 32));

        cargarMundo(ruta);
        manejadorEntidades.cargarArchivoMones();
        RandomSpawn();
        this.manejadorEntidades.getPlayer().setX(this.spwX);
        this.manejadorEntidades.getPlayer().setY(this.spwY);
    }
    
    public Mon monAleatorio(){
        Random rand = new Random();
        int n;
        n = rand.nextInt(manejadorEntidades.getCantMon());
        float randX = rand.nextInt(width) * 32; 
        float randY = rand.nextInt(height) * 32;
        while(!PosValida((int)randX, (int)randY)){
            if(!PosValida((int)randX, (int)randY)){
            randX = rand.nextInt(width) * 32; 
            randY = rand.nextInt(height) * 32;   
            }
        }
        Mon mon = new Mon(n,Utilidad.parseInt(manejadorEntidades.getArchivoMones()[n][1]), manejadorEntidades.getArchivoMones()[n][3],Assets.mones[n], handler, randX, randY, Utilidad.parseInt(manejadorEntidades.getArchivoMones()[n][4]), Utilidad.parseInt(manejadorEntidades.getArchivoMones()[n][5]), Utilidad.parseInt(manejadorEntidades.getArchivoMones()[n][6]));
        return mon;
    }
    
    public void RandomSpawn(){
        Random rand = new Random();
        manejadorEntidades.getMones().clear();
        for(int i = 0; i <= 10; i++){
            manejadorEntidades.addMones(monAleatorio());
        }
    }
    
    public boolean PosValida(int x, int y){
        if(Tile.tiles[tiles[x / 32][y / 32]].caminable()){
            return true;
        }
        return false;
    }

    public void tick() {
        this.manejadorEntidades.tick();
        if (veces == 30*60){
            RandomSpawn();
            veces = 0;
        }
        veces ++;
        if(handler.getManejadorTeclas().m){
            State.setState(new TresAtaques(handler, 0, manejadorEntidades.getPlayer()));
        }
    }

    public void render(Graphics g) {
        int xStart = (int) Math.max(0.0F, this.handler.getCamaraJuego().getxDesfase() / 32.0F);
        int xEnd = (int) Math.min(this.width, this.handler.getCamaraJuego().getxDesfase() / 32.0F + this.handler.getGame().width);
        int yStart = (int) Math.max(0.0F, this.handler.getCamaraJuego().getyDesfase() / 32.0F);
        int yEnd = (int) Math.min(this.height, this.handler.getCamaraJuego().getyDesfase() / 32.0F + this.handler.getGame().height);
        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).render(g, (int) (x * 32 - this.handler.getCamaraJuego().getxDesfase()), (int) (y * 32 - this.handler.getCamaraJuego().getyDesfase()));
            }
        }
        this.manejadorEntidades.render(g);
    }

    public Tile getTile(int x, int y) {
        if ((x < 0) || (y < 0) || (x >= this.width) || (y >= this.height)) {
            return Tile.brickTile;
        }
        Tile t = Tile.tiles[this.tiles[x][y]];
        if (t == null) {
            return Tile.grassTile;
        }
        return t;
    }

    private void cargarMundo(String ruta) {
        String file = Utilidad.loadFileAsString(ruta);
        String[] separados = file.split("\\s+");
        this.width = Utilidad.parseInt(separados[0]);
        System.out.println(this.width);
        this.height = Utilidad.parseInt(separados[1]);
        this.spwX = Utilidad.parseInt(separados[2]);
        this.spwY = Utilidad.parseInt(separados[3]);

        this.tiles = new int[this.width][this.height];
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                this.tiles[x][y] = Utilidad.parseInt(separados[(x + y * this.width + 4)]);
            }
        }
    }

    public int getSpwX() {
        return this.spwX;
    }

    public int getSpwY() {
        return this.spwY;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ManejadorEntidades getManejadorEntidades() {
        return this.manejadorEntidades;
    }

    public void setManejadorEntidades(ManejadorEntidades manejadorEntidades) {
        this.manejadorEntidades = manejadorEntidades;
    }
}
