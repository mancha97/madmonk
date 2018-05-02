/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import juego_2d.Manejador;
import juego_2d.estado.estado;

/**
 *
 * @author raalv
 */
public class Tile {
    //Instancias "static" de los tiles
    public static Tile[] tiles = new Tile[256];
    public static Tile gramaTile = new Grama(0);
    public static Tile tierraTile =  new Tierra(1);
    public static Tile arbustoTile = new Arbusto(2);
    public static Tile mota = new Montania(3);
    public static Tile mapa = new Mapa(4);
    public static Tile instruccinoes = new Instrucciones(5);
    public static Tile mapa2 = new Mapa2(6);
    public static Tile mapa3 = new Mapa3(7);
    
    private Manejador manejador;
    private int Roberto;
    
    //METODOS DE LA CLASE
    public static final int TILEWIDTH = 2048,
                            TILEHEIGHT = 1184;
    
    protected BufferedImage textura;
    protected final int id;
    
    public Tile(BufferedImage textura, int id){
        this.textura = textura;
        this.id = id;
        
        tiles[id] = this;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g, int x, int y){
        g.drawImage(textura, x, y, TILEWIDTH, TILEHEIGHT, null);            
    }
    
    public boolean isSolid(){
        return false;
    }
    
    public int getId(){
        return id;
    }
    
   
}
