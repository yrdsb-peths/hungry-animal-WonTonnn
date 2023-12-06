import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Animal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Animal extends Actor
{
    GreenfootImage[] idle = new GreenfootImage[4];
    GreenfootImage[] rightWalk = new GreenfootImage[6];
    GreenfootImage[] leftWalk = new GreenfootImage[6];
    private boolean sprint = false;
    SimpleTimer timer = new SimpleTimer();
    
    public Animal()
    {
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("char_idle/idle" + i + ".png");
            idle[i].scale(MyWorld.animXSize, MyWorld.animYSize);
        }
        
        for(int r = 0; r < rightWalk.length; r++)
        {
            rightWalk[r] = new GreenfootImage("char_right/" + r + ".png");
            rightWalk[r].scale(MyWorld.animXSize,MyWorld.animYSize);
        }
        
        for(int l = 0; l < leftWalk.length; l++)
        {
            leftWalk[l] = new GreenfootImage("char_left/" + l + ".png");
            leftWalk[l].scale(MyWorld.animXSize,MyWorld.animYSize);
        }
        timer.mark();
        
        //Initial Image
        setImage(idle[0]);
    }
    
    //Animate idle animation
    int imageIndex = 0;
    int idleIndex = 0;
    public void animateIdle()
    {
        if(timer.millisElapsed() < 100)
        {
            return;
        }   
        timer.mark();
        imageIndex = (imageIndex + 1) % idle.length;
        setImage(idle[imageIndex]);
        
    }
    
    public void animateRightWalk()
    {
        if(timer.millisElapsed() < 50)
        {
            return;
        }
        timer.mark();
        setImage(rightWalk[imageIndex]);
        imageIndex = (imageIndex + 1) % rightWalk.length;
    }
    
    public void animateLeftWalk()
    {
        if(timer.millisElapsed() < 50)
        {
            return;
        }
        timer.mark();
        setImage(leftWalk[imageIndex]);
        imageIndex = (imageIndex + 1) % leftWalk.length;
    }

    public void act()
    {
        
        if(!Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d"))
        {
            animateIdle();
        }

        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 5, getY());
            animateLeftWalk();
        }

        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 5, getY());
            animateRightWalk();
        }

        if(getY() > 250)
        {

            if(Greenfoot.isKeyDown("w")){
                setLocation(getX(), getY() - 5);
            }
        }

        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(), getY() + 5);
        }

        if(Greenfoot.isKeyDown("right")){
            turn(5);
        }

        if(Greenfoot.isKeyDown("left")){
            turn(-5);
        }

        if(isTouching(Fries.class)){
            removeTouching(Fries.class);
            MyWorld world = (MyWorld) getWorld();
            world.createFries();
            world.increaseScore();

        }

    }
}
