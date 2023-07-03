/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poli.Models;

/**
 * Representa un Estornino y recopila mediante herencia todas las 
 * caracteristicas de punto, punto movil, punto volador y animal social
 * @author subti
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
public class Starling extends SocialFlyingAnimal {
    private String group;
    private String energyLevel;
    private String adaptabilityLevel;
    private String agilityLevel;
    private String explorationLevel;
    private String playfulnessLevel;

    public Starling(Random random) {
        super(random);
    }
    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public String getEnergyLevel() {
        return energyLevel;
    }
    public void setEnergyLevel(String energyLevel) {
        this.energyLevel = energyLevel;
    }
    public String getAdaptabilityLevel() {
        return adaptabilityLevel;
    }
    public void setAdaptabilityLevel(String adaptabilityLevel) {
        this.adaptabilityLevel = adaptabilityLevel;
    }
    public String getAgilityLevel() {
        return agilityLevel;
    }
    public void setAgilityLevel(String agilityLevel) {
        this.agilityLevel = agilityLevel;
    }
    public String getExplorationLevel() {
        return explorationLevel;
    }
    public void setExplorationLevel(String explorationLevel) {
        this.explorationLevel = explorationLevel;
    }
    public String getPlayfulnessLevel() {
        return playfulnessLevel;
    }
    public void setPlayfulnessLevel(String playfulnessLevel) {
        this.playfulnessLevel = playfulnessLevel;
    }
}