/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.utils;

import java.awt.Rectangle;
import static juego_2d.entidades.criatura.Boss.xEnemigoB;
import static juego_2d.entidades.criatura.Boss.xJugador;
import static juego_2d.entidades.criatura.Boss.yEnemigoB;
import static juego_2d.entidades.criatura.Boss.yJugador;
import juego_2d.entidades.criatura.Jugador;

/**
 *
 * @author lito-
 */
public class Damage3 implements Runnable {

    private Thread hilo;
    public Damage3(){
    
    }
    
    public void Verificar(){
        
        Rectangle hola=new Rectangle(xJugador,yJugador,27,32);
        if(hola.intersects((int) (xEnemigoB),(int) (yEnemigoB)+10, 32+50, 32+50)){
            Jugador.vidaActualJ-=25;
            System.out.println("holajaja");
        }
    }
    
    
    @Override
    public void run() {
      
            Verificar();
            
        
    }
    public synchronized void iniciar() {        
        hilo = new Thread(this);
        hilo.start();
    }
    
}
