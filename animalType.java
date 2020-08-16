/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevinbell.zooproject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
/**
 *
 * @author Kevin Bell
 */
public abstract class animalType {
    protected String name; //create the name of the animals
    protected Date birthdate; //the birthdate of the animals
    protected int age; //the age of the animals
    protected String species; //the species of the animal
    protected int lifeExpectancy; //the life expectancy of the animals
    
    //Get and set the animalType methods
    public String getName()
    {
        return name;
    }
    
    public Date getBirthDate()
    {
        return birthdate;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public String getSpecies()
    {
        return species;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setBirthdate(Date birthdate)
    {
        this.birthdate = birthdate;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public void setSpecies(String species)
    {
        this.species = species;
    }
    
    @Override
    public abstract String toString();

}