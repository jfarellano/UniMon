package Estados;

import Entidades.Ataque;
import Entidades.Entidad;
import gfx.Assets;
import gfx.CargarImgs;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import pokemonj.Manejador;
import pokemonj.UI.Button;
import pokemonj.UI.ClickListener;
import pokemonj.UI.UIMananger;

public class Inventario extends State {

    private final UIMananger uiMananger;
    private final int estado;
    private final Ataque a;
    private final int index;
    private int index2 = 0;
    private BufferedImage fondo;

    public Inventario(Manejador handler, int estado, Ataque a,int index) {
        super(handler);
        this.estado = estado;
        this.a = a;
        this.index = index;
        this.fondo = CargarImgs.cargarImagen("/Texturas/inventario.png");
        uiMananger = new UIMananger(handler);
        handler.getManejadorMouse().setUIMananger(uiMananger);
        for (int i = 0; i < handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista.length; i++) {
            index2 = i;
            if (handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[i] != 99) {
                uiMananger.addObject(new Button(7 * 32, i * 34 + 50, 160, 32, Assets.Button, handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[i]).nombre + ": " + handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.get(handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[i]).magnitud, i,new ClickListener() {
                    int y = index2;
                    @Override
                    public void onClick() {
                        if(estado == 0){
                            int m = handler.getMundo().getManejadorEntidades().getPlayer().ataquesLista[y];
                            if(handler.getMundo().getManejadorEntidades().getPlayer().cantAtaq(m, index)) handler.getMundo().getManejadorEntidades().getPlayer().replaceAtaqueActivo(m, index);
                            else JOptionPane.showMessageDialog(null, "Supero el limite de daño (120)");
                            State.setState(new TresAtaques(handler, 0, handler.getMundo().getManejadorEntidades().getPlayer()));
                        }else{
                            int m = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.indexOf(a);
                            a.cap = true;
                            handler.getMundo().getManejadorEntidades().getPlayer().replaceAtaque(m, y);
                            State.setState(handler.getGame().getGameState());
                        }
                    }
                }));
            } else if (estado == 1 && i == 9) {
                uiMananger.addObject(new Button(7 * 32, i * 34 + 10, 160, 32, Assets.Button, "Agregar ataque ", 0,new ClickListener() {
                    @Override
                    public void onClick() {
                        int m = handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques.indexOf(a);
                        a.cap = true;
                        int sw = 0;
                        for(Ataque c : handler.getMundo().getManejadorEntidades().getManejadorAtaques().Ataques){
                            if(!c.cap) sw = 1;
                        }
                        if(sw == 0) JOptionPane.showMessageDialog(null, "Ganaste lograste capturar por lo menos una vez todos los ataques");
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
        g.drawImage(fondo, 0, 0, 640, 480, null);
        uiMananger.render(g);
    }

}
