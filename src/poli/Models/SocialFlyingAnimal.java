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
    private String leadershipLevel;
    private String cooperationLevel;
    private String synchronizationLevel;
    private String communicationLevel;
    private String socialBondingLevel;
    private String consensusLevel;

    public SocialFlyingAnimal(Random random) {
        super(random);
    }
    public String getLeadershipLevel() {
        return leadershipLevel;
    }
    public void setLeadershipLevel(String leadershipLevel) {
        this.leadershipLevel = leadershipLevel;
    }
    public String getCooperationLevel() {
        return cooperationLevel;
    }
    public void setCooperationLevel(String cooperationLevel) {
        this.cooperationLevel = cooperationLevel;
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
}