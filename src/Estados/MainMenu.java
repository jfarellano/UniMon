package Estados;

import gfx.CargarImgs;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import pokemonj.Manejador;

public class MainMenu extends State {
    

    private final BufferedImage fondo;
    private String ruta;

    public MainMenu(Manejador handler, String ruta) {
        super(handler);
        this.fondo = CargarImgs.cargarImagen((String) ruta);
    }

    @Override
    public void tick() {
        if (handler.getManejadorTeclas().space) {
            State.setState(handler.getGame().getGameState());
        }
    }
    
    @Override
    public void render(Graphics g) {
        g.drawImage(this.fondo, 0, 0, null);
    }
}