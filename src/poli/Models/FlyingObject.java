/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

/**
 * Representa un objeto que se desplaza por el aire, 
 * con o sin propia voluntad
 * @author subti
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javafx.scene.paint.Color;

public class FlyingObject extends MovingPoint {
    private Color color;
    private double speed;
    private double direction;
    
    private String form;
    private double tono;

    public FlyingObject(Random random) {
        super(random);
        tono = Math.abs(random.nextGaussian(0.3,0.1));
        if(tono> 1.0) tono = 1.0 - (tono%1.0);
        tono= tono*(0.5+(super.getSize()/10));
        color = new Color(Math.max(tono,0.1),tono,Math.max(tono,0.1),0.8);
    }
    public String getForm() {
        return form;
    }
    public void setForm(String form) {
        this.form = form;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getDirection() {
        return direction;
    }
    public void setDirection(double direction) {
        this.direction = direction;
    }
}