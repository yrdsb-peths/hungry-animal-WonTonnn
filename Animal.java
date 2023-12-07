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
    GreenfootImage[] explosion = new GreenfootImage[9];
    GreenfootSound eat = new GreenfootSound("zombies_eating.mp3");
    SimpleTimer timer = new SimpleTimer();

    public Animal()
    {
        //Animation loop for Idle
        for(int i = 0; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("char_idle/idle" + i + ".png");
            idle[i].scale(MyWorld.animXSize, MyWorld.animYSize);
        }

        //animation loop for right walk + left walk
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

    //Animate right walk animation
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

    public void animateExplosion()
    {
        for(int i = 0; i < explosion.length; i++)
        {
            explosion[i] = new GreenfootImage("explosion/" + i + ".png");
            explosion[i].scale(MyWorld.animXSize, MyWorld.animYSize);
            setImage(explosion[i]);
            Greenfoot.delay(10);
        }
        MyWorld.winOrNo = false;

    }

    //checks and updates size as the character is animated
    public void sizin()
    {
        getImage().scale(MyWorld.animXSize, MyWorld.animYSize);
    }

    public void act()
    {
        sizin();

        //If not moving, idle animation
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

        //Removies fries if eaten
        if(isTouching(Fries.class)){
            removeTouching(Fries.class);
            MyWorld world = (MyWorld) getWorld();
            world.createFries();
            if(MyWorld.score % 10 == 0)
            {
                eat.play();
            }
            world.increaseScore();

        }

        //checks if the user has won; and performed explosion and game over screen when finished

        if(MyWorld.winOrNo == true)
        {
            MyWorld world = (MyWorld) getWorld();
            animateExplosion();
            world.gameOver();
        }

    }
}
