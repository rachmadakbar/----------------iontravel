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
public class HotelModel {
    String query;
    DBConnector db;
    
    public ArrayList<TemporaryObject> getActiveHotelByKotaProvinsi(String kota, String provinsi){
        query = "select * from hotel where status = '1' and nama='"+kota+"' and provinsi='"+provinsi+"'";
        return db.selectQuery(query);
    }
     
    public ArrayList<TemporaryObject> getActiveHotel(){
        query = "select * from hotel where status = '1'";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getAllHotel(){
        query = "select * from hotel";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getAllHotelByKotProvinsi(String kota, String provinsi){
        query = "select * from hotel and nama='"+kota+"' and provinsi='"+provinsi+"'";
        return db.selectQuery(query);
    }
    
    public ArrayList<TemporaryObject> getHotel(String id){
        query = "select * from hotel where id='"+id+"'";
        return db.selectQuery(query);
    }
    
    public void hide(String id){
        query = "update hotel set status = '0' where id = "
                + "'" + id + "'";
        db.query(query);
    }
    
    public void unhide(String id){
         query = "update hotel set status = '1' where id = "
                + "'" + id + "'";
        db.query(query);
    }
    
    public void updateHotel(String id, String nama, String provinsi, String namaHotel, String tipe, String tarif){
        query = "update hotel set nama = '"+nama+"' and provinsi = '"+provinsi
                +"' and namahotel = '"+namaHotel+"' and tipe='"+tipe+"' and tarif = '"+tarif+"' "
                + "where id = '" + id + "'";
        db.query(query);
    }
}
