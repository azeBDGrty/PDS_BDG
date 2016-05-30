/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.serverhandler;


import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author Poweriser
 */
public class IndicatorHandle {
    
    private List<Integer> resultats;
    private List<Integer> loanNumberResultList;
    private List<Integer> simNumberResultList;
    private List<Integer> loanTimeResultList;
    private List<Integer> avgAmountResultList;

    public List<Integer> getLoanTimeResultList() {
        return loanTimeResultList;
    }

    public List<Integer> getAvgAmountResultList() {
        return avgAmountResultList;
    }
   
   
    public IndicatorHandle(){
        this.resultats = new ArrayList<>();
        this.loanNumberResultList = new ArrayList<>();
        this.simNumberResultList = new ArrayList<>();
        this.loanTimeResultList = new ArrayList<>();
        this.avgAmountResultList = new ArrayList<>();
        resultats.add(70);
        resultats.add(50);
        resultats.add(60);
        resultats.add(10);
        loanNumberResultList.add(1);
        loanNumberResultList.add(2);
        loanNumberResultList.add(3);
        loanNumberResultList.add(4);
        loanNumberResultList.add(5);
        loanNumberResultList.add(6);
        loanNumberResultList.add(7);
        loanNumberResultList.add(8);
        loanNumberResultList.add(9);
        loanNumberResultList.add(10);
        loanNumberResultList.add(11);      
       loanNumberResultList.add(12);
         simNumberResultList.add(1);
        simNumberResultList.add(2);
        simNumberResultList.add(3);
        simNumberResultList.add(4);
        simNumberResultList.add(5);
        simNumberResultList.add(6);
        simNumberResultList.add(7);
        simNumberResultList.add(8);
        simNumberResultList.add(9);
        simNumberResultList.add(10);
        simNumberResultList.add(11);      
       simNumberResultList.add(12);
                
    }
    
       public List<Integer> getResultats() {
        return resultats;
    }

     public List<Integer> getLoanNumberResultList() {
        return loanNumberResultList;
    }

    public List<Integer> getSimNumberResultList() {
        return simNumberResultList;
    }
        
    public void setAgebyLoanResult(Document lastDocument) {
        System.out.println("set indicator");
        resultats.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("resultat");
        resultats.add(Integer.parseInt(eResultat.getChildText("tranche0")));
        resultats.add(Integer.parseInt(eResultat.getChildText("tranche2")));
         resultats.add(Integer.parseInt(eResultat.getChildText("tranche4")));
          resultats.add(Integer.parseInt(eResultat.getChildText("tranche6")));
        System.out.println("resultat indicator "+resultats.get(0));
    }
    
    public void setLoanNumber(Document lastDocument) {
        System.out.println("set indicator");
        loanNumberResultList.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("eloanNumbers");
        for(int i=1;i<=12;i++)
        loanNumberResultList.add(Integer.parseInt(eResultat.getChildText("month"+i)));
        
        
    }
    
    public void setSimNumber(Document lastDocument) {
        System.out.println("set indicator");
        simNumberResultList.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("esimNumbers");
        for(int i=1;i<=12;i++)
        simNumberResultList.add(Integer.parseInt(eResultat.getChildText("month"+i)));
        
        
    }

    void setAvgAmount(Document lastDocument) {
        System.out.println("set indicator");
        avgAmountResultList.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("eavgAmount");
        for(int i=1;i<=12;i++)
        avgAmountResultList.add(Integer.parseInt(eResultat.getChildText("month"+i)));
    }

    void setLoanTime(Document lastDocument) {
        System.out.println("set indicator");
        loanTimeResultList.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("eloanTime");
        for(int i=1;i<=12;i++)
        loanTimeResultList.add(Integer.parseInt(eResultat.getChildText("month"+i)));
    }
    
    
}
