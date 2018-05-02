/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.estado;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import juego_2d.Juego;
import static juego_2d.Juego.FPSS;
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
public class EstadoChamp extends estado{
    String linea;
    Image icono = new ImageIcon("Recursos/Texturas/Menu.gif").getImage();
    public static int CONTADOR = 1;
    private UIManager uimanager;
    
        @Override
    public void actualizar() {
        uimanager.tick();

    }

    @Override
    public void renderizar(Graphics g) {
        g.drawImage(icono, 0, 0, manejador.getWidth(), manejador.getHeight(), null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 35));
        g.setColor(Color.WHITE);
        g.drawString(linea,(int) (300),(int) (200));
        uimanager.render(g);
    }
    

    public EstadoChamp(Manejador manejador){
        super(manejador);
        uimanager = new UIManager(manejador);
        File fichero = new File("Recursos/champ.txt");
        Scanner s = null;
        try {
            s = new Scanner(fichero);
            while(s.hasNextLine()){
                linea = s.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EstadoChamp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public void setCont(int contador){
        this.CONTADOR = contador;
    }

}
