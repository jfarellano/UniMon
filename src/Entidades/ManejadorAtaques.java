package Entidades;

import Utilidad.Utilidad;
import java.util.ArrayList;

public class ManejadorAtaques {
    
    public ArrayList<Ataque> Ataques;
    protected int CantAtaq;
    
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
    }

}