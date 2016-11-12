package com.planning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    private int numEns;
    private String nomEns;
    private String prenomEns;
    private String mail;
    private int tel;
    private int numUser;
    
    private Set<Seance> seanceList = new HashSet<Seance>  ();

    public Enseignant() {
    }

    public Enseignant(int numEns) {
        this.numEns = numEns;
    }

    public Enseignant(int numEns, String nomEns, String prenomEns, String mail, int tel, int numUser) {
        
        this.numEns = numEns;
        this.nomEns = nomEns;
        this.prenomEns = prenomEns;
        this.mail = mail;
        this.tel = tel;
        this.numUser = numUser;
    }

    public int getNumEns() {
        return numEns;
    }

    public void setNumEns(int numEns) {
        this.numEns = numEns;
    }

    public String getNomEns() {
        return nomEns;
    }

    public void setNomEns(String nomEns) {
        this.nomEns = nomEns;
    }

    public String getPrenomEns() {
        return prenomEns;
    }

    public void setPrenomEns(String prenomEns) {
        this.prenomEns = prenomEns;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getNumUser() {
        return numUser;
    }

    public void setNumUser(int numUser) {
        this.numUser = numUser;
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
    
    public boolean equals(Enseignant enseignant){
        return this.getNumEns() == enseignant.getNumEns();
    }

    
    public String toString() {
        return "com.planning.model.Enseignant[ numEns=" + numEns + " ]";
    }
    
}
