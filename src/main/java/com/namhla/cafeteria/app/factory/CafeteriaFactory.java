/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.Cafeteria;
import com.namhla.cafeteria.domain.Contact;
import com.namhla.cafeteria.domain.Stock;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Refilwe
 */
public class CafeteriaFactory {
    
    private static CafeteriaFactory cafeteriaFactory;
    
    
    private CafeteriaFactory(){
        
    }
    
    public synchronized static Cafeteria getCafeteria(Map<String, String>value,Contact contact, List<Stock>stock){
        
        if(cafeteriaFactory == null){
            Cafeteria cafe = new Cafeteria();
            cafe.setCafeBuilding(value.get("cafeBuilding"));
            cafe.setCafeName(value.get("cafeName"));
            cafe.setContact(contact);
            cafe.setStock(stock);
            
            return cafe;
        }
        else{
            return null;
        }
    }
    
}
