/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.utils;

import java.awt.Rectangle;
import juego_2d.Manejador;
import static juego_2d.entidades.criatura.Enemigo1M1.xEnemigo1;
import static juego_2d.entidades.criatura.Enemigo1M1.xJugador;
import static juego_2d.entidades.criatura.Enemigo1M1.yEnemigo1;
import static juego_2d.entidades.criatura.Enemigo1M1.yJugador;
import static juego_2d.entidades.criatura.Enemigo2M1.xEnemigo2;
import static juego_2d.entidades.criatura.Enemigo2M1.yEnemigo2;
import static juego_2d.entidades.criatura.Enemigo3M1.xEnemigo3;
import static juego_2d.entidades.criatura.Enemigo3M1.yEnemigo3;
import static juego_2d.entidades.criatura.Enemigo4M1.xEnemigo4;
import static juego_2d.entidades.criatura.Enemigo4M1.yEnemigo4;
import juego_2d.entidades.criatura.Jugador;
import juego_2d.estado.estado;

/**
 *
 * @author Carlos
 */
public class Damage implements Runnable {
    
   
    private Thread hilo;
    
    private Manejador manejador;
    public Damage(){
    }
    
    public void Verificar(){
        
        Rectangle hola=new Rectangle(xJugador,yJugador,27,32);
            if(hola.intersects((int) (xEnemigo1),(int) (yEnemigo1), 32, 32)){
                Jugador.vidaActualJ-=5;
                System.out.println("holajaja");
            }
            if(hola.intersects((int) (xEnemigo2),(int) (yEnemigo2), 32, 32)){
                Jugador.vidaActualJ-=5;
                System.out.println("holajaja");
            }
            if(hola.intersects((int) (xEnemigo3),(int) (yEnemigo3), 32, 32)){
                Jugador.vidaActualJ-=5;
                System.out.println("holajaja");
            }
            if(hola.intersects((int) (xEnemigo4),(int) (yEnemigo4), 32, 32)){
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
