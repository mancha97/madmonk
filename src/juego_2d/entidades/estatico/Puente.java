/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.estatico;

import java.awt.Graphics;
import juego_2d.Manejador;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author raalv
 */
public class Puente extends StaticEntity{

    public Puente(Manejador manejador, float x, float y) {
        super(manejador, x, y, 145, 122);
        
        orillas.x = 0;
        orillas.x = 0;
        orillas.width = 15;
        orillas.height = 120;
    }

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Efectos.puertas[2], (int)(x - manejador.getCamara().getxOffset()),(int)(y - manejador.getCamara().getyOffset()),width,height, null);
    }
    
}
