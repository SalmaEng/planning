package com.planning.dao.implement;

import com.planning.dao.DAO;
import com.planning.model.Users;
import com.planning.model.Enseignant;
import java.sql.Connection;
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
        return false;
    }
    
    public boolean delete(Users obj){
        return false;
    }
    
    public boolean update(Users obj){
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
