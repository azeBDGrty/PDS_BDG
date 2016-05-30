/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.entities;

import com.pds.enums.Sexe;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zouhairhajji
 */
public class Client extends Personne{
    
    
    
    
    private Conseiller conseiller;
    private Agence domiciliation;
    private List<SimulationPret> simulationsPrets;
    
    
    public Client(Conseiller conseiller, Agence domiciliation, int idPerson, String lastName, String firstName, String adress, Timestamp dateBirthDate, Sexe sexe, int codePost, Pays pays, Departement departement, InfoPersonnel infoPerso, Account account) {
        super(idPerson, lastName, firstName, adress, dateBirthDate, sexe, codePost, pays, departement, infoPerso, account);
        this.conseiller = conseiller;
        this.domiciliation = domiciliation;
        this.simulationsPrets = new ArrayList<>();
    }

    public Client() {
        super();
        this.simulationsPrets = new ArrayList<>();
    }
    
    
    
    
    // Getters and Setters

    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public Agence getDomiciliation() {
        return domiciliation;
    }

    public void setDomiciliation(Agence domiciliation) {
        this.domiciliation = domiciliation;
    }

    public List<SimulationPret> getSimulationsPrets() {
        return simulationsPrets;
    }

    @Override
    public String toString() {
        return super.toString()+ "Client{" + "conseiller=" + conseiller + ", domiciliation=" + domiciliation + ", simulationsPrets=" + simulationsPrets + '}';
    }

    
    
    
}
