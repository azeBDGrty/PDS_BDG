/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.customermanager;

import com.pds.inoutdataServer.InPutData;
import com.pds.inoutdataServer.OutPutData;
import com.pds.log.Logger;
import com.pds.usermanager.ManagerClient;
import com.pds.usermanager.ManagerConseiller;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.util.Queue;
import static com.pds.networkprotocolServer.Receive.*;
import com.pds.server.Anonyme;
import com.pds.usermanager.ManagerDB;
import com.pds.server.RoleUser;
import org.jdom2.Element;


/**
 *
 * @author zouhairhajji
 */
public class ClientHandler implements Runnable {

    private Socket socket;

    private boolean running;
    private Thread T;

    private InPutData in;
    private OutPutData out;
    private Connection connexion;
    
    private Queue<Connection> connections;
    
    private ManagerDB managerDb;
    
    private boolean logged;
    
    private Logger logger;
    
    public ClientHandler(Socket socket, Logger logger, Queue<Connection> connections) throws IOException {
        this.socket = socket;
        this.in = new InPutData(this.socket);
        this.out = new OutPutData(this.socket);
        this.connections = connections;
        this.logger = logger;
        this.managerDb = new Anonyme(in, out, logger, connexion, connections);
        this.logged = false;
    }

    public synchronized void startThread() throws InterruptedException {
        this.running = true;
        this.T = new Thread(this);
        while((this.connexion = this.connections.poll()) == null)
            wait();
        this.T.start();
    }
    
    public synchronized void stopThread() {
        this.running = false;
        //this.connections.add(this.connexion);
        //notifyAll();
    }

    @Override
    public void run() {
        while (running) {
            try {
                switch(in.getCommand()){
                    case askAuthentification:
                        Element donnee ;
                        if ( (donnee = managerDb.seConnecter() ) == null){
                            this.out.sendConnectionRefuse();
                            break;
                        }else
                            this.out.sendConnectionAutorised(donnee);
                        
                        if(managerDb.getRole() == RoleUser.client)
                            managerDb = new ManagerClient(in, out, logger, connexion, connections);
                        else if(managerDb.getRole() == RoleUser.conseiller)
                            managerDb = new ManagerConseiller(in, out, logger, connexion, connections);
                        
                        
                        Thread T = managerDb.startThread();
                        stopThread();
                        
                        break;
                        
                    default : 
                        this.out.sendUndefinedRequest();
                        break;
                }
            } catch (Exception ex) {
                //ex.printStackTrace();
                System.out.println("Client Disconnected");
                this.stopThread();
            }
        }
    }

}
