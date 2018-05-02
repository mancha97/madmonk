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
 * @author lito-
 */
public class PuertaM2 extends StaticEntity{
    public PuertaM2(Manejador manejador, float x, float y){
       super(manejador, x, y, 96, 96);
       
       orillas.x = 0;
       orillas.y = 0;
       orillas.width = 96;
       orillas.height = 78;
               
    } 

    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Efectos.puertas2[0], (int)(x - manejador.getCamara().getxOffset()),(int)(y - manejador.getCamara().getyOffset()),width,height, null);
    }
    
}
    

