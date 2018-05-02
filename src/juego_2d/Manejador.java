/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d;

import static juego_2d.Juego.FPSS;
import juego_2d.estado.estado;
import juego_2d.input.ControlMouse;
import juego_2d.input.ControlTeclado;
import juego_2d.mundos.InstruccionesMundo;
import juego_2d.mundos.Mundo;
import juego_2d.mundos.Mundo2;
import juego_2d.mundos.Mundo3;
import juegos_2d.graficos.Camara;

/**
 *
 * @author raalv
 */
public class Manejador {
    private Juego juego;
    private Mundo mundo;
    private estado estado;
    private InstruccionesMundo instrucciones;
    private Mundo2 mundo2;
    private Mundo3 mundo3;
    public int banderita = 10;
    
    public static int getFPS(){
        return FPSS;
    }
    
    public Manejador(Juego juego){
        this.juego = juego;
    }
    
    public void setBanderita(int banderita){
        this.banderita = banderita;
    }
    
    public int getBanderita(){
        return banderita;
    }
    
    public Camara getCamara(){
        return juego.getCamara();
    }
    
    public ControlTeclado getTeclado(){
        return juego.getTeclado();
    }
    
    public ControlMouse getMouse(){
        return juego.getMouse();
    }
    
    public int getWidth(){
        return juego.getWidth();
    }
    
    public int getHeight(){
        return juego.getHeight();
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public Mundo getMundo() {
        return mundo;
    }
    public Mundo2 getMundo2() {
        return mundo2;
    }
    public Mundo3 getMundo3() {
        return mundo3;
    }
    public void setMundo(Mundo mundo) {
        this.mundo = mundo;
    }
    
    public void setInstrucciones(InstruccionesMundo instrucciones){
        this.instrucciones = instrucciones;
    }
    public void setMundo2(Mundo2 mundo2){
        this.mundo2 = mundo2;
    }
    
    public estado getEstado(){
        return estado;
    }
    
    public void setMundo3(Mundo3 mundo3){
        this.mundo3 = mundo3;
    }
    
}
