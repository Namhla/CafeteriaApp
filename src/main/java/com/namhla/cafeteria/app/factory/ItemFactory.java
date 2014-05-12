/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.Item;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Refilwe
 */
public class ItemFactory {
    
   private static ItemFactory itemFactory;
    
    
    private ItemFactory(){
        
    }
    
    public synchronized static Item getItem(String itemName, List<BigDecimal> pricing){
        
        if(itemFactory == null){
            Item item = new Item();
            pricing.add(item.getSellingPrice());
            pricing.add(item.getBroughtPrice());
            pricing.add(item.getProfit());
            item.setItemName(itemName);
            
            return item;
        }
        else{
            return null;
        }
    }
    
}
