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
public class Departement {
    
    private String idDepartement;
    private String departement;
    private Region region;

    public Departement() {
    }

    public Departement(String idDepartement, String departement, Region region) {
        this.idDepartement = idDepartement;
        this.departement = departement;
        this.region = region;
    }
    
    // Getters and Setter 

    public String getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(String idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
    
    
    
    
    // toString

    @Override
    public String toString() {
        return "Departement{" + "idDepartement=" + idDepartement + ", departement=" + departement + ", region=" + region + '}';
    }
    
    
    
}
