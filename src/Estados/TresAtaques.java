package Estados;

import Entidades.Ataque;
import Entidades.Entidad;
import Entidades.EntidadEstatica.Mon;
import Entidades.Individuos.Jugador;
import gfx.Assets;
import gfx.CargarImgs;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class TresAtaques extends State{
    
    private UIMananger uiMananger;
    private int estado;
    private Entidad e;
    private int index;
    private int[] numero;
    private BufferedImage fondo;

    public TresAtaques(Manejador handler, int estado, Entidad e) {
        super(handler);
        this.fondo = CargarImgs.cargarImagen("/Texturas/TresAtq.png");
        uiMananger = new UIMananger(handler);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        this.index = 0;
        this.numero = new int[3];
        if(estado == 1){
            for (int i = 0; i < 3 ; i++){
                index = i;
                uiMananger.addObject(new Button(7 * 32, i * 42 + 190, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Mon)e).ataques[i]).nombre + ": "+ handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Mon)e).ataques[i]).magnitud, i,new ClickListener(){
                    int y = index;
                    @Override
                    public void onClick() {
                        Ataque a = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Mon)e).ataques[y]);
                        State.setState(new Inventario(handler, estado, a, y));
                    }
                }));
            }
        }else{
            for (int i = 0; i < 3 ; i++){
                index = i;
                uiMananger.addObject(new Button(7 * 32, i * 42 + 190, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Jugador)e).ataquesActivos[i]).nombre + ": "+ handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Jugador)e).ataquesActivos[i]).magnitud, 0,new ClickListener(){
                    int y = index;
                    @Override
                    public void onClick() {
                        Ataque a = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(((Jugador)e).ataquesActivos[y]);
                        State.setState(new Inventario(handler, estado, null, y));
                    }
                }));
            }
        }
        uiMananger.addObject(new Button(7 * 32, 5 * 42 + 190, 160, 32, Assets.Button, "Salir", 0,new ClickListener(){
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
        g.drawImage(fondo, 0, 0, 620, 480, null);
        uiMananger.render(g);
    }

}