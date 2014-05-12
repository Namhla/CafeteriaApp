/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.Item;
import com.namhla.cafeteria.domain.OrderItem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Refilwe
 */
public class OrderFactory {
    
  public static class Builder{
        
    private int orderID;  
    private int quantity;
    private BigDecimal cost;
    private Date date;
    private  List<Item>item;
        
        public Builder(int orderID){
            this.orderID = orderID;
        }
        
        public Builder Quantity(int quantity){
               this.quantity = quantity;
               return this;
         }
         public Builder Cost(BigDecimal cost){
             this.cost = cost;
             return this;
         }
         public Builder Date(Date date){
             this.date = date;
             return this;
         }
         public Builder Item(List<Item> item){
             this.item = item;
             return this;
         }
         
         public OrderItem build(){
             return order(this);
         }
        public OrderItem order(Builder builder){
            OrderItem order = new OrderItem();
            order.setOrderID(orderID);
            return order; 
        }
    }
    
}
