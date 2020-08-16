/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kevinbell.zooproject;

/**
 *
 * @author Kevin Bell
 */
public class BirdAgeException extends RuntimeException {
    
    public BirdAgeException() {
        super("Invalid age or life expectancy.");
    }
    
    public BirdAgeException(String message) {
        super(message);
    }
    
}
