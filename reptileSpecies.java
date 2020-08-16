/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevinbell.zooproject;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 *
 * @author Kevin Bell
 */
public class reptileSpecies extends animalType {

    private String coldBlooded;
    
    public static void main(String args[]){
        String coldBlooded = "true";
        boolean cold = Boolean.parseBoolean(coldBlooded);
        System.out.print(cold);
    }
    
    //set identifiers
    reptileSpecies(String na, Date bd, int ag, String sp, int le, String cb)
    {
    name = na;
    birthdate = bd;
    age = ag;
    species = sp;
    lifeExpectancy = le;
    coldBlooded = cb;
    }
    
    reptileSpecies(String line)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        name = line.substring(line.indexOf("<name>") + 6, line.indexOf("</name>"));
        species = line.substring(line.indexOf("<species>") + 9, line.indexOf("</species>"));
        coldBlooded = line.substring(line.indexOf("<coldblooded>") + 13,
                line.indexOf("</coldblooded>"));
        
        try
        {
            age = Integer.parseInt(line.substring(line.indexOf("<age>") + 5,
                    line.indexOf("</age>")));
            lifeExpectancy = Integer.parseInt(line.substring(line.indexOf("<lifeExpectancy>") + 16,
                    line.indexOf("</lifeExpectancy>")));
            birthdate = formatter.parse(line.substring(line.indexOf("<birthdate>") + 11,
                line.indexOf("</birthdate>"))); 
        }
        catch (ParseException e)
        {
            System.out.println("birdSpecies Constructor Error " + e.getMessage());
        }
    }
    
    //make reptile species updates
    public void updateReptileSpecies(String na, Date bd, int ag, String sp, int le, String cb)
    {
    name = na;
    birthdate = bd;
    age = ag;
    species = sp;
    lifeExpectancy = le;
    coldBlooded = cb;  
    }
    
    @Override
    public String toString()
    {

        return "<reptile>" +
                "<name>" + name + "</name>" +
                "<birthdate>" + birthdate + "</birthdate>" +
                "<age>" + age + "</age>" +
                "<species>" + species + "</species>" +
                "<lifeExpectancy>" + lifeExpectancy + "</lifeExpectancy>" +
                "<coldBlooded>" + coldBlooded + "</coldBlooded>" +
                "<</reptile>>";
    }
    
    // set and return reptile life expectancy
    public double reptileLifeExpectancy()
    {
        double lifeExpectancyCalculator;
        
        if(this.species.equals("iguana"))
        {
            lifeExpectancyCalculator = (1 / (double)age * 10);
            return lifeExpectancyCalculator;
        }
        else
        {
            lifeExpectancyCalculator = 100 - age;
            return lifeExpectancyCalculator;
        }
    }

}
