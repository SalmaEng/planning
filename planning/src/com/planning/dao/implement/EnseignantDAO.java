package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Enseignant;
import com.planning.model.Seance;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnseignantDAO extends DAO<Enseignant> {
    
    public EnseignantDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Enseignant obj) {
        try {
            Statement state1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query1 = new String("SELECT NEXTVAL ('NumEns') as numens");
            ResultSet res = state1.executeQuery(query1);
            if(res.first()) {
                int id = res.getInt("NumEns");
                PreparedStatement prepare = this.conn.prepareStatement("INSERT INTO ENSEIGNANT (NumEns, NomEns, PrenomEns, Mail, Tel, NumUser) VALUES (?,?,?,?,?,?)");
                prepare.setInt(1,obj.getNumEns());
                prepare.setString(2,obj.getNomEns());
                prepare.setString(3,obj.getPrenomEns());
                prepare.setString(4,obj.getMail());
                prepare.setInt(5,obj.getTel());
                prepare.setInt(6,obj.getNumUser());
                prepare.executeUpdate();
                obj = this.find(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Enseignant obj){
        try {
            this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM ENSEIGNANT WHERE NumEns = " + obj.getNumEns());
            return false;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Enseignant obj){
        try {
            this .conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE ENSEIGNANT SET "
                    + "NumEns = '" + obj.getNumEns() + "'"
                            +" WHERE NomEns = " + obj.getNomEns()+ "'"
                                    +" WHERE PrenomEns = " + obj.getPrenomEns()+ "'"
                                            +" WHERE Mail = " + obj.getMail()+ "'"
                                                    +" WHERE Tel = " + obj.getTel()+ "'"
                                                            +" WHERE NumUser = " + obj.getNumUser());
            obj = this.find(obj.getNumEns());
	}
        catch (SQLException e) {
	            e.printStackTrace();
	}
        return false;
    }
    
    public Enseignant find(int id){
        
        Enseignant enseignant = new Enseignant();
        
        try {
            Statement state = this.conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Enseignant WHERE NumEns = " + id);
            ResultSet res = state.executeQuery(query);
            if(res.first()) {
                enseignant = new Enseignant(res.getInt("numEns"), res.getString("nomEns"), res.getString("prenomEns"), res.getString("mail"), res.getInt("tel"), res.getInt("numUser"));
                SeanceDAO seanceDAO = new SeanceDAO(this.conn);
                Set<Seance> seanceList = seanceDAO.findByNumEns(res.getInt("numEns"));
                Iterator iterator = seanceList.iterator();
            while(iterator.hasNext()){
                enseignant.addSeance((Seance)iterator.next());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return enseignant;}
    
    
    public Set<Enseignant> findByNumUsers(int idu){
        Set<Enseignant> enseignantList = new HashSet<Enseignant>();
        try {
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Enseignant WHERE IDUsers = " + idu);
            ResultSet res = state.executeQuery(query);
            while(res.next()) {
                Enseignant enseignant = new Enseignant(res.getInt("numEns"), res.getString("nomEns"), res.getString("prenomEns"), res.getString("mail"), res.getInt("tel"), res.getInt("numUser"));
                enseignantList.add(enseignant);                  
            }
            return enseignantList;
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return enseignantList;
    }
}
