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
@Table(name = "departement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departement.findAll", query = "SELECT d FROM Departement d")
    , @NamedQuery(name = "Departement.findByNumDept", query = "SELECT d FROM Departement d WHERE d.numDept = :numDept")
    , @NamedQuery(name = "Departement.findByNomDept", query = "SELECT d FROM Departement d WHERE d.nomDept = :nomDept")
    , @NamedQuery(name = "Departement.findByNumMgr", query = "SELECT d FROM Departement d WHERE d.numMgr = :numMgr")})
public class Departement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumDept")
    private Integer numDept;
    @Column(name = "NomDept")
    private String nomDept;
    @Column(name = "NumMgr")
    private Integer numMgr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numDept")
    private Collection<Enseignant> enseignantCollection;

    public Departement() {
    }

    public Departement(Integer numDept) {
        this.numDept = numDept;
    }

    public Integer getNumDept() {
        return numDept;
    }

    public void setNumDept(Integer numDept) {
        this.numDept = numDept;
    }

    public String getNomDept() {
        return nomDept;
    }

    public void setNomDept(String nomDept) {
        this.nomDept = nomDept;
    }

    public Integer getNumMgr() {
        return numMgr;
    }

    public void setNumMgr(Integer numMgr) {
        this.numMgr = numMgr;
    }

    @XmlTransient
    public Collection<Enseignant> getEnseignantCollection() {
        return enseignantCollection;
    }

    public void setEnseignantCollection(Collection<Enseignant> enseignantCollection) {
        this.enseignantCollection = enseignantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numDept != null ? numDept.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        if ((this.numDept == null && other.numDept != null) || (this.numDept != null && !this.numDept.equals(other.numDept))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.Departement[ numDept=" + numDept + " ]";
    }
    
}
