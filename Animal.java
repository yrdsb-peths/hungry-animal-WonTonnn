import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Animal extends Actor
{
    private boolean sprint = false;
    //animation objects
    GreenfootImage[] moveRight = new GreenfootImage[6];
    GreenfootImage[] moveLeft = new GreenfootImage[6];
    GreenfootImage[] idle = new GreenfootImage[2];
    GreenfootImage[] lose = new GreenfootImage[3];
    //is pressing button
    private boolean aDown = false;
    private boolean dDown = false;
    private boolean wDown = false; 
    int imageIndex = 0;

    public void act()
    {
        //if(!aDown && !dDown && !wDown)
        //{
           // animateIdle();
       // }
        if(Greenfoot.isKeyDown("a")){
            setLocation(getX() - 5, getY());
            animateMovingRight();
            aDown = true;
        }
        

        if(Greenfoot.isKeyDown("d")){
            setLocation(getX() + 5, getY());
            animateMovingLeft();
            dDown = true;
            
        }

        if(getY() > 250)
        {

            if(Greenfoot.isKeyDown("w")){
                setLocation(getX(), getY() - 5);
                wDown = true;
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

    public Animal()
    {
        for(int i = 1; i < idle.length; i++)
        {
            idle[i] = new GreenfootImage("images/character.pictures/char.idle/" + i + ".png");

        }
        setImage(idle[0]);
    }

    public void animateIdle()
    {

        setImage(idle[imageIndex]);
        Greenfoot.delay(100);
        imageIndex = (imageIndex + 1) % idle.length;

    }

    public void animateMovingRight()
    {

    }

    public void animateMovingLeft()
    {

    }

}
