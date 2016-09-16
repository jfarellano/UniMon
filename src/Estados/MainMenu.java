package Estados;

import gfx.Assets;
import gfx.CargarImgs;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class MainMenu extends State {
    
    private UIMananger uiMananger;

    private final BufferedImage fondo;
    private String ruta;

    public MainMenu(Manejador handler, String ruta) {
        super(handler);
        uiMananger = new UIMananger(handler);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        this.fondo = CargarImgs.cargarImagen((String) ruta);
        
        uiMananger.addObject(new Button(200, 200, 64, 32, Assets.Button, new ClickListener(){
            @Override
            public void onClick() {
                handler.getManejadorMouse().setUIMananger(null);
                State.setState(handler.getGame().getGameState());
            }
        }));
    }

    @Override
    public void tick() {
        if (handler.getManejadorTeclas().space) {
            State.setState(handler.getGame().getGameState());
        }
        uiMananger.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(this.fondo, 0, 0, null);
        uiMananger.render(g);
    }
}
//Ojo aca esta como se implementa un boton en cualquier estado.