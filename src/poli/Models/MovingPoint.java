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
    private String speed;
    private String direction;
    private String scale;
    private String opacity;
    private String state;
    private String interpolation;
    
    public String getSpeed() {
        return speed;
    }
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getScale() {
        return scale;
    }
    public void setScale(String scale) {
        this.scale = scale;
    }
    public String getOpacity() {
        return opacity;
    }
    public void setOpacity(String opacity) {
        this.opacity = opacity;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getInterpolation() {
        return interpolation;
    }
    public void setInterpolation(String interpolation) {
        this.interpolation = interpolation;
    }
}
