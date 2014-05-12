/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria.services.crud.implementation;

import com.cafeteria.domain.StockOrder;
import com.cafeteria.repository.GenericDAO;
import com.cafeteria.services.crud.StockOrderCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Refilwe
 */
@Service("stockOrderCrudService")
@Transactional
public class StockOrderCrudServiceImpl  implements StockOrderCrudService{
    
    @Autowired
    private GenericDAO<StockOrder>dao;
    
    public final void setDao(final GenericDAO<StockOrder>toSetDao){
        this.dao = toSetDao;
        this.dao.setClazz(StockOrder.class);   
    }

    public StockOrder findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    public List<StockOrder> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    public void persist(StockOrder entity) {
         setDao(dao);
        dao.persist(entity);
    }

    public void merge(StockOrder entity) {
        setDao(dao);
        dao.merge(entity);
    }

    public void remove(StockOrder entity) {
        setDao(dao);
        dao.remove(entity);
    }

    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    public List<StockOrder> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    public long count() {
        setDao(dao);
        return dao.count();
    }

    public StockOrder getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    public List<StockOrder> getEntitiesByProperName(String name, String value) {
         setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
}
