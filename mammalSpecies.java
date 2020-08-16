/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevinbell.zooproject;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Kevin Bell
 */



public class mammalSpecies extends animalType {

    private String hasHair;
    private final int mammalAgeExpiration = 15;
    
    public static void main(String args[]){
        String hasHair = "true";
        boolean hair = Boolean.parseBoolean(hasHair);
        System.out.print(hair);
    }
    
    //set identifiers
    mammalSpecies(String na, Date bd, int ag, String sp, int le, String hh)
    {
    name = na;
    birthdate = bd;
    age = ag;
    species = sp;
    lifeExpectancy = le;
    hasHair = hh;
    }
    
    mammalSpecies(String line)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        name = line.substring(line.indexOf("<name>") + 6, line.indexOf("</name>"));
        species = line.substring(line.indexOf("<species>") + 9, line.indexOf("</species>"));
        hasHair = line.substring(line.indexOf("<hashair>") + 9,
                line.indexOf("</hashair>"));
        
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
    
    //make mammal species updates
    public void updateMammalSpecies(String na, Date bd, int ag, String sp, int le, String hh)
    {
    name = na;
    birthdate = bd;
    age = ag;
    species = sp;
    lifeExpectancy = le;
    hasHair = hh;  
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        return "<mammal>" +
                "<name>" + name + "</name>" +
                "<birthdate>" + formatter.format(birthdate) + "</birthdate>" +
                "<age>" + age + "</age>" +
                "<species>" + species + "</species>" +
                "<lifeExpectancy>" + lifeExpectancy + "</lifeExpectancy>" +
                "<hasHair>" + hasHair + "</hasHair>" +
                "<</mammal>>";
    }
    
    // return mammal life expectancy
    public double mammalLifeExpectancy()
    {
        double lifeExpectancyCalculator = mammalAgeExpiration - age;
        return lifeExpectancyCalculator;
    }

}
