/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services.crud.implementation;

import com.namhla.cafeteria.domain.Customer;
import com.cafeteria.repository.GenericDAO;
import com.namhla.cafeteria.services.crud.CustomerCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Refilwe
 */
@Service("customerCrudService")
@Transactional
public class CustomerCrudServiceImpl implements CustomerCrudService{

     @Autowired
    private GenericDAO<Customer>dao;
    
    public final void setDao(final GenericDAO<Customer>toSetDao){
        this.dao = toSetDao;
        this.dao.setClazz(Customer.class);   
    }
    
    @Override
    public Customer findById(Long id) {
         setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Customer entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Customer entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Customer entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<Customer> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }
    @Override
    public long count() {
         setDao(dao);
        return dao.count();
    }

    @Override
    public Customer getByPropertyName(String name, String value) {
       setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Customer> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
