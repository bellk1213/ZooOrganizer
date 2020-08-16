/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevinbell.zooproject;
import java.util.*;
import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author KevinBell
 */
public class zoo {
    private Vector animals;
    private static int lifeExpectancyCalculator;

    zoo() //constructor
    {
       animals = new Vector(); //create a Vector object for the animals 
    }
    
    zoo(String fileName) throws ParseException //constructor
    {
        try
        {         
        animals = new Vector<animalType>(); //create a Vector object for animals
        
        FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String line = null;
    
        while ((line = br.readLine()) != null)
            {
                if (line.substring(0, 8).equals("<mammal>"))
                {
                    mammalSpecies ms = new mammalSpecies(line);
                
                        animals.add(ms);
                }
                else if (line.substring(0, 9).equals("<reptile>"))
                {
                    reptileSpecies rs = new reptileSpecies(line);
            
                        animals.add(rs);
                }
                else if (line.substring(0, 6).equals("<bird>"))
                {
                    birdSpecies bs = new birdSpecies(line); //added throw clause
                    
                        animals.add(bs);
                }
            }
            br.close();
        } catch (IOException e)
        {
            System.out.println("Zoo Constructor Error " + e.getMessage());
        }
    }
    public int addAnimalType(String name, Date birthdate, int age,
            String species, int lifeExpectancy, String hasHair, String coldBlooded, String canFly)
    {
        int speciesNumber = 0;
        
        if (species.equals("goat") || species.equals("lion") || species.equals("pig"))
            speciesNumber = 1;
        
        if (species.equals("turtle") || species.equals("iguana"))
            speciesNumber = 2;
        
        if (species.equals("eagle") || species.equals("hawk"))
            speciesNumber = 3;
           
        switch (speciesNumber)
        {
            case 1:
                mammalSpecies ms = new mammalSpecies(name, birthdate, age, species, lifeExpectancy, hasHair); //hasHair);
                animals.add(ms);
                return animals.size();
            case 2:
                reptileSpecies rs = new reptileSpecies(name, birthdate, age, species, lifeExpectancy, coldBlooded); //coldBlooded);
                animals.add(rs);
                return animals.size();
            case 3:
                birdSpecies bs = new birdSpecies(name, birthdate, age, species, lifeExpectancy, canFly); //canFly);
                animals.add(bs);
                return animals.size();
            default:
                return 0;
        }
    }
    
    public void updateMammalSpecies(int id, String name, Date birthdate, int age,
            String species, int lifeExpectancy, String hasHair)
    {
        //get mammalSpecies object at position id
        mammalSpecies mammal = (mammalSpecies)animals.elementAt(id);
        
        //update the parameters to object attributes
        mammal.updateMammalSpecies(name, birthdate, age, species, lifeExpectancy, hasHair);
    }
    
    public void updateReptileSpecies(int id, String name, Date birthdate, int age,
            String species, int lifeExpectancy, String coldBlooded)
    {
        //get reptileSpecies object at position id
        reptileSpecies reptile = (reptileSpecies)animals.elementAt(id);
        
        reptile.updateReptileSpecies(name, birthdate, age, species, lifeExpectancy, coldBlooded);
    }
    
    public void updateBirdSpecies(int id, String name, Date birthdate, int age,
            String species, int lifeExpectancy, String canFly)
    {
        //get birdSpecies object at position id
        birdSpecies bird = (birdSpecies)animals.elementAt(id);
        
        //update parameters to object attributes
        bird.updateBirdSpecies(name, birthdate, age, species, lifeExpectancy, canFly);
    }
    
    //delete or remove an animal
    public void deleteAnimal(int id)
    {
        animals.removeElementAt(id);
    }
    
    //get animal by ID 1-3
    public String getAnimalByID(int animalNumber)
    {
        if (animalNumber >= animals.size())
            return null;
        else
        {
            animalType an = (animalType)animals.elementAt(animalNumber);
            
            return an.toString();
        }
    }
    
    public void saveToFile(String fileName)
    {
        try
        {
            //create a file given the fileName
            PrintWriter zooAnimalFile = new PrintWriter(fileName);
               
            //get each animal on the list
            for (int x = 0; x < animals.size(); x++)
            {
                animalType an = (animalType)animals.elementAt(x);
                zooAnimalFile.println(an.toString());
            }
            
            //close file
            zooAnimalFile.close();
        }
        catch (Exception e)
        {
            System.out.println("Error " + e.getMessage());
        }
    }   
    
    //set and get the life expectancy calculator
    public static void setLifeExpectancyCalculator(int calculator)
    {
        lifeExpectancyCalculator = calculator;
    }
    
    public int getLifeExpectancyCalculator()
    {
        return lifeExpectancyCalculator;
    } 
    
}
