/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria;

import com.cafeteria.app.factory.ItemFactory;
import com.cafeteria.app.factory.OrderFactory;
import com.cafeteria.domain.Item;
import com.cafeteria.domain.OrderItem;
import com.cafeteria.services.crud.OrderItemCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
public class OrderItemTestNGTest {
    private OrderItemCrudService orderItemCrudService;
    private static ApplicationContext ctx;
    private Long id;
    public OrderItemTestNGTest() {
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
      public void createOrderItem(){
        
        orderItemCrudService = (OrderItemCrudService)ctx.getBean("orderItemCrudService");
        
        BigDecimal sellingPrice = new BigDecimal("8.00");
        BigDecimal broughtPrice = new BigDecimal("6.00");
        BigDecimal profit = new BigDecimal("2.00");
        ArrayList prices = new ArrayList<BigDecimal>();
        prices.add(sellingPrice);
        prices.add(broughtPrice);
        prices.add(profit);
        Item item = ItemFactory.getItem("PS", prices);
        List items = new ArrayList<Item>();
        items.add(item);
      
 
        OrderItem orderItem = new OrderFactory
                              .Builder(111)
                              .Quantity(20)
                              .Cost(new BigDecimal("160.00"))
                              .Date(new Date(23/9/2013))
                              .Item(items)  
                              .build();                      
                              
        orderItemCrudService.persist(orderItem);
        
        id = orderItem.getId();
       
        assertNotNull(orderItem);
        
    }
     
 
    @Test(dependsOnMethods = "createOrderItem")
    public void readOrderItem(){
        
        orderItemCrudService = (OrderItemCrudService) ctx.getBean("orderItemCrudService");
        
        OrderItem orderItem = orderItemCrudService.findById(id);     
        assertNotNull(orderItem);
        
    }
    
    @Test(dependsOnMethods= "readOrderItem")
    public void updateOrderItem(){
        
        orderItemCrudService = (OrderItemCrudService) ctx.getBean("orderItemCrudService");
        OrderItem orderItem = orderItemCrudService.findById(id);
        orderItem.setQuantity(10);
        orderItemCrudService.merge(orderItem);
        OrderItem update = orderItemCrudService.findById(id);
        assertEquals(update.getQuantity(), 10);   
    }
    
    @Test(dependsOnMethods= "updateOrderItem")
    public void delete(){
        
        orderItemCrudService = (OrderItemCrudService) ctx.getBean("orderItemCrudService");
        OrderItem  orderItem = orderItemCrudService.findById(id);
        orderItemCrudService.remove(orderItem);
        OrderItem delete = orderItemCrudService.findById(id);
        assertNull(delete);
        
    } 
}
