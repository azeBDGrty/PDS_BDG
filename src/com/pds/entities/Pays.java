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
public class Pays {
    
    private int idPays;
    private int codePays;
    private String alpha2, alpha3, nomFr, nomGb;

    public Pays(int idPays) {
        this.idPays = idPays;
    }

    public Pays(int idPays, int codePays, String alpha2, String alpha3, String nomFr, String nomGb) {
        this.idPays = idPays;
        this.codePays = codePays;
        this.alpha2 = alpha2;
        this.alpha3 = alpha3;
        this.nomFr = nomFr;
        this.nomGb = nomGb;
    }
    
    // Getters and Setters 

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public int getCodePays() {
        return codePays;
    }

    public void setCodePays(int codePays) {
        this.codePays = codePays;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getNomFr() {
        return nomFr;
    }

    public void setNomFr(String nomFr) {
        this.nomFr = nomFr;
    }

    public String getNomGb() {
        return nomGb;
    }

    public void setNomGb(String nomGb) {
        this.nomGb = nomGb;
    }
    
    
    // toString 

    @Override
    public String toString() {
        return "Pays{" + "idPays=" + idPays + ", codePays=" + codePays + ", alpha2=" + alpha2 + ", alpha3=" + alpha3 + ", nomFr=" + nomFr + ", nomGb=" + nomGb + '}';
    }
    
    
    // Equals

    @Override
    public boolean equals(Object obj) {
       if(obj instanceof Pays && obj != null)
            return this.idPays == ((Pays)obj).idPays;
        else
            return false;
    }
    
}
