/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cafeteria.client.web.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Refilwe
 */
public class ItemModel implements Serializable{
    
    private Long id;
    private String ItemName;
    private BigDecimal sellingPrice;
    private BigDecimal broughtPrice;
    private BigDecimal profit;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal  sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal  getBroughtPrice() {
        return broughtPrice;
    }

    public void setBroughtPrice(BigDecimal  broughtPrice) {
        this.broughtPrice = broughtPrice;
    }

    public BigDecimal  getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal  profit) {
        this.profit = profit;
    }
    

    
}
