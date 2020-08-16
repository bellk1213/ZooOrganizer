/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevinbell.zooproject;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author KevinBell
 */
public class To {
    public static void main(String[] args) {
        testcase1();
        testcase2();
        testcase3();
        testcase4();
        testcase5();
        testcase6();
        testcase7();
        testzoo();
        testException();
}

//Testcase1 assures that no more than three species can be ran since there are only three species.
public static void testcase1()
{
    try
    {
        zoo kevinZoo = new zoo();
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
            
            kevinZoo.addAnimalType("Larry", formatter.parse("07/04/2010"), 10, "lion", 5, "true", "false", "false");
            
            kevinZoo.addAnimalType("Leonardo", formatter.parse("05/04/1940"), 80, "turtle", 20, "false", "true", "false");
            
            kevinZoo.addAnimalType("Glory", formatter.parse("07/04/2017"), 3, "eagle", 2, "false", "false", "true");
            
            System.out.println("Testcase 1");
            for (int x = 0; x < 3; x++)
                System.out.println(kevinZoo.getAnimalByID(x));
    }
    catch (Exception e)
    {
        System.out.println("Testcase 1 Error" + e.getMessage());
    }
    System.out.println("");
}

//Testcase2 sends an error if there are any null animalType items, and adds a list of animals.
public static void testcase2()
{
    try
    {
        zoo kevinZoo = new zoo();
            SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
            
            kevinZoo.addAnimalType("Gary", formatter.parse("07/04/2015"), 5, "goat", 10, "true", "false", "false");
            
            kevinZoo.addAnimalType("Tim", formatter.parse("06/08/1950"), 70, "turtle", 30, "false", "true", "false");
            
            kevinZoo.addAnimalType("Earnie", formatter.parse("05/14/2016"), 4, "hawk", 1, "false", "false", "true");
            
            System.out.println("Testcase 2");
            int x = 0;
            String animalType;
            do
            {
                animalType = kevinZoo.getAnimalByID(x);
                if (animalType != null)
                    System.out.println(animalType);
                x++;
            } while (animalType != null);
             
        } catch (Exception e)
        {
            System.out.println("Testcase 2 Error " + e.getMessage());
        }
    System.out.println();         
}

//Testcase3 adds an additional three animals.
public static void testcase3()
{
    try
    {
        zoo kevinZoo = new zoo();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy"); 
        
        kevinZoo.addAnimalType("Lenny", formatter.parse("05/04/2012"), 8, "lion", 7, "true", "false", "false");
            
        kevinZoo.addAnimalType("Ralph", formatter.parse("07/09/1960"), 60, "turtle", 40, "false", "true", "false");
            
        kevinZoo.addAnimalType("Easty", formatter.parse("07/04/2019"), 1, "eagle", 4, "false", "false", "true");
        kevinZoo.saveToFile("kevinzoo.txt");
        
        System.out.println("Testcase 3");
        int x = 0;
        String animalType;
        do
        {
            animalType = kevinZoo.getAnimalByID(x);
            if (animalType != null)
                System.out.println(animalType);
            x++;
        } while (animalType != null);
    }
    catch (Exception e)
    {
        System.out.println("Testcase 3 Error " + e.getMessage());
    }
    System.out.println();
}

//Testcase4 adds another additional three animals.
public static void testcase4()
{
    try
    {
        zoo kevinZoo = new zoo("kevinzoo.txt");
        
        System.out.println("Testcase 4");
        int x = 0;
        String animalType;
        do
        {
            animalType = kevinZoo.getAnimalByID(x);
            if (animalType != null)
            {
                System.out.println(animalType);
            }
            x++;
        } while (animalType != null);
    }
    catch (Exception e)
    {
        System.out.println("Testcase 4 Error " + e.getMessage());
    }
    System.out.println();
} 

//Testcase5 allows for the deletion of an animal.
public static void testcase5()
{
    try
    {
        zoo kevinZoo = new zoo("kevinzoo.txt");
        
        System.out.println("Testcase 5");
        int x = 0;
        String animalType;
        do
        {
            animalType = kevinZoo.getAnimalByID(x);
            if (animalType != null)
            {
                System.out.println(animalType);
            }
            x++;
        } while (animalType != null);
        
        kevinZoo.deleteAnimal(1);
        
        System.out.println();
        x = 0;
        animalType = null;
        do
        {
            animalType = kevinZoo.getAnimalByID(x);
            if (animalType != null)
            {
                System.out.println(animalType);
            }
            x++;
        } while (animalType != null);
    }
    catch (Exception e)
    {
        System.out.println("Testcase 5 Error " + e.getMessage());
    }
    System.out.println();
}

//Testcase6 allows for the update of an animal.
public static void testcase6()
{
    try
    {
        zoo kevinZoo = new zoo();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        kevinZoo.addAnimalType("Simba", formatter.parse("04/04/2014"), 6, "lion", 11, "true", "false", "false");
            
        kevinZoo.addAnimalType("Mike", formatter.parse("05/08/1955"), 65, "turtle", 35, "false", "true", "false");
            
        kevinZoo.addAnimalType("Ely", formatter.parse("05/14/2019"), 1, "hawk", 4, "false", "false", "true");
        System.out.println("Testcase 6");
        int x = 0;
        String animalType;
        do
        {
            animalType = kevinZoo.getAnimalByID(x);
            if (animalType != null)
                System.out.println(animalType);
            x++;
        } while (animalType != null);
        
        // update animal
        kevinZoo.updateBirdSpecies(1, "Donny", formatter.parse("05/08/1956"), 64, "turtle", 36, "true");
        
        System.out.println("Updated animal");
        x = 0;
        animalType = null;
        do
        {
            animalType = kevinZoo.getAnimalByID(x);
            if (animalType != null)
                System.out.println(animalType);
            x++;
        } while (animalType != null);
        
        //save updated list
        kevinZoo.saveToFile("updatedzoo.txt");
    }
    catch (Exception e)
    {
        System.out.println("Testcase 6 Error " + e.getMessage());
    }
    System.out.println();
}

//Testcase7 displays the life expectancy of the animals by species.
public static void testcase7()
{
    System.out.println("Testcase 7");
    SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
    
    try
    {
        mammalSpecies mammal = new mammalSpecies("Lenny", formatter.parse("05/04/2012"), 8, "lion", 7, "true");
        System.out.println("Life Expectancy = " + mammal.mammalLifeExpectancy());
        
        reptileSpecies reptile = new reptileSpecies("Ralph", formatter.parse("07/09/1960"), 60, "turtle", 40, "true");
        System.out.println("Life Expectancy = " + reptile.reptileLifeExpectancy());
        
        birdSpecies bird = new birdSpecies("Easty", formatter.parse("07/04/2019"), 1, "eagle", 4, "true");
        System.out.println("Life Expectancy = " + bird.birdLifeExpectancy());   
    }
    catch (Exception e)
    {
        System.out.println("Testcase 7 Error " + e.getMessage());
    }
    System.out.println();
}

//Testzoo test that each animal is (string, date, int, string, int, string, string, string).
public static void testzoo()
    {
        zoo z = new zoo();
        SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
        
        try
        {
            z.addAnimalType("Larry", formatter.parse("07/04/2010"), 10, "lion", 5, "true", "false", "false");
        }
        catch (Exception e)
        {
            System.out.println("Error " + e.getMessage());
        }
        
        System.out.println("Zoo test");
        System.out.println(z.getAnimalByID(0));
        System.out.println(z.getAnimalByID(1));
        System.out.println(z.getAnimalByID(2));
        System.out.println("");
    }

//TestException will test BirdAgeException.java.
public static void testException()
{
    SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

    try
    {
        System.out.println("Bird Age Exception");
        birdSpecies bs  = new birdSpecies("Easty", formatter.parse("07/04/2019"), 1, "eagle", 4, "true");
    } catch (BirdAgeException e) {
        System.out.println("Error: " + e.getLocalizedMessage());
    } catch (Exception e2)
    {
        System.out.println("Error " + e2.getMessage());
    }
}


}