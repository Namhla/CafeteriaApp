/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria;

import com.cafeteria.app.factory.CafeteriaFactory;
import com.cafeteria.app.factory.ContactFactory;
import com.cafeteria.app.factory.ItemFactory;
import com.cafeteria.app.factory.StockFactory;
import com.cafeteria.app.factory.StockOrderFactory;
import com.cafeteria.domain.Cafeteria;
import com.cafeteria.domain.Contact;
import com.cafeteria.domain.Item;
import com.cafeteria.domain.Stock;
import com.cafeteria.domain.StockOrder;
import com.cafeteria.services.crud.StockOrderCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
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
 * @author Refilwe
 */
public class StockOrderTestNGTest {
    
    private StockOrderCrudService stockOrderCrudService;
    private static ApplicationContext ctx;
    private Long id;
    
    public StockOrderTestNGTest() {
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
     public void createStockOrder(){
        stockOrderCrudService =(StockOrderCrudService)ctx.getBean("stockOrderCrudService");
        
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
        List<Stock>allStock = new ArrayList<Stock>();
        allStock.add(stock);
        
        HashMap<String, String> address = new HashMap<String, String>();
        address.put("cafeBuilding", "Student Center");
        address.put("cafeName", "CenterCafe");
        
        Contact contact = ContactFactory.getContact("CenterCafe@mycput.ac.za", "0216783555","0210118990");
        
        Cafeteria cafe = CafeteriaFactory.getCafeteria(address ,contact,allStock );
        
        StockOrder stockOrder = StockOrderFactory.getStockOrder(50,cafe, items);
        stockOrderCrudService.persist(stockOrder);
       
       id = stock.getId();
      
       assertNotNull(stockOrder);
    }
    
    @Test(dependsOnMethods = "createStockOrder")
    public void readStockOrder(){
        
        stockOrderCrudService = (StockOrderCrudService) ctx.getBean("stockOrderCrudService");
        
        StockOrder stockOrder = stockOrderCrudService.findById(id);     
        assertNotNull(stockOrder);
        
    }
    @Test(dependsOnMethods= "createStockOrder")
    public void updateStockOrder(){
        
        stockOrderCrudService = (StockOrderCrudService) ctx.getBean("stockOrderCrudService");
        StockOrder stockOrder = stockOrderCrudService.findById(id);
        stockOrder.setQuantity(70);
        stockOrderCrudService.merge(stockOrder);
        StockOrder update = stockOrderCrudService.findById(id);
        assertEquals(update.getQuantity(), 70);   
    }
    
    @Test(dependsOnMethods= "updateStockOrder")
    public void delete(){
        
        stockOrderCrudService = (StockOrderCrudService) ctx.getBean("stockOrderCrudService");
        StockOrder stockOrder = stockOrderCrudService.findById(id);
        stockOrderCrudService.remove(stockOrder);
        StockOrder delete = stockOrderCrudService.findById(id);
        assertNull(delete);
        
    } 
}

