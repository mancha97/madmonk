/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.estado;

import java.awt.Graphics;
import juego_2d.Juego;
import juego_2d.Manejador;

/**
 *
 * @author lito-
 */
public abstract class estado {
    
    private static estado estadoActual = null;
    //public static int banderita = 10;
    
    //El manager de los estados
    public static void setEstado(estado estado){
        estadoActual = estado;
    }
    
    public static estado getEstado(){
        return estadoActual;
    }
//    public static void setBanderita(int banderita){
//        estado.banderita = banderita;
//    }
//    
//    public static int getBandertia(){
//        return banderita;
//    }
    //METODOS DE LA CLASE ESTADO
    protected Manejador manejador;
    
    public estado(Manejador manejador){
        this.manejador = manejador;
    }
    
    public abstract void actualizar();
    
    public abstract void renderizar(Graphics g);
    
}
