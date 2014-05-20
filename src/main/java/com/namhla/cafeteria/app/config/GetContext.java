/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.namhla.cafeteria.app.config;

import org.springframework.context.ApplicationContext;

/**
 *
 * 
 */
public class GetContext {
private static ApplicationContext ctx;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ctx = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
}
