/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.criatura;

import java.awt.Rectangle;

/**
 *
 * @author raalv
 */
public class BoundsInstrucciones {
        
      
    private Rectangle[] boundies;
    public BoundsInstrucciones(){
        boundies= new Rectangle[17];
        boundies[0]= new Rectangle(0,0,754,253);
        boundies[1]= new Rectangle(800,0,850,256);
        boundies[2]= new Rectangle(0,497,561,79);
        boundies[3]= new Rectangle(0,576,66,391);
        boundies[4]= new Rectangle(0,896,113,128);
        boundies[5]= new Rectangle(0,1024,371,144);
        boundies[6]= new Rectangle(481,576,79,240);
        boundies[7]= new Rectangle(481,816,432,78);
        boundies[8]= new Rectangle(961,783,161,258);
        boundies[9]= new Rectangle(1122,783,95,51);
        boundies[10]= new Rectangle(944,386,181,350);
        boundies[11]= new Rectangle(1125,638,235,97);
        boundies[12]= new Rectangle(1409,637,163,43);
        boundies[13] = new Rectangle(1572,305,78 ,782);
        boundies[14] = new Rectangle(0,1180,2048 ,10);
        boundies[15] = new Rectangle(2038,0,10 ,1184);
        boundies[15] = new Rectangle(0,0,2048 ,10);
       
    }

   
   

    public  Rectangle getBoundies(int i) {
        return boundies[i];
    }
   
   
}
