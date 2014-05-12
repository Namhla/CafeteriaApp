/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services.impl;

import com.namhla.cafeteria.domain.Customer;
import com.namhla.cafeteria.domain.OrderItem;
import com.namhla.cafeteria.services.CustomerServices;
import com.namhla.cafeteria.services.crud.CustomerCrudService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mphokazi
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerServices{
   @Autowired
    CustomerCrudService customerCrudService;
    public List<OrderItem> customerOrder(Long id){
        
        List<Customer> customers = customerCrudService.findAll();
        List<OrderItem> orderItems = new  ArrayList<OrderItem>();
        for(Customer customer: customers)
        {
            if (customer.getId() == id)
            {
                orderItems = customer.getOrderItem();
            }
           
        }
        return orderItems;

    }

 
    
}
