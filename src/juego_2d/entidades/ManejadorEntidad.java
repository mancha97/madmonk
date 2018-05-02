/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import static juego_2d.Juego.FPSS;
import juego_2d.Manejador;
import juego_2d.entidades.criatura.Jugador;
import juego_2d.estado.estado;
import static juego_2d.mundos.Mundo.Pupic;
import static juego_2d.mundos.Mundo2.Pupic2;
import juegos_2d.graficos.Animacion;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author raalv
 */
public class ManejadorEntidad {
    private Manejador manejador;
    private Jugador jugador1;
    private ArrayList<Entidad> entidades;
    private ArrayList<Entidad> enemy;
    private Comparator<Entidad> renderOrder = new Comparator<Entidad>(){
        @Override
        public int compare(Entidad a, Entidad b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
        
    };
    private Rectangle disparo;
    private int cont;
    private float xi ;
    private float yi;
    private boolean pancha = true;
    private Animacion asd;
    Rectangle p, p2;
    
    public ManejadorEntidad(Manejador manejador, Jugador jugador1){
        this.manejador = manejador;
        this.jugador1 = jugador1;
        entidades = new ArrayList<>();
        enemy = new ArrayList<>();
        addEntidad(jugador1);
        xi = jugador1.getX();
        yi = jugador1.getY();
        p =  new Rectangle(477, 176, 96, 92);
        p2 = new Rectangle(973,35,96,100);
    }
    
    public void tick(){
        
        for(int i = 0; i < entidades.size(); i++){
            Entidad e = entidades.get(i);
            e.tick();
        }
        entidades.sort(renderOrder);
        if(estado.getEstado().equals(manejador.getJuego().estadoJuego) && !Pupic)
            if(p.intersects(jugador1.x+jugador1.orillas.x+jugador1.getxMove() ,jugador1.y+jugador1.orillas.y+jugador1.getyMove(),jugador1.orillas.width,jugador1.orillas.height)){       
            try {
                manejador.setBanderita(2);
                Thread.sleep(1000);
                estado.setEstado(manejador.getJuego().estadoLoading);
                return;
            } catch (InterruptedException ex) {
                Logger.getLogger(ManejadorEntidad.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        if(estado.getEstado().equals(manejador.getJuego().estadoJuego2) && !Pupic2)
            if(p2.intersects(jugador1.x+jugador1.orillas.x+jugador1.getxMove() ,jugador1.y+jugador1.orillas.y+jugador1.getyMove(),jugador1.orillas.width,jugador1.orillas.height)){       
            try {
                manejador.setBanderita(3);
                Thread.sleep(1000);
                estado.setEstado(manejador.getJuego().estadoLoading);
                return;
            } catch (InterruptedException ex) {
                Logger.getLogger(ManejadorEntidad.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        }
    }
    
    public void render(Graphics g){
        ArrayList ms=jugador1.getListamisi(); 
        for (Object m1 : ms) {
            Rectangle m = (Rectangle) m1;            
            g.drawImage(Efectos.actualmisi,(int)(m.x-manejador.getCamara().getxOffset()),
                    (int)(m.y-manejador.getCamara().getyOffset()), null);
        }
        for(Entidad e : entidades){
            e.render(g);
            
        }
        g.setFont(new Font("TimesRoman", Font.PLAIN, 17));
        g.setColor(Color.BLACK);
        g.drawString("FPS: "+FPSS,(int) (890),(int) (15));
        if(Jugador.marcelo)
            g.drawString("Recargando... ", 860, 640);
            
    }
    public void addEntidad(Entidad e){
        entidades.add(e);
    }
    public void removeEntidad(Entidad e){
        entidades.remove(e);
    }
    public void addEnemy(Entidad E){
        enemy.add(E);
    }
    public void removeEnemt(Entidad E){
        enemy.remove(E);
    }
    public Manejador getManejador() {
        return manejador;
    }

    public void setManejador(Manejador manejador) {
        this.manejador = manejador;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }
    
    public ArrayList<Entidad> getEnemy() {
        return enemy;
    }   
    
    public ArrayList<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(ArrayList<Entidad> entidades) {
        this.entidades = entidades;
    }
    
}