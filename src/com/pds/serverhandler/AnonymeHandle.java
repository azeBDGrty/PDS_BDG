/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.serverhandler;

import com.pds.entities.Account;
import com.pds.entities.Client;
import com.pds.entities.Conseiller;
import com.pds.entities.Personne;
import com.pds.inoutdata.InPutData;
import com.pds.inoutdata.OutPutData;
import com.pds.networkprotocol.RoleUser;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author zouhairhajji
 */
public class AnonymeHandle extends AbstractHandle{
    
    private AbstractHandle ServerHandle;
    
    
    
    public AnonymeHandle(InPutData in, OutPutData out, Personne user) throws IOException {
        super(in, out);
    }

    @Override
    public void run() {
        while(running){
            try{
                switch (in.getCommand()){
                    case sendAllClient : 
                        setChanged();
                        notifyObservers("sendAllClient");
                        break;
                        
                    case connectionAutorised : 
                                
                        Account compte = extractAccount(this.in.getLastDocument());
                        if(compte.getRole() == RoleUser.client){
                            return;
                            
                        }else if(compte.getRole() == RoleUser.conseiller){
                            Conseiller conseiller = new Conseiller();
                            conseiller.setAccount(compte);
                            this.ServerHandle = new ConseillerHandle(in, out, conseiller);
                            this.ServerHandle.setDeskTopPane(deskTopPane);
                        }else if(compte.getRole() == RoleUser.directeurAgence){
                            
                        }else if(compte.getRole() == RoleUser.directeurBank){
                            
                        }
                        
                        this.ServerHandle.startListenning();
                        
                        setChanged();
                        // tell to views that the model will change to ServerHandle
                        notifyObservers("connectionAutorised", this.ServerHandle);
                        
                        stopListenning();
                        break;
                        
                    case connectionRefused : 
                        setChanged();
                        notifyObservers("connectionRefused", this.in.getLastDocument());
                        
                        break;
                        
                    case connectionDone : 
                        setChanged();
                        notifyObservers("connectionDone");
                        break;
                        
                    case needRight : 
                        setChanged();
                        notifyObservers("needRight");
                        break;
                    
                        
                    default :
                        System.out.println("La commande n'est pas définie");
                        break;
                }
            }catch(Exception ex){
                ex.printStackTrace();
                stopListenning();
            }
        }
    }

    private Account extractAccount(Document lastDocument) throws ParseException {
        Element root = lastDocument.getRootElement();
        Account compte = new Account();
        
        compte.setIdAccount(Integer.parseInt(root.getChildText("idCompte")));
        compte.setNdc(root.getChildText("login"));
        compte.setQuestionSecrete(root.getChildText("questionSecrete"));
        compte.setRole(RoleUser.FactoryGetRole(root.getChildText("role")));
        compte.setDateCreation(new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(root.getChildText("dateCreation")).getTime()));
        return compte;
    }

    @Override
    public List<Client> getClients() {
        return null;
    }
    
}
