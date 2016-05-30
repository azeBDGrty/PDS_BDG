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
public enum Sexe {
    
    M ("Male"),
    F ("Female");
    
    
    
    private String abv;

    private Sexe(String abv) {
        this.abv = abv;
    }

    public String getAbv() {
        return abv;
    }
    
    public static Sexe FactorySexe(String abv){
        switch(abv){
            case "F": 
                return F;
            default: 
                return M;
        }
    }
    
}
