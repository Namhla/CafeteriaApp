/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services.impl;

import com.namhla.cafeteria.app.factory.ItemFactory;
import com.cafeteria.client.web.model.ItemModel;
import com.namhla.cafeteria.domain.Item;
import com.namhla.cafeteria.domain.Stock;
import com.namhla.cafeteria.services.ItemService;
import com.namhla.cafeteria.services.crud.ItemCrudService;
import com.namhla.cafeteria.services.crud.StockCrudService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mphokazi
 */
@Service("itemListService")
public class ItemSeviceImpl implements ItemService{
    @Autowired
    private StockCrudService stockCrudService;
    private ItemCrudService itemCrudService;
    
    @Override
     public List<Item> itemList(Long id) {
        List<Stock> stockList = stockCrudService.findAll();
        List<Item> itemList = new ArrayList<Item>();
        for(Stock stock: stockList)
        {
                if(stock.getId()== id)
                {
                    itemList = stock.getItem();
                }
        }
    
    return itemList;
    }

    public List<Item> updateItem(ItemModel model) {
        Long id = model.getId();
        List prices = new ArrayList<BigDecimal>();
        prices.add(model.getSellingPrice());
        prices.add(model.getBroughtPrice());
        prices.add(model.getProfit());
        
        Item item = ItemFactory.getItem(model.getItemName(),prices);
        List<Item> items= itemCrudService.findAll();
        
        
        return items;
        
    }

    public ItemModel getItemToEdit(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Item> getItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Item> createItem(ItemModel itemModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
