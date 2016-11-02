/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pro
 */
@Entity
@Table(name = "groupe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groupe.findAll", query = "SELECT g FROM Groupe g")
    , @NamedQuery(name = "Groupe.findByNumGroupe", query = "SELECT g FROM Groupe g WHERE g.numGroupe = :numGroupe")
    , @NamedQuery(name = "Groupe.findByNomGroupe", query = "SELECT g FROM Groupe g WHERE g.nomGroupe = :nomGroupe")
    , @NamedQuery(name = "Groupe.findByPromotion", query = "SELECT g FROM Groupe g WHERE g.promotion = :promotion")})
public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumGroupe")
    private Integer numGroupe;
    @Column(name = "NomGroupe")
    private String nomGroupe;
    @Column(name = "Promotion")
    private Integer promotion;
    @JoinColumn(name = "NumGenie", referencedColumnName = "NumGenie")
    @ManyToOne(optional = false)
    private Genie numGenie;
    @OneToMany(mappedBy = "numGroupe")
    private Collection<Seance> seanceCollection;

    public Groupe() {
    }

    public Groupe(Integer numGroupe) {
        this.numGroupe = numGroupe;
    }

    public Integer getNumGroupe() {
        return numGroupe;
    }

    public void setNumGroupe(Integer numGroupe) {
        this.numGroupe = numGroupe;
    }

    public String getNomGroupe() {
        return nomGroupe;
    }

    public void setNomGroupe(String nomGroupe) {
        this.nomGroupe = nomGroupe;
    }

    public Integer getPromotion() {
        return promotion;
    }

    public void setPromotion(Integer promotion) {
        this.promotion = promotion;
    }

    public Genie getNumGenie() {
        return numGenie;
    }

    public void setNumGenie(Genie numGenie) {
        this.numGenie = numGenie;
    }

    @XmlTransient
    public Collection<Seance> getSeanceCollection() {
        return seanceCollection;
    }

    public void setSeanceCollection(Collection<Seance> seanceCollection) {
        this.seanceCollection = seanceCollection;
    }

    @Override
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
    }

    @Override
    public String toString() {
        return "com.planning.model.Groupe[ numGroupe=" + numGroupe + " ]";
    }
    
}
