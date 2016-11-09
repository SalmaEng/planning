/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author genereux
 */
/*@Entity
@Table(name = "Filiere")
@NamedQueries({
    @NamedQuery(name = "Filiere.findAll", query = "SELECT f FROM Filiere f")})*/

public class Filiere implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumFiliere")*/
    private int numFiliere;
    /*@Column(name = "NomFiliere")*/
    private String nomFiliere;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "numFiliere")*/
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


    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (numFiliere != null ? numFiliere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filiere)) {
            return false;
        }
        Filiere other = (Filiere) object;
        if ((this.numFiliere == null && other.numFiliere != null) || (this.numFiliere != null && !this.numFiliere.equals(other.numFiliere))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "com.planning.model.Filiere[ numFiliere=" + numFiliere + " ]";
    }
    
}
