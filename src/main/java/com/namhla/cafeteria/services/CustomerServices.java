/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services;

import com.namhla.cafeteria.domain.Item;
import com.namhla.cafeteria.domain.OrderItem;
import java.util.List;

/**
 *
 * @author Refilwe
 */
public interface CustomerServices {
     public List<OrderItem> customerOrder(Long id);
    
    
}
