package Entidades.EntidadEstatica;

import Entidades.Entidad;
import Utilidad.Utilidad;
import gfx.Assets;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class ManejadorMones {

    private ArrayList<Mon> mones;
    private String[][] archivoMones;
    private int cantMon;
    
    public void addMones(Mon m){
        mones.add(m);
    }
    
    public void cargarArchivoMones(){
        mones = new ArrayList<>();
        String file = Utilidad.loadFileAsString("res/Mon/monBase.txt");
        String[] separados = file.split("\\s+");
        cantMon = Utilidad.parseInt(separados[0]);
        archivoMones = new String[cantMon][4];
        int pos = 1;
        for(int i = 0; i < cantMon; i++){
            for(int j = 0; j < 4; j++){
                archivoMones[i][j] = separados[pos];
                pos++;
            }
        }
    }
    
    public void render(Graphics g){
        for (Mon m : mones) {
            g.drawImage(m.text, (int)(m.getX() - m.getHandler().getCamaraJuego().getxDesfase()), (int)(m.getY() - m.getHandler().getCamaraJuego().getyDesfase()), m.getWidth(), m.getHeight(), null);
        }
    }

    public String[][] getArchivoMones() {
        return archivoMones;
    }

    public int getCantMon() {
        return cantMon;
    }

    public ArrayList<Mon> getMones() {
        return mones;
    }
}