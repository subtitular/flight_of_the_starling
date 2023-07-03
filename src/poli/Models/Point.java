/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

/**
 *  Reprensenta un punto que puede ser dibujado en el canvas
 * @author subti
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Point {
    private double positionX;
    private double positionY;

    Random random;
    public Point(Random random){
        this.random = random;
    }
    
    public double getPositionX() {
        return positionX;
    }
    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }
    public double getPositionY() {
        return positionY;
    }
    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }
    public void InitRandomPosition(double canvasWidth,double canvasHeight){
        
        this.positionX = random.nextDouble() * canvasWidth;
        this.positionY = random.nextDouble() * canvasHeight ;
    }
}