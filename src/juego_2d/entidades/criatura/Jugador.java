/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.entidades.criatura;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import juego_2d.Manejador;
import juego_2d.estado.EstadoMenu;
import juego_2d.estado.estado;
import juegos_2d.graficos.Animacion;
import juegos_2d.graficos.Efectos;
import juego_2d.utils.Reloading;

/**
 *
 * @author lito-
 */
public class Jugador extends Criatura{
    
    //Animaciones
    private Animacion animDown,animUp, animLeft, animRight, animDead;
    private int cont = 0, c = 0;
    boolean pito = true;
    public static int bandera = 0,auxbandera=0;
    public static boolean band=true;
    public static int recarga=0;
    private Graphics g;
    private ArrayList listamisi= new ArrayList();
    public static ArrayList direccion= new ArrayList();
    private Runnable bala= new Misil(manejador,getX(),getY(), listamisi); 
    public static float vidaActualJ;
    private int vidaMax;
    private int posXJ, posYJ, contRender;
    public static boolean pancha = true;
    public static boolean marcelo;
    public static int orillaswidthJ, orillasheightJ;
    
    public Jugador(Manejador manejador, float x, float y){
        super(manejador, x, y, Criatura.DEFAULT_CREATURE_WIDTH, Criatura.DEFAULT_CREATURE_HEIGHT);
        orillas.x = 15;
        orillas.y = 25;
        orillas.width = 14;
        orillas.height = 20;
        orillaswidthJ = orillas.width;
        orillasheightJ = orillas.height;
        
        vidaActualJ = Criatura.DEFAULT_HEALTH;
        vidaMax = (int)vidaActualJ;
        
        //Animaciones
        animDown = new Animacion(500, Efectos.pelon_abajo);
        animLeft = new Animacion(500, Efectos.pelon_izq);
        animUp = new Animacion(500, Efectos.pelon_arriba);
        animRight = new Animacion(500, Efectos.pelon_der);
        animDead = new Animacion(70, Efectos.puff);
    }

    @Override
    public void tick() {
        if(pancha){
        //Animaciones
        animDown.tick();
        animLeft.tick();
        animUp.tick();
        animRight.tick();
        new Thread(bala).start();
        //Movimientos   
        getInput();
        move();
        manejador.getCamara().centrarEnEntidad(this);
        }else{
            animDead.tickMuerte();
        }
    }
    
    public int getRecarga() {
        return recarga;
    }

    public void setRecarga(int recarga) {
        this.recarga = recarga;
    }
    
    public void fire() {    
        if(band){
            auxbandera=bandera;
            if (auxbandera==1){
                Efectos.setActualmisi(Efectos.missileizq);
            }
            if (auxbandera==2){
                Efectos.setActualmisi(Efectos.missileder);
            }
            if (auxbandera==3){
                Efectos.setActualmisi(Efectos.missilearri);
            }if (auxbandera==0){
                Efectos.setActualmisi(Efectos.missileaba);
            }
            band=false;
        }
        if (recarga<5){
            listamisi.add(new Rectangle((int)getX(),(int)getY(),32,32));
            direccion.add(auxbandera);
            recarga++;
        }
        else{
            
        }
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;
        if(estado.getEstado().equals(manejador.getJuego().estadoHowTo)){
           if(manejador.getTeclado().k){
               manejador.setBanderita(0);
               estado.setEstado(manejador.getJuego().estadoLoading);
           }
        }
        
        if(manejador.getTeclado().recarga){
            Runnable timer= new Reloading();
            new Thread(timer).start();
        }
        if(manejador.getTeclado().space){   
            if (marcelo){
                }else{fire();
                band=true;
            }
            
            
        }
        if(manejador.getTeclado().arriba)
           yMove = -speed; 
        if(manejador.getTeclado().abajo)
           yMove = speed; 
        if(manejador.getTeclado().izq)
           xMove = -speed; 
        if(manejador.getTeclado().der)
           xMove = speed; 
        if(manejador.getTeclado().shift){
            speed = 3.8f;   
            animDown.setSpeed(100);
            animLeft.setSpeed(100);
            animUp.setSpeed(100);
            animRight.setSpeed(100);
        }else{ 
            speed = 1.8f;
            animDown.setSpeed(500);
            animLeft.setSpeed(500);
            animUp.setSpeed(500);
            animRight.setSpeed(500);;
        }
    }
    
    @Override
    public void render(Graphics g) {
        if(vidaActualJ > 0){
            g.drawImage(getCurrentAnimationFrame(), (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()), width, height, null);
            DibujarVida(g, (int) (x - manejador.getCamara().getxOffset()), (int) (y - manejador.getCamara().getyOffset()));
        }else{
            if(pancha){
                posXJ = (int) (x);
                posYJ = (int) (y);
                pancha = false;
            }
            g.drawImage(getDeadAnimation(),(int) (x  - manejador.getCamara().getxOffset())-24, (int)(y  - manejador.getCamara().getyOffset()), width+20, height+20, null);
            orillas.width = 24;
            orillas.height = 20;
            if(vidaActualJ <= -15)
                estado.setEstado(manejador.getJuego().estadoGO);
        }
    }
    
    public BufferedImage getDeadAnimation(){
        return animDead.getCurrentFrame();
    }
    
    private BufferedImage getCurrentAnimationFrame(){
        if(xMove < 0){
            bandera = 1;
            return animLeft.getCurrentFrame();
        }else if(xMove > 0){
            bandera = 2;
            return animRight.getCurrentFrame();
        }else if(yMove < 0){
            bandera = 3;
            return animUp.getCurrentFrame();
        }else if(yMove > 0){
            bandera = 0;
            return animDown.getCurrentFrame();
        }else{
            if(bandera == 3)
                return animUp.getEstatic();
            if(bandera == 2)
                return animRight.getEstatic();
            if(bandera == 1)
                return animLeft.getEstatic();
            if(bandera == 0){
                if(c==0){
                    c++;
                }
                return animDown.getEstatic();
            }else{
                return animDown.getEstatic();
            }
        }
    }
    
    private void DibujarVida(Graphics g, int x, int y){
        g.setColor(Color.GREEN);
        g.fillRect(x +11, y - 5 , (int) (vidaActualJ/vidaMax * (orillas.width *2)), 2);
    }
    
    public ArrayList getListamisi() {
        return listamisi;
    }
    
    public Rectangle getOrillas() {
        return this.orillas;
    }
    
    public float getvidaActual(){
        return vidaActualJ;
    }
    public void setvidaActual(float vida){
        vidaActualJ = vida;
    }
    
    
}
