package Estados;

import Entidades.Ataque;
import Entidades.EntidadEstatica.Mon;
import Entidades.Individuos.Jugador;
import gfx.Assets;
import gfx.CargarImgs;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.TextLable;
import pokemonj.UI.UIMananger;

public class Battle extends State{
    
    private Mon m;
    private Jugador player;
    private UIMananger uiMananger;
    private Random rand;
    private int turno;
    private Ataque qtAtackPlayer;
    private TextLable vidaT, vidaM, ataques;
    private BufferedImage fondo;

    public Battle(Manejador handler, Mon m, Jugador player) {
        super(handler);
        this.fondo = CargarImgs.cargarImagen("/Texturas/Batalla.png");
        rand = new Random();
        this.m = m;
        this.player = player;
        this.uiMananger = new UIMananger(handler);
        this.turno = rand.nextInt(2);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        uiMananger.addObject(new Button(8 * 32, 10 * 32, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[0]).nombre + ": " + handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[0]).magnitud + " Daño", 0,new ClickListener(){
            @Override
            public void onClick() {
                qtAtackPlayer = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[0]);
            }
        }));
        uiMananger.addObject(new Button(8 * 32 + 170, 10 * 32, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[1]).nombre + ": " + handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[1]).magnitud + " Daño", 0,new ClickListener(){
            @Override
            public void onClick() {
                qtAtackPlayer = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[1]);
            }
        }));
        uiMananger.addObject(new Button(8 * 32, 11 * 32 + 20, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[2]).nombre + ": " + handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[2]).magnitud + " Daño", 0,new ClickListener(){
            @Override
            public void onClick() {
                qtAtackPlayer = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[2]);
            }
        }));
        uiMananger.addObject(new Button(8 * 32 + 170, 11 * 32 + 20, 160, 32, Assets.Button, "Huir", 0,new ClickListener(){
            @Override
            public void onClick() {
                handler.getManejadorMouse().setUIMananger(null);
                handler.getMundo().getManejadorEntidades().delMones(m);
                State.setState(handler.getGame().getGameState());
            }
        }));
        vidaM = new TextLable(11, 1, m.nombre + ": " + m.vida + "/" + m.VIDA_BASE, 30);
        uiMananger.addObject(vidaM);
        vidaT = new TextLable(2, 13, handler.getMundo().getManejadorEntidades().getPlayer().getVida() + "/" + handler.getMundo().getManejadorEntidades().getPlayer().VIDA_BASE, 30);
        uiMananger.addObject(vidaT);
        ataques = new TextLable(1, 1, "", 15);
        uiMananger.addObject(ataques);
        
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void tick() {
        uiMananger.tick();
        vidaT.setTexto(handler.getMundo().getManejadorEntidades().getPlayer().getVida() + "/" + handler.getMundo().getManejadorEntidades().getPlayer().VIDA_BASE);
        vidaM.setTexto(m.nombre + ": " + m.vida + "/" + m.VIDA_BASE);
        if(turno == 0){
            Ataque a = m.ataq();
            float mag = a.magnitud;
            int tipoM = m.tipo;
            int tipoA = a.tipo;
            System.out.println("Tipo del mon:" + m.tipo + " potencia" + handler.getMundo().getManejadorEntidades().getManejadorAtaques().potencia[1]);
            if(handler.getMundo().getManejadorEntidades().getManejadorAtaques().potencia[tipoM] == tipoA){} mag = (float) (mag * 1.25);
            if(handler.getMundo().getManejadorEntidades().getManejadorAtaques().potencia[tipoA] == tipoM){} mag = (float) (mag * 0.6);
            player.setVida((float)player.getVida() - mag);
            ataques.setTexto(m.nombre + " ataca con:" + a.nombre + " -" + mag);
            if(player.getVida() <= 0){
                State.setState(new GameOver(handler));
            }
            turno = 1;
        }else{
            if(qtAtackPlayer != null){
                float mag = qtAtackPlayer.magnitud;
                if(handler.getMundo().getManejadorEntidades().getManejadorAtaques().potencia[(int)qtAtackPlayer.tipo] == m.tipo) mag = (float) (mag * 1.25);
                if(handler.getMundo().getManejadorEntidades().getManejadorAtaques().potencia[(int)m.tipo] == qtAtackPlayer.tipo) mag = (float) (mag * 0.6);
                m.vida -= mag;
                qtAtackPlayer = null;
                turno = 0;
                if(m.vida <= 0){
                    handler.getMundo().getManejadorEntidades().delMones(m);
                    State.setState(new TresAtaques(handler, 1, m));
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(fondo, 0, 0, 640, 480, null);
        m.render(g);
        player.render(g);
        uiMananger.render(g);
    }
    
}