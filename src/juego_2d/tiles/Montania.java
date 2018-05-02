/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.tiles;

import juegos_2d.graficos.Efectos;

/**
 *
 * @author raalv
 */
public class Montania extends Tile{
    public Montania(int id){
        super(Efectos.montania, id);
    }
    @Override
     public boolean isSolid(){
        return true;
    }
}
