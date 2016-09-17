package Estados;

import gfx.Assets;
import java.awt.Graphics;
import javax.swing.UIManager;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class GameOver extends State{
    
    private UIMananger uiMananger;

    public GameOver(Manejador handler) {
        super(handler);
        uiMananger = new UIMananger(handler);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        uiMananger.addObject(new Button(8 * 32 + 170, 11 * 32 + 20, 160, 32, Assets.Button, new ClickListener(){
            @Override
            public void onClick() {
                System.exit(0);
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