/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pro
 */
@Entity
@Table(name = "ens_cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnsCours.findAll", query = "SELECT e FROM EnsCours e")
    , @NamedQuery(name = "EnsCours.findByNumEnsCours", query = "SELECT e FROM EnsCours e WHERE e.ensCoursPK.numEnsCours = :numEnsCours")
    , @NamedQuery(name = "EnsCours.findByNumEns", query = "SELECT e FROM EnsCours e WHERE e.ensCoursPK.numEns = :numEns")
    , @NamedQuery(name = "EnsCours.findByNumCours", query = "SELECT e FROM EnsCours e WHERE e.ensCoursPK.numCours = :numCours")})
public class EnsCours implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EnsCoursPK ensCoursPK;
    @JoinColumn(name = "NumCours", referencedColumnName = "NumCours", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cours cours;
    @JoinColumn(name = "NumEns", referencedColumnName = "NumEns", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Enseignant enseignant;

    public EnsCours() {
    }

    public EnsCours(EnsCoursPK ensCoursPK) {
        this.ensCoursPK = ensCoursPK;
    }

    public EnsCours(int numEnsCours, int numEns, int numCours) {
        this.ensCoursPK = new EnsCoursPK(numEnsCours, numEns, numCours);
    }

    public EnsCoursPK getEnsCoursPK() {
        return ensCoursPK;
    }

    public void setEnsCoursPK(EnsCoursPK ensCoursPK) {
        this.ensCoursPK = ensCoursPK;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ensCoursPK != null ? ensCoursPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnsCours)) {
            return false;
        }
        EnsCours other = (EnsCours) object;
        if ((this.ensCoursPK == null && other.ensCoursPK != null) || (this.ensCoursPK != null && !this.ensCoursPK.equals(other.ensCoursPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.EnsCours[ ensCoursPK=" + ensCoursPK + " ]";
    }
    
}
