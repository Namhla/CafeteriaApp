/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria;

import com.cafeteria.app.factory.ContactFactory;
import com.cafeteria.app.factory.DemographyFactory;
import com.cafeteria.app.factory.EmployeeFactory;
import com.cafeteria.domain.Contact;
import com.cafeteria.domain.Demography;
import com.cafeteria.domain.Employee;
import com.cafeteria.services.crud.EmployeeCrudService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 
 */
public class EmployeeTestNGTest {
    private EmployeeCrudService employeeCrudService;
    private static ApplicationContext ctx;
    private Long id;
    
    public EmployeeTestNGTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
      public void createEmployee(){
        
        List employees;
        Employee employee;
        employeeCrudService = (EmployeeCrudService)ctx.getBean("employeeCrudService");
        
        Contact contact = ContactFactory.getContact("refilwe@gmail.com", "0894567897", "0112235789");
        Demography demo = DemographyFactory.getDemography("Female", "Black", new Date(10/6/1986));
        
        HashMap<String, String> details = new HashMap<String, String>();
        details.put("loginTime", "9:00");
        details.put("logoutTime", "18:00");
        

       /* Administrator admin = AdminFactory.getAdministator(new Date(13/9/2013), details, employees);*/
        employee = new EmployeeFactory
                                .Builder(124)
                                .FirstName("Zipho")
                                .LastName("Yona")
                                .Demography(demo)
                                .JobId("Programmer")
                                .Contact(contact)
                                .build();
       
        employeeCrudService.persist(employee);
        id = employee.getId();
        Assert.assertNotNull(employee);       
    }
    
     /* @Test(dependsOnMethods= "createEmployee")
    public void readEmployee(){
        employeeCrudService = (EmployeeCrudService) ctx.getBean("employeeCrudService");
        
        Employee employee = employeeCrudService.findById(id);     
        Assert.assertNotNull(employee);
        
    }*/

/*  @Test(dependsOnMethods= "createEmployee")
    public void updateEmployee(){
        
        employeeCrudService = (EmployeeCrudService) ctx.getBean("employeeCrudService");
        Employee employee = employeeCrudService.findById(id);
        employee.setFirstName("Deee");
        employeeCrudService.merge(employee);
        Employee update = employeeCrudService.findById(id);
        Assert.assertEquals(update.getFirstName(), "Deee");   
    }*/
    
   /*@Test(dependsOnMethods= "createEmployee")
    public void delete(){
        
        employeeCrudService = (EmployeeCrudService) ctx.getBean("employeeCrudService");
        Employee employee = employeeCrudService.findById(id);
        employeeCrudService.remove(employee);
        Employee delete = employeeCrudService.findById(id);
        Assert.assertNull(delete);
        
    }*//* @Test(dependsOnMethods= "createEmployee")
    public void readEmployee(){
        employeeCrudService = (EmployeeCrudService) ctx.getBean("employeeCrudService");
        
        Employee employee = employeeCrudService.findById(id);     
        Assert.assertNotNull(employee);
        
    }*/

/*  @Test(dependsOnMethods= "createEmployee")
    public void updateEmployee(){
        
        employeeCrudService = (EmployeeCrudService) ctx.getBean("employeeCrudService");
        Employee employee = employeeCrudService.findById(id);
        employee.setFirstName("Deee");
        employeeCrudService.merge(employee);
        Employee update = employeeCrudService.findById(id);
        Assert.assertEquals(update.getFirstName(), "Deee");   
    }*/
    
   /*@Test(dependsOnMethods= "createEmployee")
    public void delete(){
        
        employeeCrudService = (EmployeeCrudService) ctx.getBean("employeeCrudService");
        Employee employee = employeeCrudService.findById(id);
        employeeCrudService.remove(employee);
        Employee delete = employeeCrudService.findById(id);
        Assert.assertNull(delete);
        
    }*/

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/cafeteria/app/conf/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
