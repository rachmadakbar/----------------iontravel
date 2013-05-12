/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helper.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ristek1
 */
public class UserModel {
    String query;
    ResultSet resultset;
    DBConnector db;
    
    public ResultSet getUser(String username, String password){
        query = "select * from user where username ='"+username+"' and "
                + "password = '"+password+"'";
        return db.selectQuery(query);
    }
    
        public boolean isAlreadyExist(String username){
        query = "select count(*) as c from user where username ='"+username+"'";
        boolean status = false;
        try {
            status = (db.selectQuery(query).getInt("c")) == 1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    public ResultSet getAllCustomer(){
        query = "select * from user where peran = 'customer'";
        return db.selectQuery(query);
    }
    
    public void bannedUser(String username){
        query = "update user set status = '0' where username = "
                + "'" + username + "'";
        db.query(query);
    }
    
    public void unbannedUser(String username){
        query = "update user set status = '1' where username = "
                + "'" + username + "'";
        db.query(query);
    }
    
    public void updateCustomer(String username, String password, String nama, 
            String alamat, String email, String no_tlp){
        query = "update user set password = '"+password+"' and nama = '"+nama
                +"' and alamat = '"+alamat+"' and email = '"+email+"' and "
                + "no_tlp = '"+no_tlp+"' where username = '" + username + "'";
        db.query(query);
    }
    
    public void insertCustomer (String username, String password, String nama, 
            String alamat, String email, String no_tlp){
        query = "insert into user values ('"+username+"','"+password+"','"+nama
                +"','"+alamat+"','"+email+"','"+no_tlp+"','customer'";
        db.query(query);
    }
}
