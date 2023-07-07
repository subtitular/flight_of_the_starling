/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

import java.security.PublicKey;
import javafx.geometry.Point2D;

/**
 *
 * @author subti
 */
public class Path {
    private Point2D centroA;
    private Point2D centroB;
    private Point2D pivote;
    private Point2D uno;
    private Point2D dos;
    private Point2D tres;
    private Point2D temp;
    private Point2D nextPivote;
    private boolean mustChange = false;
    private int pasoActual = 0;
    private double deltaX = 0.0;
    private double deltaY = 0.0;
    private int speed = 300;
    private int actual = 0;
    
    public Path(double width,double height, Point2D pivote){
        this.centroA = new Point2D(width/3,height/2);
        this.centroB = new Point2D(2*width/3,height/2);
        this.pivote = pivote;
        uno = pivote;
        dos = centroA;//pivote.distance(centroA) >= pivote.distance(centroB)?centroB : centroA;
        tres = centroB;// pivote.distance(centroA) < pivote.distance(centroB)?centroB : centroA;
        calculateDeltas();
    }
    private void calculateDeltas(){
        deltaX = -(uno.getX()-dos.getX())/speed;
        deltaY = -(uno.getY()-dos.getY())/speed;
    }
    public Point2D getNewCenter(){
        if(pasoActual<speed){
            pasoActual++;
            return currentCenter();
        }
        if(mustChange && uno.distance(pivote)== 0){
            mustChange =false;
            //uno =nextPivote;
            dos = nextPivote;
            //tres = centroB;// pivote.distance(centroA) < pivote.distance(centroB)?centroB : centroA;
        } 
        temp = uno;
        uno = dos;
        dos = tres;
        tres = temp;
            
        
        pasoActual = 0;
        calculateDeltas();
        return currentCenter();
    }
   private Point2D currentCenter(){
       return new Point2D(uno.getX() + pasoActual*deltaX,uno.getY()+ pasoActual*deltaY);
   }

    void setNewCenter(Point2D newCenter) {
        nextPivote = newCenter;
        mustChange = true;
    }
}
