import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal extends Actor
{
    /**
     * Act - do whatever the Animal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("a")){
            move(-2);
        }
        
        if(Greenfoot.isKeyDown("d")){
            move(2);
        }
        
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 2);
        }
        
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 2);
        }
    }
}
