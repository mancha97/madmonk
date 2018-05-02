/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos_2d.graficos;

import juego_2d.Juego;
import juego_2d.Manejador;
import juego_2d.entidades.Entidad;
import juego_2d.tiles.Tile;

/**
 *
 * @author raalv
 */
public class Camara {
    
    private Manejador manejador;
    public float xOffset, yOffset;
    
    public Camara(Manejador manejador, float xOffset, float yOffset){
        this.manejador = manejador;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }
    
    public void espacioEnBlanco(){
        if(xOffset < 0){
            xOffset = 0;
        }else if(xOffset > (manejador.getMundo().getWidth() * Tile.TILEWIDTH - manejador.getWidth()) ){
            xOffset = (manejador.getMundo().getWidth() * Tile.TILEWIDTH - manejador.getWidth());
               }
        
        if(yOffset < 0){
            yOffset = 0;
        }else if(yOffset > manejador.getMundo().getHeight() * Tile.TILEHEIGHT - manejador.getHeight()){
            yOffset = manejador.getMundo().getHeight() * Tile.TILEHEIGHT - manejador.getHeight();
        }
    }
    
    public void centrarEnEntidad(Entidad entidad){
        xOffset = entidad.getX() - manejador.getWidth() / 2 + entidad.getWidth() / 2;
        yOffset = entidad.getY() - manejador.getHeight() / 2 + entidad.getHeight() / 2;
        espacioEnBlanco();
    }

    public void move(float xAmt, float yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
        espacioEnBlanco();
    }
    
    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
    
    
}
