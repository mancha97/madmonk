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
import juego_2d.mundos.InstruccionesMundo;
import juego_2d.mundos.Mundo;

/**
 *
 * @author raalv
 */
public class EstadoHowTo extends estado{
    
    private Jugador jugador1;
    private Bounds boundy;
    private InstruccionesMundo instrucciones;
    private Mundo mundo;
    

    public EstadoHowTo(Manejador manejador) {
        super(manejador);
        instrucciones = new InstruccionesMundo(manejador, "Recursos/Mundos/Instrucciones.txt");
        manejador.setInstrucciones(instrucciones);
    }

    @Override
    public void actualizar() {
        instrucciones.tick();
    }

    @Override
    public void renderizar(Graphics g) {
        instrucciones.render(g);
    }
    
}
