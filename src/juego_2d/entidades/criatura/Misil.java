/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.criatura;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import juego_2d.Manejador;
import static juego_2d.entidades.criatura.Boss.orillasheightB;
import static juego_2d.entidades.criatura.Boss.orillaswidthB;
import static juego_2d.entidades.criatura.Boss.vidaActualB;
import static juego_2d.entidades.criatura.Boss.xEnemigoB;
import static juego_2d.entidades.criatura.Boss.yEnemigoB;
import static juego_2d.entidades.criatura.Enemigo.auxFire;
import static juego_2d.entidades.criatura.Enemigo1M1.orillasheight1;
import static juego_2d.entidades.criatura.Enemigo1M1.orillaswidth1;
import static juego_2d.entidades.criatura.Enemigo1M1.vidaActual1;
import static juego_2d.entidades.criatura.Enemigo1M1.xEnemigo1;
import static juego_2d.entidades.criatura.Enemigo1M1.yEnemigo1;
import static juego_2d.entidades.criatura.Enemigo1M2.orillasheight12;
import static juego_2d.entidades.criatura.Enemigo1M2.orillaswidth12;
import static juego_2d.entidades.criatura.Enemigo1M2.vidaActual12;
import static juego_2d.entidades.criatura.Enemigo1M2.xEnemigo12;
import static juego_2d.entidades.criatura.Enemigo1M2.yEnemigo12;
import static juego_2d.entidades.criatura.Enemigo2M1.orillasheight2;
import static juego_2d.entidades.criatura.Enemigo2M1.orillaswidth2;
import static juego_2d.entidades.criatura.Enemigo2M1.vidaActual2;
import static juego_2d.entidades.criatura.Enemigo2M1.xEnemigo2;
import static juego_2d.entidades.criatura.Enemigo2M1.yEnemigo2;
import static juego_2d.entidades.criatura.Enemigo2M2.orillasheight22;
import static juego_2d.entidades.criatura.Enemigo2M2.orillaswidth22;
import static juego_2d.entidades.criatura.Enemigo2M2.vidaActual22;
import static juego_2d.entidades.criatura.Enemigo2M2.xEnemigo22;
import static juego_2d.entidades.criatura.Enemigo2M2.yEnemigo22;
import static juego_2d.entidades.criatura.Enemigo3M1.orillasheight3;
import static juego_2d.entidades.criatura.Enemigo3M1.orillaswidth3;
import static juego_2d.entidades.criatura.Enemigo3M1.vidaActual3;
import static juego_2d.entidades.criatura.Enemigo3M1.xEnemigo3;
import static juego_2d.entidades.criatura.Enemigo3M1.yEnemigo3;
import static juego_2d.entidades.criatura.Enemigo3M2.orillasheight32;
import static juego_2d.entidades.criatura.Enemigo3M2.orillaswidth32;
import static juego_2d.entidades.criatura.Enemigo3M2.vidaActual32;
import static juego_2d.entidades.criatura.Enemigo3M2.xEnemigo32;
import static juego_2d.entidades.criatura.Enemigo3M2.yEnemigo32;
import static juego_2d.entidades.criatura.Enemigo4M1.orillasheight4;
import static juego_2d.entidades.criatura.Enemigo4M1.orillaswidth4;
import static juego_2d.entidades.criatura.Enemigo4M1.vidaActual4;
import static juego_2d.entidades.criatura.Enemigo4M1.xEnemigo4;
import static juego_2d.entidades.criatura.Enemigo4M1.yEnemigo4;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author raalv
 */
public class Misil implements Runnable{
    private BufferedImage Misil=Efectos.missileder;
    public ArrayList listamisi;
    public Manejador manejador;
    private float c=1;
    private boolean visible;
    private float x;
    private float y;  
    private final float DEFAULTSPEED=5f;
    public Thread hilo;
    protected static Rectangle m;
    Enemigo enemigo;
    private int enemigovida = 30;
    
    public Misil(Manejador manejador,float x, float y, ArrayList listamisi){
        this.x=x;
        this.y=y;
        this.listamisi=listamisi;
        this.manejador=manejador;
    }
    
