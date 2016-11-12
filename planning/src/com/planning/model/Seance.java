package com.planning.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Seance implements Serializable {

    private static final long serialVersionUID = 1L;
    private int numSeance;
    private Date dateSeance;
    private Date heureSeance;
    private int etatSeance;
    private int numEns;
    private int numFiliere;
    private int numGroupe;
    private int numMatiere;

    public Seance(int numSeance, Date dateSeance, Time heureSeance, int numEns, int numMatiere, int numGroupe, int numFiliere, int etatSeance) {
        
        this.numSeance = numSeance;
        this.dateSeance = dateSeance;
        this.heureSeance = heureSeance;
        this.numEns = numEns;
        this.numMatiere = numMatiere;
        this.numGroupe = numGroupe;
        this.numFiliere = numFiliere;
        this.etatSeance = etatSeance;
    }
    
    public Seance(){}

    public Seance(int numSeance) {
        this.numSeance = numSeance;
    }

    public int getNumSeance() {
        return numSeance;
    }

    public void setNumSeance(int numSeance) {
        this.numSeance = numSeance;
    }

    public Date getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Date dateSeance) {
        this.dateSeance = dateSeance;
    }

    public Date getHeureSeance() {
        return heureSeance;
    }

    public void setHeureSeance(Date heureSeance) {
        this.heureSeance = heureSeance;
    }

    public int getEtatSeance() {
        return etatSeance;
    }

    public void setEtatSeance(int etatSeance) {
        this.etatSeance = etatSeance;
    }

    public int getNumEns() {
        return numEns;
    }

    public void setNumEns(int numEns) {
        this.numEns = numEns;
    }

    public int getNumFiliere() {
        return numFiliere;
    }

    public void setNumFiliere(int numFiliere) {
        this.numFiliere = numFiliere;
    }

    public int getNumGroupe() {
        return numGroupe;
    }

    public void setNumGroupe(int numGroupe) {
        this.numGroupe = numGroupe;
    }

    public int getNumMatiere() {
        return numMatiere;
    }

    public void setNumMatiere(int numMatiere) {
        this.numMatiere = numMatiere;
    }

    
    public String toString() {
        return "com.planning.model.Seance[ numSeance=" + numSeance + " ]";
    }
    
}
