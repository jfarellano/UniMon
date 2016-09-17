package Estados;

import Entidades.Ataque;
import Entidades.EntidadEstatica.Mon;
import Entidades.Individuos.Jugador;
import gfx.Assets;
import java.awt.Graphics;
import java.util.Random;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class Battle extends State{
    
    private Mon m;
    private Jugador player;
    private UIMananger uiMananger;
    private Random rand;
    private int turno;
    private Ataque qtAtackPlayer;

    public Battle(Manejador handler, Mon m, Jugador player) {
        super(handler);
        rand = new Random();
        this.m = m;
        this.player = player;
        this.uiMananger = new UIMananger(handler);
        this.turno = rand.nextInt(2);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        uiMananger.addObject(new Button(8 * 32, 10 * 32, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[0]).nombre, new ClickListener(){
            @Override
            public void onClick() {
                qtAtackPlayer = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[0]);
            }
        }));
        uiMananger.addObject(new Button(8 * 32 + 170, 10 * 32, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[1]).nombre, new ClickListener(){
            @Override
            public void onClick() {
                qtAtackPlayer = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[1]);
            }
        }));
        uiMananger.addObject(new Button(8 * 32, 11 * 32 + 20, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[2]).nombre, new ClickListener(){
            @Override
            public void onClick() {
                qtAtackPlayer = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(player.ataquesActivos[2]);
            }
        }));
        uiMananger.addObject(new Button(8 * 32 + 170, 11 * 32 + 20, 160, 32, Assets.Button, "Huir", new ClickListener(){
            @Override
            public void onClick() {
                handler.getManejadorMouse().setUIMananger(null);
                State.setState(handler.getGame().getGameState());
            }
        }));
    }
    
    @Override
    public void tick() {
        uiMananger.tick();
        if(turno == 0){
            Ataque a = m.ataq();
            player.setVida((float)player.getVida() - a.magnitud);
            System.out.println(m.nombre + " ataca con:" + a.nombre);
            if(player.getVida() <= 0){
                State.setState(new GameOver(handler));
            }
            turno = 1;
            System.out.println("Vida Player:"+player.getVida());
        }else{
            if(qtAtackPlayer != null){
                m.vida -= qtAtackPlayer.magnitud;
                System.out.println("Turpial ataca con:" + qtAtackPlayer.nombre);
                System.out.println("Vida mon:"+m.vida);
                qtAtackPlayer = null;
                turno = 0;
                if(m.vida <= 0){
                    handler.getMundo().getManejadorEntidades().delMones(m);
                    State.setState(handler.getGame().getGameState());
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        m.render(g);
        player.render(g);
        uiMananger.render(g);
    }
    
}