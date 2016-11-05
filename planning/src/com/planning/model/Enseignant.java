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
@Table(name = "enseignant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e")
    , @NamedQuery(name = "Enseignant.findByNumEns", query = "SELECT e FROM Enseignant e WHERE e.numEns = :numEns")
    , @NamedQuery(name = "Enseignant.findByNomEns", query = "SELECT e FROM Enseignant e WHERE e.nomEns = :nomEns")
    , @NamedQuery(name = "Enseignant.findByPrenomEns", query = "SELECT e FROM Enseignant e WHERE e.prenomEns = :prenomEns")
    , @NamedQuery(name = "Enseignant.findByMail", query = "SELECT e FROM Enseignant e WHERE e.mail = :mail")
    , @NamedQuery(name = "Enseignant.findByTel", query = "SELECT e FROM Enseignant e WHERE e.tel = :tel")})
public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumEns")
    private Integer numEns;
    @Column(name = "NomEns")
    private String nomEns;
    @Column(name = "PrenomEns")
    private String prenomEns;
    @Column(name = "Mail")
    private String mail;
    @Column(name = "Tel")
    private Integer tel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "enseignant")
    private Collection<EnsCours> ensCoursCollection;
    @JoinColumn(name = "NumDept", referencedColumnName = "NumDept")
    @ManyToOne(optional = false)
    private Departement numDept;
    @JoinColumn(name = "NumUser", referencedColumnName = "NumUser")
    @ManyToOne(optional = false)
    private Users numUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numEns")
    private Collection<Seance> seanceCollection;

    public Enseignant() {
    }

    public Enseignant(Integer numEns) {
        this.numEns = numEns;
    }

    public Integer getNumEns() {
        return numEns;
    }

    public void setNumEns(Integer numEns) {
        this.numEns = numEns;
    }

    public String getNomEns() {
        return nomEns;
    }

    public void setNomEns(String nomEns) {
        this.nomEns = nomEns;
    }

    public String getPrenomEns() {
        return prenomEns;
    }

    public void setPrenomEns(String prenomEns) {
        this.prenomEns = prenomEns;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    @XmlTransient
    public Collection<EnsCours> getEnsCoursCollection() {
        return ensCoursCollection;
    }

    public void setEnsCoursCollection(Collection<EnsCours> ensCoursCollection) {
        this.ensCoursCollection = ensCoursCollection;
    }

    public Departement getNumDept() {
        return numDept;
    }

    public void setNumDept(Departement numDept) {
        this.numDept = numDept;
    }

    public Users getNumUser() {
        return numUser;
    }

    public void setNumUser(Users numUser) {
        this.numUser = numUser;
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
        hash += (numEns != null ? numEns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enseignant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.numEns == null && other.numEns != null) || (this.numEns != null && !this.numEns.equals(other.numEns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.planning.model.Enseignant[ numEns=" + numEns + " ]";
    }
    
}
