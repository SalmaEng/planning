/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pro
 */
@Entity
@Table(name = "cours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cours.findAll", query = "SELECT c FROM Cours c")
    , @NamedQuery(name = "Cours.findByNumCours", query = "SELECT c FROM Cours c WHERE c.numCours = :numCours")
    , @NamedQuery(name = "Cours.findByNomCours", query = "SELECT c FROM Cours c WHERE c.nomCours = :nomCours")
    , @NamedQuery(name = "Cours.findByDateDebut", query = "SELECT c FROM Cours c WHERE c.dateDebut = :dateDebut")
    , @NamedQuery(name = "Cours.findByDateFin", query = "SELECT c FROM Cours c WHERE c.dateFin = :dateFin")})
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumCours")
    private Integer numCours;
    @Column(name = "NomCours")
    private String nomCours;
    @Column(name = "DateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "DateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cours")
    private Collection<EnsCours> ensCoursCollection;
    @OneToMany(mappedBy = "numCours")
    private Collection<Seance> seanceCollection;

    public Cours() {
    }

    public Cours(Integer numCours) {
        this.numCours = numCours;
    }

    public Integer getNumCours() {
        return numCours;
    }

    public void setNumCours(Integer numCours) {
        this.numCours = numCours;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @XmlTransient
    public Collection<EnsCours> getEnsCoursCollection() {
        return ensCoursCollection;
    }

    public void setEnsCoursCollection(Collection<EnsCours> ensCoursCollection) {
        this.ensCoursCollection = ensCoursCollection;
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
        hash += (numCours != null ? numCours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cours)) {
            return false;
        }
        Cours other = (Cours) object;
        if ((this.numCours == null && other.numCours != null) || (this.numCours != null && !this.numCours.equals(other.numCours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.Cours[ numCours=" + numCours + " ]";
    }
    
}
