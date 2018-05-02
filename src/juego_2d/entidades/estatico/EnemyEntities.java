/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.estatico;

import juego_2d.Manejador;
import juego_2d.entidades.Entidad;

/**
 *
 * @author raalv
 */
public abstract class EnemyEntities extends Entidad{
    public EnemyEntities(Manejador manejador, float x, float y, int width, int height){
       super(manejador, x, y, width, height);
   } 
}
