/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria;

import com.cafeteria.app.factory.CafeteriaFactory;
import com.cafeteria.app.factory.ContactFactory;
import com.cafeteria.app.factory.ItemFactory;
import com.cafeteria.app.factory.StockFactory;
import com.cafeteria.domain.Cafeteria;
import com.cafeteria.domain.Contact;
import com.cafeteria.domain.Item;
import com.cafeteria.domain.Stock;
import com.cafeteria.services.crud.CafeteriaCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
public class CafeteriaTestNGTest {
    private CafeteriaCrudService cafeteriaCrudService;
    private static ApplicationContext ctx;
    private Long id;
    
    public CafeteriaTestNGTest() {
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
    public void createCafeteria(){
        
        cafeteriaCrudService = (CafeteriaCrudService)ctx.getBean("cafeteriaCrudService");
        
        HashMap<String, String> address = new HashMap<String, String>();
        address.put("cafeBuilding", "Student Center");
        address.put("cafeName", "CenterCafe");
        
        Contact contact = ContactFactory.getContact("CenterCafe@mycput.ac.za", "0216783555","0210118990");
        
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
        
        BigDecimal cost = new BigDecimal("160.00");
        Stock stoc = StockFactory.getStock(items,cost);
        List stock = new ArrayList<Stock>();
        stock.add(stoc);  
        
        Cafeteria cafeteria = CafeteriaFactory.getCafeteria(address, contact, stock);
        
        
        cafeteriaCrudService.persist(cafeteria);
        
        id = cafeteria.getId();
       
        assertNotNull(cafeteria);
        
    }
     
    @Test(dependsOnMethods = "createCafeteria")
    public void readCafeteria(){
        
        cafeteriaCrudService = (CafeteriaCrudService) ctx.getBean("cafeteriaCrudService");
        
        Cafeteria cafeteria = cafeteriaCrudService.findById(id);     
        assertNotNull(cafeteria);
        
    }
    
    @Test(dependsOnMethods= "createCafeteria")
    public void updateCafeteria(){
        
        cafeteriaCrudService = (CafeteriaCrudService) ctx.getBean("cafeteriaCrudService");
        Cafeteria cafeteria = cafeteriaCrudService.findById(id);
        cafeteria.setCafeName("Foodie");
        cafeteriaCrudService.merge(cafeteria);
        Cafeteria update = cafeteriaCrudService.findById(id);
        assertEquals(update.getCafeName(), "Foodie");   
    }
    
    @Test(dependsOnMethods= "updateCafeteria")
    public void delete(){
        
        cafeteriaCrudService = (CafeteriaCrudService) ctx.getBean("cafeteriaCrudService");
        Cafeteria  cafeteria= cafeteriaCrudService.findById(id);
        cafeteriaCrudService.remove(cafeteria);
        Cafeteria delete = cafeteriaCrudService.findById(id);
        assertNull(delete);
        
    }
}
