/*
 * To change this licenseignante header, choose Licenseignante Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.ConnexionBD;
import com.planning.model.Enseignant;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author genereux
 */
public class EnseignantDAO extends DAO<Enseignant> {
    
    public EnseignantDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Enseignant obj) {
        return false;
    }
    
    public boolean delete(Enseignant obj){
        return false;
    }
    
    public boolean update(Enseignant obj){
        return false;
   
    }
    
    public Enseignant find(int id){
        
        Enseignant enseignant = new Enseignant();
        
        try {
            
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            
            String query = new String("SELECT * FROM Enseignant WHERE NumEns = " + id);
            
            ResultSet res = state.executeQuery(query);
            
            if(res.first()) {
                
                enseignant = new Enseignant(res.getInt(0), res.getString(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5));
                
                
                SeanceDAO seanceDAO = new SeanceDAO(this.conn);
                
                String query2 = new String("SELECT * FROM Seance WHERE Seance.NumEns = Enseignant.NumEns and Enseignant.NumEns = " + res.getInt(0));
                
                ResultSet res2 = state.executeQuery(query2);
                
                
                while(res2.next()) {
                
                    enseignant.addSeance(seance);
                }
                
            }
        
        } catch (SQLException e) {
            
             e.printStackTrace();
        
        }
        
        return enseignant;
    
    }
    
}
