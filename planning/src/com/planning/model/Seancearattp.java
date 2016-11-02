/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pro
 */
@Entity
@Table(name = "seancearattp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seancearattp.findAll", query = "SELECT s FROM Seancearattp s")
    , @NamedQuery(name = "Seancearattp.findByNumSeanceARattp", query = "SELECT s FROM Seancearattp s WHERE s.numSeanceARattp = :numSeanceARattp")})
public class Seancearattp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NumSeanceARattp")
    private Integer numSeanceARattp;
    @JoinColumn(name = "NumSeanceARattp", referencedColumnName = "NumSeance", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Seance seance;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seancearattp")
    private Seancepermutee seancepermutee;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "seancearattp")
    private Seancerattp seancerattp;

    public Seancearattp() {
    }

    public Seancearattp(Integer numSeanceARattp) {
        this.numSeanceARattp = numSeanceARattp;
    }

    public Integer getNumSeanceARattp() {
        return numSeanceARattp;
    }

    public void setNumSeanceARattp(Integer numSeanceARattp) {
        this.numSeanceARattp = numSeanceARattp;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Seancepermutee getSeancepermutee() {
        return seancepermutee;
    }

    public void setSeancepermutee(Seancepermutee seancepermutee) {
        this.seancepermutee = seancepermutee;
    }

    public Seancerattp getSeancerattp() {
        return seancerattp;
    }

    public void setSeancerattp(Seancerattp seancerattp) {
        this.seancerattp = seancerattp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSeanceARattp != null ? numSeanceARattp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seancearattp)) {
            return false;
        }
        Seancearattp other = (Seancearattp) object;
        if ((this.numSeanceARattp == null && other.numSeanceARattp != null) || (this.numSeanceARattp != null && !this.numSeanceARattp.equals(other.numSeanceARattp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.Seancearattp[ numSeanceARattp=" + numSeanceARattp + " ]";
    }
    
}
