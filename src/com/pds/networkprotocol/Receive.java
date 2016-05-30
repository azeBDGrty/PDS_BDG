/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.networkprotocol;

/**
 *
 * @author zouhairhajji
 */
public enum Receive {
    
    connectionDone ("La connection est déjà établi"),
    connectionAutorised ("La connection est autorisée"),
    connectionRefused ("La connection est refusée"),
    none ("La commande n'est pas reconnu"),
    
    
    sendAllClient ("la liste de tous les clients"),
    sendInformationClient("toutes les informations qui concerne celui qui est connecter"),
    needRight ("Manque de droits"),
    
    /**
     * 
     *  Conseiller 
     */
    
    sendAllDepartement ("La liste des departements"),
    sendAllRegion ("La liste des regions"),
    sendAllPays ("La liste des pays"),
    
    sendLoanTime(""),
    sendAvgAmount(""),
    sendAvgAge(""),

    sendLoanNumber(""),
    sendSimNumber(""),
    sendTauxInteret(""),
    sendInterestEarned(""),
    sendCustomerNumber(""),
    sendAge(""),
    sendMoney(""),
    sendSimulationPretsClient ("La liste des simulations de prets.");
    
    private String signification;
    
    private Receive(String signification) {
        this.signification = signification;
    }

    public String getSignification() {
        return signification;
    }
    
    
    
    
    public static Receive FactoryGetReceive(String receiveType){
        switch(receiveType){
            case "connectionAutorised" : 
                return connectionAutorised;
                
            case "connectionDone" : 
                return connectionDone;
            
            case "connectionRefused" : 
                return connectionRefused;
                
            case "sendAllClient" : 
                return sendAllClient;
                
            case "needRight" : 
                return needRight;
                
            case "sendInformationClient":
                return sendInformationClient;
                
            case "sendAllDepartement":
                return sendAllDepartement;
                
            case "sendAllRegion":
                return sendAllRegion;
                
                
            case "sendAllPays":
                return sendAllPays;
                
            case "sendSimulationPretsClient":
                return sendSimulationPretsClient;
            
                case "sendLoanTime":
                return sendLoanTime;

            case "sendLoanNumber":
                return sendLoanNumber;
            
                case "sendAvgAmount":
                return sendAvgAmount;
            
            case "sendSimNumber":
                return sendSimNumber;

            case "sendInterestEarned":
                return sendInterestEarned;
            
            case "sendTauxInteret":
                return sendTauxInteret;

            case "sendMoney":
                return sendMoney;
                
            case "sendAge":
                return sendAge;
            
            case "sendAvgAge":
                return sendAvgAge;
            
            case "sendCustomerNumber":
                return sendCustomerNumber;    
                
            default :
                return none;
        }
    }
}
