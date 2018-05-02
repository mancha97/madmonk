/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.criatura;

import java.awt.Graphics;
import java.awt.Rectangle;
import juego_2d.Manejador;

/**
 *
 * @author Carlos
 */
public class Bounds {
    
      
    private Rectangle[] boundy;
    public Bounds(){
        boundy= new Rectangle[15];
        boundy[0]= new Rectangle(0,0,415,730);
        boundy[1]= new Rectangle(641, 0, 671, 611);
        boundy[2]= new Rectangle(1313, 0, 733, 135);
        boundy[3]= new Rectangle(415, 673, 407, 72);
        boundy[4]= new Rectangle(1541, 253, 209, 833);
        boundy[5]= new Rectangle(1912, 138, 136, 1046);
        boundy[6]= new Rectangle(0, 730, 1546, 203);
        boundy[7]= new Rectangle(1171, 867, 380, 216);
        boundy[8]= new Rectangle(644, 926, 148, 33);
        boundy[9]= new Rectangle(675, 960, 88, 62);
        boundy[10]= new Rectangle(962, 982, 221, 104);
        //boundy[11]= new Rectangle(672,1056,96,128);
        boundy[11]= new Rectangle(675, 1116, 88, 62);
        boundy[12] = new Rectangle(402, 0, 247, 265);
        boundy[13] = new Rectangle(0, 1180, 2048, 10);
        boundy[14] = new Rectangle(0, 900,10 , 284);
       
    }

   
   

    public  Rectangle getBoundy(int i) {
        return boundy[i];
    }
   
   
    
    
    
}
