/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria;

import com.cafeteria.app.factory.ItemFactory;
import com.cafeteria.app.factory.StockFactory;
import com.cafeteria.domain.Item;
import com.cafeteria.domain.Stock;
import com.cafeteria.services.crud.StockCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
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
public class StockTestNGTest {
    
    private StockCrudService stockCrudService;
    private static ApplicationContext ctx;
    private Long id;
    
    public StockTestNGTest() {
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
     public void createStock(){
        stockCrudService =(StockCrudService)ctx.getBean("stockCrudService");
        
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
        
        BigDecimal cost = new BigDecimal("200");
        
        Stock stock = StockFactory.getStock(items, cost);
        stockCrudService.persist(stock);
       
       id = stock.getId();
      
       Assert.assertNotNull(stock);
    }
    
    @Test(dependsOnMethods = "createStock")
    public void readStock(){
        
        stockCrudService = (StockCrudService) ctx.getBean("stockCrudService");
        
        Stock stock = stockCrudService.findById(id);     
        Assert.assertNotNull(stock);
        
    }
    @Test(dependsOnMethods= "createStock")
    public void updateStock(){
        
        stockCrudService = (StockCrudService) ctx.getBean("stockCrudService");
        Stock stock = stockCrudService.findById(id);
      //  stock.setQuantity(50);
        stockCrudService.merge(stock);
        Stock update = stockCrudService.findById(id);
       // Assert.assertEquals(update.getQuantity(), 50);   
    }
    
    @Test(dependsOnMethods= "updateStock")
    public void delete(){
        
        stockCrudService = (StockCrudService) ctx.getBean("stockCrudService");
        Stock stock = stockCrudService.findById(id);
        stockCrudService.remove(stock);
        Stock delete = stockCrudService.findById(id);
        Assert.assertNull(delete);
        
    } 
}
