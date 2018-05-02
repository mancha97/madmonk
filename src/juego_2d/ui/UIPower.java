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
public class UIPower extends UIObject{
      private BufferedImage[] images;
    private ClickListener clicker;
    
    public UIPower(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    @Override
    public void tick() {    }

    @Override
    public void render(Graphics g) {
        if(encima){ 
            g.drawImage(images[1], 5, 5 ,50, 50, null);
        }else{
             g.drawImage(images[0], 5, 5, 50, 50, null);
        }
    }

    @Override
    public void onClick() {
        clicker.click();
    }
    
}