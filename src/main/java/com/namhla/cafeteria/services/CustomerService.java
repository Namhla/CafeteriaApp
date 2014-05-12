/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services;

import com.namhla.cafeteria.domain.OrderItem;
import java.util.List;

/**
 *
 * @author Mphokazi
 */
public interface CustomerService{
    public List<OrderItem> customerOrder(Long id);
}
