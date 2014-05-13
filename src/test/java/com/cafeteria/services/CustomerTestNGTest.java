/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria.services;

import com.cafeteria.app.factory.ContactFactory;
import com.cafeteria.app.factory.CustomerFactory;
import com.cafeteria.app.factory.DemographyFactory;
import com.cafeteria.app.factory.ItemFactory;
import com.cafeteria.domain.Contact;
import com.cafeteria.domain.Customer;
import com.cafeteria.domain.Demography;
import com.cafeteria.domain.Item;
import com.cafeteria.domain.OrderItem;
import com.cafeteria.services.crud.CustomerCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Mphokazi
 */
public class CustomerTestNGTest {
    private CustomerCrudService customerCrudService;
    private static ApplicationContext ctx;
    private CustomerServices customerService;
    private Long id;
    public CustomerTestNGTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void customerService() {
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
        
        customer = new CustomerFactory
                                .Builder(125)
                                .CustomerName("Mphokazi")
                                .CustomerSurname("Mhlontlo")
                                .Contact(contact)
                                .Demography(demo)
                                .OrderItem(items)
                                .build();
        
        customerCrudService.persist(customer);
       customerService = (CustomerServices)ctx.getBean("customerService");
       List<OrderItem> orderItems = customerService.customerOrder(customer.getId());
        Assert.assertNotNull(orderItems);
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem.getItem());
            
            
         } 
     }

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