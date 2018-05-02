/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import juego_2d.Juego;
import juego_2d.Manejador;
import juego_2d.entidades.criatura.Jugador;
import juego_2d.entidades.estatico.Puerta;
import juego_2d.estado.estado;


/**
 *
 * @author lito-
 */
public abstract class Entidad {
    
    protected Manejador manejador;
    protected float x, y; 
    protected int width, height;
    protected Rectangle orillas;
    private int i =0;
    
    public Entidad(Manejador manejador, float x, float y, int width, int height){
        this.manejador = manejador;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        orillas = new Rectangle(0,0,width, height);
    }
    
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public boolean CheckEntityCollisions(float xOffset, float yOffset){
        if(estado.getEstado().equals(manejador.getJuego().estadoJuego)){
            for(Entidad e : manejador.getMundo().getEntityManager().getEntidades()){
                if(e.equals(this)){
                    continue;
                }
                if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                    return true;
                }
            }
            return false;
        }
        if(estado.getEstado().equals(manejador.getJuego().estadoJuego2)){
            for(Entidad e : manejador.getMundo2().getEntityManager3().getEntidades()){
                if(e.equals(this)){
                    continue;
                }
                if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                    return true;
                }
            }
            return false;
        }
        if(estado.getEstado().equals(manejador.getJuego().estadoJuego3)){
            
            for(Entidad e : manejador.getMundo3().getEntityManager4().getEntidades()){
                if(e.equals(this)){
                    continue;
                }
                if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                    i+=1;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public Rectangle getCollisionBounds(float xOffset, float yOffset){      
            return new Rectangle((int) (x + orillas.x + xOffset), (int)(y + orillas.y + yOffset), orillas.width, orillas.height);
    }
    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
}
