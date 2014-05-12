/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria.services.crud.implementation;

import com.cafeteria.domain.Item;
import com.cafeteria.repository.GenericDAO;
import com.cafeteria.services.crud.ItemCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Refilwe
 */
@Service("itemCrudService")
@Transactional
public class ItemCrudServiceImpl implements ItemCrudService{

    @Autowired
    private GenericDAO<Item>dao;
    
    public final void setDao(final GenericDAO<Item>toSetDao){
        this.dao = toSetDao;
        this.dao.setClazz(Item.class);   
    }
    
    @Override
    public Item findById(Long id) {
       setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Item> findAll() {
       setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Item entity) {
         setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Item entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Item entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<Item> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Item getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Item> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
