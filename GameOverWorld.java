import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen displayed when player dies or game is over
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 9)
 */
public class GameOverWorld extends World
{
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    Label deadLabel = new Label("YOU LOST", 100);
    Label restartLabel = new Label("Press SPACE to Restart!", 50);
    //Label finalScoreLabel = new Label("Your final score was " +score);
    
    public GameOverWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(deadLabel, getWidth()/2, 150);
        addObject(restartLabel, getWidth()/2, 300);
        //addObject(finalScoreLabel, getWidth()/2, 250);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            TitleScreen restartGame = new TitleScreen();
            Greenfoot.setWorld(restartGame);
        }
    }
}
