/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import juego_2d.Manejador;
import juego_2d.entidades.criatura.Jugador;
import juegos_2d.graficos.Animacion;

/**
 *
 * @author raalv
 */
public class EntidadesInstrucciones {
      private Manejador manejador;
    private Jugador jugador1;
    private ArrayList<Entidad> entidadesI;
    private Rectangle disparo;
    private int cont;
    private float xi ;
    private float yi;
    private boolean pelson = true;
    private Animacion asd;
    
    public EntidadesInstrucciones(Manejador manejador, Jugador jugador1){
        this.manejador = manejador;
        this.jugador1 = jugador1;
        entidadesI = new ArrayList<>();
        
    }
    
    public void tick(){
        for(int i = 0; i< entidadesI.size(); i++){
            Entidad eI = entidadesI.get(i);
            eI.tick();
        }
        jugador1.tick();
    }
    public void render(Graphics g){
        for(Entidad eI : entidadesI){
            eI.render(g);
        }
        jugador1.render(g);
        if(manejador.getTeclado().space){
            if(pelson){
                xi = jugador1.getX();
                yi = jugador1.getY();
                pelson = false;
            }else{
                if(cont < 250){ 
                    g.drawImage(asd.getCurrentFrame(), (int)(((xi + jugador1.getWidth())-manejador.getCamara().getxOffset())+cont), (int)((yi+(jugador1.getHeight()/2))-manejador.getCamara().getyOffset()), 32, 32, null);
                    //g.fillRect((int)(((xi + jugador1.getWidth())-manejador.getCamara().getxOffset())+cont), (int)((yi+(jugador1.getHeight()/2))-manejador.getCamara().getyOffset()), 8, 3);
                    cont+=6;
                }
            }
        }else{
            cont = 0;
            pelson = true;
        }   
    }
    public void addEntidad(Entidad e){
        entidadesI.add(e);
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

    public ArrayList<Entidad> getEntidades() {
        return entidadesI;
    }

    public void setEntidades(ArrayList<Entidad> entidades) {
        this.entidadesI = entidades;
    }
}
