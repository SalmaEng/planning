/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Pro
 */
@Embeddable
public class EnsCoursPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NumEns_Cours")
    private int numEnsCours;
    @Basic(optional = false)
    @Column(name = "NumEns")
    private int numEns;
    @Basic(optional = false)
    @Column(name = "NumCours")
    private int numCours;

    public EnsCoursPK() {
    }

    public EnsCoursPK(int numEnsCours, int numEns, int numCours) {
        this.numEnsCours = numEnsCours;
        this.numEns = numEns;
        this.numCours = numCours;
    }

    public int getNumEnsCours() {
        return numEnsCours;
    }

    public void setNumEnsCours(int numEnsCours) {
        this.numEnsCours = numEnsCours;
    }

    public int getNumEns() {
        return numEns;
    }

    public void setNumEns(int numEns) {
        this.numEns = numEns;
    }

    public int getNumCours() {
        return numCours;
    }

    public void setNumCours(int numCours) {
        this.numCours = numCours;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numEnsCours;
        hash += (int) numEns;
        hash += (int) numCours;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnsCoursPK)) {
            return false;
        }
        EnsCoursPK other = (EnsCoursPK) object;
        if (this.numEnsCours != other.numEnsCours) {
            return false;
        }
        if (this.numEns != other.numEns) {
            return false;
        }
        if (this.numCours != other.numCours) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.EnsCoursPK[ numEnsCours=" + numEnsCours + ", numEns=" + numEns + ", numCours=" + numCours + " ]";
    }
    
}
