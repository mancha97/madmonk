/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos_2d.graficos;

import java.awt.image.BufferedImage;

/**
 *
 * @author lito-
 */
public class Efectos {
    
    private static final int ancho = 37, alto = 37;
    private static final int anchoj = 47, altoj = 49;
    private static final int anchom = 48, altom = 48;
    
    public static BufferedImage menu, instruccion, loading, madmonk;
    public static BufferedImage[] cristal1, cristal2, cristal3, cristal4;
    public static BufferedImage[] champ, howto, play, power;
    public static BufferedImage jugador1, grama, tierra, arbusto, montania, mapa, mapa2, mapa3, larry;
    public static BufferedImage[] pelon_abajo, pelon_izq, pelon_der, pelon_arriba, puertas, puff, puertas2;
    public static BufferedImage[] monster_abajo, monster_izq, monster_der, monster_arriba;
    public static BufferedImage[] monster2_abajo, monster2_izq, monster2_der, monster2_arriba;
    public static BufferedImage missileder, missileizq, missileaba, missilearri, actualmisi;
    public static BufferedImage boss;
    
    public static void setActualmisi(BufferedImage actualmisi) {
       Efectos.actualmisi = actualmisi;
    }
    
    public static void init(){
        
        SpriteSheet boss1 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/boss.png"));
        boss = boss1.cortar(0, 0, 400, 300);
        
        SpriteSheet muerte = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/muerte.png"));
        larry = muerte.cortar(48, 0, 48, 48);
        
        SpriteSheet sheet = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/missileder.png"));
        missileder=sheet.cortar(0, 0, 32, 32);
       
        SpriteSheet sheet2 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/missileder.png"));
      
        missileizq=sheet2.cortar(0, 0, 32, 32);
        SpriteSheet sheet3 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/missileder.png"));
      
        missileaba=sheet3.cortar(0, 0, 32, 32);
        SpriteSheet sheet4 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/missileder.png"));
      
        missilearri=sheet4.cortar(0, 0, 32, 32);
        
        cristal1 = new BufferedImage[3];
        cristal2 = new BufferedImage[3];
        cristal3 = new BufferedImage[3];
        cristal4 = new BufferedImage[3];
        SpriteSheet Cristales = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/crystal.png"));
        cristal1[0] = Cristales.cortar(0, 0, 48,94);
        cristal1[1] = Cristales.cortar(48, 0, 48,94);
        cristal1[2] = Cristales.cortar(48*2 , 0, 48,94);
        cristal2[0] = Cristales.cortar(48*9, 0, 48,94);
        cristal2[1] = Cristales.cortar(48*10, 0, 48,94);
        cristal2[2] = Cristales.cortar(48*11, 0, 48,94);
        cristal3[0] = Cristales.cortar(48*6, 94*2, 48,94);
        cristal3[1] = Cristales.cortar(48*7, 94*2, 48,94);
        cristal3[2] = Cristales.cortar(48*8, 94*2, 48,94);
        cristal4[0] = Cristales.cortar(48*9, 94*2, 48,94);
        cristal4[1] = Cristales.cortar(48*10, 94*2, 48,94);
        cristal4[2] = Cristales.cortar(48*11, 94*2, 48,94);

        SpriteSheet fondo = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/fondo.png"));
        
        menu = fondo.cortar(0, 0, 950, 650);
        
        play = new BufferedImage[2];
        
        SpriteSheet Play = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/Play.png"));
        play[0] = Play.cortar(0, 0, 98, 60);
        SpriteSheet Play1 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/PlayG.png"));
        play[1] = Play1.cortar(0, 0, 149, 87);
        
        SpriteSheet Loading = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/loading.gif"));
        loading = Loading.cortar(0, 0, 800, 600);
        
        howto = new BufferedImage[2];
        
        SpriteSheet HowTo = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/Howto.png"));
        howto[0] = HowTo.cortar(0, 0, 276, 57);
        SpriteSheet HowTo1 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/HowtoG.png"));
        howto[1] = HowTo1.cortar(0, 0, 400, 87);
        
        power = new BufferedImage[2];
        SpriteSheet Power = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/power-1.png"));
        power[0] = Power.cortar(0, 0, 512, 512);
        SpriteSheet Power1 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/power.png"));
        power[1] = Power1.cortar(0, 0, 512, 512);
        
        champ = new BufferedImage[2];
        
        SpriteSheet Champ = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/Champions.png"));
        champ[0] = Champ.cortar(0, 0, 240, 68);
        SpriteSheet Champ1 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/ChampionsG.png"));
        champ[1] = Champ1.cortar(0, 0, 395, 85);
        
        puertas = new BufferedImage[3];
        SpriteSheet puerta = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/puertasniveles12.png"));
        puertas[0] = puerta.cortar(0, 10, 96, 92);
        puertas[1] = puerta.cortar(96, 10, 96, 96);
        puertas[2] = puerta.cortar(195, 0, 145, 122);
        
        SpriteSheet sheet1 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/monster4.png"));
        
        
        monster_abajo = new BufferedImage[4];
        monster_izq = new BufferedImage[3];
        monster_der = new BufferedImage[3];
        monster_arriba = new BufferedImage[3];
        
        
        monster_abajo[0] = sheet1.cortar(0,0,anchom,altom);
        monster_abajo[1] = sheet1.cortar(anchom,0,anchom,altom);
        monster_abajo[2] = sheet1.cortar((anchom*2),0,anchom,altom);
        monster_abajo[3] = sheet1.cortar(anchom,0,anchom,altom);
        monster_izq[0] = sheet1.cortar(0,altom,anchom,altom);
        monster_izq[1] = sheet1.cortar(anchom,altom,anchom,altom);
        monster_izq[2] = sheet1.cortar((anchom*2),altom,anchom,altom);
        monster_der[0] = sheet1.cortar(0,(altom*2),anchom,altom);
        monster_der[1] = sheet1.cortar(anchom,(altom*2),anchom,altom);
        monster_der[2] = sheet1.cortar((anchom*2),(altom*2),anchom,altom);
        monster_arriba[0] = sheet1.cortar(0,(altom*3),anchom,altom);
        monster_arriba[1] = sheet1.cortar(anchom,(altom*3),anchom,altom);
        monster_arriba[2] = sheet1.cortar((anchom*2),(altom*3),anchom,altom);
        
        
        SpriteSheet sheetM2 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/monster7.png"));
        
        
        monster2_abajo = new BufferedImage[4];
        monster2_izq = new BufferedImage[3];
        monster2_der = new BufferedImage[3];
        monster2_arriba = new BufferedImage[3];
        
        
        monster2_abajo[0] = sheetM2.cortar(0,0,anchom,altom);
        monster2_abajo[1] = sheetM2.cortar(anchom,0,anchom,altom);
        monster2_abajo[2] = sheetM2.cortar((anchom*2),0,anchom,altom);
        monster2_abajo[3] = sheetM2.cortar(anchom,0,anchom,altom);
        monster2_izq[0] = sheetM2.cortar(0,altom,anchom,altom);
        monster2_izq[1] = sheetM2.cortar(anchom,altom,anchom,altom);
        monster2_izq[2] = sheetM2.cortar((anchom*2),altom,anchom,altom);
        monster2_der[0] = sheetM2.cortar(0,(altom*2),anchom,altom);
        monster2_der[1] = sheetM2.cortar(anchom,(altom*2),anchom,altom);
        monster2_der[2] = sheetM2.cortar((anchom*2),(altom*2),anchom,altom);
        monster2_arriba[0] = sheetM2.cortar(0,(altom*3),anchom,altom);
        monster2_arriba[1] = sheetM2.cortar(anchom,(altom*3),anchom,altom);
        monster2_arriba[2] = sheetM2.cortar((anchom*2),(altom*3),anchom,altom);
        
        SpriteSheet mapasheet = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/map1.png"));
        mapa = mapasheet.cortar(0, 0, 2048, 1184);
        
        SpriteSheet mapa2sheet = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/map2.png"));
        mapa2 = mapa2sheet.cortar(0,0,2048,1184);
        
        SpriteSheet mapa3sheet = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/map3.png"));
        mapa3 = mapa3sheet.cortar(0, 0, 2048, 1184);
        
        SpriteSheet howtoI = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/NewUn.png"));
        instruccion = howtoI.cortar(0,0, 2049, 1185);
        
        SpriteSheet player1 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/madMonk1.png"));
        
        pelon_abajo = new BufferedImage[4];
        pelon_izq = new BufferedImage[3];
        pelon_der = new BufferedImage[3];
        pelon_arriba = new BufferedImage[3];
        
        
        pelon_abajo[0] = player1.cortar(0,0,anchoj,altoj);
        pelon_abajo[1] = player1.cortar(anchoj,0,anchoj,altoj);
        pelon_abajo[2] = player1.cortar((anchoj*2),0,anchoj,altoj);
        pelon_abajo[3] = player1.cortar(anchoj,0,anchoj,altoj);
        pelon_izq[0] = player1.cortar(0,altoj,anchoj,altoj);
        pelon_izq[1] = player1.cortar(anchoj,altoj,anchoj,altoj);
        pelon_izq[2] = player1.cortar((anchoj*2),altoj,anchoj,altoj);
        pelon_der[0] = player1.cortar(0,(altoj*2),anchoj,altoj);
        pelon_der[1] = player1.cortar(anchoj,(altoj*2),anchoj,altoj);
        pelon_der[2] = player1.cortar((anchoj*2),(altoj*2),anchoj,altoj);
        pelon_arriba[0] = player1.cortar(0,(altoj*3),anchoj,altoj);
        pelon_arriba[1] = player1.cortar(anchoj,(altoj*3),anchoj,altoj);
        pelon_arriba[2] = player1.cortar((anchoj*2),(altoj*3),anchoj,altoj);
        
        SpriteSheet antesDM = new SpriteSheet (Imagenes.cargadorImagenes("Recursos/Texturas/Puff2.png"));
        
        puff = new BufferedImage[11];
        
        puff[0] = antesDM.cortar(0, 0, 128, 125);
        puff[1] = antesDM.cortar(128, 0, 128, 125);
        puff[2] = antesDM.cortar(128*2, 0, 128, 125);
        puff[3] = antesDM.cortar(128*3, 0, 128, 125);
        puff[4] = antesDM.cortar(128*4, 0, 128, 125);
        puff[5] = antesDM.cortar(128*5, 0, 128, 125);
        puff[6] = antesDM.cortar(128*6, 0, 128, 125);
        puff[7] = antesDM.cortar(128*7, 0, 128, 125);
        puff[8] = antesDM.cortar(128*8, 0, 128, 125);
        puff[9] = antesDM.cortar(128*9, 0, 128, 125);
        puff[10] = antesDM.cortar(128*10, 0, 128, 125);
        
        
        SpriteSheet P2 = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/Gate2.png"));
        
        puertas2 = new BufferedImage[12];
        
        puertas2[0] = P2.cortar(0, 0, 143, 95);
        puertas2[1] = P2.cortar(143, 0, 143, 95);
        puertas2[2] = P2.cortar(143*2, 0, 143, 95);
        puertas2[3] = P2.cortar(0, 95, 143, 95);
        puertas2[4] = P2.cortar(143, 95, 143, 95);
        puertas2[5] = P2.cortar(143*2, 95, 143, 95);
        puertas2[6] = P2.cortar(0, 95*2, 143, 95);
        puertas2[7] = P2.cortar(143, 95*2, 143, 95);
        puertas2[8] = P2.cortar(143*2, 95*2, 143, 95);
        puertas2[9] = P2.cortar(0, 95*3, 143, 95);
        puertas2[10] = P2.cortar(143, 92*3, 143, 95);
        puertas2[11] = P2.cortar(143*2, 95*3, 143, 95);
        
        SpriteSheet MadMonk = new SpriteSheet(Imagenes.cargadorImagenes("Recursos/Texturas/madMonk.png"));
         madmonk = MadMonk.cortar(0, 0, 144, 144);
        
    }
    
}
