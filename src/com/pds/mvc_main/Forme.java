/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.mvc_main;


import com.pds.implobs.AbstractObservable;
import com.pds.implobs.IObserver;
import com.pds.mvc_customer.View_GestClient;
import com.pds.mvc_gestProspect.View_SimTauxFixe;
import com.pds.mvc_gestProspect.View_SimTauxVari;
import com.pds.mvc_indicator.View_Indicator;
import com.pds.serverhandler.ConseillerHandle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

/**
 *
 * @author zouhairhajji
 */
public class Forme extends JFrame implements IObserver {

    private Controller_MDIForm controller;

    private JDesktopPane desktopPane;
    private JMenuBar menuBar;

    private JMenu option;
    private JMenuItem seConnecter, seDeconnecter, quitter;

    private JMenu gestionComptes;
    private JMenuItem listerComptes, rechercheCompte, simPretVar;
    
    private JMenu gestionClient;
    private JMenuItem listerClients;
    
    private JMenu gestionProspect;
    private JMenuItem simProspect;
    
    
    private JMenu gestionAgence;
    private JMenuItem showIndicators;
    
    
    public Forme(Controller_MDIForm controller, boolean isNimbus) throws Exception {
        if (isNimbus) 
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        
        this.controller = controller;

        this.desktopPane = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(new Color(176, 196, 222));
                g.fillRect(0, 0, getSize().width, getSize().height);
            }
        };
        this.menuBar = new JMenuBar();

        this.option = new JMenu("Option");
        this.seConnecter = new JMenuItem("Se connecter");
        this.seDeconnecter = new JMenuItem("Se deconnecter");
        this.quitter = new JMenuItem("Quitter");

        this.gestionComptes = new JMenu("Gestion du compte");
        this.listerComptes = new JMenuItem("Gérer les comptes");

        this.gestionClient = new JMenu("Gestion des clients");
        this.listerClients = new JMenuItem("Lister les clients");
        this.simPretVar = new JMenuItem("Simulation d'emprunt à taux variable");
        
        this.gestionProspect = new JMenu("Gestion des simulations FIXE");
        this.simProspect = new JMenuItem("Simulation à taux fixe");
        
        
        this.gestionAgence = new JMenu("Gestion de l'agence");
        this.showIndicators = new JMenuItem("Voir les indicateurs");
        this.setTitle("Simulateur de prêt BDG");
        initComponent();
    }

    private void initComponent() {
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.option.add(this.seConnecter);
        this.option.add(this.seDeconnecter);
        this.option.add(this.quitter);

        this.gestionComptes.add(listerComptes);
        
        this.gestionClient.add(listerClients);
        this.gestionClient.add(simPretVar);
        
        this.gestionProspect .add(simProspect);
        
        this.gestionAgence.add(showIndicators);
        
        this.menuBar.add(option);
        this.menuBar.add(gestionComptes);
        this.menuBar.add(gestionClient);
        this.menuBar.add(gestionProspect);
        this.menuBar.add(gestionAgence);
        
        this.desktopPane.setLayout(null);

        this.seConnecter.addActionListener(new SeConnecterListener());
        this.listerComptes.addActionListener(new GestionClientListener());
        this.listerClients.addActionListener(new ListerClientListener());
        this.simProspect.addActionListener(new simProspectListener());
        this.simPretVar.addActionListener(new simProspectEmpVarListener());
        this.showIndicators.addActionListener(new InfoIndicatorListener());
        
        
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, Toolkit.getDefaultToolkit().getScreenSize().width, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, Toolkit.getDefaultToolkit().getScreenSize().height, Short.MAX_VALUE)
        );

        
        super.setJMenuBar(this.menuBar);
        
        setMenuLoged(false);
        pack();
    }


    
    public void setMenuLoged(boolean state){
        this.seConnecter.setEnabled(!state);
        this.seDeconnecter.setEnabled(state);
    }
    
    public void addWindow(JInternalFrame frameToAdd, boolean toShow){
        this.desktopPane.add(frameToAdd);
        frameToAdd.setVisible(toShow);
    }

    @Override
    public boolean update(AbstractObservable sender, String message, Object... data) {
        switch(message.toString()){
            case "needRight": 
                System.out.println("Vous n'avez pas le droit pour effectuer cette opération");
                return true;
                
            case "connectionAutorised": 
                //setMenuLoged(true);
                controller.setModelConseiller((ConseillerHandle) data[0]);
                return true;
                
            default : 
                return false;
        }
        
    }

    private class InfoIndicatorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            View_Indicator view = controller.ouvrirIndicator();
             addWindow(view, true);
//addWindow(controller.ouvrirIndicator(), true);
        }
    }
    

    
    
    
    public class SeConnecterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            addWindow(controller.ouvrirConnection(), true);
        }
    }
    
    
    public class GestionClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
             //addWindow(controller.ouvrirFormGest(), true);
        }
    }
    
    public class ListerClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            View_GestClient view = controller.ouvrirListClient();
             addWindow(view, true);
        }
    }
    
    
    public class simProspectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            View_SimTauxFixe view = controller.ouvrirListProspect();
            addWindow(view, true);
        }
    }
    
    
    public class simProspectEmpVarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            View_SimTauxVari view = controller.ouvrirListProspectEmpVar();
            addWindow(view, true);
        }
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }
    
    
    
}
