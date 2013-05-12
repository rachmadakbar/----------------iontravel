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
public class PerjalananTransportModel {
    String query;
    ResultSet resultset;
    DBConnector db;
    
    public ResultSet getAllTransportasiPerjalanan(){
        query = "select * from transportasiperjalanan";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllActive(){
        query = "select * from transportasiperjalanan where status='1'";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllTransportasiPerjalanan(String dariKota, String dariProv, 
            String keKota, String keProv){
        query = "select * from transportasiperjalanan where darikota='"+dariKota+"' and "
                + "dariProvinsi ='"+dariProv+"' and kekota = '"+keKota+"' and "
                + "keProv = '"+keProv+"'";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllTransportasiPerjalanan(String dariKota, String dariProv, 
            String keKota, String keProv, String jenis){
        query = "select * from transportasiperjalanan natural join transportasi where darikota='"+dariKota+"' and "
                + "dariProvinsi ='"+dariProv+"' and kekota = '"+keKota+"' and "
                + "keProv = '"+keProv+"' and jenis='"+jenis+"'";
        return db.selectQuery(query);
    }
    
    public ResultSet getTransportasiPerjalanan(String dariKota, String dariProv, 
            String keKota, String keProv, String maskapai){
        query = "select * from transportasiperjalanan where darikota='"+dariKota+"' and "
                + "dariProvinsi ='"+dariProv+"' and kekota = '"+keKota+"' and "
                + "keProv = '"+keProv+"' and namamaskapai ='"+maskapai+"'";
        return db.selectQuery(query);
    }
    
}
