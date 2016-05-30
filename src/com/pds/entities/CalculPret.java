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
public class CalculPret {
   
        private int id_calcPret;
        
        private double coef_assurance,t_marge ;
        private double f_dossier; 

        private Taux_directeur tauxDirecteur;

    public CalculPret() {
    }

    public CalculPret(int id_calcPret, double coef_assurance, double t_marge, double f_dossier, Taux_directeur tauxDirecteur) {
        this.id_calcPret = id_calcPret;
        this.coef_assurance = coef_assurance;
        this.t_marge = t_marge;
        this.f_dossier = f_dossier;
        this.tauxDirecteur = tauxDirecteur;
    }

    public CalculPret(double coef_assurance, double t_marge, Taux_directeur tauxDirecteur) {
        this.coef_assurance = coef_assurance;
        this.t_marge = t_marge;
        this.tauxDirecteur = tauxDirecteur;
    }    
    
    
    
    public int getId_calcPret() {
        return id_calcPret;
    }

    public void setId_calcPret(int id_calcPret) {
        this.id_calcPret = id_calcPret;
    }

    public double getCoef_assurance() {
        return coef_assurance;
    }

    public void setCoef_assurance(double coef_assurance) {
        this.coef_assurance = coef_assurance;
    }

    public double getT_marge() {
        return t_marge;
    }

    public void setT_marge(double t_marge) {
        this.t_marge = t_marge;
    }

    public double getF_dossier() {
        return f_dossier;
    }

    public void setF_dossier(double f_dossier) {
        this.f_dossier = f_dossier;
    }

    public Taux_directeur getTauxDirecteur() {
        return tauxDirecteur;
    }

    public void setTauxDirecteur(Taux_directeur tauxDirecteur) {
        this.tauxDirecteur = tauxDirecteur;
    }
        
        
        
}
