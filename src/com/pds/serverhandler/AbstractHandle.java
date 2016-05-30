/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.serverhandler;

import com.pds.entities.Account;
import com.pds.entities.Client;
import com.pds.entities.Personne;
import com.pds.implobs.AbstractObservable;
import com.pds.inoutdata.InPutData;
import com.pds.inoutdata.OutPutData;
import java.util.List;
import javax.swing.JDesktopPane;

/**
 *
 * @author zouhairhajji
 */
public abstract class AbstractHandle extends AbstractObservable implements Runnable{
    
    private Thread T;
    protected boolean running;
    int j;
    
    protected InPutData in;
    protected OutPutData out;

    protected JDesktopPane deskTopPane;
    
    public AbstractHandle(InPutData in, OutPutData out) {
        this.in = in;
        this.out = out;
    }
    
    
    public void startListenning() {
        this.running = true;
        this.T = new Thread(this);
        this.T.start();
    }

    public void stopListenning() {
        this.running = false;
    }

    public OutPutData getOut() {
        return out;
    }

    public abstract List<Client> getClients() ;

    public JDesktopPane getDeskTopPane() {
        return deskTopPane;
    }

    public void setDeskTopPane(JDesktopPane deskTopPane) {
        this.deskTopPane = deskTopPane;
    }
    
    
    
}
