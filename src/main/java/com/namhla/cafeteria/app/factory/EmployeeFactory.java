/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.EmployeeLog;
import com.namhla.cafeteria.domain.Contact;
import com.namhla.cafeteria.domain.Demography;
import com.namhla.cafeteria.domain.Employee;

/**
 *
 * @author Refilwe
 */
public class EmployeeFactory {
    
  public static class Builder{
        
        
    private int employeeID;
    private String firstName;
    private String lastName;
    private String jobId;  
    private Contact contact;
    private Demography demography;
    private EmployeeLog administrator;
        
        public Builder(int employeeID){
            this.employeeID = employeeID;
        }
        
        public Builder FirstName(String firstName){
               this.firstName = firstName;
               return this;
         }
         public Builder LastName(String lastName){
             this.lastName = lastName;
             return this;
         }
         public Builder JobId(String jobId){
             this.jobId = jobId;
             return this;
         }
         public Builder Contact(Contact contact){
             this.contact = contact;
             return this;
         }
         public Builder Demography(Demography demography){
             this.demography = demography;
             return this;
         }
         public Builder Administrator(EmployeeLog administrator){
             this.administrator = administrator;
             return this;
         }
         
         public Employee build(){
             return employee(this);
         }
        public Employee employee(Builder builder){
            Employee employee = new Employee();
            employee.setEmployeeID(builder.employeeID);
            return employee;
        }
    }
    
}
