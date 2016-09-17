package Estados;

import Entidades.EntidadEstatica.Mon;
import Entidades.Individuos.Jugador;
import gfx.Assets;
import java.awt.Graphics;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class Battle extends State{
    
    private Mon m;
    private Jugador player;
    private UIMananger uiMananger;

    public Battle(Manejador handler, Mon m, Jugador player) {
        super(handler);
        this.m = m;
        this.player = player;
        this.uiMananger = new UIMananger(handler);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        uiMananger.addObject(new Button(8 * 32, 10 * 32, 160, 32, Assets.Button, new ClickListener(){
            @Override
            public void onClick() {
                player.vida -= m.atack;
                if(player.vida <= 0){
                    //State.setState(new GameOver(handler));
                }
                System.out.println("Vida Player:"+player.vida);
                m.vida -= player.atack;
                System.out.println("Vida mon:"+m.vida);
                if(m.vida <= 0){
                    handler.getMundo().getManejadorEntidades().delMones(m);
                    State.setState(handler.getGame().getGameState());
                }
            }
        }));
        uiMananger.addObject(new Button(8 * 32 + 170, 10 * 32, 160, 32, Assets.Button, new ClickListener(){
            @Override
            public void onClick() {
                handler.getManejadorMouse().setUIMananger(null);
                State.setState(handler.getGame().getGameState());
            }
        }));
        uiMananger.addObject(new Button(8 * 32, 11 * 32 + 20, 160, 32, Assets.Button, new ClickListener(){
            @Override
            public void onClick() {
                handler.getManejadorMouse().setUIMananger(null);
                State.setState(handler.getGame().getGameState());
            }
        }));
        uiMananger.addObject(new Button(8 * 32 + 170, 11 * 32 + 20, 160, 32, Assets.Button, new ClickListener(){
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
    }

    @Override
    public void render(Graphics g) {
        m.render(g);
        player.render(g);
        uiMananger.render(g);
    }
    
}