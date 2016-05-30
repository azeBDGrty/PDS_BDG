/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_customer;

import com.pds.entities.Client;
import com.pds.entities.SimulationPret;
import com.pds.serverhandler.AbstractHandle;
import com.pds.serverhandler.ConseillerHandle;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JInternalFrame;

/**
 *
 * @author zouhairhajji
 */
public class Controller_GestClient {
    
    
    private ConseillerHandle model;

    public Controller_GestClient(ConseillerHandle model) {
        this.model = model;
    }

    public void askListClient() {
    }

    void showFrameListSimPret(Client client) {
        
        ListSimPrets view = new ListSimPrets(this);
        model.getDeskTopPane().add(view);
        
        model.addObserver(view);
        view.chargerSimulations(client);
        view.setVisible(true);
    }

    void showPanelComparaison(Client client, List<SimulationPret> listSimPret) throws CloneNotSupportedException {
        //ListSimPretComp view = new ListSimPretComp(this);
        PanelTableSimPret view = new PanelTableSimPret(this);
        model.getDeskTopPane().add(view);
        
        model.addObserver(view);
        view.chargerSimulations(client, listSimPret);
        view.setVisible(true);
        
    }

    void showFrameTableAmmort(SimulationPret simPret)  {
        PanelMoreInfoSimLoan view = new PanelMoreInfoSimLoan(this);
        model.getDeskTopPane().add(view);
        
        model.addObserver(view);
        view.loadSimulation(simPret);
        view.setVisible(true);
    }

    void fermerFenetre(PanelTableSimPret aThis) {
        this.model.deleteObserver(aThis);
        aThis.dispose();
    }
    
    
}
