/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import juego_2d.Manejador;

/**
 *
 * @author raalv
 */
public class UIManager {
    private Manejador manejador;
    private ArrayList<UIObject> objects;
    
    public UIManager(Manejador manejador){
        this.manejador = manejador;
        objects =  new ArrayList<UIObject>();
    }
    
    public void tick(){
        for(UIObject o : objects)
            o.tick();
    }
    public void render(Graphics g){
        for(UIObject o : objects)
            o.render(g);
    }
    
    public void onMouseMove(MouseEvent e){
        for(UIObject o : objects)
            o.onMouseMove(e);
    }
    
    public void onMouseRelease(MouseEvent e){
        for(UIObject o : objects)
            o.onMouseReleased(e);
    }
    
    public void addObject(UIObject o){
        objects.add(o);
    }
    
    public void removeObject(UIObject o){
        objects.remove(o);
    }

    public Manejador getManejador() {
        return manejador;
    }

    public void setManejador(Manejador manejador) {
        this.manejador = manejador;
    }

    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }
    
    
}
