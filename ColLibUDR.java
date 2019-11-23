import java.util.*;
import java.awt.*;
/**
 * Write a description of class ColLibUDR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColLibUDR
{
    public static Color BROWN() {
        return new Color(153, 102, 0);
    }
    public static Color Random() {
        int red = (int)(Math.random()*256+1);
        int green = (int)(Math.random()*256+1);
        int blue = (int)(Math.random()*256+1);
        return new Color(red, green, blue);
    }
    public static Color BRIGTHYELLOW() {
        return new Color(255, 255, 102);
    }
    public static Color ORANGE() {
        return new Color(255, 173, 51);
    }
    public static Color SKIN() {
        return new Color(255, 204, 102);
    }
    public static Color SKYBLUE() {
        return new Color(51, 204, 255);
    }
    public static Color SUNYELLOW() {
        return new Color(255, 255, 0);
    }
    public static Color VDARKBLUE() {
        return new Color(0, 0, 102);
    }
    public static Color DARLGREEN() {
        return new Color(0, 51, 0);
    }
    public static Color DARKRED() {
        return new Color(128, 0, 0);
    }
    public static Color CLOUDGREY() {
        return new Color(230, 230, 230, 127);
    }
    public static Color MOUTHRED() {
        return new Color(255, 26, 26);
    }
    public static Color TRANSWHITE() {
        return new Color(255, 255, 255, 200);
    }
}