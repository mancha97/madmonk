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
public class BoundsMapa3 {
    private Rectangle[] boundsMapa3;
    public BoundsMapa3(){
        boundsMapa3 = new Rectangle[25];
        
        boundsMapa3[0] = new Rectangle(720, 8, 603, 121);
        boundsMapa3[1] = new Rectangle(482, 127, 265, 121);
        boundsMapa3[2] = new Rectangle(359, 246, 146, 121);
        boundsMapa3[3] = new Rectangle(359, 367, 26, 460);
        boundsMapa3[4] = new Rectangle(359, 823, 147, 121);
        boundsMapa3[5] = new Rectangle(482, 944, 265, 121);
        boundsMapa3[6] = new Rectangle(723, 1064, 602, 120);
        boundsMapa3[7] = new Rectangle(1302, 944, 265, 121);
        boundsMapa3[8] = new Rectangle(1543, 824, 147, 121);
        boundsMapa3[9] = new Rectangle(1663, 368, 26, 460);
        boundsMapa3[10] = new Rectangle(1541, 248, 146,121);
        boundsMapa3[11] = new Rectangle(784, 127, 101, 67);
        boundsMapa3[12] = new Rectangle(924, 127, 202, 18);
        boundsMapa3[13] = new Rectangle(1147, 127, 151, 17);
        boundsMapa3[14] = new Rectangle(505, 247, 144, 22);
        boundsMapa3[15] = new Rectangle(1297, 249, 244, 22);
        boundsMapa3[16] = new Rectangle(385, 355, 95, 160);
        boundsMapa3[17] = new Rectangle(1565, 367, 99, 217);
        boundsMapa3[18] = new Rectangle(384, 632, 99, 193);
        boundsMapa3[19] = new Rectangle(1564, 749, 97, 74);
        boundsMapa3[20] = new Rectangle(839, 867, 45, 114);
        boundsMapa3[21] = new Rectangle(1160, 869, 46, 112);
        boundsMapa3[22] = new Rectangle(913, 952, 45, 114);
        boundsMapa3[23] = new Rectangle(1089, 954, 45, 114);
        boundsMapa3[24] = new Rectangle( 1541, 248, 146,121);
       
    }
    
    public  Rectangle getBounds3(int i) {
        return boundsMapa3[i];
    }
}

