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

/**
 *
 * @author raalv
 */
public class EstadoJuego2 extends estado{
    private Jugador jugador1;
    private Bounds boundy;
    private Mundo2 mundo2;
    
    public EstadoJuego2(Manejador manejador) {
        super(manejador);
        mundo2 = new Mundo2(manejador, "Recursos/Mundos/Mundo2.txt");
        manejador.setMundo2(mundo2);
    }

    @Override
    public void actualizar() {
        mundo2.tick();
    }

    @Override
    public void renderizar(Graphics g) {
        mundo2.render(g);
    }
    
}
