package pokemonj.UI;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import pokemonj.Manejador;

public class UIMananger {
    
    private Manejador handler;
    private ArrayList<UIObject> objects;

    public UIMananger(Manejador handler) {
        this.handler = handler;
        this.objects = new ArrayList<UIObject>();
    }

    
    public void tick(){
        for(UIObject o : objects){
            o.tick();
        }
    }
    
    public void render(Graphics g){
        for(UIObject o : objects){
            o.render(g);
        }
    }
    
    public void onMouseMove(MouseEvent e){
        for(UIObject o : objects){
            o.onMouseMove(e);
        }
    }
    
    public void onMouseRelease(MouseEvent e){
        for(UIObject o : objects){
            o.OnMouseRelease(e);
        }
    }
    
    
    //GET SET
    public void addObject(UIObject o){
        objects.add(o);
    }
    
    public void removeObject(UIObject o){
        objects.remove(o);
    }

    public Manejador getHandler() {
        return handler;
    }

    public void setHandler(Manejador handler) {
        this.handler = handler;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }

    
}