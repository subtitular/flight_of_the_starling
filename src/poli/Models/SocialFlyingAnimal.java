/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

/**
 * Represneta un animal social, que vuela
 * @author subti
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class SocialFlyingAnimal extends FlyingObject  {
    private double leadershipLevel;
    private double cooperationLevel;
    private String synchronizationLevel;
    private String communicationLevel;
    private String socialBondingLevel;
    private String consensusLevel;
    private SocialFlyingAnimal leader;
    private double minLeadership  = 0.0;
    
    public SocialFlyingAnimal(Random random) {
        super(random);
        this.leadershipLevel = random.nextGaussian(1000,200);
        if(this.leadershipLevel>2000) this.leadershipLevel = this.leadershipLevel%2000;
        if(this.leadershipLevel<0) this.leadershipLevel=(-1) * (this.leadershipLevel%2000);
    }
    public double getLeadershipLevel() {
        return leadershipLevel;
    }
    public boolean isLeader(){
        return leadershipLevel >= minLeadership;
    }
    public boolean setMinLeadership(double minLeadership) {
        this.minLeadership = minLeadership;
        return leadershipLevel >= minLeadership;
    }
    public void setLeadershipLevel(double leadershipLevel) {
        this.leadershipLevel = leadershipLevel;
    }
    public void setLeader(SocialFlyingAnimal b) {
        leader = b;
        this.path.setNewCenter(b.path.getNewCenter());
        //TODO: involucrar el diametro y la dirección para que el punto no pierda continuidad cuando elija un nuevo lider
    }
    
    public double getCooperationLevel() {
        return cooperationLevel;
    }
    public void setCooperationLevel(double cooperationLevel) {
        this.cooperationLevel = cooperationLevel;
        super.setDeltaRadio(cooperationLevel);
    }
    public String getSynchronizationLevel() {
        return synchronizationLevel;
    }
    public void setSynchronizationLevel(String synchronizationLevel) {
        this.synchronizationLevel = synchronizationLevel;
    }
    public String getCommunicationLevel() {
        return communicationLevel;
    }
    public void setCommunicationLevel(String communicationLevel) {
        this.communicationLevel = communicationLevel;
    }
    public String getSocialBondingLevel() {
        return socialBondingLevel;
    }
    public void setSocialBondingLevel(String socialBondingLevel) {
        this.socialBondingLevel = socialBondingLevel;
    }
    public String getConsensusLevel() {
        return consensusLevel;
    }
    public void setConsensusLevel(String consensusLevel) {
        this.consensusLevel = consensusLevel;
    }
    @Override
    public void InitRandomPosition(double canvasWidth,double canvasHeight){
        super.InitRandomPosition(canvasWidth,canvasHeight);
        super.setX(random.nextGaussian(canvasWidth/2,canvasWidth/4));
        super.setY(random.nextGaussian( canvasHeight/2,canvasHeight/4)) ;
        super.setDirection (random.nextDouble() * 2 * Math.PI);
        this.setSpeed (random.nextDouble() * 100);
    }
}