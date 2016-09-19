package Estados;

import gfx.Assets;
import java.awt.Graphics;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class Inventario extends State{

    private UIMananger uiMananger;

    public Inventario(Manejador handler) {
        super(handler);
        uiMananger = new UIMananger(handler);
        
        for(int i = 0; i < 10; i++){
            uiMananger.addObject(new Button(i * 32, 9 * 32, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[i]).nombre + ": "+ handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[i]).magnitud, new ClickListener(){
                @Override
                public void onClick() {
                    handler.getManejadorMouse().setUIMananger(null);
                    State.setState(handler.getGame().getGameState());
                }
            }));
        }
    }

    
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        uiMananger.render(g);
    }


}