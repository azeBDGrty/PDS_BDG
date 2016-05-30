/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.entities;

import com.pds.enums.Sexe;
import java.sql.Timestamp;
import java.util.logging.Logger;

/**
 *
 * @author zouhairhajji
 */
public class Personne {
   
    private int idPerson;
    private String lastName, firstName, adress;
    private Timestamp dateBirthDate;
    private Sexe sexe;
    private int codePost;
    
    private Pays pays;
    private Departement departement;
    
    private InfoPersonnel infoPerso;
    
    private Account account;

    

    public Personne(int idPerson, String lastName, String firstName, String adress, Timestamp dateBirthDate, Sexe sexe, int codePost, Pays pays, Departement departement, InfoPersonnel infoPerso, Account account) {
        this.idPerson = idPerson;
        this.lastName = lastName;
        this.firstName = firstName;
        this.adress = adress;
        this.dateBirthDate = dateBirthDate;
        this.sexe = sexe;
        this.codePost = codePost;
        this.pays = pays;
        this.departement = departement;
        this.infoPerso = infoPerso;
        this.account = account;
    }

    public Personne() {
    }
    
    
    
    
    
    
    // Getters and Setters

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Timestamp getDateBirthDate() {
        return dateBirthDate;
    }

    public void setDateBirthDate(Timestamp dateBirthDate) {
        this.dateBirthDate = dateBirthDate;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public int getCodePost() {
        return codePost;
    }

    public void setCodePost(int codePost) {
        this.codePost = codePost;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public InfoPersonnel getInfoPerso() {
        return infoPerso;
    }

    public void setInfoPerso(InfoPersonnel infoPerso) {
        this.infoPerso = infoPerso;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    // toString  
    @Override
    public String toString() {
        return "Personne{" + "idPerson=" + idPerson + ", lastName=" + lastName + ", firstName=" + firstName + ", adress=" + adress + ", dateBirthDate=" + dateBirthDate + ", sexe=" + sexe + ", codePost=" + codePost + ", pays=" + pays + ", departement=" + departement + ", infoPerso=" + infoPerso + ", account=" + account + '}';
    }

    
    
    
}
