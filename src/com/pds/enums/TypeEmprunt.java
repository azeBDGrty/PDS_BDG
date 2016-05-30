/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.enums;

/**
 *
 * @author zouhairhajji
 */
public enum TypeEmprunt {
    _Credit_IMMO_("Crédit immobilier"),
    _CREDIT_CONSO_("Crédit à la consommation");
    
    private String abv;

    private TypeEmprunt(String abv) {
        this.abv = abv;
    }
    
    public static TypeEmprunt FactoryGetTypeEmprunt(String abv){
        switch(abv){
            case "_Credit_IMMO_" : 
                return _Credit_IMMO_;
            default :
                return _CREDIT_CONSO_;
        }
    }

    public String getAbv() {
        return abv;
    }
    
    
}
