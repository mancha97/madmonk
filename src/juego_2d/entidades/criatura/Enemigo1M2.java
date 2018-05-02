/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.criatura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import juego_2d.Manejador;
import juego_2d.utils.Damage2;
import juego_2d.utils.Utils;
import juegos_2d.graficos.Animacion;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author lito-
 */
public class Enemigo1M2 extends Enemigo{
    
    public static float vidaActual12;
    private float vidaMaxima;
    private Animacion animDown,animUp, animLeft, animRight;
    private int bandera, c;
    private Runnable hi = new Damage2();
    public static boolean posicion1;
    private int posX, posY;
    public  static int xJugador, yJugador, xEnemigo12, yEnemigo12;
    private static Rectangle rectanguloE1M2;
    private float rango = 500;
    private double distancia;
    private boolean mood = true;
    public static int orillasx12, orillasy12, orillaswidth12, orillasheight12;
    private int contadorDamage=0;

    
    public Enemigo1M2(Manejador manejador, float x, float y, Jugador jugador1) {
        super(manejador, x, y, jugador1);
        
        this.speed = 1.2f;
        
        orillas.x = 5;
        orillas.y = 5;
        orillas.width = 22;
        orillas.height = 22;
        rectanguloE1M2 = orillas;
        orillaswidth12 = orillas.width;
        orillasheight12 = orillas.height;
        
        vidaMaxima = Criatura.DEFAULT_HEALTH_ENEMIGO;
        vidaActual12 = vidaMaxima;
        
        
        //Animaciones
        animDown = new Animacion(500, Efectos.monster2_abajo);
        animLeft = new Animacion(500, Efectos.monster2_izq);
        animUp = new Animacion(500, Efectos.monster2_arriba);
        animRight = new Animacion(500, Efectos.monster2_der);
        
        posicion1 = true;
        
    }
    
    private void DibujarVida(Graphics g, int x, int y){
        g.setColor(Color.red);
        g.fillRect(x +5, y - 5 , (int) (vidaActual12), 2);
       // System.out.println(vidaActual);
    }
    
    @Override
    public void tick(){
        animDown.tick();
        animRight.tick();
        animUp.tick();
        animLeft.tick();
        
        if(!RangodePersecusion()){
            PerseguirJugador();
            
        }
        if(contadorDamage >= 60){
            new Thread(hi).start();
            contadorDamage = 0;
        }else{
            contadorDamage++;
        }
        
        
    }
    
     @Override
    public void render(Graphics g) {
        if(vidaActual12>0){
            g.drawImage(getCurrentAnimationFrame(), (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()), width, height, null);
            DibujarVida(g, (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()));
            DibujarDistancia(g, (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()));
        }else{
            if(posicion1){
                posX = (int) (x);
                posY = (int) (y);
                posicion1 = false;
            }
            g.drawImage(Efectos.larry,(int) (posX  - manejador.getCamara().getxOffset()), (int)(posY  - manejador.getCamara().getyOffset()), width-5, height-5, null);
            orillas.x = 0;
            orillas.y = 10;
            orillas.width = 38;
            orillas.height = 28;
        }
    }
    
    private void DibujarDistancia(Graphics g, int x, int y){

        xJugador = (int) (jugador1.getX() - manejador.getCamara().getxOffset());
        yJugador = (int) (jugador1.getY() - manejador.getCamara().getyOffset());
        xEnemigo12 =  x;
        yEnemigo12 =  y;
        distancia = Utils.CalcularDistancia(xJugador, yJugador, xEnemigo12, yEnemigo12);
        
        g.drawString(String.format("%.2f", distancia), x + 5, y - 8);

    }
    
    private boolean RangodePersecusion(){
        if(distancia < rango){
            mood = false;
        }else{
            mood = true;
        }
        return mood;
    }
    
    private void PerseguirJugador(){
            
        xMove = 0;
        yMove = 0;
        
        if(xJugador > xEnemigo12 && yJugador < yEnemigo12){ //diagonal derecha superior
            xMove = speed;
            yMove = -speed;
        }else if(xJugador < xEnemigo12 && yJugador < yEnemigo12){ //diagonal izquierda superior
            xMove = -speed;
            yMove = -speed;
        }else if(xJugador < xEnemigo12 && yJugador == yEnemigo12){ //izquierda 
            xMove = -speed;
        }else if(xJugador == xEnemigo12 && yJugador < yEnemigo12){ //arriba
            yMove = -speed;
        }else if(xJugador > xEnemigo12 && yJugador == yEnemigo12){ //derecha 
            xMove = speed;
        }else if(xJugador == xEnemigo12 && yJugador > yEnemigo12){ //abajo
            yMove = speed;
        }else if(xJugador > xEnemigo12 && yJugador > yEnemigo12){ //diagonal derecha inferior
            xMove = speed;
            yMove = speed;
        }else if(xJugador < xEnemigo12 && yJugador > yEnemigo12){ //diagonal izquierda inferior
            xMove = -speed;
            yMove = speed;
        }
        
        move();
        
    }

    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            bandera = 1;
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            bandera = 2;
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            bandera = 3;
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            bandera = 0;
            return animDown.getCurrentFrame();
        }else{
            if(bandera == 3)
                return animUp.getEstatic();
            if(bandera == 2)
                return animRight.getEstatic();
            if(bandera == 1)
                return animLeft.getEstatic();
            if(bandera == 0){
                if(c==0){
                    c++;
                }
                return animDown.getEstatic();
            }else{
                return animDown.getEstatic();
            }
        }
    }
      
}
