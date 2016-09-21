package Entidades;

import Utilidad.Utilidad;
import java.util.ArrayList;

public class ManejadorAtaques {
    
    public ArrayList<Ataque> Ataques;
    protected int CantAtaq;
    public int[] potencia;

    public ManejadorAtaques() {
        this.potencia = new int[4];
        this.cargarAtaques();
    }
    
    
    public void cargarAtaques(){
        String file = Utilidad.loadFileAsString("res/Mon/atackBase.txt");
        String[] separados = file.split("\\s+");
        CantAtaq = Utilidad.parseInt(separados[0]);
        Ataques = new ArrayList<>(CantAtaq);
        int pos = 1;
        for(int i = 0; i < CantAtaq; i++){
            int mag = Utilidad.parseInt(separados[pos]);
            pos++;
            int tipo = Utilidad.parseInt(separados[pos]);
            pos++;
            String nam = separados[pos];
            pos++;
            Ataques.add(new Ataque(mag, tipo, nam));
        }
        potencia[0] = 0;
        potencia[1] = 3;
        potencia[2] = 1;
        potencia[3] = 2;
    }

    public int getCantAtaq() {
        return CantAtaq;
    }

    
}