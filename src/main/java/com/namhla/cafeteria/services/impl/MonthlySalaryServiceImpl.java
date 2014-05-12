/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services.impl;

import com.cafeteria.services.MonthlySalaryService;
import com.cafeteria.services.crud.EmployeeCrudService;
import com.namhla.cafeteria.domain.Employee;
import com.namhla.cafeteria.domain.EmployeeLog;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mphokazi
 */
@Service("monthlySalaryService")
public class MonthlySalaryServiceImpl implements MonthlySalaryService{

    @Autowired
    private EmployeeCrudService employeeCrudService;
    private List<Employee> employees;
    public double monthlySalary(Long empID) {
        double salary = 0;
        //employees = employeeCrudService.findAll();
        
        return salary;
        
    }
    
}
