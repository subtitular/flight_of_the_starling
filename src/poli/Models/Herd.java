/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author subti
 */
public class Herd {
    private ArrayList<Point> points;
      
    
    public Herd(){
        points = new ArrayList<Point>();
    }
    public void Create(int cantidad, double width, double height, Random random){
        for(int i=0;i<cantidad;cantidad++){
            Point point = new Point(random);
            point.InitRandomPosition(width, height);
            points.add(point);
        }
       
        
    }

    public ArrayList<Point> getPoints() {
        return points; 
    }
}
