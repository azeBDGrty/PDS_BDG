/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.serverhandler;

import com.pds.entities.Pays;
import com.pds.entities.InfoPersonnel;
import com.pds.entities.Account;
import com.pds.entities.Agence;
import com.pds.entities.Client;
import com.pds.entities.Region;
import com.pds.entities.Personne;
import com.pds.entities.Departement;
import com.pds.entities.Taux_directeur;
import com.pds.entities.SimulationPret;
import com.pds.entities.Conseiller;
import com.pds.entities.CalculPret;
import com.pds.enums.Sexe;
import com.pds.enums.Situation;
import com.pds.enums.TypeEmprunt;
import com.pds.enums.TypePret;
import com.pds.inoutdata.InPutData;
import com.pds.inoutdata.OutPutData;
import com.pds.networkprotocol.RoleUser;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author zouhairhajji
 */
public class ConseillerHandle extends AbstractHandle{

    private Conseiller user;
    private List<Region> regions;
    private List<Departement> departements;
    private List<Pays> pays;
    private List<Client> clients;
    private List<SimulationPret> simulations;
    private IndicatorHandle Indicator;

    public IndicatorHandle getIndicator() {
        return Indicator;
    }

    
    
    public ConseillerHandle(InPutData in, OutPutData out, Personne user) {
        super(in, out);
        this.user = (Conseiller) user;
        this.regions = new ArrayList<>();
        this.departements = new ArrayList<>();
        this.pays = new ArrayList<>();
        this.clients  = new ArrayList<>();
        this.Indicator = new IndicatorHandle();
        simulations=new ArrayList<>();
    }

