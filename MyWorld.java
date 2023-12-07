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
    public int score = 0;
    Label scoreLab;
    GreenfootImage animalImg = anim.getImage();
    public static int animXSize = 100;
    public static int animYSize = 100;
    public static boolean gameOver = false;
    Label gameOv = new Label ("Game Over", 100);
    Label resetRequest = new Label("Press space to restart!", 50);
    int imageIndex = 0;
    SimpleTimer timer = new SimpleTimer();
    public static boolean winOrNo = false;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        createFries();
        createAnim();
        prepare();
        //Create Label
        scoreLab = new Label(0, 80);
        addObject(scoreLab, 50, 50);

        //Explosion Animation

        prepare();
    }

    public void act()
    {

        //Checks if game is over; gives ability to reset 
        if(gameOver == true)
        {
            if(Greenfoot.isKeyDown("space"))
            {
                removeObject(gameOv);
                removeObject(resetRequest);
                reset();
            }
        }

    }

    //Spawns in character
    public void createAnim()
    {
        animalImg = anim.getImage();
        addObject(anim, 200, 200);
    }

    //Makes character bigger in increments 
    public void bigAnim()
    {
        animalImg.scale(animalImg.getWidth() + 15, animalImg.getHeight() + 15); 
        animXSize = animXSize + 15;
        animYSize = animYSize + 15;
    }

    //Spawns in fries 
    public void createFries()
    {
        int random1 = Greenfoot.getRandomNumber(600);
        addObject(fries, random1, 0); 
    }

    //Increases label for score every time a fry is eaten
    public void increaseScore()
    {
        score++;
        scoreLab.setValue(score);
        if(score < 50)
        {

            if(score % 5 == 0)
            {
                bigAnim();
            }
        }

        if(score == 50)
        {
            winOrNo = true;
            removeObject(fries);
        }
    }

    //Game over function
    public void gameOver()
    {
        addObject(gameOv,super.getWidth()/2, super.getHeight()/2);
        removeObject(fries);
        Greenfoot.delay(150);
        addObject(resetRequest, super.getWidth()/2, super.getHeight()/2 + 100);
        gameOver = true;
        anim.setLocation(-100, -100);

    }

    //Reset to titlescreen function
    public void reset()
    {
        TitleScreen title = new TitleScreen();
        scoreLab.setValue(0);
        prepare();
        Greenfoot.setWorld(title);
        gameOver = false;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */

    //Sets character's size to regular between biggering 
    private void prepare()
    {
        animXSize = 100;
        animYSize = 100; 
    }
}
