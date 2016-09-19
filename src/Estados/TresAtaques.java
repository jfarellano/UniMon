package Estados;

import gfx.Assets;
import java.awt.Graphics;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class TresAtaques extends State{
    
    private UIMananger uiMananger;

    public TresAtaques(Manejador handler) {
        super(handler);
        uiMananger = new UIMananger(handler);
        
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
        
    }

    @Override
    public void render(Graphics g) {
        uiMananger.render(g);
    }

}