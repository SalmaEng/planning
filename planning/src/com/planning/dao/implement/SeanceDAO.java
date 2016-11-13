package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Seance;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.sql.Time;
import java.sql.Date;

public class SeanceDAO extends DAO<Seance> {
        
    public SeanceDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Seance obj) {
        try {
            Statement state1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query1 = new String("SELECT NEXTVAL ('NumSeance') as numseance");
            ResultSet res = state1.executeQuery(query1);
            if(res.first()) {
                int id = res.getInt("NumSeance");
                PreparedStatement prepare = this.conn.prepareStatement("INSERT INTO SEANCE (NumSeance, DateSeance, HeurSeance, NumEns, NumMatiere, NumGroupe, NumFiliere, EtatSeance) VALUES (?,?,?,?,?,?,?,?)");
                prepare.setInt(1,obj.getNumSeance());
                prepare.setDate(2, (Date) obj.getDateSeance());
                prepare.setDate(3,(Date) obj.getHeureSeance());
                prepare.setInt(4,obj.getNumEns());
                prepare.setInt(5,obj.getNumMatiere());
                prepare.setInt(6,obj.getNumGroupe());
                prepare.setInt(7,obj.getNumFiliere());
                prepare.setInt(8,obj.getEtatSeance());
                prepare.executeUpdate();
                obj = this.find(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Seance obj){
        try {
            this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM Seance WHERE NumSeance = " + obj.getNumSeance()
            );
            return false;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Seance obj){
        try {
            this .conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE Seance SET "
                    + "NumSeance = '" + obj.getNumSeance() + "'"
                            +" WHERE DateSeance = " + obj.getDateSeance()+ "'"
                                    +" WHERE HeureSenace = " + obj.getHeureSeance()+ "'"
                                            +" WHERE NumEns = " + obj.getNumEns()+ "'"
                                                    +" WHERE NumMatiere = " + obj.getNumMatiere()+ "'"
                                                            +" WHERE NumGroupe = " + obj.getNumGroupe()
                                                                    +" WHERE NumFiliere = " + obj.getNumFiliere()
                                                                            +" WHERE EtatSeance = " + obj.getEtatSeance());
            obj = this.find(obj.getNumSeance());
	}
        catch (SQLException e) {
	            e.printStackTrace();
	}
        return false;
   
    }
    
    public Seance find(int id){
        Seance seance = new Seance();
        try {
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Seance WHERE NumSeance = " + id);
            ResultSet res = state.executeQuery(query);
            if(res.first()) {
                seance = new Seance(res.getInt(0), res.getDate(1), res.getTime(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6), res.getInt(7));                
            }
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return seance;
    }
    
    
    
    public Set<Seance> findByNumEns(int nume){
        Set<Seance> seanceList = new HashSet<Seance>();
        try {
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Seance WHERE NumEns = " + nume);
            ResultSet res = state.executeQuery(query);
            while(res.next()) {
                Seance seance = new Seance(res.getInt("numSeance"), res.getDate("dateSeance"), res.getTime("heureSeance"), res.getInt("etatSeance"), res.getInt("numEns"), res.getInt("numFiliere"), res.getInt("numGroupe"), res.getInt("numMatiere"));
                seanceList.add(seance);                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seanceList;
    }
    
    
    public Set<Seance> findByNumFiliere(int numf){
        Set<Seance> seanceList = new HashSet<Seance>();
        try {
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Seance WHERE NumFiliere = " + numf);
            ResultSet res = state.executeQuery(query);
            while(res.next()) {
                Seance seance = new Seance(res.getInt("numSeance"), res.getDate("dateSeance"), res.getTime("heureSeance"), res.getInt("etatSeance"), res.getInt("numEns"), res.getInt("numFiliere"), res.getInt("numGroupe"), res.getInt("numMatiere"));
                seanceList.add(seance);                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seanceList;
    }
    
    
    
    public Set<Seance> findByNumGroupe(int numg){
        Set<Seance> seanceList = new HashSet<Seance>();
        try {
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Seance WHERE NumGroupe = " + numg);
            ResultSet res = state.executeQuery(query);
            while(res.next()) {
                Seance seance = new Seance(res.getInt("numSeance"), res.getDate("dateSeance"), res.getTime("heureSeance"), res.getInt("etatSeance"), res.getInt("numEns"), res.getInt("numFiliere"), res.getInt("numGroupe"), res.getInt("numMatiere"));
                seanceList.add(seance);                  
            }
            return seanceList;
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return seanceList;
    }
  
    
    
    public Set<Seance> findByNumMatiere(int numm){
        Set<Seance> seanceList = new HashSet<Seance>();
        try {
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Seance WHERE NumMatiere = " + numm);
            ResultSet res = state.executeQuery(query);
            while(res.next()) {
                Seance seance = new Seance(res.getInt("numSeance"), res.getDate("dateSeance"), res.getTime("heureSeance"), res.getInt("etatSeance"), res.getInt("numEns"), res.getInt("numFiliere"), res.getInt("numGroupe"), res.getInt("numMatiere"));
                seanceList.add(seance);                  
            }
            return seanceList;
        } catch (SQLException e) {
             e.printStackTrace();
        }
        return seanceList;
    }
    
    
    
}
