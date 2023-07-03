/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author subti
 */
public class Herd {
    private SocialFlyingAnimal[] birds;
    private int total;
    private double maxLeadership;
    private List<SocialFlyingAnimal> ultimateLeaders = new ArrayList<SocialFlyingAnimal>();
    
            
    public Herd(int max){
        total = max;
        birds = new SocialFlyingAnimal[total];
    }
    /*public void Create(double width, double height, Random random){
        for(int i=0;i<total - 1;total++){
            SocialFlyingAnimal bird = new SocialFlyingAnimal(random);
            bird.InitRandomPosition(width, height);
            birds[i] = (T) bird;
        }
       
        
    }*/
    public double getMaxLeadership(){
        return this.maxLeadership;
    }
    public SocialFlyingAnimal[] getBirds() {
        return birds; 
    }
    public void setBirds(SocialFlyingAnimal[] birds){
        this.birds = birds;
    }
    public void setLeadership(SocialFlyingAnimal bird){
        if(bird.getLeadershipLevel()==maxLeadership){
            ultimateLeaders.add(bird);
        }
        if(bird.getLeadershipLevel()>maxLeadership){
            ultimateLeaders.clear();
            ultimateLeaders.add(bird);
            maxLeadership= bird.getLeadershipLevel();
        }
        
    }

    public void searchLeader(Starling starling) {
        double distance = 10000000;
        for(int i = 0; i < ultimateLeaders.size();i++){
            var l = ultimateLeaders.get(i);
            double dist = starling.center.distance(l.center);
            if(distance > dist )
                starling.setLeader(l);
        }
        
    }
}
