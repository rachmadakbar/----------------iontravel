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
public class TransportasiModel {
    String query;
    ResultSet resultset;
    DBConnector db;
    
    public ResultSet getTransport(String namamaskapai){
        query = "select * from transport where namamaskapai ='"+namamaskapai+"'";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllActiveTransport(){
        query = "select * from transport where status = '1'";
        return db.selectQuery(query);
    }
    
    public ResultSet getAllTransport(){
        query = "select * from transport";
        return db.selectQuery(query);
    }
    
    public void hide(String namamaskapai){
        query = "update transport set status = '0' where namamaskapai = "
                + "'" + namamaskapai+"'";
        db.query(query);
    }
    
    public void unhide(String namamaskapai){
         query = "update transport set status = '0' where namamaskapai = "
                + "'" + namamaskapai+"'";
        db.query(query);
    }
    
    public void updateTransport(String newNamaMaskapai, String jenis, 
            String kelas, String tarif, String oldNamaMaskapai){
        query = "update transport set namamaskapai = '"+newNamaMaskapai
                +"' and jenis = '"+jenis+"' and kelas = '"+kelas+"' "
                + "and tarif = '"+tarif+"' where namamaskapia = '" + oldNamaMaskapai + "'";
        db.query(query);
    }
}
