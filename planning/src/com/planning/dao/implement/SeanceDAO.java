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
            
            String query = new String("SELECT * FROM Seance WHERE NumEns = " + id);
            
            ResultSet res = state.executeQuery(query);
            
            if(res.first()) {
                
                seance = new Seance();
                                
            }
        
        } catch (SQLException e) {
            
             e.printStackTrace();
        
        }
        
        return seance;
}
    
}
