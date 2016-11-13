package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Users;
import com.planning.model.Enseignant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

public class UsersDAO extends DAO<Users> {
    
    public UsersDAO (Connection conn) {
        super(conn);
    }
    
    public boolean create(Users obj) {
        try {
            Statement state1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            String query1 = new String("SELECT NEXTVAL ('IDUser') as IDUser");
            ResultSet res = state1.executeQuery(query1);
            if(res.first()) {
                int id = res.getInt("IDUser");
                PreparedStatement prepare = this.conn.prepareStatement("INSERT INTO USERS (IDUser, MotDePasse) VALUES (?,?)");
                prepare.setInt(1,obj.getIDUser());
                prepare.setString(2,obj.getMotDePasse());
                prepare.executeUpdate();
                obj = this.find(id);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean delete(Users obj){
        try {
            this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate("DELETE FROM USERS WHERE IDUser = " + obj.getIDUser()
            );
            return false;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean update(Users obj){
        try {
            this .conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE).executeUpdate("UPDATE USERS SET "
                    + "IDUser = '" + obj.getIDUser() + "'"
                            +" WHERE MotDePasse = " + obj.getMotDePasse());
            obj = this.find(obj.getIDUser());
	}
        catch (SQLException e) {
	            e.printStackTrace();
	}
        return false;
   
    }
    
    public Users find(int idu){
        Users users = new Users();
        try {    
            Statement state = conn.createStatement(ResultSet.CONCUR_READ_ONLY, ResultSet.TYPE_SCROLL_INSENSITIVE);
            String query = new String("SELECT * FROM Users WHERE IDUsers = " + idu);
            ResultSet res = state.executeQuery(query);
            if(res.first()) {
                users = new Users(res.getInt("numGroupe"));   
                EnseignantDAO enseignantDAO = new EnseignantDAO(this.conn);
                Set<Enseignant> enseignantList = enseignantDAO.findByNumUsers(res.getInt("numGroupe"));
                Iterator iterator = enseignantList.iterator();
                while(iterator.hasNext()){
                    users.addEnseignant((Enseignant)iterator.next());
                }
             }   
        }catch (SQLException e) {   
        e.printStackTrace();       
        }
        return users;
    }
}
