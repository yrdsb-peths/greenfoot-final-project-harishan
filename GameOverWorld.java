import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Screen displayed when player dies or game is over
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 9)
 */
public class GameOverWorld extends World
{
    //labels and game end sound
    Label deadLabel = new Label("YOU LOST", 100);
    Label scoreLabel; 
    Label restartLabel = new Label("Press SPACE to Restart!", 50);
    
    GreenfootSound gameEndSound = new GreenfootSound("gameEndSound.mp3");
    /**
     * Constructor for objects of class GameOverWorld.
     * 
     */
    public GameOverWorld(int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        gameEndSound.play();
        Label scoreLabel = new Label("YOUR FINAL SCORE WAS "+score, 50);
        addObject(deadLabel, getWidth()/2, 150);
        addObject(scoreLabel, getWidth()/2, 235);
        addObject(restartLabel, getWidth()/2, 300);
    }
    /**
     * if user presses space, restart
     */
    public void act(){
        if(Greenfoot.isKeyDown("space")){
            MyWorld restartGame = new MyWorld();
            Greenfoot.setWorld(restartGame);
        }
    }
}
