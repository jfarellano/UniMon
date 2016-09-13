package Entidades.EntidadEstatica;

import Entidades.Entidad;
import pokemonj.Manejador;

public abstract class Estatica
extends Entidad {
    public Estatica(Manejador handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }
}