/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.criatura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import juego_2d.Manejador;
import juego_2d.entidades.Entidad;
import juego_2d.entidades.ManejadorEntidad;
import static juego_2d.entidades.criatura.Misil.m;
import juego_2d.tiles.Tile;
import juego_2d.utils.Utils;
import juegos_2d.graficos.Animacion;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author lito-
 */
public class Enemigo extends Criatura{
    
    //public Runnable hilo = new hilo();

    protected Jugador jugador1;
    private int cont, contador;
    public static int xPos, yPos;
    public static float xB, yB,wB, hB,xM,yM;
   
   

    public static Rectangle auxFire;
    public int id;
    
    public Enemigo(Manejador manejador, float x, float y, Jugador jugador1){
        super(manejador, x, y, Criatura.DEFAULT_CREATURE_WIDTH, Criatura.DEFAULT_CREATURE_HEIGHT);
        this.id = id;
        this.jugador1 = jugador1;
        
        this.speed = 1.2f;
        

        
        
        xPos = (int) x;
        yPos = (int) y;
        
    }
    
    @Override
    public void render(Graphics g) {
    }
    

     

    

    

    @Override
    public void tick() {
    }
    
   
}

