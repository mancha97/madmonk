/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.estado;

import java.awt.Graphics;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import juego_2d.Juego;
import juego_2d.Manejador;
import juego_2d.ui.ClickListener;
import juego_2d.ui.UIChamp;
import juego_2d.ui.UIInstrucciones;
import juego_2d.ui.UIManager;
import juego_2d.ui.UIPlay;
import juego_2d.ui.UIPower;
import juego_2d.utils.SimplePlayer;
import juegos_2d.graficos.Efectos;

/**
 *
 * @author lito-
 */
public class EstadoMenu extends estado{
    
    Image icono = new ImageIcon("Recursos/Texturas/Menu.gif").getImage();
    public static int CONTADOR = 1;
    private UIManager uimanager;
    private Runnable menu = new SimplePlayer(1);
    Thread h = new Thread(menu);
    
        @Override
    public void actualizar() {
        uimanager.tick();

    }

    @Override
    public void renderizar(Graphics g) {
        g.drawImage(icono, 0, 0, manejador.getWidth(), manejador.getHeight(), null);
        uimanager.render(g);
    }
    

    public EstadoMenu(Manejador manejador){
        super(manejador);
        uimanager = new UIManager(manejador);
        manejador.getMouse().setUIManager(uimanager);
        h.start();
        uimanager.addObject(new UIPlay(413, 414, 98, 60, Efectos.play, new ClickListener(){
            @Override
            public void click() {
                h.stop();
                manejador.getMouse().setUIManager(null);
                manejador.setBanderita(0);
                estado.setEstado(manejador.getJuego().estadoLoading);
            }
        }));
        uimanager.addObject(new UIInstrucciones(325, 488, 276, 57, Efectos.howto, new ClickListener(){
            @Override
            public void click() {
               h.stop();
               manejador.getMouse().setUIManager(null);
               manejador.setBanderita(1);
               estado.setEstado(manejador.getJuego().estadoLoading);
            }
        }));
        uimanager.addObject(new UIChamp(331, 575, 240, 68, Efectos.champ, new ClickListener(){
            @Override
            public void click() {
               
               manejador.getMouse().setUIManager(null);
               manejador.setBanderita(8);
               estado.setEstado(manejador.getJuego().estadoLoading);
            }
        }));
        uimanager.addObject(new UIPower(0, 0, 50, 50, Efectos.power, new ClickListener(){
            @Override
            public void click() {
               System.exit(0);
            }
        }));
    }

    public void setCont(int contador){
        this.CONTADOR = contador;
    }

}
