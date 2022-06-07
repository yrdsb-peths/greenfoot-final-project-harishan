import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Harishan Ganeshanathan) 
 * @version (June 1)
 */
public class MyWorld extends World
{
    public int x;
    public int y;
    public int level = 1;
    public int score = 0;
    public boolean attackStatus = false; //used to see if player is currently
    //attacking. This way, they can't spam bullets until it hits the end of 
    //the world or an animal
    Label scoreLabel; 
    Label livesLabel;
    public int lives=3;
    public int numSnakes = 1;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        GreenfootImage bg = new GreenfootImage("images/background.jpg");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
              
        spawnPlayer();
        
        scoreLabel = new Label(0,80);
        addObject(scoreLabel, 50,50);
        
        if(score%5 == 0){
            spawnMedkit();
        }
        
        livesLabel = new Label(3,80);
        addObject(livesLabel, 50, 110);
        
        spawnSnake();
        
        Treasure treasure = new Treasure();
        addObject(treasure,15, 200);
        
    }
    
    public void spawnPlayer(){
        Player player = new Player();
        addObject(player, 100, 350);
    }
    
    public void spawnSnake(){
        int x = 600;
        int y = Greenfoot.getRandomNumber(350);
        
        Snake snake = new Snake();
        snake.setSpeed(level);
        addObject(snake,x,y);
    }
    
    public void spawnMedkit(){
        Medkit medkit = new Medkit();
        addObject(medkit, Greenfoot.getRandomNumber(450), Greenfoot.getRandomNumber(180)); 
    }
    
    public void increaseScore(){
        score++;
        scoreLabel.setValue(score);
        if(score%5==0){
            level+=1;
        }
    }
    
    public void gameOverDead(){
        Label gameOverLabel = new Label("You Died!", 60);
        Label finalScoreLabel = new Label("Your Final Score was "+score, 60);
        addObject(gameOverLabel, 300, 200);
        addObject(finalScoreLabel, 300,250);
    }
    public void lostTreasure(){
        Label lostTreasureLabel = new Label("The Snakes got the Treasure!", 50);
        Label endScoreLabel = new Label("Your Final Score was "+score,60);
        addObject(lostTreasureLabel,300,200);
        addObject(endScoreLabel, 300,250);
    }
}
