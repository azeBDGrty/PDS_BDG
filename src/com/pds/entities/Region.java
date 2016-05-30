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
public class Region {
    
    private int idRegion;
    private String nameRegion;

    public Region() {
    }

    public Region(int idRegion, String nameRegion) {
        this.idRegion = idRegion;
        this.nameRegion = nameRegion;
    }
    
    
    // Getters and Setters

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNameRegion() {
        return nameRegion;
    }

    public void setNameRegion(String nameRegion) {
        this.nameRegion = nameRegion;
    }
    
    
    
    // toString

    @Override
    public String toString() {
        return "Region{" + "idRegion=" + idRegion + ", nameRegion=" + nameRegion + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Region && obj != null)
            return this.idRegion == ((Region)obj).idRegion;
        else
            return false;
    }
    
    
    
}
