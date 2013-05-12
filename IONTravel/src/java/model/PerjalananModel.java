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
public class PerjalananModel {
    String query;
    ResultSet resultset;
    DBConnector db;
    
    public ResultSet getAllPerjalanan(){
        query = "select * from perjalanan";
        return db.selectQuery(query);
    }
    
    public ResultSet getPerjalanan(String dariKota, String dariProv, 
            String keKota, String keProv){
        query = "select * from perjalanan where darikota='"+dariKota+"' and "
                + "dariProvinsi ='"+dariProv+"' and kekota = '"+keKota+"' and "
                + "keProv = '"+keProv+"'";
        return db.selectQuery(query);
    }
}
