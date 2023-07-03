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
import java.util.Random;
import java.util.Set;
public class MovingPoint extends Point {
    private double speed;
    private double direction;
    private double scale;
    private double opacity;
    private double state;
    private double interpolation;
    private double deltaDirectionX;
    private double deltaDirectionY;
    private double deltaRadio;
    private double deltaDirection;
    private double deltaSpeed;

    public MovingPoint(Random random) {
        super(random);
        deltaDirection=random.nextGaussian(0.01,0.005);
        deltaRadio = random.nextGaussian(0.4,0.2);
        deltaDirectionX = random.nextGaussian(deltaRadio,0.05);
        deltaDirectionY = random.nextGaussian(deltaRadio,0.05);
        deltaSpeed = random.nextGaussian(50,10);
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
    @Override 
    public void InitRandomPosition(double canvasWith,double canvasHeight){
        super.InitRandomPosition(canvasWith,canvasHeight);
        this.direction = random.nextDouble() * 2 * Math.PI;
        this.speed = random.nextDouble() * deltaSpeed;
    }
    
    public void NextPosition(){
        double x = getPositionX();
        double y = getPositionY();
        x = x +  Math.cos(direction)* deltaDirectionX;
        y = y +  Math.sin(direction)*deltaDirectionY;
        setPositionX(x);
        setPositionY(y);
        direction += deltaDirection;
    }
      
    
}
