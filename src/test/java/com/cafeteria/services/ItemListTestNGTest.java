/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria.services;

import com.cafeteria.app.factory.ItemFactory;
import com.cafeteria.app.factory.StockFactory;
import com.cafeteria.domain.Item;
import com.cafeteria.domain.Stock;
import com.cafeteria.services.crud.StockCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
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
 * @author Mphokazi
 */
public class ItemListTestNGTest {
    private StockCrudService stockCrudService;
    private static ApplicationContext ctx;
    private ItemService itemListService;
    private Long id;
    public ItemListTestNGTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
     stockCrudService =(StockCrudService)ctx.getBean("stockCrudService");
    
        BigDecimal sellingPrice = new BigDecimal("8.00");
        BigDecimal broughtPrice = new BigDecimal("6.00");
        BigDecimal profit = new BigDecimal("2.00");
        ArrayList prices = new ArrayList<BigDecimal>();
        prices.add(sellingPrice);
        prices.add(broughtPrice);
        prices.add(profit);
        Item item = ItemFactory.getItem("LunchBar", prices);
        
        List<Item>items = new ArrayList<Item>();
        items.add(item);
        BigDecimal cost = new BigDecimal("200");
        
        
        Stock stock = StockFactory.getStock(items, cost);
        stockCrudService.persist(stock);
        
        itemListService = (ItemService)ctx.getBean("itemListService");
        List<Item> itemArr =  itemListService.itemList(item.getId());
        Assert.assertNotNull(itemArr);
        for (Item ite : itemArr) {
            System.out.println(ite.getItemName());
            
            
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