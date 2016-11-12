    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author genereux
 */
/*@Entity
@Table(name = "Users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")})*/

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUser")*/
    private int iDUser;
    /*@Column(name = "MotDePasse")*/
    private String motDePasse;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "numUser")*/
    private Set<Enseignant> enseignantList = new HashSet<Enseignant> ();

    public Users() {
    }

    public Users(int iDUser) {
        this.iDUser = iDUser;
    }

    public int getIDUser() {
        return iDUser;
    }

    public void setIDUser(int iDUser) {
        this.iDUser = iDUser;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Set<Enseignant> getEnseignantList() {
        return enseignantList;
    }

    public void setEnseignantList(Set<Enseignant> enseignantList) {
        this.enseignantList = enseignantList;
    }
    
    public void addEnseignant(Enseignant enseignant){
        if(!this.enseignantList.contains(enseignant)) this.enseignantList.add(enseignant);
    }
    
    public void removeEnseignant(Enseignant enseignant){
        this.enseignantList.remove(enseignant);
        
    }
    
    public boolean equals(Users user){
        return this.getIDUser() == user.getIDUser();
    }


    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUser != null ? iDUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.iDUser == null && other.iDUser != null) || (this.iDUser != null && !this.iDUser.equals(other.iDUser))) {
            return false;
        }
        return true;
    }

    */

    @Override
    public String toString() {
        return "com.planning.model.Users[ iDUser=" + iDUser + " ]";
    }
    
}
