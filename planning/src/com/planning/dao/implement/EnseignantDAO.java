package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Enseignant;
import com.planning.model.Seance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
