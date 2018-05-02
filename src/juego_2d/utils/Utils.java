/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego_2d.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author raalv
 */
public class Utils {
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();
        try{
                BufferedReader br = new BufferedReader(new FileReader(path));
                String line;
                while((line = br.readLine()) != null){
                    builder.append(line).append("\n");

                }
        }catch(IOException e){
            e.getMessage();
        }
        return builder.toString();
    }
    
    public static int parseInt(String number){
        try{
            return Integer.parseInt(number);
        }catch(NumberFormatException e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public static double CalcularDistancia(int x1, int y1, int x2, int y2){
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}
