package Entidades.EntidadEstatica;

import Entidades.Ataque;
import Estados.State;
import gfx.Assets;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import pokemonj.Manejador;

public class Mon extends Estatica {
    
    public int vida, id;
    public String nombre;
    public BufferedImage text, image;
    public int[] ataques = new int[3];

    public Mon(int id, int vida, String nombre, BufferedImage text, Manejador handler, float x, float y, int a, int b, int c) {
        super(handler, x, y, 32, 32);
        this.ataques[0] = a;
        this.ataques[1] = b;
        this.ataques[2] = c;
        this.vida = vida;
        this.id = id;
        this.nombre = nombre;
        this.text = text;
        this.limites.x = 0;
        this.limites.y = 0;
        this.limites.width = 32;
        this.limites.height = 32;
        this.image = Assets.Blank;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        if(State.getState() != handler.getGame().getGameState()){
            g.drawImage(image, 12 * 32, 3 * 32, 32 * 5, 32* 5, null);
        }else g.drawImage(image, (int)(this.x - this.handler.getCamaraJuego().getxDesfase()), (int)(this.y - this.handler.getCamaraJuego().getyDesfase()), this.width, this.height, null);
    }
    
    public Ataque ataq(){
        Random r = new Random();
        int cual = r.nextInt(100) +1;
        if(cual <= 60){
            return handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(ataques[0]);
        }
        if(cual <= 90){
            return handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(ataques[1]);
        }
        if(cual <= 100){
            return handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(ataques[2]);
        }
        return new Ataque(1,2,"Hola");
    }

    public Manejador getHandler() {
        return handler;
    }

    public BufferedImage getText() {
        return text;
    }
    
    
}