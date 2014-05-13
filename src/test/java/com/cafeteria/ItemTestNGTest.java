/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria;

import com.cafeteria.app.factory.ItemFactory;
import com.cafeteria.domain.Item;
import com.cafeteria.services.crud.ItemCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
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
public class ItemTestNGTest {
    private ItemCrudService itemCrudService;
    private static ApplicationContext ctx;
    private Long id;
    
    
    public ItemTestNGTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

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
    public void createItem(){
        
        itemCrudService = (ItemCrudService)ctx.getBean("itemCrudService"); 
        
        BigDecimal sellingPrice = new BigDecimal("8.00");
        BigDecimal broughtPrice = new BigDecimal("6.00");
        BigDecimal profit = new BigDecimal("2.00");
        ArrayList prices = new ArrayList<BigDecimal>();
        prices.add(sellingPrice);
        prices.add(broughtPrice);
        prices.add(profit);
        Item item = ItemFactory.getItem("PS", prices);
        
        itemCrudService.persist(item);
        
        id = item.getId();
        assertNotNull(item);    
    }
    
   
    @Test(dependsOnMethods = "createItem")
    public void readItem(){
        
        itemCrudService = (ItemCrudService) ctx.getBean("itemCrudService");
        
        Item item = itemCrudService.findById(id);     
        assertNotNull(item);
        
    }
    
    @Test(dependsOnMethods= "createItem")
    public void updateItem(){
        
        itemCrudService = (ItemCrudService) ctx.getBean("itemCrudService");
        Item item = itemCrudService.findById(id);
        item.setItemName("Crusher");
        itemCrudService.merge(item);
        Item update = itemCrudService.findById(id);
        assertEquals(update.getItemName(), "Crusher");   
    }
    
     @Test(dependsOnMethods= "updateItem")
    public void delete(){
        
        itemCrudService = (ItemCrudService) ctx.getBean("itemCrudService");
        Item  item = itemCrudService.findById(id);
        itemCrudService.remove(item);
        Item delete = itemCrudService.findById(id);
        assertNull(delete);
        
    }
    
}
