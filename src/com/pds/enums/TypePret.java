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
public enum TypePret {

    _variable_("Taux Variable"),
    _fixe_("Taux Fixe"),
    _mixt_("Taux Mixe");

    private String abv;

    private TypePret(String abv) {
        this.abv = abv;
    }

    public String getAbv() {
        return abv;
    }

    public static TypePret FactoryTypePret(String abv) {
        switch (abv) {

            case "_variable_":
                return _variable_;

            case "_mixt_":
                return _mixt_;
                
            default : 
                return _fixe_;
        }
    }

}
