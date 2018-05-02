/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author raalv
 */
public abstract class UIObject {
    
    protected float x, y;
    protected int width, height;
    protected Rectangle orilla;
    protected boolean encima = false;
    
    public UIObject(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        orilla = new Rectangle((int)(x), (int)(y), width, height);
    }

    public abstract void tick();
    
    public abstract void render(Graphics g);
    
    public abstract void onClick();
    
    public void onMouseMove(MouseEvent e){
        if(orilla.contains(e.getX(), e.getY())){
            encima = true;
        }else{encima = false;}
    }
    
    public void onMouseReleased(MouseEvent e){
        if(encima){
            onClick();
        }
    }
    
    //Getter and setters
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isEncima() {
        return encima;
    }

    public void setEncima(boolean encima) {
        this.encima = encima;
    }
    
    
}
