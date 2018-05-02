package juego_2d.mundos;

import java.awt.Graphics;
import juego_2d.Manejador;
import juego_2d.entidades.EntidadesInstrucciones;
import juego_2d.entidades.ManejadorEntidad;
import juego_2d.entidades.criatura.Boss;
import static juego_2d.entidades.criatura.Boss.vidaActualB;
import juego_2d.entidades.criatura.Bounds;
import juego_2d.entidades.criatura.Jugador;
import juego_2d.estado.estado;
import juego_2d.tiles.Tile;
import juego_2d.utils.Utils;

/**
 *
 * @author raalv
 */
public class Mundo3 {
    private Manejador manejador;
    private int width, height;
    private int spawnx, spawny;
    private int[][] tiles;
    public Bounds boundy= new Bounds();
    
    //Entidades
   // private ManejadorEntidad entityManager;
    private EntidadesInstrucciones InstruccionesManager;
    private ManejadorEntidad entityManager4;
    
    private Boss boss;
    
    public Mundo3(Manejador manejador, String path){
        this.manejador = manejador;
        
        entityManager4 =  new ManejadorEntidad(manejador, new Jugador(manejador,100, 100));
        boss = new Boss(manejador, 824, 428, entityManager4.getJugador1());
        AddStaticEntity();
        
        cargarMundoo(path);
        
        entityManager4.getJugador1().setX(spawnx);
        entityManager4.getJugador1().setY(spawny);
    }
    public void AddStaticEntity(){
        entityManager4.addEntidad(boss);
    }
    public void tick(){
        if(vidaActualB <= 0)
            estado.setEstado(manejador.getJuego().estadoWIN);
        entityManager4.tick();
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
        entityManager4.render(g);
       
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

    public ManejadorEntidad getEntityManager4() {
        return entityManager4;
    }
}
