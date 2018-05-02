/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author raalv
 */
public class UIPlay extends UIObject{

    private BufferedImage[] images;
    private ClickListener clicker;
    
    public UIPlay(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {    }

    @Override
    public void render(Graphics g) {
        if(encima){
            
            g.drawImage(images[1], 392, 401 ,149, 87, null);
        }else{
             g.drawImage(images[0], 413, 414, 98, 60, null);
        }
    }

    @Override
    public void onClick() {
        clicker.click();
    }
    
}
