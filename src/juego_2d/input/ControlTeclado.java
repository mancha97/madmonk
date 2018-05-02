/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author lito-
 */
public class ControlTeclado implements KeyListener {
    
    private boolean[] teclas;
    public boolean arriba, abajo, izq, der, shift, space=false, recarga=false,k;
    int c=0, x=0;
    boolean pito = false;
    boolean r = false;
    
    public ControlTeclado(){
        teclas = new boolean[256];
    }
    
    public void tick(){
        arriba = teclas[KeyEvent.VK_W];
        abajo = teclas[KeyEvent.VK_S];
        izq = teclas[KeyEvent.VK_A];
        der = teclas[KeyEvent.VK_D];
        shift = teclas[KeyEvent.VK_SHIFT];
        k = teclas[KeyEvent.VK_K];
        if(c==0){
            space= pito;
            pito=false;
        }
        if(x==0){
            recarga=r;
            r=false;
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(teclas[KeyEvent.VK_SPACE ]){
            c++; 
            space=false;    
        }
        if(teclas[KeyEvent.VK_R ]){
            x++; 
            recarga=false;    
        }
        if(teclas[KeyEvent.VK_SPACE] && teclas[e.getKeyCode()]){
            teclas[e.getKeyCode()] = true;
        }else
        if(teclas[KeyEvent.VK_R] && teclas[e.getKeyCode()]){
            teclas[e.getKeyCode()] = true;
        }else{
            teclas[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
        c=0;
        x=0;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (teclas[KeyEvent.VK_SPACE ]&& c==0){  
            pito=true;
        }
        if (teclas[KeyEvent.VK_R]&& x==0){  
            r=true;
        }
        if(x!=0 && teclas[KeyEvent.VK_R]){
            recarga=false;
        } 
        if(c!=0 && teclas[KeyEvent.VK_SPACE]){
            space=false;
        } 
        else{
            teclas[e.getKeyCode()] = false;
        }
    }
    public boolean isSpace() {
        return space;
    }

    public void setSpace(boolean space) {
        this.space = space;
    }
    
}
