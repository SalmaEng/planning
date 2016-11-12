package com.planning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;
    private int numGroupe;
    private String nomGroupe;
    private int niveau;
     private Set<Seance> seanceList = new HashSet<Seance> ();

    public Groupe() {
    }

    public Groupe(int numGroupe) {
        this.numGroupe = numGroupe;
    }

    public int getNumGroupe() {
        return numGroupe;
    }

    public void setNumGroupe(int numGroupe) {
        this.numGroupe = numGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
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
    
    public boolean equals(Groupe groupe){
        return this.getNumGroupe() == groupe.getNumGroupe();
    }



    public String toString() {
        return "com.planning.model.Groupe[ numGroupe=" + numGroupe + " ]";
    }
    
}
