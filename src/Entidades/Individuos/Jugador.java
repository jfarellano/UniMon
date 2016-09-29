package Entidades.Individuos;

import Entidades.Ataque;
import Entidades.Entidad;
import Estados.State;
import gfx.Animacion;
import gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import pokemonj.Manejador;

public class Jugador extends Individuo {

    private final BufferedImage[] quieto;
    private final Animacion animDw;
    private final Animacion animUp;
    private final Animacion animIzq;
    private final Animacion animDer;
    private Random r = new Random();;
    public int last;
    public int ultimo;
    public int atack = 30;
    public int[] ataquesActivos = new int[3], ataquesLista = new int[10];

    public Jugador(Manejador handler, float x, float y) {
        super(handler, x, y, 32, 32);
        this.limites.x = 10;
        this.limites.y = 0;
        this.limites.width = 13;
        this.limites.height = 30;
        this.ultimo = 3;
        this.quieto = new BufferedImage[4];
        this.quieto[0] = Assets.Turpial_Der[0];
        this.quieto[1] = Assets.Turpial_Izq[0];
        this.quieto[2] = Assets.Turpial_Up[0];
        this.quieto[3] = Assets.Turpial_Dw[0];
        this.animDw = new Animacion(200, Assets.Turpial_Dw);
        this.animDer = new Animacion(200, Assets.Turpial_Der);
        this.animIzq = new Animacion(200, Assets.Turpial_Izq);
        this.animUp = new Animacion(200, Assets.Turpial_Up);
    }
    
    public void ataquesAleatorios(){
        for(int i = 0; i < 3; i++){
            int j = r.nextInt(11);
            ataquesActivos[i] = j;
            ataquesLista[i] = ataquesActivos[i];
        }
        for(int i = 3; i < 10; i++){
            ataquesLista[i] = 99;
        }
    }
    
    public boolean cantAtaq(int a, int index){
        int total = 0;
        for(int i = 0; i < 3; i++){
            if(i != index) total += handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(ataquesActivos[i]).magnitud;
            else total += handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(a).magnitud;
        }
        if(total <= 120) return true;
        return false;
    }
    
    public void replaceAtaque(int a, int index){
        ataquesLista[index] = a;
    }
    
    public void replaceAtaqueActivo(int a, int index){
        ataquesActivos[index] = a;
    }
    
    public void addAtaque(int a){
        boolean sw = true;
        int i = 0;
        while(sw){
            if(ataquesLista[i] == 99){
                ataquesLista[i] = a;
                ultimo = i++;
                sw = false;
            }else i++;
        }
    }

    private void getInput() {
        this.xMov = 0.0f;
        this.yMov = 0.0f;
        if (this.handler.getGame().getManejador().up) {
            this.yMov = -this.velocidad;
        }
        if (this.handler.getGame().getManejador().down) {
            this.yMov = this.velocidad;
        }
        if (this.handler.getGame().getManejador().left) {
            this.xMov = -this.velocidad;
        }
        if (this.handler.getGame().getManejador().rigth) {
            this.xMov = this.velocidad;
        }
    }
    
    public void loadGame(){
        String s = Utilidad.Utilidad.loadFileAsString("res/Save/Inventario.txt");
        String[] atq = s.split("\\s+");
        for(int i = 0; i < 10; i++){
                ataquesLista[i] = Utilidad.Utilidad.parseInt(atq[i]);
        }
        s = Utilidad.Utilidad.loadFileAsString("res/Save/Activos.txt");
        atq = s.split("\\s+");
        for(int i = 0; i < 3; i++){
            ataquesActivos[i] = Utilidad.Utilidad.parseInt(atq[i]);
        }
        s = Utilidad.Utilidad.loadFileAsString("res/Save/Player.txt");
        atq = s.split("\\s+");
        vida = Utilidad.Utilidad.parseFloat(atq[0]);
        x = Utilidad.Utilidad.parseFloat(atq[1]);
        y = Utilidad.Utilidad.parseFloat(atq[2]);
    }

    @Override
    public void tick() {
        this.animDer.tick();
        this.animDw.tick();
        this.animIzq.tick();
        this.animUp.tick();
        this.getInput();
        this.move();
        this.handler.getGame().getCamaraJuego().centrar((Entidad) this);
    }

    @Override
    public void render(Graphics g) {
        if(State.getState() != handler.getGame().getGameState()){
            g.drawImage(Assets.Turpial_Der[0], 2 * 32, 7 * 32, 32 * 5, 32* 5, null);
        }else
        g.drawImage(this.conseguirCuadro(), (int) (this.x - this.handler.getCamaraJuego().getxDesfase()), (int) (this.y - this.handler.getCamaraJuego().getyDesfase()), this.width, this.height, null);
    }

    private BufferedImage conseguirCuadro() {
        if (this.handler.getGame().getManejador().rigth) {
            this.last = 0;
            return this.animDer.getFrame();
        }
        if (this.handler.getGame().getManejador().left) {
            this.last = 1;
            return this.animIzq.getFrame();
        }
        if (this.handler.getGame().getManejador().up) {
            this.last = 2;
            return this.animUp.getFrame();
        }
        if (this.handler.getGame().getManejador().down) {
            this.last = 3;
            return this.animDw.getFrame();
        }
        return this.quieto[this.last];
    }

    @Override
    public float getVida() {
        return vida;
    }

    @Override
    public void setVida(float vida) {
        this.vida = vida;
    }
}
