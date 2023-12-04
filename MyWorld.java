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
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        createFries();
        //Create Label
        scoreLab = new Label(0, 80);
        addObject(scoreLab, 50, 50);
        addObject(anim, 200, 200);
    }

    public void bigAnim()
    {
        animalImg.scale(animalImg.getWidth() + 15, animalImg.getHeight() + 15);   
    }

    public void createFries()
    {
        int random1 = Greenfoot.getRandomNumber(600);
        addObject(fries, random1, 0); 
    }

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
    }

    public void gameOver()
    {
        Label gameOv = new Label ("Game Over", 100);
        addObject(gameOv,super.getWidth()/2, super.getHeight()/2);
        removeObject(fries);
        Greenfoot.delay(150);
        Label resetRequest = new Label("Restart?", 50);
        addObject(resetRequest, super.getWidth()/2, super.getHeight()/2 + 100);

    }
}
