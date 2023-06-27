/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subti
 */
public class Herd {
    private ArrayList<Point> points  = new ArrayList<Point>();;
      
    
    public Herd(){
    }
    public void Create(int cantidad, double width, double height){
        points.clear();
        for(int i=0;i<cantidad;cantidad++){
            Point point = new Point();
            point.InitRandomPosition(width, height);
            points.add(point);
        }
        System.out.println(points.size());
        
    }

    public ArrayList<Point> getPoints() {
        return points; 
    }
}
