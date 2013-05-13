/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rachmad-
 */
public class DBConnector {
    private final String username ="root";
    private final String password ="";
    private final  String url = "jdbc:mysql://localhost/iontravel";
    private Connection connection;
    private Statement statement ;
    private ResultSet resultSet;
    private ResultSetMetaData data;
    private int column;
    private TemporaryObject temp;
    private ArrayList<TemporaryObject> list;
    
    public void query(String query){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<TemporaryObject> selectQuery(String query){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            list = new ArrayList<TemporaryObject>();
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            data = resultSet.getMetaData();
            column = data.getColumnCount();
            while(resultSet.next()){
                temp = new TemporaryObject();
                for(int i=1; i<=column; i++){
                    temp.add(resultSet.getString(i));
                }
                list.add(temp);
            }
            connection.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
            
}
