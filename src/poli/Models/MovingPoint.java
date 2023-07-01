/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

/**
 * Herenda de Point, representa un punto que se mueve, 
 * Por tanto se puede dibujar en distintas ubicaciones
 * @author subti
 */
import java.util.HashMap;
import java.util.Map;
public class MovingPoint extends Point {
    private double speed;
    private double direction;
    private double scale;
    private double opacity;
    private double state;
    private double interpolation;
    
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
    public double getScale() {
        return scale;
    }
    public void setScale(double scale) {
        this.scale = scale;
    }
    public double getOpacity() {
        return opacity;
    }
    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }
    public double getState() {
        return state;
    }
    public void setState(double state) {
        this.state = state;
    }
    public double getInterpolation() {
        return interpolation;
    }
    public void setInterpolation(double interpolation) {
        this.interpolation = interpolation;
    }
    
    
}