    @Override
    public void run() {
        
        
        try {
            out.askAllRegion();
            in.getCommand();
            buildAllRegion(this.in.getLastDocument());
            
            out.askAllDepartement();
            in.getCommand();
            buildAllDepartement(in.getLastDocument());
            
            
            out.askAllPays();
            in.getCommand();
            buildAllPays(this.in.getLastDocument());
            

            
            Element root = new Element("rootElement");
            Element eIdConseille = new Element("idConseille");
            eIdConseille.setText(user.getAccount().getIdAccount()+"");
            root.addContent(eIdConseille);
            out.askAllInformationClient(root);
            in.getCommand();
            buildOwnInfo(this.in.getLastDocument());
            
            out.askAllClient();
            in.getCommand();
            buildAllClient(this.in.getLastDocument());
            

            Element eIdClient = new Element("idClient");
            eIdClient.setText(user.getAccount().getIdAccount()+"");
            root.addContent(eIdClient);
            out.askAllInformationClient(root);
            in.getCommand();
            buildOwnInfo(this.in.getLastDocument());
            
            
            
            out.askAllSimulationClientPret(root);
            in.getCommand();
            this.buildAllSimulation(this.in.getLastDocument());
            
            
            
        } catch (IOException | ParseException ex) {
            Logger.getLogger(ConseillerHandle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(running){
            
            try {
                switch(in.getCommand()){
                    
                    case connectionDone : 
                        System.out.println("Connection déjà effectuée");
                        break;
                    
                    case sendAllClient : 
                        break;
                        
                        
                    case sendInformationClient: 
                        System.out.println("Mes informations sont : " + new XMLOutputter().outputString(in.getLastDocument()));
                        buildOwnInfo(this.in.getLastDocument());
                        break;
                    
                    case sendTauxInteret: 
                        System.out.println(new XMLOutputter().outputString(this.in.getLastDocument()));
                        double tauxInteret = Double.parseDouble(this.in.getLastDocument().getRootElement().getChildText("taux"));
                        setChanged();
                        notifyObservers("setTauxInteretProspect", tauxInteret);
                        break;
                        
                    case sendAllRegion : 
                        System.out.println("Je dois recevoir la liste des regions;");
                        break;
                        
                    case sendAllDepartement : 
                        System.out.println("Je dois recevoir la liste des départements;");
                        break;
                        
                    case sendAllPays : 
                        System.out.println("Je dois recevoir la liste des pays;");
                        break;
                       
                   case sendLoanNumber : 
                       Indicator.setLoanNumber(this.in.getLastDocument());
                       setChanged();
                       //notifyObservers("sendLoanNumber");
                       //break;

                       notifyObservers("sendLoanNumbers",this.in.getLastDocument().getRootElement().getChildText("loanNumbers"));
                       break;

                   
                    case sendSimNumber : 
                       Indicator.setSimNumber(this.in.getLastDocument());
                        setChanged();
                       notifyObservers("sendSimNumber");
                        break;   
                    
                    case sendAvgAmount : 
                       Indicator.setAvgAmount(this.in.getLastDocument());
                        setChanged();
                       notifyObservers("sendAvgAmount");
                        break;
                    
                    case sendLoanTime : 
                       Indicator.setLoanTime(this.in.getLastDocument());
                        setChanged();
                       notifyObservers("sendLoanTime");
                        break;    
                    
                   case sendAvgAge : 
                       System.out.println("test ConseillerHandle " + this.in.getLastDocument().getRootElement().getChildText("resultat"));                       
                       Indicator.setAgebyLoanResult(this.in.getLastDocument());
                       System.out.println("resultat indicator niveau Cobseiller" + Indicator.getResultats().get(0));
                       
                       setChanged();
                       notifyObservers("sendAvgAge");
                        break;
                       
                    default : 
                      break; 
                      
                }  
            } catch (Exception ex) {
                Logger.getLogger(ConseillerHandle.class.getName()).log(Level.SEVERE, null, ex);
                startListenning();
            }
        }
        
    }

    
    
    
    public double askTauxInteret(int age, double revenue, String typeContrat, TypeEmprunt typeEmprunt, boolean isClient ){
        double tauxInteret = 100;
                
        Element eRoot = new Element("eRoot");
        Element eAge = new Element("age");
        eAge.setText(age+"");
        Element eRevenu = new Element("revenu");
        eRevenu.setText(revenue+"");
        Element eTypeContrat = new Element("typeContrat");
        eTypeContrat.setText(typeContrat);
        Element eTypeEmprunt = new Element("typeEmprunt");
        eTypeEmprunt.setText(typeEmprunt.toString());
        Element eIsClient = new Element("isClient");
        eIsClient.setText( (isClient) ? "1" : "0" );
        eRoot.addContent(eAge);
        eRoot.addContent(eRevenu);
        eRoot.addContent(eTypeContrat);
        eRoot.addContent(eTypeEmprunt);
        eRoot.addContent(eIsClient);
        this.out.askTauxInteretPretFixe(eRoot);
        
        return tauxInteret/100;
    }
    
   
    
    
    
    
    
    
    
    
    
    private void buildOwnInfo(Document lastDocument) throws ParseException {
        //System.out.println(new XMLOutputter().outputString(lastDocument));
        this.user.setIdPerson(Integer.parseInt(lastDocument.getRootElement().getChildText("id_employe")));
        this.user.setFirstName(lastDocument.getRootElement().getChildText("nom"));
        this.user.setLastName(lastDocument.getRootElement().getChildText("prenom"));
        this.user.setDateBirthDate(new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(lastDocument.getRootElement().getChildText("dateNaissance")).getTime()));
        this.user.setAdress(lastDocument.getRootElement().getChildText("adresse"));
        this.user.setSexe(Sexe.FactorySexe(lastDocument.getRootElement().getChildText("sexe")));
        this.user.setCodePost(Integer.parseInt(lastDocument.getRootElement().getChildText("codePostale")));
        this.user.setMatricule(lastDocument.getRootElement().getChildText("matricule"));
        // Select Pays
        this.user.setInfoPerso(new InfoPersonnel());
        this.user.getInfoPerso().setIdinfoPerso(Integer.parseInt(lastDocument.getRootElement().getChildText("id_info_perso")));
        this.user.getInfoPerso().setProfession(lastDocument.getRootElement().getChildText("profession"));
        this.user.getInfoPerso().setRevenuMensuel(Double.parseDouble(lastDocument.getRootElement().getChildText("mt_Revenus_mensuels")));
        this.user.getInfoPerso().setRevenuConjoint(Double.parseDouble(lastDocument.getRootElement().getChildText("mt_Revenus_conjoint")));
        this.user.getInfoPerso().setApportPerso(Double.parseDouble(lastDocument.getRootElement().getChildText("mt_apport_perso")));
        this.user.getInfoPerso().setAutre(Double.parseDouble(lastDocument.getRootElement().getChildText("mt_autre")));
        this.user.getInfoPerso().setSituation(Situation.FactorySituation(lastDocument.getRootElement().getChildText("situation")));
        this.user.getInfoPerso().setLastUpdate(new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(lastDocument.getRootElement().getChildText("lastUpdate")).getTime()));
    }
 
    
    
    
    
    
    
    
    
    
    
    
    
    private void buildAllRegion(Document lastDocument) {
        Element eRoot =lastDocument.getRootElement();
        for(Element region : eRoot.getChildren()){
            regions.add(new Region(Integer.parseInt(region.getChildText("id_region")), region.getChildText("region")));
        }
    }

    
    
    
    
    
    
    
    
    private void buildAllDepartement(Document lastDocument) {
        Element eRoot = lastDocument.getRootElement();
        for(Element departement : eRoot.getChildren()){
            this.departements.add(new Departement(
                                    departement.getChildText("id_departement"),
                                    departement.getChildText("departement"), 
                                new Region(Integer.parseInt(
                                        departement.getChildText("id_region")),
                                        departement.getChildText("region"))
            ));
        }
    }

    
    
    
    
    
    
    
    
    
    
    private void buildAllPays(Document lastDocument) {
        Element eRoot =lastDocument.getRootElement();
        for(Element epays : eRoot.getChildren()){
            pays.add(new Pays(Integer.parseInt(epays.getChildText("id_pays")),
                    Integer.parseInt(epays.getChildText("code")),
                    epays.getChildText("alpha2"),
                    epays.getChildText("alpha3"),
                    epays.getChildText("nom_en_fr"),
                    epays.getChildText("nom_en_gb")));
        }
    }
    
