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
    private double X;
    private double Y;
    private int id;

    private int size;

    
    
    Random random;
    public Point(Random random){
        this.random = random;
        this.size=random.nextInt(3,5);
    }
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public double getX() {
        return X;
    }
    public void setX(double positionX) {
        this.X = positionX;
    }
    public double getY() {
        return Y;
    }
    public void setY(double positionY) {
        this.Y = positionY;
    }
    public void InitRandomPosition(double canvasWidth,double canvasHeight){
        
       this.X = random.nextGaussian(canvasWidth/2,canvasWidth/4);
       this.Y = random.nextGaussian( canvasHeight/2, canvasHeight/4);
       // System.out.println(this.positionX +" "+ this.positionY);
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public double distance(Point point){
        return Math.sqrt(Math.pow(X-point.getX(),2) + Math.pow(Y-point.getY(),2));
    }
}