/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.client.web.controllers;





import com.namhla.cafeteria.client.factory.WelcomeFactory;
import com.cafeteria.client.web.model.Welcome;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author 211040819
 */
@Controller
@SessionAttributes
public class Indexcontroller {

    //@RequestMapping({"/"})
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Model model) {

         Welcome welcome = WelcomeFactory.getWelcome("Welcome to the program", new Date());
         model.addAttribute("msg", welcome);

        return "index";
    }
    

  
}  

