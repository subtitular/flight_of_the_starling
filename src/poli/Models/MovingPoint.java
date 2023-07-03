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
import javafx.geometry.Point2D;
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
    /*private double centerX = 0.0;
    private double centerY = 0.0;*/
    public Point2D center;

    public MovingPoint(Random random) {
        super(random);
        deltaDirection=random.nextGaussian(0.01,0.005);
        deltaRadio = random.nextGaussian(200,40);
        //System.out.println(deltaRadio);
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
        center = new Point2D(super.getPositionX(), super.getPositionY());
        /*centerX=super.getPositionX();
        centerY = super.getPositionY();*/
        //System.out.println("Moving " +centerX +" "+ centerY);
        this.direction = random.nextDouble() * 2 * Math.PI;
        this.speed = random.nextDouble() * deltaSpeed;
    }
    //double maxx = 0.0;
    //double maxy = 0.0;
    public void NextPosition(){
        //double x = getPositionX();
        //double y = getPositionY();
        double x = center.getX() +  Math.cos(direction)* deltaDirectionX;
        double y = center.getY() +  Math.sin(direction)*deltaDirectionY;
        //if(y>=maxy)maxy=y;
        //if(x>=maxx)maxx=x;
        setPositionX(x);
        setPositionY(y);
        direction += deltaDirection;
        //System.out.println( x +" " +y+ "-- " +deltaDirectionX +"  " + deltaDirectionY );
    }
      
    
}
