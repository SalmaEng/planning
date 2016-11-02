/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pro
 */
@Entity
@Table(name = "seance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seance.findAll", query = "SELECT s FROM Seance s")
    , @NamedQuery(name = "Seance.findByNumSeance", query = "SELECT s FROM Seance s WHERE s.numSeance = :numSeance")
    , @NamedQuery(name = "Seance.findByDateSeance", query = "SELECT s FROM Seance s WHERE s.dateSeance = :dateSeance")
    , @NamedQuery(name = "Seance.findByHeureSeance", query = "SELECT s FROM Seance s WHERE s.heureSeance = :heureSeance")})
public class Seance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumSeance")
    private Integer numSeance;
    @Column(name = "DateSeance")
    @Temporal(TemporalType.DATE)
    private Date dateSeance;
    @Column(name = "HeureSeance")
    @Temporal(TemporalType.DATE)
    private Date heureSeance;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seance")
    private Seancearattp seancearattp;
    @JoinColumn(name = "NumCours", referencedColumnName = "NumCours")
    @ManyToOne
    private Cours numCours;
    @JoinColumn(name = "NumEns", referencedColumnName = "NumEns")
    @ManyToOne(optional = false)
    private Enseignant numEns;
    @JoinColumn(name = "NumGroupe", referencedColumnName = "NumGroupe")
    @ManyToOne
    private Groupe numGroupe;

    public Seance() {
    }

    public Seance(Integer numSeance) {
        this.numSeance = numSeance;
    }

    public Integer getNumSeance() {
        return numSeance;
    }

    public void setNumSeance(Integer numSeance) {
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

    public Seancearattp getSeancearattp() {
        return seancearattp;
    }

    public void setSeancearattp(Seancearattp seancearattp) {
        this.seancearattp = seancearattp;
    }

    public Cours getNumCours() {
        return numCours;
    }

    public void setNumCours(Cours numCours) {
        this.numCours = numCours;
    }

    public Enseignant getNumEns() {
        return numEns;
    }

    public void setNumEns(Enseignant numEns) {
        this.numEns = numEns;
    }

    public Groupe getNumGroupe() {
        return numGroupe;
    }

    public void setNumGroupe(Groupe numGroupe) {
        this.numGroupe = numGroupe;
    }

    @Override
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
    }

    @Override
    public String toString() {
        return "com.planning.model.Seance[ numSeance=" + numSeance + " ]";
    }
    
}
