/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author genereux
 */
/*@Entity
@Table(name = "Groupe")
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g")})*/

public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumGroupe")*/
    private int numGroupe;
    /*@Column(name = "NomGroupe")*/
    private String nomGroupe;
    /*@Column(name = "Niveau")*/
    private int niveau;
    /*@OneToMany(mappedBy = "numGroupe")*/
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



    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (numGroupe != null ? numGroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.numGroupe == null && other.numGroupe != null) || (this.numGroupe != null && !this.numGroupe.equals(other.numGroupe))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "com.planning.model.Groupe[ numGroupe=" + numGroupe + " ]";
    }
    
}
