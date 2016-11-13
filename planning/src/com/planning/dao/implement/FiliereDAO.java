package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Filiere;
import com.planning.model.Seance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

public class FiliereDAO extends DAO<Filiere> {
    
    public FiliereDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Filiere obj) {
        try {
            Statement state1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query1 = new String("SELECT NEXTVAL ('NumFiliere') as numfiliere");
            ResultSet res = state1.executeQuery(query1);
            if(res.first()) {
                int id = res.getInt("NumFiliere");
                PreparedStatement prepare = this.conn.prepareStatement("INSERT INTO FILIERE (NumFiliere, NomFiliere) VALUES (?,?)");
                prepare.setInt(1,obj.getNumFiliere());
                prepare.setString(2,obj.getNomFiliere());
                prepare.executeUpdate();
                obj = this.find(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Filiere obj){
        try {
            this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM FILIERE WHERE NumFliere = " + obj.getNumFiliere());
            return false;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Filiere obj){
        try {
            this .conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE FILIERE SET "
                    + "NumFilere = '" + obj.getNumFiliere() + "'"
                            +" WHERE NomFiliere = " + obj.getNomFiliere());
            obj = this.find(obj.getNumFiliere());
	}
        catch (SQLException e) {
	            e.printStackTrace();
	}
        return false;
   
    }
    
    public Filiere find(int numf){
        Filiere filiere = new Filiere();
        try {    
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Filiere WHERE NumFiliere = " + numf);
            ResultSet res = state.executeQuery(query);
            if(res.first()) {
                filiere = new Filiere(res.getInt("numFiliere"), res.getString("nomFiliere"));   
                SeanceDAO seanceDAO = new SeanceDAO(this.conn);
                Set<Seance> seanceList = seanceDAO.findByNumFiliere(res.getInt("numfiliere"));
                Iterator iterator = seanceList.iterator();
                while(iterator.hasNext()){
                    filiere.addSeance((Seance)iterator.next());
                }
             }   
        }catch (SQLException e) {   
        e.printStackTrace();       
        }
        return filiere;
    }
}
