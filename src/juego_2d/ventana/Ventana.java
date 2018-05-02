
package juego_2d.ventana;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Marcelo
 */
public class Ventana extends JFrame{
    private JFrame frame;
    private Canvas canva;
    
    private String titulo;
    private int alto, ancho;
    
    public Ventana(String titulo, int ancho, int alto){
        this.titulo = titulo;
        this.alto = alto;
        this.ancho = ancho;
        
        crearVentana();
    }
    
    private void crearVentana(){
        frame = new JFrame(titulo);
        frame.setSize(ancho, alto);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        canva = new Canvas();
        canva.setPreferredSize(new Dimension(ancho, alto));
        canva.setMaximumSize(new Dimension(ancho, alto));
        canva.setMinimumSize(new Dimension(ancho, alto));
        canva.setFocusable(false);//puede funcionar en algunos lados y hace que la aplicacion se concentre en el movimiento o presion de teclas
    
        frame.add(canva);
        frame.pack();//Ajusta la vantana con el canvas para que este se vea completamente 
    }
    
    public Canvas getCanva(){
        return canva;
    }
    
    public JFrame getFrame(){
        return frame;
    }
    
}
