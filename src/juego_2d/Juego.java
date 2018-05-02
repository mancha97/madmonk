
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d;

import juego_2d.estado.*;
import juegos_2d.graficos.Efectos;
import juegos_2d.graficos.Imagenes;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import juego_2d.input.ControlMouse;
import juego_2d.input.ControlTeclado;
import juego_2d.ventana.Ventana;
import juegos_2d.graficos.Camara;

/**
 *
 * @author Marcelo
 */
public class Juego implements Runnable {

    private Ventana ventana;
    private boolean ejecutando = false;
    public String titulo;
    private int ancho, alto;
    private Thread hilo;
    private BufferedImage testimage;
    
    private BufferStrategy bs;
    private Graphics g;
    
    //estados
    public estado estadoJuego; //siempre se declaran como estados
    public estado estadoMenu;
    public estado estadoHowTo;
    public estado estadoLoading;
    public estado estadoJuego2;
    public estado estadoJuego3;
    public estado estadoInicio;
    public estado estadoWIN;
    public estado estadoGO;
    public estado estadoChamp;
    public static int FPSS;
    
    public int banderita;
    
    //teclado
    private ControlTeclado teclado;
    private ControlMouse mouse;
    
    //camara
    private Camara camara;
    
    //Manejador
    private Manejador manejador;

    public Juego(String titulo, int ancho, int alto) {
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;
        teclado = new ControlTeclado();
        mouse = new ControlMouse();
    }

    private void init() {
        ventana = new Ventana(titulo, ancho, alto);
        ventana.getFrame().addKeyListener(teclado);
        ventana.getFrame().addMouseListener(mouse);
        ventana.getFrame().addMouseMotionListener(mouse);
        ventana.getCanva().addMouseListener(mouse);
        ventana.getCanva().addMouseMotionListener(mouse);
        Efectos.init();
        
        manejador = new Manejador(this);
        camara = new Camara(manejador,0,0); 
        
        
        estadoJuego = new EstadoJuego(manejador); //pero se pueden inicializar como cualquier tipo de estado
        estadoMenu = new EstadoMenu(manejador);
        estadoHowTo = new EstadoHowTo(manejador);
        estadoLoading = new EstadoLoading(manejador);
        estadoJuego2 = new EstadoJuego2(manejador);
        estadoJuego3 = new EstadoJuego3(manejador);
        estadoInicio = new EstadoInicio(manejador);
        estadoWIN = new EstadoWIN(manejador);
        estadoGO = new EstadoGO(manejador);
        estadoChamp = new EstadoChamp(manejador);
        estado.setEstado(estadoInicio);
    }
    

    private void actualizar() {
        teclado.tick();//no se puede mover de esta linea
        
        if(estado.getEstado() != null)
            estado.getEstado().actualizar();
       
    }

    private void renderizar() {     //dibujar en pantalla
        bs = ventana.getCanva().getBufferStrategy();
        if (bs == null) {
            ventana.getCanva().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //limpiando pantalla
        g.clearRect(0, 0, 1200, 700);
        //Inicio de dibujo
        
        if(estado.getEstado() != null){
            estado.getEstado().renderizar(g);
        }
        
        //Final de dibujo
        bs.show();
        g.dispose();
    }

    public void run() {
        
        init();
        
        int fps = 60;
        double timePerTick = 1000000000 / fps; //cuantas veces se va a hacer el metodo actualizar y renderizar por segundo
        double delta = 0;
        long instant;
        long ultimoTiempo = System.nanoTime();
        long tiempo = 0;
        int ticks = 0;
        
        
        while (ejecutando) {
            instant = System.nanoTime();
            delta += (instant - ultimoTiempo) /timePerTick;
            tiempo += instant - ultimoTiempo;
            ultimoTiempo = instant;
            
            if(delta >= 1){
                actualizar();
                renderizar();
                ticks++;
                delta--;
            }
            
            if(tiempo >= 1000000000){
                FPSS = ticks;
                //System.out.println("FPS: " + ticks);
                ticks = 0;
                tiempo =0;
            }
        }
        detener();
    }
    //GETTERS
    
    public Camara getCamara(){
        return camara;
    }
    
    public ControlTeclado getTeclado(){
        return teclado;
    }
    
    public ControlMouse getMouse(){
        return mouse;
    }
    
    public int getWidth(){
        return ancho;
    }
    
    public int getHeight(){
        return alto;
    }
    //GETTERS
    public synchronized void iniciar() {
        if (ejecutando) {
            return;
        }
        ejecutando = true;
        hilo = new Thread(this);
        hilo.start();
    }

    public synchronized void detener() {
        if (!ejecutando) {
            return;
        }
        ejecutando = false;
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            System.out.println("Conexión interrumpida.");
            //Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
