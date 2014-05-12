/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.client.factory;


import com.cafeteria.client.web.model.Welcome;
import java.util.Date;

/**
 *
 * @author 211040819
 */
public class WelcomeFactory{


         public static Welcome getWelcome(String msg, Date date){
             
            Welcome message = new Welcome();
            message.setToday(date);
            message.setWelcome(msg);
            return message;
         
         }

}
       
    

    
   