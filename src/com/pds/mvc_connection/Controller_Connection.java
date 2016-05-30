/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_connection;


import com.pds.serverhandler.AbstractHandle;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author zouhairhajji
 */
public class Controller_Connection {
   
    private AbstractHandle model;

    public Controller_Connection(AbstractHandle model) {
        this.model = model;
    }
    
    
    public void fermer(View_Connection view){
        view.dispose();
        this.model.deleteObserver(view);
    }
    
    public void seConnecter(String login, String passWord){
        if(login == null || login == "" ){
            
        }else if( passWord == "" || passWord == null || passWord.length() < 4 ){
            
        }else{
            
            Element root = new Element("InfoAuthentification");
            
            Element eLogin = new Element("login");
            eLogin.setText(login);
            
            Element ePassWord = new Element("passWord");
            ePassWord.setText(passWord);
            
            root.addContent(eLogin);
            root.addContent(ePassWord);
            
            model.getOut().askAuthentification(root);
        }
    }
    
    
}
