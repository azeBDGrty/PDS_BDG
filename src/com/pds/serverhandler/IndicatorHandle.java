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
    private int customerNumber;
    private int money;
    private int age;

  
   
   
    public IndicatorHandle(){
        this.resultats = new ArrayList<>();
        this.loanNumberResultList = new ArrayList<>();
        this.simNumberResultList = new ArrayList<>();
        this.loanTimeResultList = new ArrayList<>();
        this.avgAmountResultList = new ArrayList<>();
        
        for(int i = 0;i<12;i++){
          //  resultats.add(i);
            loanNumberResultList.add(i);
            simNumberResultList.add(i);
            loanTimeResultList.add(i);
            avgAmountResultList.add(i);
        }
           
                
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Document lastDocument) {
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("CustomerNumber");
        System.out.println("resultat nomre client"+eResultat.getText());
          customerNumber = Integer.parseInt(eResultat.getText());
        
        
        
    }
    
    
    
      public List<Integer> getLoanTimeResultList() {
        return loanTimeResultList;
    }

    public List<Integer> getAvgAmountResultList() {
        return avgAmountResultList;
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
       System.out.println("passage dans setagebyLoanResult");
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
       System.out.println("passage dans le setter setLoanNumber");
        loanNumberResultList.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("loanNumbers");
        for(int i=1;i<=12;i++){
            
        loanNumberResultList.add(Integer.parseInt(eResultat.getChildText("month"+i)));
        System.out.println("loanNumberList["+i+"] = " + loanNumberResultList.get(i-1));
        }
        
    }
    
    public void setSimNumber(Document lastDocument) {
        
        simNumberResultList.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("simNumbers");
        for(int i=1;i<=12;i++)
        simNumberResultList.add(Integer.parseInt(eResultat.getChildText("month"+i)));
        
        
    }

    void setAvgAmount(Document lastDocument) {
        System.out.println("passage dans le setter setavgAmount");
        avgAmountResultList.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("avgAmount");
        for(int i=1;i<=12;i++){
            int value = Math.round(Float.parseFloat(eResultat.getChildText("month"+i)));
        avgAmountResultList.add(value);
        }
    }

    void setLoanTime(Document lastDocument) {
        System.out.println("passage dans le setter setLoanTime");
        loanTimeResultList.clear();
          Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("loanTime");
        for(int i=1;i<=12;i++){
            int value = Math.round(Float.parseFloat(eResultat.getChildText("month"+i)));
        loanTimeResultList.add(value);
        }
    }

    void setInterestEarned(Document lastDocument) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMoney(Document lastDocument) {
         Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("avg_money");
      System.out.println("resultat set money"+eResultat.getText());
          money = Integer.parseInt(eResultat.getText()); 
    }

    void setAge(Document lastDocument) {
         Element eRoot =lastDocument.getRootElement();
        Element eResultat = eRoot.getChild("avg_age");
     
          age = Math.round(Float.parseFloat(eResultat.getText()));
    }

    public int getAge() {
        return age;
    }

    public int getMoney() {
       return money;
    }
    
    
    
}
