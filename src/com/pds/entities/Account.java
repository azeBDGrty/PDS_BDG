/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.entities;

import com.pds.networkprotocol.RoleUser;
import java.sql.Timestamp;
/*test*/
/**
 *
 * @author zouhairhajji
 */
public class Account {
    
    private int idAccount;
    private String ndc;
    
    private String questionSecrete;
    private RoleUser role;
    
    private Timestamp dateCreation;

    public Account() {
    }

    public Account(int idAccount, String ndc, String questionSecrete, RoleUser role, Timestamp dateCreation) {
        this.idAccount = idAccount;
        this.ndc = ndc;
        this.questionSecrete = questionSecrete;
        this.role = role;
        this.dateCreation = dateCreation;
    }

    
    
    
    /**
     * 
     * Getters and Setters
     * 
     */
    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getNdc() {
        return ndc;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public String getQuestionSecrete() {
        return questionSecrete;
    }

    public void setQuestionSecrete(String questionSecrete) {
        this.questionSecrete = questionSecrete;
    }

    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Account{" + "idAccount=" + idAccount + ", ndc=" + ndc + ", questionSecrete=" + questionSecrete + ", role=" + role + ", dateCreation=" + dateCreation + '}';
    }
    
    
    
}
