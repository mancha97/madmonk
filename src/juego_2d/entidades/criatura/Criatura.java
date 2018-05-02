/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.criatura;

import java.awt.Rectangle;
import juego_2d.Juego;
import juego_2d.Manejador;
import juego_2d.entidades.Entidad;
import juego_2d.estado.estado;
import juego_2d.tiles.Tile;
import juegos_2d.graficos.Camara;

/**
 *
 * @author lito-
 */
public abstract class Criatura extends Entidad{
    
    public static final int DEFAULT_HEALTH = 80;
    public static final int DEFAULT_HEALTH_ENEMIGO = 36;
    public static final int DEFAULT_HEALTH_BOSS = 60;
    public static final float DEFAULT_SPEED = 1.8f;
    public static final int DEFAULT_CREATURE_WIDTH =46, 
                            DEFAULT_CREATURE_HEIGHT = 48;
   
    
    protected int health;
    protected float speed;
    protected float xMove, yMove;
    public Bounds boundy= new Bounds();
    public BoundsInstrucciones boundies = new BoundsInstrucciones();
    public BoundsMapa2 bounds2 = new BoundsMapa2();
    public BoundsMapa3 bounds3 = new BoundsMapa3();
   // public static Rectangle rect;
    public Criatura(Manejador manejador, float x, float y, int width, int height){
        super(manejador, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed  = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        //rect= new Rectangle((int)x,(int)y,width,height);
    }

    public void move(){
        if(!CheckEntityCollisions(xMove, 0f)){
            moveX();
        }
        if(!CheckEntityCollisions(0f, yMove)){
            moveY();
        }   
    }
    
    public void moveX(){
        if(estado.getEstado().equals(manejador.getJuego().estadoJuego)){
            if(xMove > 0){//Derecha
                int dx = (int) (x + xMove + orillas.x + orillas.width) / Tile.TILEWIDTH;

                for(int i=0;i<15;i++){
                 if(boundy.getBoundy(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                        System.out.println("entro x en el tile:"+i);
                        x -= xMove+0.01;

                        }}
                x += xMove;
            }else if(xMove < 0){//Izquierda
                int dx = (int) (x + xMove + orillas.x) / Tile.TILEWIDTH;
               for(int i=0;i<15;i++){
                 if(boundy.getBoundy(i).intersects(  x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                        System.out.println("entro en x en el tile:"+i);
                        x -= xMove-0.01;
                        }}
                x += xMove;

            }
        }else if(estado.getEstado().equals(manejador.getJuego().estadoHowTo)){
            if(xMove>0){//Derecha
                for(int i = 0; i < 17; i++){
                    if(boundies.getBoundies(i).intersects(x+orillas.x+xMove, y+orillas.y+yMove,orillas.width, orillas.height)){
                        x-=xMove-0.01;
                    }
                }
                x+=xMove;
            }else{
                if(xMove<0){//Derecha
                for(int i = 0; i < 17; i++){
                      if(boundies.getBoundies(i).intersects(x+orillas.x+xMove, y+orillas.y+yMove,orillas.width, orillas.height)){
                         x-=xMove-0.01;
                      }
                    }
                     x+=xMove;
                }
            }
        }else if(estado.getEstado().equals(manejador.getJuego().estadoJuego2)){
            if(xMove>0){//Derecha
                for(int i = 0; i < 33; i++){
                    if(bounds2.getBounds2(i).intersects(x+orillas.x+xMove, y+orillas.y+yMove,orillas.width, orillas.height)){
                        x-=xMove-0.01;
                    }
                }
                x+=xMove;
            }else{
                if(xMove<0){//Derecha
                for(int i = 0; i < 33; i++){
                      if(bounds2.getBounds2(i).intersects(x+orillas.x+xMove, y+orillas.y+yMove,orillas.width, orillas.height)){
                         x-=xMove-0.01;
                      }
                    }
                     x+=xMove;
                }
            }
        }else if(estado.getEstado().equals(manejador.getJuego().estadoJuego3)){
            if(xMove>0){//Derecha
                for(int i = 0; i < 25; i++){
                    if(bounds3.getBounds3(i).intersects(x+orillas.x+xMove, y+orillas.y+yMove,orillas.width, orillas.height)){
                        x-=xMove-0.01;
                    }
                }
                x+=xMove;
            }else{
                if(xMove<0){//Derecha
                for(int i = 0; i < 25; i++){
                      if(bounds3.getBounds3(i).intersects(x+orillas.x+xMove, y+orillas.y+yMove,orillas.width, orillas.height)){
                         x-=xMove-0.01;
                      }
                    }
                     x+=xMove;
                }
            }
        }
    }
    
    public void moveY(){
        if(estado.getEstado().equals(manejador.getJuego().estadoJuego)){
            if(yMove < 0){//Arriba
                for(int i=0;i<15;i++){
                    if(boundy.getBoundy(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                       //System.out.println("entro y en el tile:"+i);
                       y -= yMove-0.01;
                    }
                }
               y += yMove;

            }else if(yMove > 0){//Abajo

               for(int i=0;i<15;i++){
                if(boundy.getBoundy(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                       //System.out.println("entro y en el tile:"+i);
                       y -= yMove-0.01;

                       }}
               y += yMove;

           }
        }else if(estado.getEstado().equals(manejador.getJuego().estadoHowTo)){
            if(yMove < 0){//Arriba
                for(int i=0;i<17;i++){
                    if(boundies.getBoundies(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                        y -= yMove-0.01;
                    }
                }
            y += yMove;
            }else if(yMove > 0){//Abajo
                for(int i=0;i<17;i++){
                    if(boundies.getBoundies(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                       y -= yMove-0.01;
                    }
                }
                y += yMove;
            }
        }else if(estado.getEstado().equals(manejador.getJuego().estadoJuego2)){
            if(yMove < 0){//Arriba
                for(int i=0;i<33;i++){
                    if(bounds2.getBounds2(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                        y -= yMove-0.01;
                    }
                }
            y += yMove;
            }else if(yMove > 0){//Abajo
                for(int i=0;i<33;i++){
                    if(bounds2.getBounds2(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                       y -= yMove-0.01;
                    }
                }
                y += yMove;
            }
        }else if(estado.getEstado().equals(manejador.getJuego().estadoJuego3)){
            if(yMove < 0){//Arriba
                for(int i=0;i<25;i++){
                    if(bounds3.getBounds3(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                        y -= yMove-0.01;
                    }
                }
            y += yMove;
            }else if(yMove > 0){//Abajo
                for(int i=0;i<25;i++){
                    if(bounds3.getBounds3(i).intersects( x+orillas.x+xMove ,y+orillas.y+yMove,orillas.width,orillas.height)){
                       y -= yMove-0.01;
                    }
                }
                y += yMove;
            }
        }
    }
    
    protected boolean colisionConTile(int x, int y){
        return manejador.getMundo().getTile(x, y).isSolid();
    }
    
    //Setters y getters
    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
    
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
}
