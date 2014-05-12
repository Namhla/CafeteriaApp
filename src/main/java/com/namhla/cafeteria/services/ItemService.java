 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.services;

import com.namhla.cafeteria.client.web.model.ItemModel;
import com.namhla.cafeteria.domain.Item;
import java.util.List;

/**
 *
 * @author Mphokazi
 */
public interface ItemService {
    
     public List<Item> itemList(Long id);
     public List<Item> createItem(ItemModel itemModel);
     public List<Item> updateItem(ItemModel model);
     public ItemModel getItemToEdit(Long id);
     public List<Item> getItems();
    
}
