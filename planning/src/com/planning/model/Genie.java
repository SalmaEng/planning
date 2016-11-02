/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "genie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genie.findAll", query = "SELECT g FROM Genie g")
    , @NamedQuery(name = "Genie.findByNumGenie", query = "SELECT g FROM Genie g WHERE g.numGenie = :numGenie")
    , @NamedQuery(name = "Genie.findByNomGenie", query = "SELECT g FROM Genie g WHERE g.nomGenie = :nomGenie")})
public class Genie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumGenie")
    private Integer numGenie;
    @Column(name = "NomGenie")
    private String nomGenie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numGenie")
    private Collection<Groupe> groupeCollection;

    public Genie() {
    }

    public Genie(Integer numGenie) {
        this.numGenie = numGenie;
    }

    public Integer getNumGenie() {
        return numGenie;
    }

    public void setNumGenie(Integer numGenie) {
        this.numGenie = numGenie;
    }

    public String getNomGenie() {
        return nomGenie;
    }

    public void setNomGenie(String nomGenie) {
        this.nomGenie = nomGenie;
    }

    @XmlTransient
    public Collection<Groupe> getGroupeCollection() {
        return groupeCollection;
    }

    public void setGroupeCollection(Collection<Groupe> groupeCollection) {
        this.groupeCollection = groupeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numGenie != null ? numGenie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genie)) {
            return false;
        }
        Genie other = (Genie) object;
        if ((this.numGenie == null && other.numGenie != null) || (this.numGenie != null && !this.numGenie.equals(other.numGenie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.Genie[ numGenie=" + numGenie + " ]";
    }
    
}
