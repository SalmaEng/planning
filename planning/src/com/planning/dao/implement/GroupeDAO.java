package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Filiere;
import com.planning.model.Groupe;
import com.planning.model.Seance;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GroupeDAO extends DAO<Groupe> {
    
    public GroupeDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Groupe obj) {
        try {
            Statement state1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query1 = new String("SELECT NEXTVAL ('NumGroupe') as numgroupe");
            ResultSet res = state1.executeQuery(query1);
            if(res.first()) {
                int id = res.getInt("NumGroupe");
                PreparedStatement prepare = this.conn.prepareStatement("INSERT INTO GROUPE (NumGroupe, NomGroupe, Niveau) VALUES (?,?,?)");
                prepare.setInt(1,obj.getNumGroupe());
                prepare.setString(2,obj.getNomGroupe());
                prepare.setInt(3,obj.getNiveau());
                prepare.executeUpdate();
                obj = this.find(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Groupe obj){
        try {
            this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM GROUPE WHERE NumGroupe = " + obj.getNumGroupe()
            );
            return false;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Groupe obj){
        try {
            this .conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE GROUPE SET "
                    + "NumGroupe = '" + obj.getNumGroupe() + "'"
                            +" WHERE NomGroupe = " + obj.getNomGroupe()+ "'"
                                    +" WHERE Niveau = " + obj.getNiveau());
            obj = this.find(obj.getNumGroupe());
	}
        catch (SQLException e) {
	            e.printStackTrace();
	}
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

