/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.criatura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import juego_2d.Manejador;
import juego_2d.utils.Damage3;
import juego_2d.utils.Utils;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author lito-
 */
public class Boss extends Enemigo{
    
    public static float vidaActualB;
    private float vidaMaximaB;
    private Runnable hi;
    public static boolean posicionB;
    private int posX, posY;
    public  static int xJugador, yJugador, xEnemigoB, yEnemigoB;
    private float rango = 550;
    private double distancia;
    private boolean mood = true;
    public static int orillasxB, orillasyB, orillaswidthB, orillasheightB;
    
    private int contadorDamage;
    
    public Boss(Manejador manejador, float x, float y, Jugador jugador1) {
        super(manejador, x, y, jugador1);
        
        this.speed = 1.9f;
        
        orillas.x = 5;
        orillas.y = 5;
        orillas.width = 27+50;
        orillas.height = 27+50;
        orillaswidthB = orillas.width;
        orillasheightB = orillas.height;
        
        vidaMaximaB = Criatura.DEFAULT_HEALTH_BOSS;
        vidaActualB = vidaMaximaB;
        
        hi = new Damage3();
        
        posicionB = true;
        
    }
    
    @Override
    public void tick(){
        
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
        if(vidaActualB>0){
            g.drawImage(Efectos.boss, (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()), width+50, height+50, null);
            DibujarVida(g, (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()));
            DibujarDistancia(g, (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()));
        }else{
            if(posicionB){
                posX = (int) (x);
                posY = (int) (y);
                posicionB = false;
            }
        }
    }
    
    private void DibujarVida(Graphics g, int x, int y){
        g.setColor(Color.red);
        g.fillRect(x +5, y - 5 , (int) (vidaActualB), 2);
    }
    
    private void DibujarDistancia(Graphics g, int x, int y){

        xJugador = (int) (jugador1.getX() - manejador.getCamara().getxOffset());
        yJugador = (int) (jugador1.getY() - manejador.getCamara().getyOffset());
        xEnemigoB =  x;
        yEnemigoB =  y;
        distancia = Utils.CalcularDistancia(xJugador, yJugador, xEnemigoB, yEnemigoB);
        
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
        
        if(xJugador > xEnemigoB && yJugador < yEnemigoB){ //diagonal derecha superior
            xMove = speed;
            yMove = -speed;
        }else if(xJugador < xEnemigoB && yJugador < yEnemigoB){ //diagonal izquierda superior
            xMove = -speed;
            yMove = -speed;
        }else if(xJugador < xEnemigoB && yJugador == yEnemigoB){ //izquierda 
            xMove = -speed;
        }else if(xJugador == xEnemigoB && yJugador < yEnemigoB){ //arriba
            yMove = -speed;
        }else if(xJugador > xEnemigoB && yJugador == yEnemigoB){ //derecha 
            xMove = speed;
        }else if(xJugador == xEnemigoB && yJugador > yEnemigoB){ //abajo
            yMove = speed;
        }else if(xJugador > xEnemigoB && yJugador > yEnemigoB){ //diagonal derecha inferior
            xMove = speed;
            yMove = speed;
        }else if(xJugador < xEnemigoB && yJugador > yEnemigoB){ //diagonal izquierda inferior
            xMove = -speed;
            yMove = speed;
        }
        
        move();
    }


    
}
