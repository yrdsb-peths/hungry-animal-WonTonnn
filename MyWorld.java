import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    Animal anim = new Animal();
    Fries fries = new Fries();
    private int random1 = Greenfoot.getRandomNumber(600);
    private int random2 = Greenfoot.getRandomNumber(600);
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        addObject(anim, 200, 200);
        addObject(fries, 0,0);
        
        
    }
}
