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
    private double size;
    private String form;
    Random random;
    public Point(){
        random = new Random();
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
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }
    public void InitRandomPosition(double canvasWith,double canvasHeight){
        
        this.positionX = random.nextDouble() * canvasWith;
        this.positionY = random.nextDouble() * canvasHeight;
    }
}