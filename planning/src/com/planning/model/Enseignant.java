/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author genereux
 */
/*@Entity
@Table(name = "Enseignant")
@NamedQueries({
    @NamedQuery(name = "Enseignant.findAll", query = "SELECT e FROM Enseignant e")})*/

public class Enseignant implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NumEns")*/
    private int numEns;
    /*@Column(name = "NomEns")*/
    private String nomEns;
    /*@Column(name = "PrenomEns")*/
    private String prenomEns;
    /*@Column(name = "Mail")*/
    private String mail;
    /*@Column(name = "Tel")*/
    private int tel;
    /*@JoinColumn(name = "NumUser", referencedColumnName = "IDUser")
    @ManyToOne(optional = false)*/
    private int numUser;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "numEns")*/
    //private List<Seance> seanceList;
    
    private Set<Seance> seanceList = new HashSet<Seance>  ();

    public Enseignant() {
    }

    public Enseignant(int numEns) {
        this.numEns = numEns;
    }

    public Enseignant(int numEns, String nomEns, String prenomEns, String mail, int tel, int numUser) {
        
        this.numEns = numEns;
        this.nomEns = nomEns;
        this.prenomEns = prenomEns;
        this.mail = mail;
        this.tel = tel;
        this.numUser = numUser;
    }

    public int getNumEns() {
        return numEns;
    }

    public void setNumEns(int numEns) {
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getNumUser() {
        return numUser;
    }

    public void setNumUser(int numUser) {
        this.numUser = numUser;
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
    
    public boolean equals(Enseignant enseignant){
        return this.getNumEns() == enseignant.getNumEns();
    }

    /*@Override
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
*/

    @Override
    public String toString() {
        return "com.planning.model.Enseignant[ numEns=" + numEns + " ]";
    }
    
}
