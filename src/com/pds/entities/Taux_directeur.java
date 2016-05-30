/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.entities;

/**
 *
 * @author zouhairhajji
 */
public class Taux_directeur {
    private int id_tauxDirecteur;
    private double value;

    public Taux_directeur() {
    }

    public Taux_directeur(int id_tauxDirecteur, double value) {
        this.id_tauxDirecteur = id_tauxDirecteur;
        this.value = value;
    }

    public Taux_directeur(double value) {
        this.value = value;
    }
    
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
        this.value = value;
    }
    
}
