/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.utils;

import java.awt.Rectangle;
import static juego_2d.entidades.criatura.Enemigo1M2.xJugador;
import static juego_2d.entidades.criatura.Enemigo1M2.yJugador;
import static juego_2d.entidades.criatura.Enemigo1M2.xEnemigo12;
import static juego_2d.entidades.criatura.Enemigo1M2.yEnemigo12;
import static juego_2d.entidades.criatura.Enemigo2M2.xEnemigo22;
import static juego_2d.entidades.criatura.Enemigo2M2.yEnemigo22;
import static juego_2d.entidades.criatura.Enemigo3M2.xEnemigo32;
import static juego_2d.entidades.criatura.Enemigo3M2.yEnemigo32;
import juego_2d.entidades.criatura.Jugador;

/**
 *
 * @author Carlos
 */
public class Damage2 implements Runnable {
    
   
    private Thread hilo;
    public Damage2(){
    
    }
    
    public void Verificar(){
        
        Rectangle hola=new Rectangle(xJugador,yJugador,27,32);
        if(hola.intersects((int) (xEnemigo12),(int) (yEnemigo12), 32, 32)){
            
            Jugador.vidaActualJ-=5;
            System.out.println("holajaja");
        }
        if(hola.intersects((int) (xEnemigo22),(int) (yEnemigo22), 32, 32)){
            Jugador.vidaActualJ-=5;
            System.out.println("holajaja");
        }
        if(hola.intersects((int) (xEnemigo32),(int) (yEnemigo32), 32, 32)){
            Jugador.vidaActualJ-=5;
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
