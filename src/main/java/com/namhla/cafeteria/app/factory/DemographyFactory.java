/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.namhla.cafeteria.app.factory;

import com.namhla.cafeteria.domain.Demography;
import java.util.Date;

/**
 *
 * @author Refilwe
 */
public class DemographyFactory {
    
    private static DemographyFactory demographyFactory;
    
    
    private DemographyFactory(){
        
    }
    
    public synchronized static Demography getDemography(String gender, String race, Date dateOfBirth){
        
        if(demographyFactory == null){
            Demography demography = new Demography();
            demography.setGender(gender);
            demography.setRace(race);
            demography.setDateOfBirth(dateOfBirth);
            
            return demography;
        }
        else{
            return null;
        }
    }
    
}
