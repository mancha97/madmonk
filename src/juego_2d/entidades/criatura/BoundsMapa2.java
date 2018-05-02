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
public class BoundsMapa2 {
    private Rectangle[] boundsMapa2;
    public BoundsMapa2(){
        boundsMapa2 = new Rectangle[33];
        
        boundsMapa2[0] = new Rectangle(613, 9, 821, 120);
        boundsMapa2[1] = new Rectangle(635, 127, 314, 20);
        boundsMapa2[2] = new Rectangle(1095, 127, 314, 20);
        boundsMapa2[3] = new Rectangle(105, 117, 481, 123);
        boundsMapa2[4] = new Rectangle(1480, 117, 481, 123);
        boundsMapa2[5] = new Rectangle(129, 234, 100, 123);
        boundsMapa2[6] = new Rectangle(225, 234, 337, 24);
        boundsMapa2[7] = new Rectangle(563, 119, 76, 460);
        boundsMapa2[8] = new Rectangle(1410, 119, 76, 460);
        boundsMapa2[9] = new Rectangle(1654, 236, 263, 33);
        boundsMapa2[10] = new Rectangle(105, 239, 26, 463);
        boundsMapa2[11] = new Rectangle(128, 415, 51, 48);
        boundsMapa2[12] = new Rectangle(415, 456, 147, 97);
        boundsMapa2[13] = new Rectangle(818, 260, 97, 93);
        boundsMapa2[14] = new Rectangle(1128, 260, 97, 93);
        boundsMapa2[15] = new Rectangle(1484, 456, 147, 97);
        boundsMapa2[16] = new Rectangle(1866, 352, 51, 48);
        boundsMapa2[17] = new Rectangle(1918, 236, 26, 463);
        boundsMapa2[18] = new Rectangle(128, 544, 97, 147);
        boundsMapa2[19] = new Rectangle(225, 613, 97, 77);
        boundsMapa2[20] = new Rectangle(982, 353, 89, 93);
        boundsMapa2[21] = new Rectangle(1818, 499, 99, 194);
        boundsMapa2[22] = new Rectangle(105, 690, 480, 121);
        boundsMapa2[23] = new Rectangle(563, 620, 76, 193);
        boundsMapa2[24] = new Rectangle(818, 492, 97, 93);
        boundsMapa2[25] = new Rectangle(1128, 492, 97, 93);
        boundsMapa2[26] = new Rectangle(1410, 620, 76, 193);
        boundsMapa2[27] = new Rectangle(1459, 690, 480, 121);
        boundsMapa2[28] = new Rectangle(618, 710, 350, 131);
        boundsMapa2[29] = new Rectangle(1071, 710, 357, 131);
        boundsMapa2[30] = new Rectangle(806, 827, 25, 253);
        boundsMapa2[31] = new Rectangle(1212, 827, 25, 253);
        boundsMapa2[32] = new Rectangle(806, 1076, 434, 108);
    }
    
    public  Rectangle getBounds2(int i) {
        return boundsMapa2[i];
    }
}
