/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.estatico;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import juego_2d.Manejador;
import juegos_2d.graficos.Animacion;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author raalv
 */
public class Cristal2 extends StaticEntity{
    private Animacion cristal2;
    public Cristal2(Manejador manejador, float x, float y) {
        super(manejador, x, y, 48, 94);
        cristal2 = new Animacion(180, Efectos.cristal2);
    }

    @Override
    public void tick() {
        cristal2.tick();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()), width, height, null);
    }
    
    private BufferedImage getCurrentAnimationFrame(){
        return cristal2.getCurrentFrame();
    }
}
