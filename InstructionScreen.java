import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays logistics and more instructions for the game 
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 10)
 */

public class InstructionScreen extends World
{
    //create labels
    Label powerupLabel = new Label("Pick up Powerups to help you. There are ", 30);
    Label powerupLabel2 = new Label("Speed Boost, Fast Arrow and Medkit Powerups", 30);
    Label snakesLabel = new Label("Don't get hit by snakes or let snakes hit", 30);
    Label totalLivesLabel = new Label("The end of the world. You have 3 lives",30);
    Label gameEndLabel = new Label("But if the snakes get to the end of the world ", 30);
    Label gameEndLabel2 = new Label("Or you lose all of your lives ", 30);
    Label gameEndLabel3 = new Label("YOU LOSE", 50);
    Label startGameLabel = new Label("Press Enter to start", 40);
    /**
     * Constructor for objects of class InstructionScreen.
     * 
     */
    public InstructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        //powerup labels 
        addObject(powerupLabel, getWidth()/2, 40);
        addObject(powerupLabel2, getWidth()/2, 70);
        
        SuperSpeed superSpeedIcon = new SuperSpeed();
        FastArrow fastArrowIcon = new FastArrow();
        Medkit medkitIcon = new Medkit();
        
        addObject(superSpeedIcon, 120, 110);
        addObject(fastArrowIcon, 250, 110);
        addObject(medkitIcon, 400, 110);
        //intruction labels
        addObject(snakesLabel, getWidth()/2, 150);
        addObject(totalLivesLabel, getWidth()/2, 180);
        addObject(gameEndLabel, getWidth()/2, 210);
        addObject(gameEndLabel2, getWidth()/2, 240);
        addObject(gameEndLabel3, getWidth()/2, 290);
        addObject(startGameLabel, getWidth()/2, 350);
    }
    
    public void act(){
        //start game if user presses space
        if(Greenfoot.isKeyDown("enter")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
    }
}
