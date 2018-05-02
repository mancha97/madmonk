/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos_2d.graficos;

import java.awt.image.BufferedImage;

/**
 *
 * @author lito-
 */
public class SpriteSheet {
    
    private BufferedImage sheet;
    
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }
    
    public BufferedImage cortar(int x, int y, int ancho, int alto){
        return sheet.getSubimage(x, y, ancho, alto);
    }
    
    
    
}
