/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "seancerattp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seancerattp.findAll", query = "SELECT s FROM Seancerattp s")
    , @NamedQuery(name = "Seancerattp.findByNumSeanceRattp", query = "SELECT s FROM Seancerattp s WHERE s.numSeanceRattp = :numSeanceRattp")})
public class Seancerattp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NumSeanceRattp")
    private Integer numSeanceRattp;
    @JoinColumn(name = "NumSeanceRattp", referencedColumnName = "NumSeanceARattp", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Seancearattp seancearattp;

    public Seancerattp() {
    }

    public Seancerattp(Integer numSeanceRattp) {
        this.numSeanceRattp = numSeanceRattp;
    }

    public Integer getNumSeanceRattp() {
        return numSeanceRattp;
    }

    public void setNumSeanceRattp(Integer numSeanceRattp) {
        this.numSeanceRattp = numSeanceRattp;
    }

    public Seancearattp getSeancearattp() {
        return seancearattp;
    }

    public void setSeancearattp(Seancearattp seancearattp) {
        this.seancearattp = seancearattp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSeanceRattp != null ? numSeanceRattp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seancerattp)) {
            return false;
        }
        Seancerattp other = (Seancerattp) object;
        if ((this.numSeanceRattp == null && other.numSeanceRattp != null) || (this.numSeanceRattp != null && !this.numSeanceRattp.equals(other.numSeanceRattp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.Seancerattp[ numSeanceRattp=" + numSeanceRattp + " ]";
    }
    
}
