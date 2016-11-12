package com.planning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    private int numFiliere;
    private String nomFiliere;
    private Set<Seance> seanceList = new HashSet<Seance> ();

    public Filiere() {
    }

    public Filiere(int numFiliere) {
        this.numFiliere = numFiliere;
    }

    public Filiere(int numFilire, String nomFiliere) {
        this.nomFiliere = nomFiliere;
        this.numFiliere = numFiliere;
    }

    public int getNumFiliere() {
        return numFiliere;
    }

    public void setNumFiliere(int numFiliere) {
        this.numFiliere = numFiliere;
    }

    public String getNomFiliere() {
        return nomFiliere;
    }

    public void setNomFiliere(String nomFiliere) {
        this.nomFiliere = nomFiliere;
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
    
    public boolean equals(Filiere filiere){
        return this.getNumFiliere() == filiere.getNumFiliere();
    }

    public String toString() {
        return "com.planning.model.Filiere[ numFiliere=" + numFiliere + " ]";
    }
    
}
