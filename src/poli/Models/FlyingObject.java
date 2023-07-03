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

public class FlyingObject extends MovingPoint {
    private String color;
    private double speed;
    private double direction;

    public FlyingObject(Random random) {
        super(random);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
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