package Entidades.EntidadEstatica;

import Entidades.Entidad;
import Utilidad.Utilidad;
import java.awt.Graphics;
import java.util.ArrayList;

public class ManejadorMones {

    private ArrayList<Mon> mones;
    private String[][] archivoMones;
    private int cantMon;
    
    public void addMones(Mon m){
        mones.add(m);
    }
    
    public void cargarArchivoMones(){
        String file = Utilidad.loadFileAsString("res/Mon/monBase.txt");
        String[] separados = file.split("\\s+");
        System.out.println(separados[0]+ " " +separados[1]);
        cantMon = Utilidad.parseInt(separados[0]);
        int j = 1;
        System.out.println(cantMon);
        /*
        for(int i = 0; i < cantMon; i++){
            j=0;
            archivoMones[i][j] = separados[i + j * 4 + 1];
            j++;
            archivoMones[i][j] = separados[i + j * 4 + 1];
            j++;
            archivoMones[i][j] = separados[i + j * 4 + 1];
            j++;
            archivoMones[i][j] = separados[i + j * 4 + 1];
        }
        */
        archivoMones[0][0] = separados[j];
        j++;
        archivoMones[0][1] = separados[j];
        j++;
        archivoMones[0][2] = separados[j];
        j++;
        archivoMones[0][3] = separados[j];
        j++;
    }
    
    public void render(Graphics g){
        System.out.println(archivoMones[0][0] + archivoMones[0][1] + archivoMones[0][2] + archivoMones[0][3]);
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