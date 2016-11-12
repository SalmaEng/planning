package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Filiere;
import com.planning.model.Groupe;
import com.planning.model.Seance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

public class GroupeDAO extends DAO<Groupe> {
    
    public GroupeDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Groupe obj) {
        return false;
    }
    
    public boolean delete(Groupe obj){
        return false;
    }
    
    public boolean update(Groupe obj){
        return false;
   
    }
    
    public Groupe find(int numg){
        Groupe groupe = new Groupe();
        try {    
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Groupe WHERE NumGroupe = " + numg);
            ResultSet res = state.executeQuery(query);
            if(res.first()) {
                groupe = new Groupe(res.getInt("numGroupe"));   
                SeanceDAO seanceDAO = new SeanceDAO(this.conn);
                Set<Seance> seanceList = seanceDAO.findByNumGroupe(res.getInt("numGroupe"));
                Iterator iterator = seanceList.iterator();
                while(iterator.hasNext()){
                    groupe.addSeance((Seance)iterator.next());
                }
             }   
        }catch (SQLException e) {   
        e.printStackTrace();       
        }
        return groupe;
    }
}

