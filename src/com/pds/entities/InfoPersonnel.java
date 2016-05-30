/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.entities;

import com.pds.enums.Situation;
import java.sql.Timestamp;

/**
 *
 * @author zouhairhajji
 */
public class InfoPersonnel {
    
    private int idinfoPerso;
    private String profession;
    private double revenuMensuel, revenuConjoint, apportPerso, autre;
    private Situation situation;
    private Timestamp lastUpdate;

    public InfoPersonnel() {
    }

    public InfoPersonnel(int idinfoPerso, String profession, double revenuMensuel, double revenuConjoint, double apportPerso, double autre, Situation situation, Timestamp lastUpdate) {
        this.idinfoPerso = idinfoPerso;
        this.profession = profession;
        this.revenuMensuel = revenuMensuel;
        this.revenuConjoint = revenuConjoint;
        this.apportPerso = apportPerso;
        this.autre = autre;
        this.situation = situation;
        this.lastUpdate = lastUpdate;
    }
    
    
    
    
    // Getter and Setter

    public int getIdinfoPerso() {
        return idinfoPerso;
    }

    public void setIdinfoPerso(int idinfoPerso) {
        this.idinfoPerso = idinfoPerso;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public double getRevenuMensuel() {
        return revenuMensuel;
    }

    public void setRevenuMensuel(double revenuMensuel) {
        this.revenuMensuel = revenuMensuel;
    }

    public double getRevenuConjoint() {
        return revenuConjoint;
    }

    public void setRevenuConjoint(double revenuConjoint) {
        this.revenuConjoint = revenuConjoint;
    }

    public double getApportPerso() {
        return apportPerso;
    }

    public void setApportPerso(double apportPerso) {
        this.apportPerso = apportPerso;
    }

    public double getAutre() {
        return autre;
    }

    public void setAutre(double autre) {
        this.autre = autre;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
}
