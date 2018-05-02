/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.mundos;

import java.awt.Graphics;
import juego_2d.Juego;
import juego_2d.Manejador;
import juego_2d.entidades.criatura.Bounds;
import juego_2d.tiles.Tile;
import juego_2d.utils.Utils;
import java.awt.Rectangle;
import juego_2d.entidades.ManejadorEntidad;
import juego_2d.entidades.criatura.Enemigo;
import juego_2d.entidades.criatura.Enemigo1M1;
import static juego_2d.entidades.criatura.Enemigo1M1.vidaActual1;
import juego_2d.entidades.criatura.Enemigo2M1;
import static juego_2d.entidades.criatura.Enemigo2M1.vidaActual2;
import juego_2d.entidades.criatura.Enemigo3M1;
import static juego_2d.entidades.criatura.Enemigo3M1.vidaActual3;
import juego_2d.entidades.criatura.Enemigo4M1;
import static juego_2d.entidades.criatura.Enemigo4M1.vidaActual4;
import juego_2d.entidades.criatura.Jugador;
import juego_2d.entidades.estatico.Puerta;
import juego_2d.entidades.estatico.PuertaAzul;
import juego_2d.estado.estado;

/**
 *
 * @author raalv
 */
public class Mundo {
    
    private Manejador manejador;
    private int width, height;
    private int spawnx, spawny;
    private int[][] tiles;
    public Bounds boundy= new Bounds();
    private Enemigo1M1 enemigo1;
    private Enemigo2M1 enemigo2;
    private Enemigo3M1 enemigo3;
    private Enemigo4M1 enemigo4;
    private Puerta puerta;
    private PuertaAzul puertaAzul;
    //Entidades
    private ManejadorEntidad entityManager;
    public static boolean Pupic = true;
    
    public Mundo(Manejador manejador, String path){
        this.manejador = manejador;
        
        entityManager =  new ManejadorEntidad(manejador, new Jugador(manejador,100, 100));
        enemigo1 = new Enemigo1M1(manejador, 530, 1085, entityManager.getJugador1());
        enemigo2 = new Enemigo2M1(manejador, 1865, 225, entityManager.getJugador1());
        enemigo3 = new Enemigo3M1(manejador, 545, 295, entityManager.getJugador1());
        enemigo4 = new Enemigo4M1(manejador, 565, 355, entityManager.getJugador1());
        puerta = new Puerta(manejador, 477,176);
        puertaAzul = new PuertaAzul(manejador, 477,176);
        AddStaticEntity();
        
        cargarMundo(path);
        
        entityManager.getJugador1().setX(spawnx);
        entityManager.getJugador1().setY(spawny);
    }
    
    public void AddStaticEntity(){
        entityManager.addEntidad(puerta);
        entityManager.addEntidad(enemigo1);
        entityManager.addEntidad(enemigo2);
        entityManager.addEntidad(enemigo3);
        entityManager.addEntidad(enemigo4);
    }
    
    public void tick(){
        entityManager.tick(); 
        if(vidaActual1 <= 0 && vidaActual2 <= 0 && vidaActual3 <= 0 && vidaActual4 <= 0){
            
            if(Pupic)
                //if(entityManager.getEntidades().size()==6){
                    entityManager.addEntidad(puertaAzul);
                    entityManager.removeEntidad(puerta);
                    Pupic = false;
                //}
        }
    }
    
    public void render(Graphics g){
        int xStart = ((int) (Math.max(0, manejador.getCamara().getxOffset() / Tile.TILEWIDTH)));
        int xEnd = ((int) (Math.min(width, (manejador.getCamara().getxOffset() + manejador.getWidth()) / Tile.TILEWIDTH + 1)));
        int yStart = ((int) (Math.max(0, (manejador.getCamara().getyOffset()) / Tile.TILEHEIGHT)));
        int yEnd = ((int) (Math.min(height, (manejador.getCamara().getyOffset()) / Tile.TILEHEIGHT + 1)));
        
        for(int y = yStart; y < height ;y++){
            for(int x = xStart; x < xEnd ;x++){
                getTile(x, y).render(g, (int) (x*Tile.TILEWIDTH - manejador.getCamara().getxOffset()),
                                        (int) (y*Tile.TILEHEIGHT - manejador.getCamara().getyOffset()));
            }
        }
        entityManager.render(g);
       
    }
    
    public Tile getTile(int x, int y){
        if(x < 0 || y < 0 || x >= width || y >= height)
            return Tile.gramaTile;
        
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null){
            return Tile.tierraTile;
        }
        return t;
    }
    
    private void cargarMundo(String path){
       String file = Utils.loadFileAsString(path);
       String[] tokens = file.split("\\s+");
       width = Utils.parseInt(tokens[0]);
       height = Utils.parseInt(tokens[1]);
       spawnx = Utils.parseInt(tokens[2]);
       spawny = Utils.parseInt(tokens[3]);
       
       tiles = new int[width][height];
       for(int y = 0; y< height;y++){
           for(int x = 0; x< width; x++){
               tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
           }
       }
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getSpawnx(){
        return spawnx;
    }
    
    public int getSpawny(){
        return spawny;
    }

    public ManejadorEntidad getEntityManager() {
        return entityManager;
    }
    
}
