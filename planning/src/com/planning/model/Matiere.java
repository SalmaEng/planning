package com.planning.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    private int numMatiere;
    private String nomMatiere;
    private Date dateDebut;
    private Date dateFin;
    private Set<Seance> seanceList = new HashSet<Seance> ();

    public Matiere() {
    }

    public Matiere(int numMatiere) {
        this.numMatiere = numMatiere;
    }

    public int getNumMatiere() {
        return numMatiere;
    }

    public void setNumMatiere(int numMatiere) {
        this.numMatiere = numMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Set<Seance> getSeanceList() {
        return seanceList;
    }

    public void setSeanceList(Set<Seance> seanceList) {
        this.seanceList = seanceList;
    }
    
    public void addSeance(Seance seance){
        if(!this.seanceList.contains(seance)) this.seanceList.add(seance);
    }
    
    public void removeSeance(Seance seance){
        this.seanceList.remove(seance);
        
    }
    
    public boolean equals(Matiere matiere){
        return this.getNumMatiere() == matiere.getNumMatiere();
    }

    public String toString() {
        return "com.planning.model.Matiere[ numMatiere=" + numMatiere + " ]";
    }
    
}
