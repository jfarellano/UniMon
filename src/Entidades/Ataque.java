package Entidades;

public class Ataque {
    public int magnitud;
    public int tipo;
    public String nombre;
    public boolean cap;

    public Ataque(int magnitud, int tipo, String nombre) {
        this.magnitud = magnitud;
        this.tipo = tipo;
        this.nombre = nombre;
        this.cap = false;
    }
}