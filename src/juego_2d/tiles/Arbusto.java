/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.tiles;

import java.awt.image.BufferedImage;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author raalv
 */
public class Arbusto extends Tile{
    
    public Arbusto( int id) {
        super(Efectos.arbusto, id);
    }
    
    @Override
     public boolean isSolid(){
        return true;
    }
}
