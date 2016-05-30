/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.enums;

/**
 *
 * @author zouhairhajji
 */
public enum Situation {
    
    Marie("La personne est mariée"), 
    Celibataire ("la personne est celibataire"),
    Autre ("Indifini");
    
    
    private String abv;
    
    Situation(String  abv){
        this.abv = abv;
    }   

    public String getAbv() {
        return abv;
    }
    
    
    
    public static Situation FactorySituation(String abv){
        if(abv.trim().equalsIgnoreCase("Marie"))
            return Marie;
        else if (abv.trim().equalsIgnoreCase("Celibataire"))
            return Celibataire;
        else
            return Autre;
    }
}
