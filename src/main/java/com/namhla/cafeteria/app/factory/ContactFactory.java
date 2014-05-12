/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.Contact;

/**
 *
 * @author Refilwe
 */
public class ContactFactory {
    
    private static ContactFactory contactFactory;
    
    
    private ContactFactory(){
        
    }
    
    public synchronized static Contact getContact(String email, String cellphone, String officeNumber){
        
        if(contactFactory == null){
            Contact contact = new Contact();
            contact.setEmail(email);
            contact.setCellphone(cellphone);
            contact.setOfficeNumber(officeNumber);
            
            return contact;
        }
        else{
            return null;
        }
    }
}
