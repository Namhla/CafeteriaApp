/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria;

import com.cafeteria.app.factory.EmployeeLogFactory;
import com.cafeteria.app.factory.ContactFactory;
import com.cafeteria.app.factory.DemographyFactory;
import com.cafeteria.app.factory.EmployeeFactory;
import com.cafeteria.domain.EmployeeLog;
import com.cafeteria.domain.Contact;
import com.cafeteria.domain.Demography;
import com.cafeteria.domain.Employee;
import com.cafeteria.services.crud.EmployeeLogCrudService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author 
 */
public class EmployeeLogTestNGTest {
    private EmployeeLogCrudService administratorCrudService;
    private static ApplicationContext ctx;
    private Long id;
    
    public EmployeeLogTestNGTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
//     @Test
//    public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
       //  ctx = new ClassPathXmlApplicationContext("classpath:com/cafeteria/app/conf/applicationContext-*.xml");
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
    @Test
    public void createAdministrator(){
        
        administratorCrudService = (EmployeeLogCrudService)ctx.getBean("administratorCrudService");
        
        HashMap<String, String> details = new HashMap<String, String>();
        details.put("loginTime", "9:00");
        details.put("logoutTime", "18:00");
        
        Contact contact = ContactFactory.getContact("tyokozo@gmail.com", "0742367309","0216789990");
        Demography demo = DemographyFactory.getDemography("Female", "black", new Date(12/9/1992)); 
        Employee emp = new EmployeeFactory
                           .Builder(123)
                           .FirstName("Nolu")
                           .LastName("Tyokozo")
                           .JobId("Programmer")
                           .Contact(contact)
                           .Demography(demo)
                           .build();
        List  employee = new ArrayList<Employee>();
        employee.add(emp);
        
        EmployeeLog admin = EmployeeLogFactory.getAdministator(new Date(13/9/2013), details, employee);
                          
        administratorCrudService.persist(admin);
        
        id = admin.getId();
       
        assertNotNull(admin);
        
    }
     
    @Test(dependsOnMethods = "createAdministrator")
    public void readAdministrator(){
        
        administratorCrudService = (EmployeeLogCrudService) ctx.getBean("administratorCrudService");
        
        EmployeeLog administrator = administratorCrudService.findById(id);     
        assertNotNull(administrator);
        
    }
    @Test(dependsOnMethods= "createAdministrator")
    public void updateAdministrator(){
        
        administratorCrudService = (EmployeeLogCrudService) ctx.getBean("administratorCrudService");
        EmployeeLog administrator = administratorCrudService.findById(id);
        administrator.setLoginTime("10:00");
        administratorCrudService.merge(administrator);
        EmployeeLog update = administratorCrudService.findById(id);
        assertEquals(update.getLoginTime(), "10:00");   
    }
    
    @Test(dependsOnMethods= "updateAdministrator")
    public void delete(){
        
        administratorCrudService = (EmployeeLogCrudService) ctx.getBean("administratorCrudService");
        EmployeeLog administrator = administratorCrudService.findById(id);
        administratorCrudService.remove(administrator);
        EmployeeLog delete = administratorCrudService.findById(id);
        assertNull(delete);
        
    } 

}
