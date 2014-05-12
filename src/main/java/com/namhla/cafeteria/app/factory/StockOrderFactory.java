/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.Cafeteria;
import com.namhla.cafeteria.domain.Item;
import com.namhla.cafeteria.domain.StockOrder;
import java.util.List;

/**
 *
 * @author Refilwe
 */
public class StockOrderFactory {
    
    private static StockOrderFactory stockOrderFactory;
    
    
    private StockOrderFactory(){
        
    }
    
    public synchronized static StockOrder getStockOrder(int quantity, Cafeteria cafe, List<Item>items){
        
        if(stockOrderFactory == null){
            StockOrder stockOrder = new StockOrder();
            stockOrder.setQuantity(quantity);
            stockOrder.setCafeteria(cafe);
            stockOrder.setItem(items);
            
            return stockOrder;
        }
        else{
            return null;
        }
    }

}
