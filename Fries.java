import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fries here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fries extends Actor
{
    /**
     * Act - do whatever the Fries wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int random1 = Greenfoot.getRandomNumber(600);
    public void act()
    {
        setLocation(getX(), getY() + 5);
        
    }
}
