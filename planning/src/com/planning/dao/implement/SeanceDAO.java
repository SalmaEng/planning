/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Seance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author genereux
 */
public class SeanceDAO extends DAO<Seance> {
        
    public SeanceDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Seance obj) {
        return false;
    }
    
    public boolean delete(Seance obj){
        return false;
    }
    
    public boolean update(Seance obj){
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
    
    public Set<Seance> findByNumEns(int id){
        
        Set<Seance> seanceList = new HashSet<Seance>();
        
        try {
            
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            String query = new String("SELECT * FROM Seance WHERE NumEns = " + id);
            
            ResultSet res = state.executeQuery(query);
            
            while(res.next()) {
                
                Seance seance = new Seance(res.getInt(0), res.getDate(1), res.getTime(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6), res.getInt(7));
                
                seanceList.add(seance);
                                
            }
        
        } catch (SQLException e) {
            
             e.printStackTrace();
        
        }
        
        return seanceList;
    }
    
    public Set<Seance> findByNumFiliere(int id){
        
        Set<Seance> seanceList = new HashSet<Seance>();
        
        try {
            
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            String query = new String("SELECT * FROM Seance WHERE NumFiliere = " + id);
            
            ResultSet res = state.executeQuery(query);
            
            while(res.next()) {
                
                Seance seance = new Seance(res.getInt(0), res.getDate(1), res.getTime(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6), res.getInt(7));
                
                seanceList.add(seance);
                
                                
            }
        
            return seanceList;
            
        } catch (SQLException e) {
            
             e.printStackTrace();
        
        }
        
        return seanceList;
    }
    
}
