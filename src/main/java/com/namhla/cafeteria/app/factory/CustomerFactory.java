/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.Contact;
import com.namhla.cafeteria.domain.Customer;
import com.namhla.cafeteria.domain.Demography;
import com.namhla.cafeteria.domain.OrderItem;
import java.util.List;

/**
 *
 * @author Refilwe
 */
public class CustomerFactory {
    
       public static class Builder{
        
        private int customerID;
        private String customerName;
        private String customerSurname;
        
        private List<OrderItem> orderItem;       
        private Contact contact;
        private Demography demography;
        
        
        public Builder(int customerID){
            this.customerID = customerID;
        }
        
        public Builder CustomerName(String customerName){
               this.customerName = customerName;
               return this;
         }
         public Builder CustomerSurname(String customerSurname){
             this.customerSurname = customerSurname;
             return this;
         }
         public Builder OrderItem(List<OrderItem> orderItem){
             this.orderItem = orderItem;
             return this;
         }
         public Builder Contact(Contact contact){
             this.contact = contact;
             return this;
         }
         public Builder Demography(Demography demography){
             this.demography = demography;
             return this;
         }
         
//          public Builder Demography(List<Demography> demography){
//             this.demography = (Demography) demography;
//             return this;
//         }
         
         public Customer build(){
             return customer(this);
         }
        public Customer customer(Builder builder){
            Customer customer = new Customer();
            customer.setCustomerID(builder.customerID);
            return customer;
        }
    }
    
}