    public  void updateMissiles() {
        ArrayList ms = listamisi;
        int j=0;
        for (int i = 0; i < ms.size(); i++) {   
            j++;
            m = (Rectangle) ms.get(i);
            if (m.x<2048 && m.y<1184) {
                movemissile(m,(int)Jugador.direccion.get(i));
                auxFire = m;
                if(m.intersects((int)xEnemigo1 + manejador.getCamara().getxOffset(),(int) yEnemigo1 + manejador.getCamara().getyOffset(), orillaswidth1, orillasheight1)){
                    
                    vidaActual1-=3;
                    if(vidaActual1>=0){
                        ms.remove(i);
                        Jugador.direccion.remove(i);
                    }
                }
                if(m.intersects((int)xEnemigo2 + manejador.getCamara().getxOffset(),(int) yEnemigo2 + manejador.getCamara().getyOffset(), orillaswidth2, orillasheight2)){
                    
                    vidaActual2-=3;
                    if(vidaActual2>=0){
                        ms.remove(i);
                        Jugador.direccion.remove(i);
                    }
                }
                if(m.intersects((int)xEnemigo3 + manejador.getCamara().getxOffset(),(int) yEnemigo3 + manejador.getCamara().getyOffset(), orillaswidth3, orillasheight3)){
                    
                    vidaActual3-=3;
                    if(vidaActual3>=0){
                        ms.remove(i);
                        Jugador.direccion.remove(i);
                    }
                }
                if(m.intersects((int)xEnemigo4 + manejador.getCamara().getxOffset(),(int) yEnemigo4 + manejador.getCamara().getyOffset(), orillaswidth4, orillasheight4)){
                    
                    vidaActual4-=3;
                    if(vidaActual4>=0){
                        ms.remove(i);
                        Jugador.direccion.remove(i);
                    }
                }
                
                if(m.intersects((int)xEnemigo12 + manejador.getCamara().getxOffset(),(int) yEnemigo12 + manejador.getCamara().getyOffset(), orillaswidth12, orillasheight12)){
                    
                    vidaActual12-=3;
                    if(vidaActual12>=0){
                        ms.remove(i);
                        Jugador.direccion.remove(i);
                    }
                }
                
                if(m.intersects((int)xEnemigo22 + manejador.getCamara().getxOffset(),(int) yEnemigo22 + manejador.getCamara().getyOffset(), orillaswidth22, orillasheight22)){
                    
                    vidaActual22-=3;
                    if(vidaActual22>=0){
                        ms.remove(i);
                        Jugador.direccion.remove(i);
                    }
                }
                
                if(m.intersects((int)xEnemigo32 + manejador.getCamara().getxOffset(),(int) yEnemigo32 + manejador.getCamara().getyOffset(), orillaswidth32, orillasheight32)){
                    
                    vidaActual32-=3;
                    if(vidaActual32>=0){
                        ms.remove(i);
                        Jugador.direccion.remove(i);
                    }
                }
                if(m.intersects((int)xEnemigoB + manejador.getCamara().getxOffset(),(int) yEnemigoB + manejador.getCamara().getyOffset(), orillaswidthB, orillasheightB)){
                    //System.out.println("BOSS");
                    vidaActualB-=3;
                    if(vidaActualB>0){
                        ms.remove(i);
                        Jugador.direccion.remove(i);
                    }
                }
                
                if(m.x-manejador.getCamara().xOffset>950 || m.y-manejador.getCamara().yOffset>650||m.x-manejador.getCamara().xOffset<0||m.y-manejador.getCamara().yOffset<0){
                    
                    ms.remove(i);
                    Jugador.direccion.remove(i);
                }
            } 
        }
    }
    public void movemissile(Rectangle m, int x) {
        if (x==1){
        m.x-=(int)DEFAULTSPEED;}
        if (x==2){
        m.x+=(int)DEFAULTSPEED;}
        if (x==3){
        m.y-=(int)DEFAULTSPEED;}
        if (x==0){
        m.y+=(int)DEFAULTSPEED;}
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    @Override
    public void run() {
        updateMissiles();    
    }

    public BufferedImage getMisil() {
        return Misil;
    }

    public void setMisil(BufferedImage Misil) {
        this.Misil = Misil;
    }

    public synchronized void iniciar() {        
        hilo = new Thread(this);
        hilo.start();
    }
}
