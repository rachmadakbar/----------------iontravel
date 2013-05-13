/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;

/**
 *
 * @author Rachmad-
 */
public class TemporaryObject {
    ArrayList<String> list;
    
    public TemporaryObject(){
        list = new ArrayList<String>();
    }
    
    public void add(String data){
        list.add(data);
    }
    
    public String get(int i){
        return list.get(i);
    }
}
