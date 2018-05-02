/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.estado;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import juego_2d.Manejador;
import juegos_2d.graficos.Animacion;
import juegos_2d.graficos.Efectos;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raalv
 */
public class EstadoWIN extends estado{
   
    public Runnable hilo = new Loading();
    
    private int cont = 0, hola;
    Image iconi = new ImageIcon("Recursos/Texturas/winner.gif").getImage();
    
    public EstadoWIN(Manejador manejador) {
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
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 950, 650);
        g.drawImage(iconi, 150, 75, 650, 315, null);
        g.drawImage(Efectos.madmonk, 400, 400, 145,145,null);
        
    }
    
    private class ventana extends JFrame{
        private JTextField txtNombre;
        private JButton ok;
        private int cantidad = 0;
        private JTable table;
        private DefaultTableModel model;
        private HashMap<Integer, String> Champions;
        private JFrame frame;
        private Canvas canvas;
        
        private String titulo;
        private int alto, ancho;
        
        public ventana(String titulo, int ancho, int alto){
            super(titulo);
            this.titulo = titulo;
            this.alto = alto;
            this.ancho = ancho;

            crearVentana();
        }
        
        private void crearVentana(){
            Champions = new HashMap<>();    
            model = new DefaultTableModel();
            model.addColumn("NOMBRE");
            table = new JTable(model);
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));

            JPanel panelForm = new JPanel();
            GridLayout gl = new GridLayout(3,1, 3, 3);
            panelForm.setLayout(gl);
            panelForm.add(new JLabel("NOMBRE: "));
            txtNombre = new JTextField();
            panelForm.add(txtNombre);
            ok = new JButton ("AGREGAR CAMPEON");
            panelForm.add(ok);

            Container cp = getContentPane();
            cp.add(panelForm, BorderLayout.CENTER);

            ok.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(txtNombre.getText().isEmpty()){
                        JOptionPane.showMessageDialog(ventana.this, "Ingrese nombre antes de continuar.", "Error!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        
                        FileWriter fichero = null;
                        try {
                            fichero = new FileWriter("Recursos/champ.txt");
                            fichero.write(txtNombre.getText());
                            fichero.close();
                        } catch (IOException ex) {
                            Logger.getLogger(EstadoWIN.class.getName()).log(Level.SEVERE, null, ex);
                  
                        }
                        Champions.put(cantidad, txtNombre.getText());
                        System.out.println(Champions.get(cantidad));
                        txtNombre.setEnabled(false);
                        ok.setEnabled(false);
                        cantidad++;
                    }
                }

            });

            setSize(ancho, alto);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(true);
                setResizable(false);
        }
    
    public Canvas getCanva(){
        return canvas;
    }
    
    public JFrame getFrame(){
        return frame;
    }
    }
    
    private class Loading implements Runnable{
        
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                ventana h = new ventana("FELICIDADES ", 320, 130);
            } catch (InterruptedException ex) {
                System.out.println("Error");
            }
        }
 
        public synchronized void iniciar() {
        
            
        }
        
    }
}
