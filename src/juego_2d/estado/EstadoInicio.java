/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.estado;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import juego_2d.Manejador;
import juegos_2d.graficos.Animacion;
import juegos_2d.graficos.Efectos;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author raalv
 */
public class EstadoInicio extends estado{
    //private Animacion loading;
    //Thread hilo;
   
    public Runnable hilo = new Loading();
    private int cont = 0, hola;
    //Random rnd = new Random();
    Image iconi = new ImageIcon("Recursos/Texturas/Inicio.gif").getImage();
    public EstadoInicio(Manejador manejador) {
        super(manejador);
        //loading = new Animacion(1000, Efectos.loading);
        
    }

    @Override
    public void actualizar() {
       // loading.tick();
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
               // hola = ThreadLocalRandom.current().nextInt(4000, 8500 + 1);
                        //(int)(rnd.nextDouble()*(8000 + 5000))
                        
                manejador.setBanderita(9);
                Thread.sleep(11000);
                System.out.println("INICIO");
                estado.setEstado(manejador.getJuego().estadoMenu);
//                switch (manejador.getBanderita()) {
//                    case 0:
//                        cont = 0;m
//                        estado.setEstado(manejador.getJuego().estadoJuego);
//                        break;
//                    case 1:
//                        cont = 0;
//                        estado.setEstado(manejador.getJuego().estadoHowTo);
//                        break;
//                    case 2:
//                        cont = 0;
//                        estado.setEstado(manejador.getJuego().estadoJuego2);
//                        break;
//                    default:
//                        break;
//                }
            } catch (InterruptedException ex) {
                System.out.println("jsfd");
            }
        }
        public synchronized void iniciar() {
        
            
        }
        
    }
}
