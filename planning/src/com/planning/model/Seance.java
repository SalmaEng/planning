/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author genereux
 */
/*@Entity
@Table(name = "Seance")
@NamedQueries({
    @NamedQuery(name = "Seance.findAll", query = "SELECT s FROM Seance s")})*/

public class Seance implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumSeance")*/
    private int numSeance;
    /*@Column(name = "DateSeance")
    @Temporal(TemporalType.DATE)*/
    private Date dateSeance;
    /*@Column(name = "HeureSeance")
    @Temporal(TemporalType.DATE)*/
    private Date heureSeance;
    /*@Column(name = "EtatSeance")*/
    private int etatSeance;
    /*@JoinColumn(name = "NumEns", referencedColumnName = "NumEns")
    @ManyToOne(optional = false)*/
    private int numEns;
    /*@JoinColumn(name = "NumFiliere", referencedColumnName = "NumFiliere")
    @ManyToOne(optional = false)*/
    private int numFiliere;
    /*@JoinColumn(name = "NumGroupe", referencedColumnName = "NumGroupe")
    @ManyToOne*/
    private int numGroupe;
    /*@JoinColumn(name = "NumMatiere", referencedColumnName = "NumMatiere")
    @ManyToOne*/
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

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (numSeance != null ? numSeance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seance)) {
            return false;
        }
        Seance other = (Seance) object;
        if ((this.numSeance == null && other.numSeance != null) || (this.numSeance != null && !this.numSeance.equals(other.numSeance))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "com.planning.model.Seance[ numSeance=" + numSeance + " ]";
    }
    
}
