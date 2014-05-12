/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria.services.crud.implementation;

import com.cafeteria.domain.EmployeeLog;
import com.cafeteria.repository.GenericDAO;
import com.cafeteria.services.crud.EmployeeLogCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Refilwe
 */
@Service("administratorCrudService")
@Transactional
public class EmployeeLogCrudServiceImpl implements EmployeeLogCrudService{
    
    @Autowired
    private GenericDAO<EmployeeLog>dao;
    
    public final void setDao(final GenericDAO<EmployeeLog>toSetDao){
        this.dao = toSetDao;
        this.dao.setClazz(EmployeeLog.class);   
    }

    @Override
    public EmployeeLog findById(Long id) {
          setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<EmployeeLog> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(EmployeeLog entity) {
        setDao(dao);
        dao.persist(entity);
    }
    @Override
    public void merge(EmployeeLog entity) {
        setDao(dao);
        dao.merge(entity);
    }


    @Override
    public void remove(EmployeeLog entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<EmployeeLog> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
       setDao(dao);
        return dao.count();
    }


    @Override
    public EmployeeLog getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<EmployeeLog> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }
    
}
