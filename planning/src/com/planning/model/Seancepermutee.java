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
@Table(name = "seancepermutee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seancepermutee.findAll", query = "SELECT s FROM Seancepermutee s")
    , @NamedQuery(name = "Seancepermutee.findByNumSeanceARattp", query = "SELECT s FROM Seancepermutee s WHERE s.numSeanceARattp = :numSeanceARattp")
    , @NamedQuery(name = "Seancepermutee.findByNumSeancePermutee", query = "SELECT s FROM Seancepermutee s WHERE s.numSeancePermutee = :numSeancePermutee")})
public class Seancepermutee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NumSeanceARattp")
    private Integer numSeanceARattp;
    @Column(name = "NumSeancePermutee")
    private Integer numSeancePermutee;
    @JoinColumn(name = "NumSeanceARattp", referencedColumnName = "NumSeanceARattp", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Seancearattp seancearattp;

    public Seancepermutee() {
    }

    public Seancepermutee(Integer numSeanceARattp) {
        this.numSeanceARattp = numSeanceARattp;
    }

    public Integer getNumSeanceARattp() {
        return numSeanceARattp;
    }

    public void setNumSeanceARattp(Integer numSeanceARattp) {
        this.numSeanceARattp = numSeanceARattp;
    }

    public Integer getNumSeancePermutee() {
        return numSeancePermutee;
    }

    public void setNumSeancePermutee(Integer numSeancePermutee) {
        this.numSeancePermutee = numSeancePermutee;
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
        hash += (numSeanceARattp != null ? numSeanceARattp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seancepermutee)) {
            return false;
        }
        Seancepermutee other = (Seancepermutee) object;
        if ((this.numSeanceARattp == null && other.numSeanceARattp != null) || (this.numSeanceARattp != null && !this.numSeanceARattp.equals(other.numSeanceARattp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.Seancepermutee[ numSeanceARattp=" + numSeanceARattp + " ]";
    }
    
}
