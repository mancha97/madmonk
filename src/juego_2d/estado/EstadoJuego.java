/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.estado;

import juegos_2d.graficos.Efectos;
import java.awt.Graphics; 
import juego_2d.Juego;
import juego_2d.Manejador;
import juego_2d.entidades.criatura.Bounds;
import juego_2d.entidades.criatura.Jugador;
import juego_2d.mundos.Mundo;
import juego_2d.tiles.Tile;

/**
 *
 * @author lito-
 */
public class EstadoJuego extends estado{
    
    private Jugador jugador1;
    private Bounds boundy;
    private Mundo mundo;
    
    
    public EstadoJuego(Manejador manejador){
        super(manejador);
        mundo = new Mundo(manejador, "Recursos/Mundos/Mundo1.txt");
        manejador.setMundo(mundo);
        //jugador1 = new Jugador(manejador, manejador.getMundo().getSpawnx(), manejador.getMundo().getSpawny());
        
        
    }
    
    @Override
    public void actualizar() {
        mundo.tick();
        //jugador1.tick();
    }

    @Override
    public void renderizar(Graphics g) {
        mundo.render(g);
        //jugador1.render(g);
    }
    
    
    
    
}
