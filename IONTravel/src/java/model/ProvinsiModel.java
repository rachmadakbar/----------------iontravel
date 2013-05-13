/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import helper.DBConnector;
import helper.TemporaryObject;
import java.util.ArrayList;

/**
 *
 * @author Ristek1
 */
public class ProvinsiModel {
    String query;
    DBConnector db;
    
    public ArrayList<TemporaryObject> getAllActiveProvinsi(){
        query = "select distinct provinsi from kota where status = '1'";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getAllProvinsi(){
        query = "select distinct provinsi from kota";
        return db.selectQuery(query);
    }
}
