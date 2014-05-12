/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.Item;
import com.namhla.cafeteria.domain.Stock;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Refilwe
 */
public class StockFactory {
    
    private static StockFactory stockFactory;
    
    
    private StockFactory(){
        
    }
    
    public synchronized static Stock getStock(List<Item>item, BigDecimal cost){
        
        if(stockFactory == null){
            Stock stock = new Stock();
            stock.setItem(item);
         
            stock.setCost(cost);
            
            return stock;
        }
        else{
            return null;
        }
    }
    
}
