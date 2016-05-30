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
public enum Send {
    
    none (""),
    askAuthentification (""),
    askAddClient (""),
    askModifyClient (""),
    askDeleteClient (""),
    askInformationClient (""),
    askAllClient (""),
    
    /**
     * 
     *  Conseiller 
     */
    
    askAllDepartement ("Demande la liste des departements"),
    askAllPays ("Demande la liste des pays"),
    askAllRegion ("Demande la liste des regions "),
    askSimulationPretsClient ("Demande la liste des simulations des prets"),
    askSimulationClient("demander les simulations d'un client passé en param"),
    askIndicatorInfo (""),
    askAvgAge(""),
    askLoanNumber(""),
    askLoanTime(""),
    askAvgAmount(""),
    askSimNumber(""),
    askTauxInteret ("");
    
    private String signification;

    private Send(String signification) {
        this.signification = signification;
    }

    public String getSignification() {
        return signification;
    }
    
    
    
    /*
    public static Send FactoryGetSend(String sendString){
        switch(sendString.trim()){
            case "askAuthentification" : 
                return askAuthentification;
                
            case "askAddClient" : 
                return askAddClient;
                
            case "askDeleteClient" : 
                return askDeleteClient;
                
            case "askInformationClient" : 
                return askInformationClient;
                
            default :
                return none;
        }
    }
    */
}
