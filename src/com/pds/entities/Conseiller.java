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
public class Conseiller extends Personne{
    
    private String matricule;

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return super.toString() + " \n Conseiller{" + "matricule=" + matricule + '}';
    }
    
    
    
    
}
