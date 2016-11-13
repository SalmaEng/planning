package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Matiere;
import com.planning.model.Seance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;
import java.sql.Time;
import java.sql.Date;

public class MatiereDAO extends DAO<Matiere> {
    
    public MatiereDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Matiere obj) {
        try {
            Statement state1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query1 = new String("SELECT NEXTVAL ('NumMatiere') as numgroupe");
            ResultSet res = state1.executeQuery(query1);
            if(res.first()) {
                int id = res.getInt("NumMatiere");
                PreparedStatement prepare = this.conn.prepareStatement("INSERT INTO Matiere (NumMatiere, NomMatiere, DateDebut, DateFin) VALUES (?,?,?,?)");
                prepare.setInt(1,obj.getNumMatiere());
                prepare.setString(2,obj.getNomMatiere());
                prepare.setDate(3,(Date) obj.getDateDebut());
                prepare.setDate(4,(Date) obj.getDateFin());
                prepare.executeUpdate();
                obj = this.find(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Matiere obj){
        try {
            this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM MATIERE WHERE NumMatiere = " + obj.getNumMatiere()
            );
            return false;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Matiere obj){
        try {
            this .conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE MATIERE SET "
                    + "NumMatiere = '" + obj.getNumMatiere() + "'"
                            +" WHERE NomMatiere = " + obj.getNomMatiere()+ "'"
                                    +" WHERE DateDebut = " + obj.getDateDebut()+ "'"
                                            +" WHERE DateFin = " + obj.getDateFin());
            obj = this.find(obj.getNumMatiere());
	}
        catch (SQLException e) {
	            e.printStackTrace();
	}
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
