/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services.crud.implementation;

import com.namhla.cafeteria.domain.Cafeteria;
import com.cafeteria.repository.GenericDAO;
import com.cafeteria.services.crud.CafeteriaCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Refilwe
 */
@Service("cafeteriaCrudService")
@Transactional
public class CafeteriaCrudServiceImpl implements CafeteriaCrudService{

     @Autowired
    private GenericDAO<Cafeteria>dao;
    
    public final void setDao(final GenericDAO<Cafeteria>toSetDao){
        this.dao = toSetDao;
        this.dao.setClazz(Cafeteria.class);   
    }
    
    @Override
    public Cafeteria findById(Long id) {
          setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Cafeteria> findAll() {
         setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Cafeteria entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Cafeteria entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Cafeteria entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<Cafeteria> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Cafeteria getByPropertyName(String name, String value) {
         setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Cafeteria> getEntitiesByProperName(String name, String value) {
         setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }

    @Override
    public com.cafeteria.domain.Cafeteria findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<com.cafeteria.domain.Cafeteria> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist(com.cafeteria.domain.Cafeteria entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void merge(com.cafeteria.domain.Cafeteria entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(com.cafeteria.domain.Cafeteria entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<com.cafeteria.domain.Cafeteria> findInRange(int firstResult, int maxResults) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public com.cafeteria.domain.Cafeteria getByPropertyName(String name, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<com.cafeteria.domain.Cafeteria> getEntitiesByProperName(String name, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