    private void buildAllSimulation(Document lastDocument) {
        Element eRoot =lastDocument.getRootElement();
        for(Element eSimulation : eRoot.getChildren()){
            simulations.add(new SimulationPret(Integer.parseInt(eSimulation.getChildText("id_sim_pret")),
                    Integer.parseInt(eSimulation.getChildText("duree_pret")),
                    Double.parseDouble(eSimulation.getChildText("mt_pret"))
            
            
            ));
        }
    }

    
    
    
    
    
    
    
    private void buildAllClient(Document lastDocument) throws ParseException {
        Element eRoot =lastDocument.getRootElement();
        System.out.println(new XMLOutputter().outputString(lastDocument));
        for(Element eClient : eRoot.getChildren()){
            Client client = new Client();
            client.setIdPerson(Integer.parseInt(eClient.getChildText("id_client")));
            client.setLastName(eClient.getChildText("nom"));
            client.setFirstName(eClient.getChildText("prenom"));
            client.setDateBirthDate(new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(eClient.getChildText("dateNaissance")).getTime()));
            client.setAdress(eClient.getChildText("adresse"));
            client.setSexe(Sexe.FactorySexe(eClient.getChildText("sexe")));
            client.setCodePost(Integer.parseInt(eClient.getChildText("codePostale")));
            
            client.setPays(new Pays(Integer.parseInt(eClient.getChildText("id_pays")), Integer.parseInt(eClient.getChildText("code")), eClient.getChildText("alpha2"), eClient.getChildText("alpha3"), eClient.getChildText("nom_fr_fr"), eClient.getChildText("nom_fr_gb")));
            client.setDepartement(new Departement(eClient.getChildText("id_departement"), eClient.getChildText("departement"), new Region(Integer.parseInt(eClient.getChildText("id_region")), eClient.getChildText("region"))));
            client.setAccount(new Account(Integer.parseInt(eClient.getChildText("id_account")), eClient.getChildText("ndc"), eClient.getChildText("questionSecrete"), RoleUser.client, new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(eClient.getChildText("dateCreation")).getTime())));
            client.setDomiciliation(new Agence(Integer.parseInt(eClient.getChildText("id_agence")), 0, 0, eClient.getChildText("description"), eClient.getChildText("adresse"), new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(eClient.getChildText("dateDebutService")).getTime()), 0));
            client.setInfoPerso(new InfoPersonnel(Integer.parseInt(eClient.getChildText("id_info_perso")), eClient.getChildText("profession"), Double.parseDouble(eClient.getChildText("mt_Revenus_mensuels")), Double.parseDouble(eClient.getChildText("mt_Revenus_conjoint")), Double.parseDouble(eClient.getChildText("mt_apport_perso")), Double.parseDouble(eClient.getChildText("mt_autre")), Situation.FactorySituation(eClient.getChildText("situation")), null));
            
            // addingSimulations
            for(Element eSimulation : eClient.getChildren("simulation")){
                SimulationPret sm = new SimulationPret();
                sm.setBlocked((eSimulation.getChildText("locked") == "1"));
                sm.setDureePret(Integer.parseInt(eSimulation.getChildText("duree_pret")));
                sm.setTypePret(TypePret.FactoryTypePret(eSimulation.getChildText("typeTaux")));
                sm.setMtPret(Double.parseDouble(eSimulation.getChildText("mt_pret")));
                sm.setIdSimPret(Integer.parseInt(eSimulation.getChildText("id_sim_pret")));
                sm.setDateSimulation(new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(eSimulation.getChildText("dateSimulation")).getTime()));
                sm.setDateContraction(new Timestamp(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").parse(eSimulation.getChildText("date_contraction")).getTime()));
                sm.setTypeEmprunt(TypeEmprunt.FactoryGetTypeEmprunt(eSimulation.getChildText("libelle")));
                CalculPret calcPret = new CalculPret();
                Taux_directeur tauxDirecteur = new Taux_directeur(Integer.parseInt(eSimulation.getChildText("id_tauxDirecteur")), Double.parseDouble(eSimulation.getChildText("valeur")));
                sm.setCalcPret(calcPret);
                calcPret.setTauxDirecteur(tauxDirecteur);
                
                
                calcPret.setCoef_assurance(Double.parseDouble(eSimulation.getChildText("coef_assurance")));
                calcPret.setF_dossier(Double.parseDouble(eSimulation.getChildText("f_dossier")));
                calcPret.setId_calcPret(Integer.parseInt(eSimulation.getChildText("id_calcPret")));
                calcPret.setT_marge(Double.parseDouble(eSimulation.getChildText("t_marge")));
                client.getSimulationsPrets().add(sm);
            }
            
            clients.add(client);
        }
        
        
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }
    
}
