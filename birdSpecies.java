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
public class birdSpecies extends animalType {
    private String canFly;
    private final int birdLifeExpectancy = 5;
    
    public static void main(String args[]){
        String canFly = "true";
        boolean fly = Boolean.parseBoolean(canFly);
        System.out.print(fly);
    }
    
    //set identifiers
    birdSpecies(String na, Date bd, int ag, String sp, int le, String cf)
    {
        //Bird Age Exception
        if (ag > 5 && le > 5) {
            throw new BirdAgeException();
        }
        name = na;
        birthdate = bd;
        age = ag;
        species = sp;
        lifeExpectancy = le;
        canFly = cf;
    }
    
    birdSpecies(String line) throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        name = line.substring(line.indexOf("<name>") + 6, line.indexOf("</name>"));
        species = line.substring(line.indexOf("<species>") + 9, line.indexOf("</species>"));
        canFly = line.substring(line.indexOf("<canfly>") + 8,
                line.indexOf("</canfly>"));
        try
        {
            age = Integer.parseInt(line.substring(line.indexOf("<age>") + 5,
                    line.indexOf("</age>")));
            lifeExpectancy = Integer.parseInt(line.substring(line.indexOf("<lifeExpectancy>") + 16,
                    line.indexOf("</lifeExpectancy>")));
            birthdate = formatter.parse(line.substring(line.indexOf("<birthdate>") + 11,
                line.indexOf("</birthdate>"))); 
        }
        catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
    
    //make bird species updates
    public void updateBirdSpecies(String na, Date bd, int ag, String sp, int le, String cf)
    {
        //Bird Age Exception
        if (ag > 5 && le > 5) {
            throw new BirdAgeException();
        }
        name = na;
        birthdate = bd;
        age = ag;
        species = sp;
        lifeExpectancy = le;
        canFly = cf;  
    }
    
    @Override
    public String toString()
    {
        return "<bird>" +
                "<name>" + name + "</name>" +
                "<birthdate>" + birthdate + "</birthdate>" +
                "<age>" + age + "</age>" +
                "<species>" + species + "</species>" +
                "<lifeExpectancy>" + lifeExpectancy + "</lifeExpectancy>" +
                "<canFly>" + canFly + "</canFly>" +
                "<</bird>>";
    }
    
    // return bird life expectancy
    public double birdLifeExpectancy()
    {
        return birdLifeExpectancy;
    }
    
}