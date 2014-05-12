/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Refilwe
 */
@Embeddable
public class Contact implements Serializable {
    
    private String email;
    private String cellphone;
    private String officeNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }
    

    
}
