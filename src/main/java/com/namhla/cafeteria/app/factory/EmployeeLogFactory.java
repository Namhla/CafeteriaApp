/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.EmployeeLog;
import com.namhla.cafeteria.domain.Employee;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Refilwe
 */
public class EmployeeLogFactory {
    
    private static EmployeeLogFactory adminFactory;
    private EmployeeLog admin;
    
    private EmployeeLogFactory(){
        
    }
    
    public synchronized static EmployeeLog getAdministator(Date date, Map<String, String>value, List<Employee> employee){
        
        if(adminFactory == null){
            EmployeeLog admin = new EmployeeLog();
            admin.setDate(date);
            admin.setLoginTime(value.get("loginTime"));
            admin.setLogoutTime(value.get("logoutTime"));
            admin.setEmployee(employee);
            
            return admin;
        }
        else{
            return null;
        }
    }
}
