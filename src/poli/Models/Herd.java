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
public class Herd<T extends SocialFlyingAnimal> {
    private T[] birds;
    private int total;
    
    public Herd(int max){
        total = max;
        birds = (T[]) new SocialFlyingAnimal[total];
    }
    public void Create(double width, double height, Random random){
        for(int i=0;i<total - 1;total++){
            SocialFlyingAnimal bird = new SocialFlyingAnimal(random);
            bird.InitRandomPosition(width, height);
            birds[i] = (T) bird;
        }
       
        
    }

    public SocialFlyingAnimal[] getBirds() {
        return birds; 
    }
}
