/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.inoutdata;

import static com.pds.networkprotocol.Receive.*;
import com.pds.networkprotocol.Receive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.Socket;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 * 
 * @author zouhairhajji
 */
public class InPutData {
    
    
    private Receive lastCommand;
    private Document lastDocument;
    private BufferedReader reader;
    
    public InPutData(Socket socket) throws IOException {
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    
    
    
    private synchronized String readMessage() throws IOException{   //read message sent by the server
        String message = reader.readLine();
        if (message == null) 
            throw new IOException();
        System.out.println(">>"+message);
        return message;
    }
    
    
    
        
        
    /**
     *  Cette méthode permet de lire toutes sortes d'information.
     */
    public synchronized void readElement() throws IOException{  //conversion of the message sent by the server in XML in XML format
        String ElementBuilder = "";
        String message = "";
        
        while( !  ".".equalsIgnoreCase(message = readMessage()) ){
            ElementBuilder += message; 
        }
        try {
            this.lastDocument = new SAXBuilder().build(new InputSource( new StringReader( ElementBuilder ) ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public Receive getlastCommand(){
        return this.lastCommand;
    }
            
            
    public synchronized Receive getCommand() throws IOException{
        this.lastCommand =  Receive.FactoryGetReceive(readMessage());
        System.out.println("Request : " + this.lastCommand);
        switch(lastCommand){        
            case connectionRefused : 
                break;
                
            case connectionDone : 
                break;
            
            case connectionAutorised :
                readElement();
                break;
            
            case sendInformationClient :
                readElement();
                break;
                
            case sendAllClient:
                readElement();
                break ;
                
                
            case sendAllRegion:
                readElement();
                break ;
                
            case sendAllDepartement:
                
                readElement();
                break ;
                
            case sendAllPays:
                
                readElement();
                break ;
                
            case sendLoanNumber:
                readElement();
                break ;
            
            case sendCustomerNumber:
                readElement();
                break;
                
            case sendMoney:
                readElement();
                break;
                
            case sendAge:
                readElement();
                break;
                
                
            case sendLoanTime:
                readElement();
                break ;    
            
            case sendAvgAmount:
                readElement();
                break ;    
                
            case sendSimNumber:
                readElement();
                break ;
                
            case sendTauxInteret:
                 System.out.println("Input coté client");
                readElement();
                break ;
                
            case sendAvgAge:
                System.out.println("Input coté client pour sendAvgAge");
                readElement();
                break ;
            
            case sendInterestEarned:
                readElement();
                break ;    
                
            case sendSimulationPretsClient: 
                System.out.println("Simulation lkfsdmghmfdsjlghvhjmskfldghjkmsdgfhjk");
                readElement(); 
                
                break;
            default:
                break;
        }
        return this.lastCommand;
    }

    public Document getLastDocument() {
        return this.lastDocument;
    }
    
    
    
}
