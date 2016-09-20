package Estados;

import Entidades.Ataque;
import Entidades.Entidad;
import Entidades.EntidadEstatica.Mon;
import Entidades.Individuos.Jugador;
import gfx.Assets;
import java.awt.Graphics;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class TresAtaques extends State{
    
    private UIMananger uiMananger;
    private int estado;
    private Entidad e;
    private int index;

    public TresAtaques(Manejador handler, int estado, Entidad e) {
        super(handler);
        uiMananger = new UIMananger(handler);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        this.index = 0;
        if(estado == 1){
            for (int i = 0; i < 3 ; i++){
                index = i;
                uiMananger.addObject(new Button(7 * 32, i * 42 + 190, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Mon)e).ataques[i]).nombre + ": "+ handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Mon)e).ataques[i]).magnitud, new ClickListener(){
                    @Override
                    public void onClick() {
                        Ataque a = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Mon)e).ataques[index]);
                        State.setState(new Inventario(handler, estado, a));
                    }
                }));
            }
        }else{
            for (int i = 0; i < 3 ; i++){
                index = i;
                uiMananger.addObject(new Button(7 * 32, i * 42 + 190, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Jugador)e).ataquesActivos[i]).nombre + ": "+ handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Jugador)e).ataquesActivos[i]).magnitud, new ClickListener(){
                    @Override
                    public void onClick() {
                        Ataque a = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Jugador)e).ataquesLista[index]);
                        State.setState(new Inventario(handler, 0, a));
                    }
                }));
            }
        }
        uiMananger.addObject(new Button(7 * 32, 5 * 42 + 190, 160, 32, Assets.Button, "Salir", new ClickListener(){
            @Override
            public void onClick() {
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
        uiMananger.render(g);
    }

}