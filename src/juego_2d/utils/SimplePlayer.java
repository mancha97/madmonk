/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.utils;

import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 *
 * @author raalv
 */
public class SimplePlayer implements Runnable{
    public int id;
    public static boolean h = false;
    
    public SimplePlayer(int id ){
        this.id=id;
    }
    public void Loader(){
        if( id==1){
            try{
                FileInputStream fis = new FileInputStream("Recursos/mp3/menu.mp3");
                Player playMP3 = new Player(fis);
                 playMP3.play();
            }catch(Exception e){System.out.println(e);}
        }
    }
    @Override
    public void run() {    
        while (!h) {
            System.out.println("hilo musica");
            Loader();
        }
    }
    public void shutdown() {
       h = true;
    }
}
