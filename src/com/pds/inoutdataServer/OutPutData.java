/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.inoutdataServer;


import com.pds.networkprotocolServer.Send;
import static com.pds.networkprotocolServer.Send.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author zouhairhajji
 */
public class OutPutData {
    
    
    private PrintWriter writer;
    private XMLOutputter outPutter;
    
    public OutPutData(Socket socket) throws IOException {
        this.writer = new PrintWriter(socket.getOutputStream(), true);
    }
    
    
    private synchronized  void sendMessage(String typeMessage, Element elementData){
        typeMessage = (typeMessage == null)? "" : typeMessage;
        writer.println(typeMessage);
        if(elementData == null)
            return;
        writer.println(new XMLOutputter().outputString(elementData));
        writer.println(".");
        //System.out.println(" : " + typeMessage + " : " + new XMLOutputter().outputString(elementData));
    }
    
    
    public void sendConnectionRefuse(){
        sendMessage(connectionRefused.toString(), null);
    }
    
    public void sendConnectionAutorised(Element information){
        sendMessage(connectionAutorised.toString(), information);
    }
    
    public void sendConnectionDone(Element information){
        sendMessage(connectionDone.toString(), information);
    }
    
    public void sendAllClient(Element information){
        sendMessage(sendAllClient.toString(), information);
    }
    
    public void sendOwnInformationClient(Element information){
        sendMessage(sendInformationClient.toString(), information);
    }
    
    public void sendNeedRight(Element information){
        sendMessage(needRight.toString(), information);
    }
    
    public void sendUndefinedRequest(){
        sendMessage(undefinedRequest.toString(), null);
    }
    
    public void sendAllSimPretClient(Element information){
        sendMessage(sendSimulationPretsClient.toString(), information);
    }
    
    
    public void sendALlRegion(Element information){
        sendMessage(sendAllRegion.toString(), information);
    }
    
    public void sendALlDepartement(Element information){
        sendMessage(sendAllDepartement.toString(), information);
    }
    
    public void sendALlPays(Element information){
        sendMessage(sendAllPays.toString(), information);
    }
    
    public void sendTauxInteret(Element information){
        sendMessage(sendTauxInteret.toString(), information);
    }
    
    
     
     public void sendAvgAge(Element information) {
        sendMessage(sendAvgAge.toString(),information);
    }

    public void sendSimNumber(Element information) {
    sendMessage(sendSimNumber.toString(),information);
    }

    public void sendLoanNumber(Element information) {
     sendMessage(sendLoanNumber.toString(),information);
    }
    
    public void sendAvgAmount(Element information) {
     sendMessage(sendAvgAmount.toString(),information);
    }
    
    public void sendLoanTime(Element information) {
     sendMessage(sendLoanTime.toString(),information);
    }

    public void sendInterestEarned(Element information) {
        sendMessage(sendInterestEarned.toString(),information);
    }

     public void sendCustomerNumber(Element information) {
        sendMessage(sendCustomerNumber.toString(),information);
    }
    
     public void sendMoney(Element information) {
        sendMessage(sendMoney.toString(),information);
    }
     
    public void sendAge(Element information) {
        sendMessage(sendAge.toString(),information);
    }
     
     
}
