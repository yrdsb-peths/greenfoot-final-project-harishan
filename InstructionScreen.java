import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class InstructionScreen extends World
{
    Label powerupLabel = new Label("Pick up Powerups to help you. There are ", 30);
    Label powerupLabel2 = new Label("Speed Boost, Fast Arrow and Medkit Powerups", 30);
    Label snakesLabel = new Label("Don't get hit by snakes or let snakes hit the end of the world", 25);
    Label totalLivesLabel = new Label("You have 3 lives, but if the snakes get to the end", 30);
    Label gameEndLabel = new Label("Or you lose all your lives", 40);
    Label gameEndLabel2 = new Label("YOU LOSE", 50);
    Label startGameLabel = new Label("Press Enter to start", 40);
    /**
     * Constructor for objects of class InstructionScreen.
     * 
     */
    public InstructionScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        addObject(powerupLabel, getWidth()/2, 60);
        addObject(powerupLabel2, getWidth()/2, 90);
        addObject(snakesLabel, getWidth()/2, 150);
        addObject(totalLivesLabel, getWidth()/2, 180);
        addObject(gameEndLabel, getWidth()/2, 210);
        addObject(gameEndLabel2, getWidth()/2, 260);
        addObject(startGameLabel, getWidth()/2, 320);
    }
    
    public void act(){
        //start game if user presses space
        if(Greenfoot.isKeyDown("enter")){
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld); 
        }
    }
}
