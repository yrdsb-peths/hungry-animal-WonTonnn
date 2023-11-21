import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal extends Actor
{
    private boolean sprint = false;
    
    public void act()
    {
                
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 2, getY());
        }
        
        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 2, getY());
        }
        
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(), getY() - 2);
        }
        
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 2);
        }
        
        if(Greenfoot.isKeyDown("right")){
            turn(2);
        }
        
        if(Greenfoot.isKeyDown("left")){
            turn(-2);
        }

    }
}
