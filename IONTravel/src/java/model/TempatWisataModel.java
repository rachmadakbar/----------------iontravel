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
public class TempatWisataModel {
    String query;
    ResultSet resultset;
    DBConnector db;
    
    public ResultSet getAllActiveTempatWisata(){
        query = "select * from tempat_wisata where status = '1'";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllActiveTempatWisataByKotaProvinsi(String kota, String provinsi){
        query = "select * from tempat_wisata where status = '1' and kota='"+kota+"' and provinsi='"+provinsi+"'";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllTempatWisata(){
        query = "select * from tempat_wisata";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllTempatWisataByKotaProvinsi(String kota, String provinsi){
        query = "select * from tempat_wisata where kota='"+kota+"' and provinsi='"+provinsi+"'";
        return db.selectQuery(query);
    }
    
    public ResultSet getTempatWisata(String id){
        query = "select * from tempat_wisata where id='"+id+"'";
        return db.selectQuery(query);
    }
    
   public void hide(String id){
        query = "update tempat_wisata set status = '0' where id = "
                + "'" + id + "'";
        db.query(query);
    }
    
    public void unhide(String id){
         query = "update tempat_wisata set status = '1' where id = "
                + "'" + id + "'";
        db.query(query);
    }
    
    public void updateTempatWisata(String id, String nama, String kota, String provinsi, String tipe){
        query = "update tempat_wisata set nama = '"+nama+"' and kota = '"+kota+"' and provinsi = '"+provinsi
                +"' and tipe='"+tipe+"' where id = '" + id + "'";
        db.query(query);
    }
}
