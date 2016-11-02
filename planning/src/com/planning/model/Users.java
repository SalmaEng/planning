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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByNumUser", query = "SELECT u FROM Users u WHERE u.numUser = :numUser")
    , @NamedQuery(name = "Users.findByNomUser", query = "SELECT u FROM Users u WHERE u.nomUser = :nomUser")
    , @NamedQuery(name = "Users.findByMotDePasse", query = "SELECT u FROM Users u WHERE u.motDePasse = :motDePasse")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumUser")
    private Integer numUser;
    @Column(name = "NomUser")
    private String nomUser;
    @Column(name = "MotDePasse")
    private String motDePasse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numUser")
    private Collection<Enseignant> enseignantCollection;

    public Users() {
    }

    public Users(Integer numUser) {
        this.numUser = numUser;
    }

    public Integer getNumUser() {
        return numUser;
    }

    public void setNumUser(Integer numUser) {
        this.numUser = numUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
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
        hash += (numUser != null ? numUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.numUser == null && other.numUser != null) || (this.numUser != null && !this.numUser.equals(other.numUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.Users[ numUser=" + numUser + " ]";
    }
    
}
