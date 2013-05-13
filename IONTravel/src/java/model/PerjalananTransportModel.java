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
public class PerjalananTransportModel {
    String query;
    DBConnector db;
    
    public PerjalananTransportModel(){
        db = new DBConnector();
    }
            
    public ArrayList<TemporaryObject> getAllTransportasiPerjalanan(){
        query = "select * from transportasiperjalanan";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getAllActive(){
        query = "select * from transportasiperjalanan where status='1'";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getAllTransportasiPerjalanan(String dariKota, String dariProv, 
            String keKota, String keProv){
        query = "select * from transportasiperjalanan where darikota='"+dariKota+"' and "
                + "dariProvinsi ='"+dariProv+"' and kekota = '"+keKota+"' and "
                + "keProvinsi = '"+keProv+"'";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getAllTransportasiPerjalanan(String dariKota, String dariProv, 
            String keKota, String keProv, String jenis){
        query = "select * from transportasiperjalanan natural join transportasi where darikota='"+dariKota+"' and "
                + "dariProvinsi ='"+dariProv+"' and kekota = '"+keKota+"' and "
                + "keProvinsi = '"+keProv+"' and jenis='"+jenis+"'";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getTransportasiPerjalanan(String dariKota, String dariProv, 
            String keKota, String keProv, String maskapai){
        query = "select * from transportasiperjalanan where darikota='"+dariKota+"' and "
                + "dariprovinsi ='"+dariProv+"' and kekota = '"+keKota+"' and "
                + "keprovinsi = '"+keProv+"' and namamaskapai ='"+maskapai+"'";
        return db.selectQuery(query);
    }
    
}
