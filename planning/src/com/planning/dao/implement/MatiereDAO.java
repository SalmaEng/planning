package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Matiere;
import com.planning.model.Seance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

public class MatiereDAO extends DAO<Matiere> {
    
    public MatiereDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Matiere obj) {
        return false;
    }
    
    public boolean delete(Matiere obj){
        return false;
    }
    
    public boolean update(Matiere obj){
        return false;
   
    }
    
    public Matiere find(int numm){
        Matiere matiere = new Matiere();
        try {    
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Matiere WHERE NumMatiere = " + numm);
            ResultSet res = state.executeQuery(query);
            if(res.first()) {
                matiere = new Matiere(res.getInt("numMatiere"));   
                SeanceDAO seanceDAO = new SeanceDAO(this.conn);
                Set<Seance> seanceList = seanceDAO.findByNumFiliere(res.getInt("numMatiere"));
                Iterator iterator = seanceList.iterator();
                while(iterator.hasNext()){
                    matiere.addSeance((Seance)iterator.next());
                }
             }   
        }catch (SQLException e) {   
        e.printStackTrace();       
        }
        return matiere;
    }
}
