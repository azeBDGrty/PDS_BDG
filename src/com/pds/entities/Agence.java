/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.entities;

import java.sql.Timestamp;

/**
 *
 * @author zouhairhajji
 */
public class Agence {
 
    private int idAgence, id_pays, id_departement;
    private String description, adress;
    private Timestamp debutService;
    private int codePostale;

    public Agence(int idAgence, int id_pays, int id_departement, String description, String adress, Timestamp debutService, int codePostale) {
        this.idAgence = idAgence;
        this.id_pays = id_pays;
        this.id_departement = id_departement;
        this.description = description;
        this.adress = adress;
        this.debutService = debutService;
        this.codePostale = codePostale;
    }

    public Agence() {
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public int getId_pays() {
        return id_pays;
    }

    public void setId_pays(int id_pays) {
        this.id_pays = id_pays;
    }

    public int getId_departement() {
        return id_departement;
    }

    public void setId_departement(int id_departement) {
        this.id_departement = id_departement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    
    
    /**
     * Getters and setters 
     */
    
     public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Timestamp getDebutService() {
        return debutService;
    }

    public void setDebutService(Timestamp debutService) {
        this.debutService = debutService;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }
    
    
    
    
    
}
