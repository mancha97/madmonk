/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.estado;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import juego_2d.Manejador;

/**
 *
 * @author raalv
 */
public class EstadoGO extends estado{
   
    public Runnable hilo = new Loading();
    
    private int cont = 0, hola;
    Image iconi = new ImageIcon("Recursos/Texturas/gameover.gif").getImage();
    
    public EstadoGO(Manejador manejador) {
        super(manejador);
        
    }

    @Override
    public void actualizar() {
       if(cont < 1){
            cont++;
            new Thread(hilo).start();
        }
    }

    @Override
    public void renderizar(Graphics g) {
        g.drawImage(iconi, 0, 0, 950, 650, null);
        
    }
    
   
    private class Loading implements Runnable{
        
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                System.exit(0);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
 
        public synchronized void iniciar() {
        
            
        }
        
    }
}
