package com.planning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    private int iDUser;
    private String motDePasse;
   
    private Set<Enseignant> enseignantList = new HashSet<Enseignant> ();

    public Users() {
    }

    public Users(int iDUser) {
        this.iDUser = iDUser;
    }

    public int getIDUser() {
        return iDUser;
    }

    public void setIDUser(int iDUser) {
        this.iDUser = iDUser;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Set<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(Set<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }
    
    public void addEnseignant(Enseignant enseignant){
        if(!this.enseignantList.contains(enseignant)) this.enseignantList.add(enseignant);
    }
    
    public void removeEnseignant(Enseignant enseignant){
        this.enseignantList.remove(enseignant);
        
    }
    
    public boolean equals(Users user){
        return this.getIDUser() == user.getIDUser();
    }


    public String toString() {
        return "com.planning.model.Users[ iDUser=" + iDUser + " ]";
    }
    
}

