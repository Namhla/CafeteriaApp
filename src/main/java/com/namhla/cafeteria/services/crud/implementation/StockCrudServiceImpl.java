/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria.services.crud.implementation;

import com.cafeteria.domain.Stock;
import com.cafeteria.repository.GenericDAO;
import com.cafeteria.services.crud.StockCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Refilwe
 */
@Service("stockCrudService")
@Transactional
public class StockCrudServiceImpl implements StockCrudService{
    
     @Autowired
    private GenericDAO<Stock>dao;
    
    public final void setDao(final GenericDAO<Stock>toSetDao){
        this.dao = toSetDao;
        this.dao.setClazz(Stock.class);   
    }

    @Override
    public Stock findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Stock> findAll() {
        setDao(dao);
        return dao.findAll();
    }
    @Override
    public void persist(Stock entity) {
         setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Stock entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Stock entity) {
         setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<Stock> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Stock getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }


    @Override
    public List<Stock> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
