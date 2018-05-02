/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.utils;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import juego_2d.entidades.criatura.Jugador;

/**
 *
 * @author raalv
 */
public class Reloading implements Runnable{
    public Thread hilo;
    public int recarga;
    public ArrayList balas;
    public int x,y;
    boolean pito;
    private boolean ejecutando=true;
    
    public Reloading(){     
    }
    
    public void Agregar(){    
        try {
            Jugador.marcelo = true;
            Thread.sleep(1000);
            Jugador.marcelo = false;
            Jugador.recarga=0;
        } catch (InterruptedException ex) {
            Logger.getLogger(Reloading.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        Agregar();
    }
    public synchronized void iniciar() {    
        hilo = new Thread(this);
        hilo.start();
    }
    
    public synchronized void detener() {
        if (!ejecutando) {
            return;
        }
        ejecutando = false;
        try {
            hilo.join();
        } catch (InterruptedException ex) {
            System.out.println("Conexión interrumpida.");
            //Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
