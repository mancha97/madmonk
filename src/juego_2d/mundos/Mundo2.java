/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.mundos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import juego_2d.Manejador;
import juego_2d.entidades.EntidadesInstrucciones;
import juego_2d.entidades.ManejadorEntidad;
import juego_2d.entidades.criatura.Bounds;
import juego_2d.entidades.criatura.Enemigo1M2;
import static juego_2d.entidades.criatura.Enemigo1M2.vidaActual12;
import juego_2d.entidades.criatura.Enemigo2M2;
import static juego_2d.entidades.criatura.Enemigo2M2.vidaActual22;
import juego_2d.entidades.criatura.Enemigo3M2;
import static juego_2d.entidades.criatura.Enemigo3M2.vidaActual32;
import juego_2d.entidades.criatura.Jugador;
import juego_2d.entidades.estatico.Cristal1;
import juego_2d.entidades.estatico.Cristal2;
import juego_2d.entidades.estatico.Cristal3;
import juego_2d.entidades.estatico.Cristal4;
import juego_2d.entidades.estatico.Puente;
import juego_2d.entidades.estatico.Puerta;
import juego_2d.entidades.estatico.PuertaM2;
import juego_2d.entidades.estatico.PuertaM2A;
import juego_2d.tiles.Tile;
import juego_2d.utils.Utils;
import juegos_2d.graficos.Animacion;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author raalv
 */
public class Mundo2 {
    private Manejador manejador;
    private int width, height;
    private int spawnx, spawny;
    private int[][] tiles;
    public Bounds boundy= new Bounds();
    private Enemigo1M2 enemigo5;
    private Enemigo2M2 enemigo6;
    private Enemigo3M2 enemigo7;
    private PuertaM2 puerta;
    private PuertaM2A puerta2;
    
    //Entidades
   // private ManejadorEntidad entityManager;
    private EntidadesInstrucciones InstruccionesManager;
    private ManejadorEntidad entityManager3;
    public static boolean Pupic2 = true;
    
    public Mundo2(Manejador manejador, String path){
        this.manejador = manejador;
        
        entityManager3 =  new ManejadorEntidad(manejador, new Jugador(manejador,100, 100));
        enemigo5 = new Enemigo1M2(manejador, 350, 350, entityManager3.getJugador1());
        enemigo6 = new Enemigo2M2(manejador, 1010, 640, entityManager3.getJugador1());
        enemigo7 = new Enemigo3M2(manejador, 1670, 360, entityManager3.getJugador1());
        puerta = new PuertaM2(manejador, 973,35);
        puerta2 = new PuertaM2A(manejador, 973, 35);
        AddStaticEntity();
        
        cargarMundoo(path);
        
        entityManager3.getJugador1().setX(spawnx);
        entityManager3.getJugador1().setY(spawny);
        
        
    }
    public void AddStaticEntity(){
        entityManager3.addEntidad(new Puente(manejador, 950,709));
        entityManager3.addEntidad(new Cristal1(manejador, 844,230));
        entityManager3.addEntidad(new Cristal2(manejador, 1157,230));
        entityManager3.addEntidad(new Cristal3(manejador, 844,462));
        entityManager3.addEntidad(new Cristal4(manejador, 1157,462));
        entityManager3.addEntidad(new Cristal4(manejador, 1157,462));
        entityManager3.addEntidad(puerta);
        
        //ENEMIGOS
        entityManager3.addEntidad(enemigo5);
        entityManager3.addEntidad(enemigo6);
        entityManager3.addEntidad(enemigo7);
    }
    public void tick(){
        entityManager3.tick();
        
        if(vidaActual12 < 0 && vidaActual22 < 0 && vidaActual32 < 0){
            if(Pupic2){
                entityManager3.removeEntidad(puerta);     
                entityManager3.addEntidad(puerta2);
                Pupic2 = false;

            }
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
        entityManager3.render(g);
       
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
    
    private void cargarMundoo(String path){
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

    public ManejadorEntidad getEntityManager3() {
        return entityManager3;
    }
}
