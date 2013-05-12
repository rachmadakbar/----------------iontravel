/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Ristek1
 */
import helper.DBConnector;
import java.sql.ResultSet;

public class KotaModel {
    String query;
    ResultSet resultset;
    DBConnector db;
    
    public ResultSet getActiveKotaByProvinsi(String provinsi){
        query = "select * from kota where status = '1' and provinsi='"+provinsi+"'";
        return db.selectQuery(query);
    }
    
    public ResultSet getActiveKota(){
        query = "select * from kota where status = '1'";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllKota(){
        query = "select * from kota";
        return db.selectQuery(query);
    }
    public ResultSet getAllKotaByProvinsi(String provinsi){
        query = "select * from kota and provinsi='"+provinsi+"'";
        return db.selectQuery(query);
    }
    
    public ResultSet getKota(String nama, String provinsi){
        query = "select * from kota where nama='"+nama+"' and "
                + "provinsi = '"+provinsi+"'";
        return db.selectQuery(query);
    }
    
    public void hide(String nama, String provinsi){
        query = "update kota set status = '0' where nama = "
                + "'" + nama + "' and provinsi = '"+provinsi+"'";
        db.query(query);
    }
    
    public void unhide(String nama, String provinsi){
        query = "update kota set status = '1' where nama = "
                + "'" + nama + "' and provinsi = '"+provinsi+"'";
        db.query(query);
    }
    
    public void updateKota(String newNama, String newProvinsi, String oldNama, String oldProvinsi){
        query = "update kota set nama = '"+newNama+"' and provinsi = '"+newProvinsi
                +"' where nama = '" + oldNama + "' and provisi = '"+oldProvinsi+"'";
        db.query(query);
    }
}
