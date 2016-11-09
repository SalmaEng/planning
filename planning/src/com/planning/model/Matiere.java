/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author genereux
 */
/*@Entity
@Table(name = "Matiere")
@NamedQueries({
    @NamedQuery(name = "Matiere.findAll", query = "SELECT m FROM Matiere m")})*/

public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumMatiere")*/
    private int numMatiere;
    /*@Column(name = "NomMatiere")*/
    private String nomMatiere;
    /*@Column(name = "DateDebut")
    @Temporal(TemporalType.DATE)*/
    private Date dateDebut;
    /*@Column(name = "DateFin")
    @Temporal(TemporalType.DATE)*/
    private Date dateFin;
    /*@OneToMany(mappedBy = "numMatiere")*/
    private Set<Seance> seanceList = new HashSet<Seance> ();

    public Matiere() {
    }

    public Matiere(int numMatiere) {
        this.numMatiere = numMatiere;
    }

    public int getNumMatiere() {
        return numMatiere;
    }

    public void setNumMatiere(int numMatiere) {
        this.numMatiere = numMatiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
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

    public Set<Seance> getSeanceList() {
        return seanceList;
    }

    public void setSeanceList(Set<Seance> seanceList) {
        this.seanceList = seanceList;
    }
    
    public void addSeance(Seance seance){
        if(!this.seanceList.contains(seance)) this.seanceList.add(seance);
    }
    
    public void removeSeance(Seance seance){
        this.seanceList.remove(seance);
        
    }
    
    public boolean equals(Matiere matiere){
        return this.getNumMatiere() == matiere.getNumMatiere();
    }


    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (numMatiere != null ? numMatiere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matiere)) {
            return false;
        }
        Matiere other = (Matiere) object;
        if ((this.numMatiere == null && other.numMatiere != null) || (this.numMatiere != null && !this.numMatiere.equals(other.numMatiere))) {
            return false;
        }
        return true;
    }*/

    @Override
    public String toString() {
        return "com.planning.model.Matiere[ numMatiere=" + numMatiere + " ]";
    }
    
}
