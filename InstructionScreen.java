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
    Label powerupLabel = new Label("Powerups", 30);
    Label powerupLabel2 = new Label("Speed Boost, Fast Arrow and Medkit", 30);
    Label objectiveLabel = new Label("Stop the snakes from reaching the border", 30);
    Label totalLivesLabel = new Label("If the snakes get to the end",30);
    Label gameEndLabel = new Label("Of the world, or you lose all of your lives  ", 30);
    Label gameEndLabel3 = new Label("YOU LOSE", 70);
    Label startGameLabel = new Label("Press SPACE to start", 40);
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
        
        addObject(superSpeedIcon, 165, 110);
        addObject(fastArrowIcon, 295, 110);
        addObject(medkitIcon, 460, 110);
        //intruction labels
        addObject(objectiveLabel, getWidth()/2, 160);
        addObject(totalLivesLabel, getWidth()/2, 190);
        addObject(gameEndLabel, getWidth()/2, 220);
        
        addObject(gameEndLabel3, getWidth()/2, 270);
        addObject(startGameLabel, getWidth()/2, 330);
    }
    
    boolean flag = false;
    public void act(){
        //start game if user presses space
        if(!Greenfoot.isKeyDown("space")){
            flag = true;
        }
        if(flag && Greenfoot.isKeyDown("space")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
    }
}
