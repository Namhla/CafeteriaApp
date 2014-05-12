/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services.crud;

import com.namhla.cafeteria.domain.Customer;
import com.cafeteria.services.services;

/**
 *
 * @author Refilwe
 */
public interface CustomerCrudService extends services<Customer, Long>{
    public Customer findById(Long id);
    
}
