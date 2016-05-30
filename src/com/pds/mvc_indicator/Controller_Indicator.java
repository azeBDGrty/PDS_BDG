/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_indicator;

import com.pds.entities.Conseiller;
import com.pds.implobs.AbstractObservable;
import com.pds.implobs.IObserver;
import com.pds.serverhandler.ConseillerHandle;
import com.pds.serverhandler.IndicatorHandle;
import org.jdom2.Element;

/**
 *
 * @author Poweriser
 */
public class Controller_Indicator implements IObserver{
    
      private ConseillerHandle model;
      private IndicatorHandle Indicator;

    public IndicatorHandle getIndicator() {
        return Indicator;
    }

    public Controller_Indicator(ConseillerHandle model) {
        this.model = model;
        this.Indicator = this.model.getIndicator();
    }
    

    public void sendIndicatorInfo() {
        
        System.out.println("sendIndicator");
        
        Element root = new Element("InfoIndicator");
            
            Element eAnnee = new Element("annee");
            eAnnee.setText("2017");
            
            Element eAgeDebut = new Element("ageDebut");
            eAgeDebut.setText("20");
            
            Element eAgeFin = new Element("ageFin");
            eAgeFin.setText("25");
            
            Element eLibelle = new Element("libelle");
            eLibelle.setText("_Credit_IMMO_");
            
            Element eTypeTaux = new Element("typeTaux");
            eTypeTaux.setText("_fixe_");
            
            Element eId_agence = new Element("Id_agence");
            eId_agence.setText("2");
            
            root.addContent(eAnnee);
            root.addContent(eAgeDebut);
            root.addContent(eAgeFin);
            root.addContent(eLibelle);
            root.addContent(eTypeTaux);
            root.addContent(eId_agence);
            
            model.getOut().askIndicatorInfo(root);
    }
    
    public void sendAvgAgeQuery(String checkImmo,String checkConso){
       Element root = new Element("AvgAge"); 
       
       
           Element eTypePretImmo = new Element("TypePretImmo");
           eTypePretImmo.setText(checkImmo);
           root.addContent(eTypePretImmo);
           Element eTypePretConso = new Element("TypePretConso");
           eTypePretConso.setText(checkConso);
           root.addContent(eTypePretConso);
       
       model.getOut().askAvgAge(root);
    }

     public void sendLoanNumberRequest(String checkImmo,String checkConso,int tranche){
       Element root = new Element("LoanNumber"); 
       
           
           Element eTypePretImmo = new Element("TypePretImmo");
           eTypePretImmo.setText(checkImmo);
           root.addContent(eTypePretImmo);
           Element eTypePretConso = new Element("TypePretConso");
           eTypePretConso.setText(checkConso);
           root.addContent(eTypePretConso);
           Element eTranche = new Element("Tranche");
           eTranche.setText(String.valueOf(tranche));
           root.addContent(eTranche);
           
       model.getOut().askLoanNumber(root);
    }
     
      public void sendSimNumberRequest(String checkImmo,String checkConso,int tranche){
     Element root = new Element("SimNumber"); 
       
          
           Element eTypePretImmo = new Element("TypePretImmo");
           eTypePretImmo.setText(checkImmo);
           root.addContent(eTypePretImmo);
           Element eTypePretConso = new Element("TypePretConso");
           eTypePretConso.setText(checkConso);
           root.addContent(eTypePretConso);
           Element eTranche = new Element("Tranche");
           eTranche.setText(String.valueOf(tranche));
           root.addContent(eTranche);
           
       model.getOut().askSimNumber(root);
    }
    
      public void sendAvgAmount(String checkImmo,String checkConso,int tranche){
       Element root = new Element("AvgAmount"); 
       
           
           Element eTypePretImmo = new Element("TypePretImmo");
           eTypePretImmo.setText(checkImmo);
           root.addContent(eTypePretImmo);
           Element eTypePretConso = new Element("TypePretConso");
           eTypePretConso.setText(checkConso);
           root.addContent(eTypePretConso);
           Element eTranche = new Element("Tranche");
           eTranche.setText(String.valueOf(tranche));
           root.addContent(eTranche);
           
       model.getOut().askAvgAmount(root);
    }
      
     public void sendLoanTime(String checkImmo,String checkConso,int tranche){
       Element root = new Element("LoanTime"); 
       
           
           Element eTypePretImmo = new Element("TypePretImmo");
           eTypePretImmo.setText(checkImmo);
           root.addContent(eTypePretImmo);
           Element eTypePretConso = new Element("TypePretConso");
           eTypePretConso.setText(checkConso);
           root.addContent(eTypePretConso);
           Element eTranche = new Element("Tranche");
           eTranche.setText(String.valueOf(tranche));
           root.addContent(eTranche);
           
       model.getOut().askAvgAmount(root);
    }  
      
      
    @Override
    public boolean update(AbstractObservable sender, String message, Object... data) {
        System.out.println("mise a jour du controller indicator");
      this.Indicator = this.model.getIndicator();
        System.out.println(this.model.getIndicator().getResultats().get(0));
      System.out.println("resultat indicator niveau controller" +Indicator.getResultats().get(0));
          return true;
    }
    
}
