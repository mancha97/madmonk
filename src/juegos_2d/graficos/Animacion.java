/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos_2d.graficos;

import java.awt.image.BufferedImage;

/**
 *
 * @author raalv
 */
public class Animacion {
    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;
    
    public Animacion(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }
    
    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        if(timer > speed){
            index++;
            timer = 0;
            if(index >= frames.length)
                index = 0;
        }
    }
    
    public void tickMuerte(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        
        if(timer > speed){
            index++;
            timer = 0;
            if(index >= frames.length)
                index = 10;
        }
    }
    
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
    
    public BufferedImage getEstatic(){
        return frames[1];
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
}

