package Estados;

import Entidades.Ataque;
import Entidades.Entidad;
import gfx.Assets;
import java.awt.Graphics;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class Inventario extends State {

    private final UIMananger uiMananger;
    private final int estado;
    private final Ataque a;
    private int index;
    private int index2 = 0;

    public Inventario(Manejador handler, int estado, Ataque a,int index) {
        super(handler);
        this.estado = estado;
        this.a = a;
        this.index = index;
        uiMananger = new UIMananger(handler);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        for (int i = 0; i < handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista.length; i++) {
            index2 = i;
            if (handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[i] != 99) {
                uiMananger.addObject(new Button(7 * 32, i * 32 + 10, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[i]).nombre + ": " + handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[i]).magnitud, i,new ClickListener() {
                    int y = index2;
                    @Override
                    public void onClick() {
                        if(estado == 0){
                            int m = handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[y];
                            int n = index2;
                            handler.getMundo().getManejadorEntidades().getPlayer().replaceAtaqueActivo(m, index);
                            State.setState(new TresAtaques(handler, 0, handler.getMundo().getManejadorEntidades().getPlayer()));
                        }else{
                            int m = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.indexOf(a);
                            handler.getMundo().getManejadorEntidades().getPlayer().replaceAtaque(m, y);
                            State.setState(handler.getGame().getGameState());
                        }
                    }
                }));
            } else if (estado == 1 && i == 9) {
                uiMananger.addObject(new Button(7 * 32, i * 32 + 10, 160, 32, Assets.Button, "Agregar ataque ", 0,new ClickListener() {
                    @Override
                    public void onClick() {
                        int m = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.indexOf(a);
                        handler.getMundo().getManejadorEntidades().getPlayer().addAtaque(m);
                        State.setState(handler.getGame().getGameState());
                    }
                }));
            }
        }
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
