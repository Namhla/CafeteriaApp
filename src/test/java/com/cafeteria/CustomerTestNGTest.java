/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria;

import com.cafeteria.app.factory.ContactFactory;
import com.cafeteria.app.factory.CustomerFactory;
import com.cafeteria.app.factory.DemographyFactory;
import com.cafeteria.app.factory.ItemFactory;
import com.cafeteria.app.factory.OrderFactory;
import com.cafeteria.domain.Contact;
import com.cafeteria.domain.Customer;
import com.cafeteria.domain.Demography;
import com.cafeteria.domain.Item;
import com.cafeteria.domain.OrderItem;
import com.cafeteria.services.crud.CustomerCrudService;
import com.cafeteria.services.crud.OrderItemCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
public class CustomerTestNGTest {
    
    private CustomerCrudService customerCrudService;
    private static ApplicationContext ctx;
    private Long id;
    
    public CustomerTestNGTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     

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
    
     @Test
     public void createCustomer() {
      
        Customer customer;
        customerCrudService = (CustomerCrudService)ctx.getBean("customerCrudService");
        
        Contact contact = ContactFactory.getContact("mphokazi@gmail.com", "0785566321", "0218897190");
        Demography demo = DemographyFactory.getDemography("Female", "Black", new Date(10/6/1986));
        
        BigDecimal sellingPrice = new BigDecimal("8.00");
        BigDecimal broughtPrice = new BigDecimal("6.00");
        BigDecimal profit = new BigDecimal("2.00");
        ArrayList prices = new ArrayList<BigDecimal>();
        prices.add(sellingPrice);
        prices.add(broughtPrice);
        prices.add(profit);
        Item item = ItemFactory.getItem("PS", prices);
        List items = new ArrayList<Item>();
        items.add(items);
        
        BigDecimal cost = new BigDecimal("10.00");
        Date today = new Date();
        OrderItem orderedItem = new OrderFactory
                                .Builder(111)
                                .Cost(cost)
                                .Quantity(5)
                                .Date(today)
                                .build();
        List orderedItems = new ArrayList<OrderItem>();
        orderedItems.add(orderedItem);
        
        customer = new CustomerFactory
                                .Builder(125)
                                .CustomerName("Mphokazi")
                                .CustomerSurname("Mhlontlo")
                                .Contact(contact)
                                .Demography(demo)
                                .OrderItem(orderedItems)
                                .build();
        
        customerCrudService.persist(customer);
        id = customer.getId();
        Assert.assertNotNull(customer);    
     }
     
    @Test(dependsOnMethods = "createCustomer")
    public void readCustomer(){
        
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");
        
        Customer customer = customerCrudService.findById(id);     
        Assert.assertNotNull(customer);
        
    }
    @Test(dependsOnMethods= "createCustomer")
    public void updateCustomer(){
        
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");
        Customer customer = customerCrudService.findById(id);
        customer.setCustomerName("Naledi");
        customerCrudService.merge(customer);
        Customer update = customerCrudService.findById(id);
        Assert.assertEquals(update.getCustomerName(), "Naledi");   
    }
    
    @Test(dependsOnMethods= "updateCustomer")
    public void delete(){
        
        customerCrudService = (CustomerCrudService) ctx.getBean("customerCrudService");
        Customer customer = customerCrudService.findById(id);
        customerCrudService.remove(customer);
        Customer delete = customerCrudService.findById(id);
        Assert.assertNull(delete);
        
    } 
}
