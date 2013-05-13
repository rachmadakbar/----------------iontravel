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
public class PerjalananModel {
    String query;
    DBConnector db;
    
    public ArrayList<TemporaryObject> getAllPerjalanan(){
        query = "select * from perjalanan";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getPerjalanan(String dariKota, String dariProv, 
            String keKota, String keProv){
        query = "select * from perjalanan where darikota='"+dariKota+"' and "
                + "dariProvinsi ='"+dariProv+"' and kekota = '"+keKota+"' and "
                + "keProv = '"+keProv+"'";
        return db.selectQuery(query);
    }
}
