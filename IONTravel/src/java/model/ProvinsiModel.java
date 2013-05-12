/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helper.DBConnector;
import java.sql.ResultSet;

/**
 *
 * @author Ristek1
 */
public class ProvinsiModel {
    String query;
    ResultSet resultset;
    DBConnector db;
    
    public ResultSet getAllActiveProvinsi(){
        query = "select distinct provinsi from kota where status = '1'";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllProvinsi(){
        query = "select distinct provinsi from kota";
        return db.selectQuery(query);
    }
}
