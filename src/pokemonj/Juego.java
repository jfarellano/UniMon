package pokemonj;

import Estados.GameState;
import Estados.MainMenu;
import Estados.State;
import Input.ManejadorMouse;
import Input.ManejadorTeclas;
import gfx.Assets;
import gfx.CamaraJuego;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Juego implements Runnable {

    private Pantalla ventana;
    public int width;
    public int height;
    public String title;
    private boolean running = false;
    private Thread hilo;
    private BufferStrategy bs;
    private Graphics g;
    private State gameState;
    private State mainMenu;
    private State pause;
    private final ManejadorTeclas manejador;
    private final ManejadorMouse manejadorMouse;
    private CamaraJuego camara;
    private Manejador handler;

    private void init() {
        this.ventana = new Pantalla(this.title, this.width, this.height);
        Assets.init();
        this.handler = new Manejador(this);
        this.camara = new CamaraJuego(this.handler, 0.0F, 0.0F);
        this.ventana.getVentana().addKeyListener(this.manejador);
        this.ventana.getVentana().addMouseListener(this.manejadorMouse);
        this.ventana.getVentana().addMouseMotionListener(this.manejadorMouse);
        this.ventana.getLienzo().addMouseListener(this.manejadorMouse);
        this.ventana.getLienzo().addMouseMotionListener(this.manejadorMouse);

        this.gameState = new GameState(this.handler);
        this.mainMenu = new MainMenu(this.handler, "/Texturas/Fondo.png");
        State.setState(this.mainMenu);
    }

    public Juego(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.manejador = new ManejadorTeclas();
        this.manejadorMouse = new ManejadorMouse();
    }

    @Override
    public void run() {
        init();

        int fps = 30;
        double tiempoTick = 1000000000 / fps;
        double delta = 0.0D;

        long lastTime = System.nanoTime();
        long timer = 0L;
        int ticks = 0;
        while (this.running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / tiempoTick;
            timer += now - lastTime;
            lastTime = now;
            if (delta >= 1.0D) {
                tick();
                render();
                ticks++;
                delta -= 1.0D;
            }
            if (timer >= 1000000000L) {
                System.out.println("Ticks:" + ticks);
                ticks = 0;
                timer = 0L;
            }
        }
        stop();
    }

    private void tick() {
        this.manejador.tick();
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        this.bs = this.ventana.getLienzo().getBufferStrategy();
        if (this.bs == null) {
            this.ventana.getLienzo().createBufferStrategy(3);
            return;
        }
        this.g = this.bs.getDrawGraphics();

        this.g.clearRect(0, 0, this.width, this.height);
        if (State.getState() != null) {
            State.getState().render(this.g);
        }
        this.bs.show();
        this.g.dispose();
    }

    public synchronized void start() {
        if (this.running) {
            return;
        }
        this.running = true;
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    public synchronized void stop() {
        if (!this.running) {
            return;
        }
        this.running = false;
        try {
            this.hilo.join();
        } catch (InterruptedException localInterruptedException) {
        }
    }

    public ManejadorTeclas getManejador() {
        return this.manejador;
    }

    public ManejadorMouse getManejadorMouse() {
        return this.manejadorMouse;
    }

    public CamaraJuego getCamaraJuego() {
        return this.camara;
    }

    public State getGameState() {
        return this.gameState;
    }

    public State getMainMenu() {
        return this.mainMenu;
    }

    public State getPause() {
        return this.pause;
    }
}
