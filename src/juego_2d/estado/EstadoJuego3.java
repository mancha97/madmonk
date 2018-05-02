/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.estado;

import java.awt.Graphics;
import juego_2d.Manejador;
import juego_2d.entidades.criatura.Bounds;
import juego_2d.entidades.criatura.Jugador;
import juego_2d.mundos.Mundo;
import juego_2d.mundos.Mundo2;
import juego_2d.mundos.Mundo3;

/**
 *
 * @author raalv
 */
public class EstadoJuego3 extends estado{
    private Jugador jugador1;
    private Bounds boundy;
    private Mundo mundo;
    private Mundo2 mundo2;
    private Mundo3 mundo3;
    
    public EstadoJuego3(Manejador manejador) {
        super(manejador);
        mundo3 = new Mundo3(manejador, "Recursos/Mundos/Mundo3.txt");
        manejador.setMundo3(mundo3);
    }

    @Override
    public void actualizar() {
        mundo3.tick();
    }

    @Override
    public void renderizar(Graphics g) {
        mundo3.render(g);
    }
    
}
