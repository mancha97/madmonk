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
public class EstadoLoading extends estado{
    //private Animacion loading;
    //Thread hilo;
   
    public Runnable hilo = new Loading();
    private int cont = 0, hola;
    //Random rnd = new Random();
    Image icon = new ImageIcon("Recursos/Texturas/loading.gif").getImage();
    public EstadoLoading(Manejador manejador) {
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
        
        g.setColor(Color.decode("#2A80B9"));
        g.fillRect(0, 0 , 950, 650);
        g.drawImage(icon, 75, 25, 800, 600, null);
        
    }
    
    private class Loading implements Runnable{
        
        @Override
        public void run() {
            try {
                hola = ThreadLocalRandom.current().nextInt(4000, 8500 + 1);
                        //(int)(rnd.nextDouble()*(8000 + 5000));
                Thread.sleep(hola);
                System.out.println("sdafasdfsdf");
                switch (manejador.getBanderita()) {
                    case 0:
                        cont = 0;
                        estado.setEstado(manejador.getJuego().estadoJuego);
                        break;
                    case 1:
                        cont = 0;
                        estado.setEstado(manejador.getJuego().estadoHowTo);
                        break;
                    case 2:
                        cont = 0;
                        estado.setEstado(manejador.getJuego().estadoJuego2);
                        break;
                    case 3:
                        cont = 0;
                        estado.setEstado(manejador.getJuego().estadoJuego3);
                        break;
                    case 8:
                        cont = 0;
                        estado.setEstado(manejador.getJuego().estadoChamp);
                    default:
                        break;
                }
            } catch (InterruptedException ex) {
                System.out.println("jsfd");
            }
        }
        public synchronized void iniciar() {
        
            
        }
        
    }
}
