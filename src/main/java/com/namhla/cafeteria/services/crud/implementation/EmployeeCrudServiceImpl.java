/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services.crud.implementation;

import com.namhla.cafeteria.domain.Employee;
import com.cafeteria.repository.GenericDAO;
import com.cafeteria.services.crud.EmployeeCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Refilwe
 */
@Service("employeeCrudService")
@Transactional
public class EmployeeCrudServiceImpl implements EmployeeCrudService{
    
    @Autowired
    private GenericDAO<Employee>dao;
    
    public final void setDao(final GenericDAO<Employee>toSetDao){
        this.dao = toSetDao;
        this.dao.setClazz(Employee.class);   
    }

    @Override
    public Employee findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Employee entity) {
        setDao(dao);
        dao.persist(entity);
    }

     @Override
    public void merge(Employee entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Employee entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        dao.removeById(entityId);
    }

    @Override
    public List<Employee> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }

    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }

    @Override
    public Employee getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Employee> getEntitiesByProperName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByProperName(name, value);
    }

}
